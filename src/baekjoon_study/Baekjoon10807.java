package ch00_백준;

import java.util.Scanner;

public class Baekjoon10807 {
// Q) 변수입력 넘어가는것을 공백으로 받는 방법
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n, b, v, rt;				
		rt = 0;

		// 1. 반복 횟수 입력
		n = sc.nextInt();
		int a[] = new int[n];
		
		// 2. 배열 나열
		for(int i = 0; i < n; i++) {
			b = sc.nextInt();
			a[i] = b;
		}		
		
		// 3. 찾을 값 입력
		v = sc.nextInt();
		for(int i = 0; i < a.length; i++) {					
			if(a[i] == v) {
				rt++;
			}
		}
		
		// 4. 찾은 값의 갯수 출력
		System.out.println(rt);
		
	}

}
