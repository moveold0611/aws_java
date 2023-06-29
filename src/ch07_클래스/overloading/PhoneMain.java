package ch07_클래스.overloading;

public class PhoneMain {

	public static void main(String[] args) {
		
		Phone phone = new Phone();
		
		phone.send();
		phone.send("str1");
		phone.send("str1", "str2");
		phone.send("str1", 1);
		

	}

}
