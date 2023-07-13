package teamProjectTest.socket.tpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.google.gson.Gson;

import teamProjectTest.socket.tpClient.dto.RequestBodyDto;

public class TpClientReceiver extends Thread{
	
	@Override
	public void run() {
		System.out.println("Debug text : 클라이언트 리시버 실행 완료");
		TpClient tpClient = TpClient.getInstance();
		while(true) {
			try {
				BufferedReader bufferedReader =
						new BufferedReader(new InputStreamReader(tpClient.getSocket().getInputStream()));
				String requestBody = bufferedReader.readLine();
				receiverRequsetController(requestBody);
			} catch (IOException e) {	
				e.printStackTrace();
			}
		}	
	}
	
	
	private void receiverRequsetController(String requestBody) {
		Gson gson = new Gson();
		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResource();
		
		switch (resource) {
			case "updateRoomList" :
				List<String> roomList = (List<String>) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				TpClient.getInstance().getRoomListModel().clear();
				TpClient.getInstance().getRoomListModel().addAll(roomList);				
				break;

		}
	}
	
	
}
