package ch18_빌더;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@AllArgsConstructor

@Data
@Builder
public class KoreaUser {	
	private int userId;
	private String username;
	private String password;
	private String name;
	private String email;

	
	
	
	// @Builer 만들시 생성되는 코드
	
	public static KoreaUserBuilder builder() {
		return new KoreaUserBuilder();	
	}
					
	public static class KoreaUserBuilder { // 클래스 안에 클래스 생성
//		private int userId;
//		private String username;
//		private String password;
//		private String name;
//		private String email;	
//		
//		public KoreaUser build() {
//			return new KoreaUser(userId, username, password, name, email);
//		}	
//			
//			public KoreaUserBuilder userId(int userId) {
//				this.userId = userId;
//				return this;
//			}
//			
//			public KoreaUserBuilder username(String username) {
//				this.username = username;
//				return this;
//			}
//			
//			public KoreaUserBuilder password(String password) {
//				this.password = password;
//				return this;
//			}
//			
//			public KoreaUserBuilder name(String name) {
//				this.name = name;
//				return this;
//			}
//			
//			public KoreaUserBuilder email(String email) {
//				this.email = email;
//				return this;
//			}
	}
	
	
	
}
