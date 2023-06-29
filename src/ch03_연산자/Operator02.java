package ch03_연산자;

public class Operator02 {

	public static void main(String[] args) {
		final int MAX = 100;
		final int MIN = 0;
		int num = -10;
				
		/*
		 * 논리연산자
		 * 1. ||
		 * 2. &&
		 * 3. ! (부정), (반전)
		 */
		
		System.out.println(MIN < num || num < MAX);
		//  || : 또는 (or), (합)
		// 한쪽의 연산이 true값이면 true
		// true || false = true
				
		System.out.println(MIN < num && num < MAX);
		// &&  :  그리고 (and), (곱)
		// 두 연산이 모두 true값이면 true
		// true && false = false
		 		 
		// !(true || false) = false
		// !true = false
		System.out.println();
		
		
		//문제 (백준 윤년)
		
//		(논리결과 ? 1 : 0)  -> true면 1 출력, false면 0 출력
		
		int year = 2000;		
		System.out.println(year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 1 : 0);
//		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
//			System.out.println(1);
//		}
		
		int year2 = 1999;
		System.out.println(year2 % 4 == 0 && year2 % 100 != 0 || year2 % 400 == 0 ? 1 : 0);
//		if(!(year2 % 4 == 0 && year2 % 100 != 0 || year2 % 400 == 0)) {
//			System.out.println(0);
//		}
		
		boolean result = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		System.out.println(result);
		
		boolean result2 = year2 % 4 == 0 && year2 % 100 != 0 || year2 % 400 == 0;
		
		System.out.println(result ? 1 : 0);
		System.out.println(result2 ? 1 : 0);
		
		int result3 = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 1 : 0;
		int result4 = year2 % 4 == 0 && year2 % 100 != 0 || year2 % 400 == 0 ? 1 : 0;
				
		System.out.println(result3);
		System.out.println(result4);
				
	}
}
