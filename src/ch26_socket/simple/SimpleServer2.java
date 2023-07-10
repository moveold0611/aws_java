package ch26_socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class SimpleServer2 {
	public static ServerSocket serverSocket;
	public static int port;
	
	public static void main(String[] args) {
		System.out.println("서버 실행");
		List<Socket> socketList = new ArrayList<>();
		
		
		
		
		try {
			serverSocket = new ServerSocket(8000);
			
			while(true) {
			Socket socket = serverSocket.accept();
			socketList.add(socket);
			System.out.println("클라이언트 감지");
			
			Thread thread = new Thread(() -> {	
				Socket threadSocket = socket;
				while(true) {					
					System.out.println("데이터 입력 기다림");
					BufferedReader bufferedReader;
					try {
						InputStreamReader inputStreamReader = new InputStreamReader(threadSocket.getInputStream());
						bufferedReader = new BufferedReader(inputStreamReader);					
						String requestBody = bufferedReader.readLine();
						
						socketList.forEach(s -> {
							try {
								PrintWriter printWriter = new PrintWriter(s.getOutputStream(), true);
								printWriter.println("메세지 내용: (" + requestBody + ")");
							} catch (IOException e) {								
								e.printStackTrace();
							}
						});					
						
					} catch (IOException e) {						
						e.printStackTrace();
					}					
				}			
			});

			thread.start();
		}
			
		
						
		} catch (IOException e) {			
			e.printStackTrace();			
		}
		
		
		
		
		
	}
		
}	
