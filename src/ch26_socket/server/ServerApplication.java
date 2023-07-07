package ch26_socket.server;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ServerApplication {
	public static ServerSocket serverSocket;
	public static int port;	

	
	public static void main(String[] args) {						
		Thread connectionThread = null;
		
		System.out.println("[ 서버 프로그램 실행 ]");
	

		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			int selectedMenu = 0;
			System.out.println("1. 서버켜기");
			System.out.println("2. 서버끄기");
			System.out.print("선택: ");
			
			
			try {
				selectedMenu = scanner.nextInt();
				
			} 
			catch (InputMismatchException e) {
				System.out.println("숫자만 입력 가능합니다.");
				continue;
			}
			switch (selectedMenu) {
				case 1:	
					if(serverSocket != null) {
						System.out.println("이미 서버가 실행중입니다.");
						break;
					}
					
					System.out.print("서버의 포트번호를 입력하세요: ");
					port = scanner.nextInt();					
					connectionThread = new Thread(() -> {							
						try {
						serverSocket = new ServerSocket(port);						
							while(!Thread.interrupted()) {								
								Socket socket = serverSocket.accept();																
								System.out.println("[[[[[접속]]]]]");
								System.out.println(socket.getInetAddress().getHostAddress());
							}
							
						} catch (BindException e) {
							System.out.println("이미 사용중인 포트번호입니다.");										
						}catch (SocketException e) {
							System.out.println("서버의 연결이 종료되었습니다.");
						} catch (IOException e) {							
							e.printStackTrace();
						}

					}, "connectionThread");
					
					connectionThread.start();						
					
					
					break;
				
				case 2:	
					if(serverSocket == null) {
						System.out.println("서버가 실행중이지 않습니다.");
						break;
					}
					
					try {
						serverSocket.close();
					} catch (IOException e) {
						connectionThread.interrupt();
					}
					
					try {
						connectionThread.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
																		
					System.out.println("프로그램 종료");					
					return;
				default:
					System.out.println("다시 선택하세요.");				
			}
			
			if(serverSocket == null) {
				try {
					connectionThread.join(500);
				} catch (Exception e) {	
					e.printStackTrace();
				}
				
			}
			
		}
		
		
		
		
		
	}
}

