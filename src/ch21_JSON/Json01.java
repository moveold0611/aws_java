package ch21_JSON;
// 클라이언트와 서버간의 통신은 문자(String)로만 교환되기 때문에 json 사용
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Json01 {

	public static void main(String[] args) {
		//map
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("productCode", "P20230704");
		dataMap.put("productName", "아이폰15");
		
		System.out.println(dataMap);
		
		// json
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("productCode", "P20230704");
		jsonObject.addProperty("productName", "아이폰15");
		
		System.out.println(jsonObject);
		//map과 json의 차이
		
		
		
		//map과 json을 서로 캐스팅하기 위해서 gson 생성
		Gson gson = new Gson();
		
		gson.toJson(dataMap); // dataMap객체를 전부 문자열(String)으로 바꿈
		System.out.println(gson.toJson(dataMap));
		
		Map<String, Object> jsonMap = gson.fromJson(jsonObject, Map.class);
		System.out.println(jsonMap.get("productCode")); // get 타입은 Object
		// jsonObject를 Map 형태로 바꿈
		
		
	}

}
