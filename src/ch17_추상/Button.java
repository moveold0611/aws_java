package ch17_추상;
// 인터페이스 (표준)
public interface Button {
	public static final int buttonCount = 4;
	//                        ㄴ static 상수 (인터페이스 안에는 일반 변수 사용 불가)
	
	public void powerOn(); // 인터페이스 안에는 기본적으로 추상메소드 생성
	public void powerOff();
	public void volumeUp();
	public void volumeDown();
	
}
