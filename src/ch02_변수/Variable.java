package ch02_변수;

public class Variable {
	public static void main(String[] args) {
		boolean flag; //선언
		flag = true; //초기화(대입)
		
		System.out.print("FLAG: ");
		System.out.println(flag);
		
		char lastName = '김';
		System.out.println(lastName);
		
		int number = 100;
		System.out.println("점수: " + number);
		
		double pi = 3.14;
		System.out.println(pi);
		
		String name = "김준일";
		System.out.println(name);		
		
		String num1 = "10";
		int num2 = 10;
		System.out.println("String: " + num1);
		System.out.println("int: " + num2); 
		System.out.println();
		
		char num3 = '5';
		System.out.println(num3 + num2);
		
		// 업캐스팅 우선순위 (문자 < 정수 < 실수) / 다운캐스팅은 반대로
		// 정수형 int와 문자형 char를 연산하면 정수형인 int기준으로 연산됨
		System.out.println((double) num3); // 다운캐스팅 (5의 아스키코드값인 53이 출력됨)
		
		/*
		 * 업캐스팅(묵시적 형변환)
		 * 다운캐스팅(명시적 형변환)
		 */
		
		int num4 = num3; //묵시적
		System.out.println(num4);
		
		char num5 = (char) num4; //명시적
		System.out.println(num5);
		
		final int SUPER_NUM = 1; // 상수 선언(선언과 동시에 초기화) / 변경 불가 / 변수명이 모두 대문자
		System.out.println(SUPER_NUM);

	}
}
