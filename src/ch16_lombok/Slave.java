package ch16_lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
// @RequiredArgsConstructor - 부분생성자 사용하기 위해서 변수가 아닌 상수(final)을 만들어야함
public class Slave {
	private String name;
	private int age;
	
	
	
	
	
}
