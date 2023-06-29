package ch08_생성자;

public class StudentMain {

	public static void main(String[] args) {
//		Student s1 = new Student();    
//		new Student();
//		System.out.println(s1);
//		s1.name = "김준일";
//		s1.age = 30;
//		s1.address = "부산 동래구"; //기본생성자 호출
		
//		System.out.println();
//		System.out.println(s1.name);
//		System.out.println();
		
		Student s2 = new Student("이동헌", 27, "부산");
		System.out.println();
		
		Student s3 = new Student("홍길동");
	
		
		
	}
}
