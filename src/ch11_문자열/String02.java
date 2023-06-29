package ch11_문자열;

public class String02 {

	public static void main(String[] args) {
		String phone = "010-9988-1916";

		int index = phone.indexOf("-"); // 앞에서부터 색인
		int lastindex = phone.lastIndexOf("-"); //뒤에서부터 색인
		
		System.out.println(index);
		
		String midNumber = phone.substring(index + 1, lastindex);
	
		System.out.println(midNumber);
		
		boolean findFlag = phone.contains(midNumber);
		System.out.println(findFlag);
	}

}
	