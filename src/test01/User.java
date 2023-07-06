package test01;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class User {
	private	String username;
	private	String password;
	private	String name;
	private	String email;
	public String getUsername() {
		System.out.print("username: ");
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		System.out.print("password: ");
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		System.out.print("name: ");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		System.out.print("email: ");
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
