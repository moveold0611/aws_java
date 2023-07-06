package test01;

public class Factory {
	private static Factory instance;
	
	private String factoryName;	
	
	public static Factory getInstance() { 
		if(instance == null) {
			instance = new Factory();
		}
		return instance;
	}
	
	private Factory () {
		factoryName = "Intel Factory";
	}
			
	
}
