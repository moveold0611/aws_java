package ch26_socket.simpleGUI.server;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Objects;

import com.google.gson.Gson;

import ch26_socket.simpleGUI.server.dto.RequestBodyDto;
import ch26_socket.simpleGUI.server.dto.SendMessage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread{
	
	private final Socket socket;
	
	 @Override
	public void run() {
		 while(true) {
			 try {
				BufferedReader bufferedReader =
						new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String requestBody = bufferedReader.readLine();
				
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
	 }
		 
	private void requestController(String requsetBody) {
		Gson gson = new Gson();
		RequestBodyDto<?> requestBodyDto = gson.fromJson(requsetBody, RequestBodyDto.class);
		
		switch(requestBodyDto.getResource()) {
		case "sendMessage" :
			SendMessage sendMessage = (SendMessage) requestBodyDto.getBody();
			if(Objects.isNull(sendMessage.getToUsername())){
				simpleGUIServer.connectedSocketList.forEach(con -> {
					RequestBodyDto<String> showMessageDto =
							new RequestBodyDto<String>("showMessage", sendMessage.getFromUsername() + ": " + sendMessage.getMessageBody());
					ServerSender.getInstance().send(con.socket, showMessageDto);
				}) ;
			}
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
