package test01;

import java.util.ArrayList;
import java.util.List;

public class Main3 {
	public static void main(String[] args) {
		
	
		List<Student> students = new ArrayList<>();
		
		students.add(new Student(1001, "홍길동"));
		students.add(new Student(1002, "강철수"));
		students.add(new Student(1003, "김영희"));
		
		for(Student student : students) {
//			if(student == null) {
//				continue;
//			}
			student.showStudent();
		}
		
		
		
	}
	
}
