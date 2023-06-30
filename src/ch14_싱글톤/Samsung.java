package ch14_싱글톤;

import java.time.LocalDate;
import java.util.Date;

public class Samsung {
	private static Samsung instance;	// 1. 스태틱 instance 만들기
	
	private String companyName;
	private int autoIncrementSerialNumber = LocalDate.now().getYear() * 10000; 
	
	public static Samsung getInstance() { // 2. instance를 받을 메소드 만들기
		if(instance == null) {
			instance = new Samsung();
		}
		return instance;
	}
	
	private Samsung() {
		companyName = "SAMSUNG"; // 3. 스태틱을 private으로 메소드 생성
	}
	
	public int getAutoIncrementSerialNumber() {
		return autoIncrementSerialNumber;
	}
	public void setAutoIncrementSerialNumber(int autoIncrementSerialNumber) {
		this.autoIncrementSerialNumber = autoIncrementSerialNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	
	
	
}
