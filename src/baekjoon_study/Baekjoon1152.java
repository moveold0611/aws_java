package ch00_백준;

import java.util.ArrayList;
import java.util.Scanner;

// 단어의 개수

/*
입력 :  The Curious Case of Benjamin Button
 		The first character is a blank
 		The last character is a blank

출력 : 	6 6 6
*/
public class Baekjoon1152 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String s1; // 입력받을 문자열 변수
		int a; // 단어 수를 담을 정수 변수
	
		
								
		// 단순 3번 반복문
		
//		for(int i = 0; i < 3; i++) {
//			a = 0; // a 값 초기화
//			s1 = sc.nextLine(); // s1 초기화, 입력
//			s1 = s1.trim();	 // s1 첫, 끝 공백삭제
//			for(int j = 0; j < s1.length(); j++) { // 단어 수 세는 반복문
//				if(s1.indexOf(" ") == j) {	// 공백 위치 찾기
//					s1 = s1.substring(s1.indexOf(" ") + 1, s1.length()); // 공백 이전 단어 자르기				
//					a++; // 찾은 공백 수 세기					
//					j = 0; // j 값을 초기화하여 다시 처음부터 찾기
//				}else if(j == s1.length() - 1) { // 찾을 위치가 끝에 도달
//					System.out.println(a + 1); // 찾은 공백 수 + 1(마지막 단어)										
//				}
//			}	
//		}

	
		
		
		
		
		// 엔터만 입력할 경우 탈출하는 반복문
		
//		int n = 0;
//		for(int i = 0; i < n + 1; i++) {
//			a = 0; // a 값 초기화
//			s1 = sc.nextLine(); // s1 초기화, 입력
//			s1 = s1.trim();	 // s1 첫, 끝 공백삭제
//			for(int j = 0; j < s1.length(); j++) { // 단어 수 세는 반복문
//				if(s1.indexOf(" ") == j) {	// 공백 위치 찾기
//					s1 = s1.substring(s1.indexOf(" ") + 1, s1.length()); // 공백 이전 단어 자르기				
//					a++; // 찾은 공백 수 세기					
//					j = 0; // j 값을 초기화하여 다시 처음부터 찾기
//				}else if(j == s1.length() - 1) { // 찾을 위치가 끝에 도달
//					System.out.println(a + 1); // 찾은 공백 수 + 1(마지막 단어)										
//				}
//			}if (s1 != "") { // 입력 문자열이 없는게 아닐 시
//				n++; // n값을 ++하여 다시 반복
//			}
//		}
		
		
		
		
		
		
		// 스트링으로 받아서 저장하고 한번에 출력하도록 나누기
		
//		int n = 0;		
//		StringBuilder sb = new StringBuilder();
//		for(int i = 0; i < n + 1; i++) {
//			a = 0;
//			s1 = sc.nextLine();
//			s1 = s1.trim();
//			for(int j = 0; j < s1.length(); j++) {
//				if(s1.indexOf(" ") == j) {	
//					s1 = s1.substring(s1.indexOf(" ") + 1, s1.length());			
//					a++; 				
//					j = 0; 				
//				}else if(j == s1.length() - 1) { 
//				sb.append(a + 1 + " ");	//arr1.add(i, (String) a + 1);						
//				}
//			}if (s1 != "") { 
//				n++; 
//			}			
//		}
//		sb.delete(sb.lastIndexOf(" "), sb.length());
//		System.out.println(sb);
		
		
		
		
		// 배열로 받아서 저장하고 한번에 출력하기
		
		int n = 0;		
		ArrayList<Integer> arr1 = new ArrayList<>();
		for(int i = 0; i < n + 1; i++) {
			a = 0;
			s1 = sc.nextLine();
			s1 = s1.trim();
			for(int j = 0; j < s1.length(); j++) {
				if(s1.indexOf(" ") == j) {	
					s1 = s1.substring(s1.indexOf(" ") + 1, s1.length());			
					a++; 				
					j = 0; 				
				}else if(j == s1.length() - 1) { 
				arr1.add(i, a + 1);						
				}
			}if (s1 != "") { 
				n++; 
			}			
		}		
		System.out.println(arr1);
		
		
		
		
	}
}
