package ch26_socket.simpleGUI.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.google.gson.Gson;

import ch26_socket.simpleGUI.client.dto.RequestBodyDto;

public class ClientReceiver extends Thread{
		
	@Override
	public void run() {
		SimpleGUIClient simpleGUIClient = SimpleGUIClient.getInstance();
		while(true) {
			try {
				BufferedReader bufferedReader = 
						new BufferedReader(new InputStreamReader(simpleGUIClient.getSocket().getInputStream()));
				String requestBody = bufferedReader.readLine();
//				simpleGUIClient.getTextArea().append(requestBody + "\n");
				requestController(requestBody);
				
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
	

	
	private void requestController(String requestBody) {
		Gson gson = new Gson();
		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResource();
		
		switch(resource) {
		
			case "updateRoomList" :
				List<String> roomList = (List<String>) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				SimpleGUIClient.getInstance().getRoomListModel().clear();
				SimpleGUIClient.getInstance().getRoomListModel().addAll(roomList);
				break;
		
			case "updateUserList" :
				List<String> usernameList = (List<String>) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				SimpleGUIClient.getInstance().getUserListModel().clear();
				usernameList.set(0, usernameList.get(0) + " <방장>");
				SimpleGUIClient.getInstance().getUserListModel().addAll(usernameList);
				break; 				
				
			case "showMessage" :
				String messageContent = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				SimpleGUIClient.getInstance().getChattingTextArea().append(messageContent + "\n");
				break;			
				
			case "removeTextArea" :
				String removeTextArea = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				SimpleGUIClient.getInstance().getChattingTextArea().setText("");
				break;
				
			case "removeRoom" :
				System.out.println("룸리스트 삭제");
				String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				SimpleGUIClient.getInstance().getRoomList().remove(
						SimpleGUIClient.getInstance().getRoomListModel().indexOf(roomName));
				break;
				

		}
	}
	
		
		
			
}
		
	

