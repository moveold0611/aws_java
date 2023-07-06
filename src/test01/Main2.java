package test01;

import java.util.Arrays;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		List<String> subjects = Arrays.asList(new String[] {"C", "Java" ,"Python"});
		SubjectService subjectService = new SubjectService(subjects);
		subjectService.showSubjects();
		subjects.size();
		
	}

}
