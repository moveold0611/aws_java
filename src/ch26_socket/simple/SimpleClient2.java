package ch26_socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleClient2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("클라이언트 실행");
		
		
		
		try {
			Socket socket = new Socket("127.0.0.1", 8000);
			Thread inputThread = new Thread( () -> {				
				try {
//					InputStream inputStream = socket.getInputStream();
//					InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
					while(true) {
						BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						String requestBody = bufferedReader.readLine();
						System.out.println("내용: " + requestBody);
					}
				} catch (IOException e) {					
					e.printStackTrace();
				}									
			});
			inputThread.start();
			// 서버에서 데이터를 전달받을 코드
			
			
			while(true) {
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
				System.out.println("입력: ");
				String input = scanner.nextLine();
				
				printWriter.println(input);
			}
			
			
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
}
