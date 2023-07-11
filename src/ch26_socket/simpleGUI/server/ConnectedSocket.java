package ch26_socket.simpleGUI.server;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import ch26_socket.simpleGUI.server.dto.RequestBodyDto;
import ch26_socket.simpleGUI.server.dto.SendMessage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread{
	
	private final Socket socket;
	private String username;
	
	 @Override
	public void run() {
		 while(true) {
			 try {
				BufferedReader bufferedReader =
						new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String requestBody = bufferedReader.readLine();
				
				requestController(requestBody);
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
	 }
		 
	private void requestController(String requsetBody) {
		Gson gson = new Gson();
		String resource = gson.fromJson(requsetBody, RequestBodyDto.class).getResource();
//		TypeToken<RequestBodyDto<SendMessage>> token = new TypeToken<RequestBodyDto<SendMessage>>() {};
//		RequestBodyDto<SendMessage> requestBodyDto = gson.fromJson(requsetBody,
//				token.getType());
		
		
		switch(resource) {
		case "sendMessage" :
			TypeToken<RequestBodyDto<SendMessage>> typeToken = 
				new TypeToken<RequestBodyDto<SendMessage>>() {};
			
			RequestBodyDto<SendMessage> requsetBodyDto = 
					gson.fromJson(requsetBody, typeToken.getType());
			SendMessage sendMessage = requsetBodyDto.getBody();
			SimpleGUIServer.connectedSocketList.forEach(connectedSocket -> {
				RequestBodyDto<String> dto =
					new RequestBodyDto<String>("showMessage", requsetBody);
			
			ServerSender.getInstance().send(connectedSocket.socket, dto);
			});						
			
			break;
			
			
		case "join" :
			username = (String) gson.fromJson(requsetBody, RequestBodyDto.class).getBody();
			SimpleGUIServer.connectedSocketList.forEach(connectedSocket -> {
				List<String> usernameList = new ArrayList<>();
				
				SimpleGUIServer.connectedSocketList.forEach(con -> {
					usernameList.add(con.username);
				});
				
				RequestBodyDto<List<String>> updateUserListDto = new RequestBodyDto<List<String>>("updateUserList", usernameList);
				RequestBodyDto<String> joinMessageDto = new RequestBodyDto<String>("showMessage", username + "님이 들어왔습니다.");
				
				ServerSender.getInstance().send(connectedSocket.socket, updateUserListDto);
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
					
				ServerSender.getInstance().send(connectedSocket.socket, joinMessageDto);
			});
			
			break;
			
		}
	}
				
												
//				System.out.println(requestBody);
//				simpleGUIServer.connectedSocketList.forEach( connectedSocket -> {
//					try {
//						PrintWriter printWriter = new PrintWriter(connectedSocket.socket.getOutputStream(), true);
//						printWriter.println(requestBody);
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				});
				
//	case2		for(ConnectedSocket connectedSocket = simpleGUIServer.connectedSocketList) {}
				
//  case3		for(int i = 0; i < simpleGUIServer.connectedSocketList.size(); i++) {}		
				

		 
		 
	
	
	 
	 
	
}
