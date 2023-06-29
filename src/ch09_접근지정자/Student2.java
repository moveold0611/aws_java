package ch09_접근지정자;

public class Student2 {
	private String name;
	private int age;
	

	
	
	//Setter
	public void setName(String name) {		
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//Getter
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
}
