package ch23_예외;

import javax.management.RuntimeErrorException;

public class ArrayExceptionThrows {

	public static void main(String[] args) {
		Integer[] nums = new Integer[] {1, 2, 3, 4, 5};
		
		try {
			printArray(nums);
		} catch (Exception e) {
			System.out.println("예외 처리");
			e.printStackTrace();			
		}
				
		
		System.out.println("프로그램 정상 종료");
		
		
	}
	
	public static void printArray(Integer[] numArray) throws Exception{
		if(true) {
			throw new RuntimeException("예외 강제 생성");
		}
		
		
		for(int i = 0; i < numArray.length + 1; i++) {
			System.out.println(numArray[i]);
		}

	}

	

}
