package ch07_클래스;

public class BMain {

	public static void main(String[] args) {
		
		B b1 = new B();

		b1.test1();
		int num1 = b1.test2();
		int num2 = 200;
		System.out.println(num1);
		System.out.println(b1.test2());
		
		if(b1.test3()) {
			System.out.println("if문을 실행.");			
		}
		
		b1.test4("김준일", num2);
		b1.test4(num2 , "김준일");
		
	}

}
