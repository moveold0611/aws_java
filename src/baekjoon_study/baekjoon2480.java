package ch00_백준;

import java.util.Scanner;

public class Baekjoon2480 {

	// 입력 3 3 6, 2 2 2, 6 2 5
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a, b, c;
		
						
		for(int i = 0; i < 3; i ++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
									
			if(a == b && b == c) {
				if(b >= a) {
					a = b;
					if(c >= a) {
						a = c;
					}
				}
				System.out.println(10000 + a * 1000);			
												
			}else if((a == b && a != c) 
					|| (b == c || b != a) 
					|| (a != b && a == c)) {
				if(a == b) {
					System.out.println(1000 + a * 100);
					if(c == a) {
						System.out.println(1000 + a * 100);
					}else if (b == c) {
						System.out.println(1000 + b * 100);						
					}
				}
				
			// 수정필요
			}else {
				if(b >= a) {
					a = b;
					if(c >= a) {
						a = c;
					}					
				}
				System.out.println(a * 100);				
			}
		
			
			
		}




	}
}
