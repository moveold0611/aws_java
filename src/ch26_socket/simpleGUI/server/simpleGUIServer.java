package ch26_socket.simpleGUI.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class simpleGUIServer {
	public static List<ConnectedSocket> connectedSocketList = new ArrayList<>();
	public static Socket socket;
	public static void main(String[] args) {
		
		Thread inputThread = new Thread( () -> { // 입력 스레드
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
	//					Thread inputThread = new Thread( () -> { // 입력 스레드
	//	
	//					}
	//					Thread outputThread = new Thread( () -> { //출력 스레드
	//						messageOutSocket.start();
	//						System.out.println("출력");
	//						messageOutSocket.toString();
	//					});
				}									
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		inputThread.start();
		
		MessageOutSocket messageOutSocket = new MessageOutSocket(socket);
		messageOutSocket.start();
		System.out.println("출력");
		messageOutSocket.toString();
			
		
	}
}
