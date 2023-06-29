package ch05_조건;

import java.util.Scanner;

public class Ifscore {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int score;
		String result;	
		
		System.out.print("점수를 입력하세요: ");
		score = scanner.nextInt();
				
		if(score > 100 || score < 0) {
			result = "error";
			
		}else if(score <= 100 && score > 90) {
			result = "A";
			
		}else if(score <= 90 && score > 80 ) {
			result = "B";
			
		}else if(score <= 80 && score > 70) {
			result = "C";
			
		}else if(score <= 70 && score > 60) {
			result = "D";
			
		}else result = "F";
		
		System.out.println(result + "학점입니다.");
		
	}
}
