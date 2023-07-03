package ch13_스태틱;

import java.time.LocalDate;
import java.util.Arrays;

import ch10_배열.Array01;

@SuppressWarnings("unused")
public class MessageUtilMain {
	
	private int a;
	
	public static void main(String[] args) {
		//static = 공유(정적)
						
		MessageUtil messageUtil = new MessageUtil();
//		
//		messageUtil.sendMail();
//		messageUtil.sendFile();
		
		MessageUtil.sendFile(); // 스태틱 메소드는 생성을 생략 가능    스태틱.메소드();

		MessageUtil.data = "안녕";
		System.out.println(MessageUtil.data);
		
		System.out.println(messageUtil.data); // 스태틱은 생성된 변수와 메모리를 공유함
				
		
		MessageUtilMain messageUtilMain = new MessageUtilMain();
		System.out.println(messageUtilMain.a); // 스태틱에 변수를 사용하기 위해서는 반드시 생성 필요
		
//		Array01.main(null);     다른 패키지 클래스 호출
		
			
		
		
	}
	
	

}
