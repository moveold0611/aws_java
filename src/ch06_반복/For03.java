package ch06_반복;

public class For03 {

	public static void main(String[] args) {
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < i + 1; j++) {
				System.out.print("*");				
			}
			System.out.println();
		}
		
		
		
		System.out.println();
		//문제
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		System.out.println();
		//문제2
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5 - 1 - i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		

		
		
	}

}
