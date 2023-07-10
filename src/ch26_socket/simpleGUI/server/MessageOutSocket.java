package ch26_socket.simpleGUI.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MessageOutSocket extends Thread{
	private final Socket socket;
	
	@Override
	public void run() {
		while(true) {
			BufferedWriter bufferedWriter;
			try {
				bufferedWriter =
						new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				String outlineString = bufferedWriter.toString();
				System.out.println(outlineString);
			} catch (IOException e) {				
				e.printStackTrace();
			}
			
		}
		
	}

}
