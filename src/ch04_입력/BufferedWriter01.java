package ch04_입력;

import java.io.BufferedWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BufferedWriter01 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		bw.write(str);
		
		bw.flush();
		bw.close();

	}

}
