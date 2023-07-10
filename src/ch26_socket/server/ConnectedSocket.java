package ch26_socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread{
	private final Socket socket; // 부분 생성자를 만들때는 항상 final 상수 붙이기
	
	
	@Override
	public void run() { // 클라이언트가 보낸 socket객체를 받아서 입력하는 메소드
		BufferedReader bufferedReader = null;
		
		try {
			while(true) {
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // BufferedReader는 reader라는 객체를 받아서 생성해야 한다.
				String requestBody = bufferedReader.readLine();
				System.out.println("입력데이터: " + requestBody);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
}
