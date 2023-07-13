package teamProjectTest.socket.tpClient;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import teamProjectTest.socket.tpClient.dto.RequestBodyDto;

public class TpClientSender {
	private Gson gson;
	
	private static TpClientSender instance;
	private TpClientSender() {
		gson = new Gson();
	}
	
	
	public static TpClientSender getInstance() {
		if(instance == null) {
			instance = new TpClientSender();
		}
		return instance;		
	}
	
	
	
	
	
	public void send(RequestBodyDto<?> requestBodyDto) {
		try {
			PrintWriter printWriter = 
					new PrintWriter(TpClient.getInstance().getSocket().getOutputStream(), true);
			printWriter.println(gson.toJson(requestBodyDto));
			System.out.println("Debug text : 클라이언트 센더 실행 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
