package ch17_추상;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public abstract class SmartDevice {	 // abstract 추상
	private String deviceName;
	private double displaySize;
	
	public abstract void connectedWiFi(); //추상 메소드(내부 자료가 없음)
	
	
	
	
	
}
