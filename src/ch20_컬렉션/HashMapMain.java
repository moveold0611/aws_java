package ch20_컬렉션;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapMain {

	public static void main(String[] args) {
		HashMap<String, String> strMap = new HashMap<>();
		strMap.put("username", "aaa");
		strMap.put("password", "1234");
		strMap.put("name", "김준일");
		// 값 삽입(put)
		
		System.out.println(strMap);
		System.out.println(strMap.get("username"));
		// 값 출력(get)
		
		strMap.entrySet();
		for(Entry<String, String> entry : strMap.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}// 인덱스가 없는 HashMap의 반복을 돌리는법 (entry) 
		
		for(String key : strMap.keySet()) {
			System.out.println(strMap.get(key));
			System.out.println(key);
		}
		
		
		
	}

}
