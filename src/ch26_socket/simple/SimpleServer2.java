package ch26_socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer2 {
	public static ServerSocket serverSocket;
	public static int port;
	
	public static void main(String[] args) {
		System.out.println("서버 실행");
		
		
		try {
			
			Socket socket = serverSocket.accept();
			System.out.println("클라이언트 감지");
			Thread thread = new Thread(() -> {
				
				while(true) {
					
					System.out.println("데이터 입력 기다림");
					BufferedReader bufferedReader;
					try {
						InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
						bufferedReader = new BufferedReader(inputStreamReader);					
						System.out.println(bufferedReader.readLine());
					} catch (IOException e) {						
						e.printStackTrace();
					}					
				}			
			});

			thread.start();
		
			
			
		} catch (IOException e) {			
			e.printStackTrace();			
		}
		
		
		
		
		
	}
	
	
}	
