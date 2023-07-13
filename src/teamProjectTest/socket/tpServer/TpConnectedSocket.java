package teamProjectTest.socket.tpServer;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import ch10_배열.Array01;
import ch26_socket.simpleGUI.server.ServerSender;
import lombok.RequiredArgsConstructor;
import lombok.val;
import teamProjectTest.socket.tpClient.dto.RequestBodyDto;
import teamProjectTest.socket.tpServer.tpEntity.TpRoom;


@RequiredArgsConstructor
public class TpConnectedSocket extends Thread{
	private String username;
	private Gson gson;
	
	private final Socket socket;
	
	
	
	@Override
	public void run() {
		System.out.println("Debug Text : 서버 스레드 실행");
		gson = new Gson();
		while(true) {
			try {
				BufferedReader bufferedReader =
						new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String requestBody = bufferedReader.readLine();				
				socketRequestConroller(requestBody);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void socketRequestConroller(String requestBody) {
		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResource();
		System.out.println("Debug text : 실행 확인");
		
		switch(resource) {
			case "connection" :
				connection(requestBody);
				break;
				
			case "createRoom" :
				createRoom(requestBody);
				break;
				
			case "join" :
				join(requestBody);
				break;
		}
	}
	
	// gson 명령에 작동하는 메소드	
	private void connection(String requestBody) {
		username = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
		
		List<String> roomNameList = new ArrayList<>();
		
		TpServer.roomList.forEach(room -> {
			roomNameList.add(room.getRoomName());			
		});
		RequestBodyDto<List<String>> updateRoomLustRequestBodyDto = 
				new RequestBodyDto<List<String>>("updateRoomList", roomNameList);
		
		System.out.println("Debug text : 서버 센더 실행 시도");
		TpServerSender.getInstance().send(socket, updateRoomLustRequestBodyDto);
	}
	
	
	private void join(String requestBody) {
		String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
		TpServer.roomList.forEach(room -> {
			if(room.getRoomName().equals(roomName)) {
				room.getUserList().add(this);
				
				List<String> usernameList = new ArrayList<>();
				
				room.getUserList().forEach(con -> {
					usernameList.add(con.username);
				});
				
				room.getUserList().forEach(connectedSocket -> {
					RequestBodyDto<List<String>> updateUserListDto = new RequestBodyDto<List<String>>("updateUserList", usernameList);
					RequestBodyDto<String> joinMessageDto = new RequestBodyDto<String>("showMessage", username + "님이 들어왔습니다.");
					
					TpServerSender.getInstance().send(connectedSocket.socket, updateUserListDto);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {	
						e.printStackTrace();
					}
					TpServerSender.getInstance().send(connectedSocket.socket, joinMessageDto);
		
				});
			}						
		});
				
	}
	
	
	private void createRoom(String requestBody) {
		String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
		TpRoom newRoom = TpRoom.builder()
				.roomName(roomName)
				.owner(username)
				.userList(new ArrayList<TpConnectedSocket>())
				.build();
		
		TpServer.roomList.add(newRoom);
		
		List<String> roomNameList = new ArrayList<>();
		
		TpServer.roomList.forEach(room -> {
			roomNameList.add(room.getRoomName());
		});
		
		RequestBodyDto<List<String>> updateRoomListRequestBodyDto =
				new RequestBodyDto<List<String>>("updateRoomList", roomNameList);
		
		TpServer.tpConnectedSocketList.forEach(con -> {
			TpServerSender.getInstance().send(con.socket, updateRoomListRequestBodyDto);
		});
		System.out.println("Debug text : 방 생성 완료");
	}
	
}
