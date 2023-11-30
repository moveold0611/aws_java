package ch00_백준;

import java.util.Scanner;

public class Baekjoon11022 {
	// (반복)A + B - 8
	
	// 입력 5 11 23 34  98 52
	
	/* 출력Case #1: 1 + 1 = 2
	Case #2: 2 + 3 = 5
			Case #3: 3 + 4 = 7
			Case #4: 9 + 8 = 17
			Case #5: 5 + 2 = 7
			*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a, b, n;
		
		n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			a = sc.nextInt();
			b = sc.nextInt();			
			System.out.println
			("Case #" + (i + 1) + ": " + (a) +" + " + (b) + " = " + (a + b));
		}
		
		

	}

}
