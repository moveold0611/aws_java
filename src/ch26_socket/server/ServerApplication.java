package ch26_socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication {
	public static void main(String[] args) {
		System.out.println("[ 서버 프로그램 실행 ]");
		
		ServerSocket serverSocket = null;		
		try {
			serverSocket = new ServerSocket(8000);			
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("접속");
				System.out.println(socket.getInetAddress().getHostAddress());
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
