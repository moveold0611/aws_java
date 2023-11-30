package ch00_백준;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Baekjoon2739 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = sc.nextInt();
		bw.write(a);				
		
		for(int i = 0; i < 9; i++) {
			System.out.println(a + " * " + i + " = " + a * (i + 1));			
		}
		sc.close();
		bw.flush();
		bw.close();
	}

}
