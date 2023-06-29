package ch08_생성자;

public class ConstructorMain01 {

	public static void main(String[] args) {
		
		Constructor01 constructor01 = new Constructor01();
		System.out.println(constructor01); // 기본 생성자 - 주소값 호출
		Constructor01 constructor02 = new Constructor01(1);
		System.out.println(constructor02);
	
		
	}

}
