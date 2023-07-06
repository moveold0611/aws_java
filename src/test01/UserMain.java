package test01;

public class UserMain {

	public static void main(String[] args) {
		User user = new User("junil" , "1234", "김준일", "junil@gmail.com");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getName());
		System.out.println(user.getEmail());

	}

}
