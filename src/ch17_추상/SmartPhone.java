package ch17_추상;

import lombok.ToString;

//lombok은 상속을 했을때 부모클래스의 생성자를 만들어주지 않는다.

@ToString(callSuper = true)
public class SmartPhone extends SmartDevice implements Button {

	private String phoneNumber;

	public SmartPhone(String deviceName, double displaySize, String phoneNumber) {
		super(deviceName, displaySize);
		this.phoneNumber = phoneNumber;
	} 
	
	
	
	@Override
	public void connectedWiFi() {
		System.out.println("스마트폰에 와이파이를 연결합니다.");
	}



	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		
	}



	
	
	
	
	
}