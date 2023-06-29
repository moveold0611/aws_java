package ch11_문자열;

public class StringBuilder01 {
	public static void main(String[] args) {
		
//		String str = "abc";
//		
//		str = str + "def";
//		System.out.println(str);
		
		StringBuilder builder = new StringBuilder();
		builder.append("이름: ");
		builder.append("김준일");
		builder.delete(builder.indexOf(":"), builder.indexOf(":") + 1);
		builder.insert(2, ">>");
		
		String str = builder.toString();
		System.out.println(str);
		
		String name = "이름: 김준일";
		
		System.out.print(name.substring(0, name.indexOf(":")));
		System.out.println(name.substring(name.indexOf(":") + 1));
		
		
		
	}

}
