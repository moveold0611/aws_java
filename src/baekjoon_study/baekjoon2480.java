package baekjoon_study;

import java.util.Scanner;

public class baekjoon2480 {

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
				continue;
				
				
				
			}else if((a == b && a != c) 
					|| (b == c || b != a) 
					|| (a != b && a == c) 
					|| (b == a && b != c)) {
				if(a == b) {
					System.out.println(1000 + a * 100);
					if(c == a) {
						System.out.println(1000 + a * 100);
					}else if (b == c) {
						System.out.println(1000 + b * 100);
						continue;
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
