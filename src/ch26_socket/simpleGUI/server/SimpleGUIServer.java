package ch26_socket.simpleGUI.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SimpleGUIServer {
	public static List<ConnectedSocket> connectedSocketList = new ArrayList<>();
	public static Socket socket;
	public static void main(String[] args) {		

		
						
		Thread thread = new Thread( () -> {
			try {
				ServerSocket serverSocket = new ServerSocket(8000);
				System.out.println("[ 서버 실행 ]");
				  
					while(true) {
							socket = serverSocket.accept();
							System.out.println("클라이언트 감지");
							ConnectedSocket connectedSocket = new ConnectedSocket(socket);							
							System.out.println("입력 대기");
							connectedSocketList.add(connectedSocket);			
							connectedSocket.start();							
					}									
				} catch (IOException e) {
					e.printStackTrace();
				}
		});
		thread.start();
		
		
		
	}
}
