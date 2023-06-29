package ch11_문자열;

public class String04 {
	public static void main(String[] args) {
		
		String phone = "     010  -9988. 1916";
		
		String relpacePhone2 = phone
				.replaceAll("-", "")
				.replaceAll(" ", "")
				.replaceAll("[.]", "");
				
		
		System.out.println(relpacePhone2);
		
		String phone2 = phone.trim(); // 시작점과 끝의 공백 삭제
		System.out.println(phone2);

	
	
	}

}
