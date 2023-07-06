package ch12_상속;

public class ProductMain {
	public static void main(String[] args) {
		
		// instanceOf (객체 자료형 비교)
		
		Computer computer = new Computer("삼성 컴퓨터", 1000, "데스크탑");
		Clothes clothes = new Clothes("상의", 2000, "L", "black");
		
		Product product = computer;

		Computer computer2 = (Computer) product;
		
		System.out.println(computer2.getType());
		System.out.println(computer2.getModel());
		
		
		
		
		
		
		double a = 3.14;
		int b;
		
		b = (int)a;
		System.out.println(b);
		
		a = b;
		System.out.println(a);
		// 기본 자료형은 다운캐스팅 후 업캐스팅을 하면 자료가 넘쳐서 잘린다.			
		
		
		Computer computer3 = new Computer("model1", 1, "type1");			
		System.out.println(computer3.getType());
															
		Computer computer4 = new Computer("model2", 2, "type2");
		
		Product product2 = computer3;
		computer4 = (Computer)product2;
		
		System.out.println(computer4.getType());
		// 클래스 자료형은 다운캐스팅 후 업캐스팅을 해도 자료가 메모리에 저장되어 있다가 다시 나타난다.
		
	}

}
