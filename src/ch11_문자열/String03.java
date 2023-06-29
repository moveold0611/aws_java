package ch11_문자열;

public class String03 {

	public static void main(String[] args) {
		String[] addressArray = new String[] {
				"부산시 동래구",
				"부산시 부산진구",
				"창원시 마산합포구",				 
				"창원시 진해구"
		};
		
		String[] addressArray2 = new String[0];
		String[] addressArray3 = new String[0];		
				
		for(int i = 0; i < addressArray.length; i++) {						
			if(addressArray[i].contains("부산시")) { // 0, 1				
				String[] tempArray1 = new String[addressArray2.length + 1];
				for(int j = 0; j < addressArray2.length; j++) {
					tempArray1[j] = addressArray2[j];					
				}
				tempArray1[addressArray2.length] = addressArray[i];	
				addressArray2 = tempArray1;
			}else if(addressArray[i].contains("창원시")) { // 2, 3
				String[] tempArray2 = new String[addressArray3.length + 1];
				for(int j = 0; j < addressArray3.length; j++) {
					tempArray2[j] = addressArray3[j];					
				}
				tempArray2[addressArray3.length] = addressArray[i];
				addressArray3 = tempArray2;
			}
		}
		System.out.println("부산시");
		for(int i = 0; i < addressArray2.length; i++) {
			System.out.println(addressArray2[i]);
		}
		
		System.out.println("창원시");
		for(int i = 0; i < addressArray3.length; i++) {
			System.out.println(addressArray3[i]);
		}
		
		
	}

}
