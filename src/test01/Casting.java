package test01;

public class Casting {

	public static void main(String[] args) {
		Program[] programs = new Program[2];
		programs[0] = new Java();
		programs[1] = new C();
				
		for(int i = 0; i < programs.length; i++) {
			programs[i].develop();
			if(programs[i].getClass() == Java.class) {
				Java java = (Java) programs[i];
				java.garbageCollection();
			}else if(programs[i].getClass() == C.class) {
				C c = (C) programs[i];
				c.defineStructure();
			}
			
		}
		
	}

}
