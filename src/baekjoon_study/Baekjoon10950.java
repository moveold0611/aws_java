package baekjoon_study;
import java.util.Scanner;

public class Baekjoon10950 {
	// 풀이 보류
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int a, b;
		boolean flag = true;

		while(flag) {
			a = sc.nextInt();
			b = sc.nextInt();
			int c = a + b - 3;
			System.out.println(c);
			if(c == 7) {			
				flag = false;
			}
			

		}
		

	}

}
