package ch19_제네릭;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString(callSuper = true)
public class UpdataUser {
	private String address;
	private String phone;
		
}
