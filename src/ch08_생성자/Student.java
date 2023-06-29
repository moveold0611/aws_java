package ch08_생성자;

public class Student {

	final String address, name;
	int age;
	
//	Student() {
//		System.out.println("NoArgsConstructor"); //기본생성자
//	}
	
	Student(String name, int age, String address) {
		System.out.println("AllArgsConstructor");	//전체생성자
		this.name = name;
		this.age = age;
		this.address = address;
		System.out.println("학생 이름: " + name);
		System.out.println("학생 나이: " + age);
		System.out.println("학생 주소: " + address);		
	}
	
	Student(String name) {
		System.out.println("RequiredArgsConstructor"); // 필수생성자
		this.name = name;
		address = null;
		System.out.println("학생 이름: " + name);
	}
	
	// 필수생성자를 쓰면 기본생성자는 사용 불가능해진다.
	// 기본생성자 외의 생성자를 사용할 때, 기본생성자를 사용하려면 반드시 명시해주어야 한다. 
	
}
