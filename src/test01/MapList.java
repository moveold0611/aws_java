package test01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapList {	

	public static void main(String[] args) {
		List<Map<String, Object>> customers = new ArrayList<>();
				
		HashMap<String, Object> customersData = new HashMap<>();

		customersData.put("name", "홍길동");
		customersData.put("rating", "vip");
		customersData.put("age", "30");
		customers.add(customersData);		
						
		for(Entry<String, Object> customer : customersData.entrySet()) {
			System.out.print(customer.getKey()+"=");
			System.out.println(customer.getValue());
			if(customer.getKey() == "age") {
				customersData.put("name", "김기영");
				customersData.put("rating", "gold");
				customersData.put("age", "35");				
			}
		}
		
		for(Entry<String, Object> customer : customersData.entrySet()) {
			System.out.print(customer.getKey()+"=");
			System.out.println(customer.getValue());
		}
		
		
	}
	
}
