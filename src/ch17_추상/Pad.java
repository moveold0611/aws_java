package ch17_추상;

import lombok.ToString;

@ToString(callSuper = true)
public class Pad extends SmartDevice {
	private boolean avilabilityPen;

	public Pad(String deviceName, double displaySize, boolean avilabilityPen) {
		super(deviceName, displaySize);
		this.avilabilityPen = avilabilityPen;
	}
	
	@Override
	public void connectedWiFi() {
		System.err.println("패드에 와이파이를 연결합니다.");
	}
	
	
	
}