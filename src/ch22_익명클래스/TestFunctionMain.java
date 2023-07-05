package ch22_익명클래스;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestFunctionMain {

	public static void main(String[] args) {
//		TestFunction1 function1 = () -> {
//			System.out.println("매개변수x, 리턴x");
//		};
		
// 명령문이 하나일 경우 중괄호 생략가능
		TestFunction1 function1 = () -> 
			System.out.println("매개변수x, 리턴x");
		function1.test();

// 매개변수는 타입 생략 가능, 매개변수가 하나일 경우 괄호도 생략가능
		TestFunction2 function2 = num -> { 
			System.out.println("매개변수 1개, 리턴x");
			System.out.println("num: " + num);
		};
		function2.test(2);

// 매개변수명 자유롭게 변경 가능
		TestFunction3 function3 = (age, str) -> {
			System.out.println("매개변수 2개, 리턴x");
			System.out.println("age: " + age);
			System.out.println("str: " + str);
		};
		function3.test(27, "Test");
		
//		TestFunction4 function4 = (num, str) -> {
//			System.out.println("매개변수 o, 리턴o");
//			return "나이: " + num + ", 이름: " + str;
//		};
		
// 명령이 한줄일 경우 중괄호를 생략 할 수 있으며 중괄호를 생략한 경우 즉시 리턴값이 된다.
		TestFunction4 function4 = (num, str) -> 
		"나이: " + num + ", 이름: " + str;
				
		String result1 = function4.test(22, "test");
		System.out.println(result1);

		System.out.println("============================================");
//==============================================================간략화
		
		// Type function1
		Runnable runnable = () -> {
			System.out.println("매개변수x, 리턴x");
		};
		runnable.run();
		
		//Type function2
		Consumer<String> consumerStr = name -> {
			System.out.println("매개변수 1개;, 리턴x");
			System.out.println("str: " + name);
		};
		consumerStr.accept("이동헌");
		
		
		//Type function3
		BiConsumer<String, Integer> biConsumer = (name, age) -> {
			System.out.println("매개변수 2개;, 리턴x");
			System.out.println("age: " + age);
			System.out.println("str: " + name);
		};
		biConsumer.accept("이동헌bi", 27);
		
		//Type function4
		Function<Integer, String> function = year -> "생일: " + year;
		System.out.println(function.apply(1997));
				
		//Type function5 (공급자)/매개변수x, 리턴o/ -> 뒤 리턴값만 바로 입력
		Supplier<Integer> supplier = () -> 100;
		
		System.out.println(supplier.get());
		
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		System.out.println(numbers);
		numbers.removeIf(num -> num % 2 == 0);		
		System.out.println(numbers);
		
		//forEach
		numbers.forEach(num -> System.out.println("출력: " + num));
		
	}
}
