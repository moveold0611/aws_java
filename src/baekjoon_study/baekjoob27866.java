package baekjoon_study;

import java.util.Scanner;

public class baekjoob27866 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = null;
		
		for (int i = 0; i < 3;  i++) {
			str = sc.next();
			int a = sc.nextInt();
			str.substring(a);
			System.out.println(str.substring(a - 1, a));
		}
		

	}

}
