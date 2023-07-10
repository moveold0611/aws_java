package ch26_socket.simple;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleClient2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		try {
			Socket socket = new Socket("127.0.0.1", 8000);
			
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
