package ch00_백준;

import java.util.Scanner;

public class Baekjoon2562 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int max = 0;
		int count = 0;
		
		for(int i = 0; i < 9; i++) {
			int put = sc.nextInt();
			if(max < put) {
				max = put;
				count = i + 1;
			}else if(9 == i + 1) {								
				System.out.println("가장 큰 수는 " + count + "번째 수 " + max + "입니다.");
			}
		}
		
				
		

		
		
		

	}

}
