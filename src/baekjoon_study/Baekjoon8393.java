package ch00_백준;

import java.util.Scanner;

public class Baekjoon8393 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a, b, c;
		a = sc.nextInt();		
		c = 0;
						
		for(int i = 0; i < 10000; i++) {				
			b = i + 1;			
			c = b + c;			
			if(i + 1 == a) {
				System.out.println(c);				
			}						
		}
		
		sc.close();
		
		
	}
}
