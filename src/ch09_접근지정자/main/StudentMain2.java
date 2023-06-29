package ch09_접근지정자.main;

import ch09_접근지정자.Student2;

public class StudentMain2 {
	public static void main(String[] args) {
		Student2 s = new Student2();
		s.setName("홍길동");
		s.setAge(1);		
		System.out.println(s.getAge());
		System.out.println(s.getName());
		
	}

}
