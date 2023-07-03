package ch20_컬렉션;

public class CustomArrayList {
	private String[] array;
	
	public CustomArrayList() {
		array = new String[0];
	}
	
	public void add(String str) {
		String[] newArray = new String[array.length + 1];
		for(int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		
		newArray[array.length] = str;
		array = newArray;		
	}
	
		
	public void add(int index, String str) {
		// 1. index 이하의 기존 배열 보존
		String[] newArray = new String[array.length + 1];
		for(int i = 0; i < index; i++) {
			newArray[i] = array[i];			
		}
		// 2. 새로운 배열 삽입
		newArray[index] = str;
		
		// 3. index 초과의 기존 배열 보존
		for(int i = index; i < array.length; i++) {
			newArray[i + 1] = array[i]; 
		}
		// 4. 조합
		array = newArray;		
	}
	
	
	
	
	
	public String remove() {
		String value = null;
		String[] newArray = new String[array.length - 1];
		
		value = array[array.length - 1];
		
		for(int i = 0; i < newArray.length; i++) {
			newArray[i] = array[i];
		}		
		array = newArray;
		
		return value;
	}
	
	
	
	
	
	public String remove(int index) {
		String value = null;
		String[] newArray = new String[array.length - 1];
		
		value = array[index];
	
		for(int i = 0; i < index; i++) {
			newArray[i] = array[i];
		}		
		for(int i = index; i < array.length - 1; i++) {
			newArray[i] = array[i + 1];
		}
		array = newArray;
		
		return value;
	}
	
	
	public void set(int index, String str) {
		array[index] = str;		
		}
		
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for(String str : array) { // foreach문 (array의 배열을 순서대로 꺼내서 str에 대입)
			builder.append(str + ", "); 
		}
		builder.delete(builder.lastIndexOf(","), builder.length());
		builder.append("]");		
		return builder.toString();
	}
	
}
