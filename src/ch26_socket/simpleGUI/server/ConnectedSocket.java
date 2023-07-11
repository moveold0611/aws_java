package ch26_socket.simpleGUI.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

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
				System.out.println(requestBody);
				simpleGUIServer.connectedSocketList.forEach( connectedSocket -> {
					try {
						PrintWriter printWriter = new PrintWriter(connectedSocket.socket.getOutputStream(), true);
						printWriter.println(requestBody);
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
//	case2		for(ConnectedSocket connectedSocket = simpleGUIServer.connectedSocketList) {}
				
//  case3		for(int i = 0; i < simpleGUIServer.connectedSocketList.size(); i++) {}		
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }
		 
		 
	}
	
	 
	 
	
}
