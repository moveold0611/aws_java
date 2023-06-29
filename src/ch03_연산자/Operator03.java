package ch03_연산자;

public class Operator03 {

	public static void main(String[] args) {
		// 가장 큰 값 골라내기
		int a = 3;
		int b = 4;
		int c = 5;
		int max = 0;
		
		max = a < b ? b : a;
		max = max < c ? c : max;
		
		System.out.println(max);	
		System.out.println(a < b ? b : a < c ? c : a);	
		
		
		//시험 점수		
		int score = 68;
						
		System.out.println((score < 0 || score > 100 ? "error" 
				: score <= 100 && score >= 90 ? "A" 
				: 80 <= score ? "B" 
				: 70 <= score ? "C" 
				: 60 <= score ? "D" 
				: "F") + " 학점");
			System.out.println();
		
		//복합 대입 연산자 +=, -=, *=, /=, %=
		int num1 = 1;
		int num2 = 2;
		
		//ex
		num1 += num2;
		System.out.println(num1);
		
		
	}
}
