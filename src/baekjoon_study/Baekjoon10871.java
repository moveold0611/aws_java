package ch00_백준;

import java.io.BufferedWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;


public class Baekjoon10871 {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		
		int n, a, x;
		n = sc.nextInt();
		
		x = sc.nextInt();
						
		bw.write(n);
		bw.write(x);	
		
		for(int i = 0; i < n; i++) {			
			a = sc.nextInt();
			bw.write(a);			
			if(x > a) {
				System.out.print(a + " ");
			}
		}						
		bw.flush();
		bw.close();
		
	}

}
