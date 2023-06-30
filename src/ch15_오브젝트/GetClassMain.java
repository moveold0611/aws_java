package ch15_오브젝트;

import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class GetClassMain {
	
	public static void main(String[] args) {
		KoreaStudent koreaStudent = new KoreaStudent("20230001", "김채원");
		System.out.println(koreaStudent.getClass());
			
		Method[] methods = koreaStudent.getClass().getDeclaredMethods();
		for(int i = 0; i < methods.length; i++) {
			System.out.println(methods[i].getName());
		}
		
		Field[] fields = koreaStudent.getClass().getDeclaredFields();
		for(int i = 0; i < fields.length; i++) {
			System.out.println(methods[i].getName());
			System.out.println(methods[i].getReturnType());
		}
		
		System.out.println(KoreaStudent.class == koreaStudent.getClass());
		System.out.println(koreaStudent instanceof KoreaStudent);
		System.out.println(koreaStudent.getClass().getName());
		
		
		
		
	}

}
