package teamProjectTest.socket.tpServer;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import teamProjectTest.socket.tpServer.tpEntity.TpRoom;

public class TpServer {
	public static Socket socket;
	public static List<TpConnectedSocket> tpConnectedSocketList = new ArrayList<>();
	public static List<TpRoom> roomList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		
		Thread thread = new Thread(() -> {
			try {
				ServerSocket serverSocket = new ServerSocket(8000);
				System.out.println("Debug text : 서버 실행");

				while(true) {
					socket = serverSocket.accept();
					System.out.println("Debug text : 클라이언트 감지");
					TpConnectedSocket tpConnectedSocket = new TpConnectedSocket(socket);
					tpConnectedSocketList.add(tpConnectedSocket);
					System.out.println("Debug text : 서버 소켓 리스트에 저장");
					tpConnectedSocket.start();
				}

			} catch (IOException e) {				
				e.printStackTrace();
			}		
		});
		thread.start();
		
		
		
		
		
	}
	
}
