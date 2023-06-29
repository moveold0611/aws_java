package ch12_상속;

public class Computer extends Product {	
	
	private String type;
		
//	public Computer() {
//		 super("", 10); // 기본생성자 뿐이라면 생략됨 (부모 클래스 주소 생성)
//		System.out.println("컴퓨터 객체 생성");
//	}
	
	
	public Computer(String model, int price) {
		super(model, price);		
		
	}
				
	public Computer(String model, int price, String type) {
		super(model, price);
		this.type = type;
	}




	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
		
	
	

	
	
}
