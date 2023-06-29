package ch12_상속;

public class ProductArray {

	public static void main(String[] args) {
		
		Product[] products = new Product[5];
		
		products[0] = new Computer("삼성 컴퓨터", 1000, "데스크탑");
		products[1] = new Clothes("하의", 2000, "L", "red");
		products[2] = new Computer("맥북", 2000, "랩탑");
		products[3] = new Clothes("상의", 3000, "M", "black");
		products[4] = new Computer("그램", 3000, "랩탑");
		
		
		
		
		// 카테고리 분류하고 정보 출력
		for(int i = 0; i < products.length; i++) {
			System.out.println("모델명: " + products[i].getModel());
			System.out.println("가격: " + products[i].getPrice());				
			if(products[i] instanceof Computer) {
				Computer computer = (Computer) products[i];
				System.out.println("타입: " + computer.getType());
				System.out.println("종류: 컴퓨터");
			}else if(products[i] instanceof Clothes) {
				Clothes clothes = (Clothes) products[i];
				System.out.println("사이즈: " + clothes.getSize());
				System.out.println("색상: " + clothes.getColor());
				System.out.println("종류: 의류");
			}
			System.out.println("=======================");									
		}
		
		
		

		
		
		
	}

}
