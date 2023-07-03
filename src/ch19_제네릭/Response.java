package ch19_제네릭;
// 클래스 안의 변수 자료형을 다양한 상황에 맞추기 위해 사용
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response<T> { //제네릭 클래스
	private int statusCode;
	private T data; // T자료형을 상황에 맞춰서 변환
	
	
	
	
}
