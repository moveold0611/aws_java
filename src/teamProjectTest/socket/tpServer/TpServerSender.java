package teamProjectTest.socket.tpServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;

import teamProjectTest.socket.tpClient.dto.RequestBodyDto;

public class TpServerSender {
	private Gson gson;
	
	private static TpServerSender instance;
	private TpServerSender() {
		gson = new Gson();
	}
	
	public static TpServerSender getInstance() {
		if(instance == null) {
			instance = new TpServerSender();
		}
		return instance;
	}
	
	
	
	public void send(Socket socket, RequestBodyDto<?> requestBodyDto) {
		PrintWriter printWriter;
		try {
			printWriter = new PrintWriter(socket.getOutputStream(), true);
			printWriter.println(gson.toJson(requestBodyDto));
			System.out.println("Debug text : 서버 센더 실행 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
