package ch20_컬렉션;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@ToString
@Data
public class TestUser {
	private String username;
	private String password;
		
}
