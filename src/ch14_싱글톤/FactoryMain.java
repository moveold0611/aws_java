package ch14_싱글톤;
// 싱글톤 = 유일한 객체를 만드는 행위
/*
 * 사용이유
 * 1. 어디서나 접근이 용이한 객체를 만들기 위해
 */

public class FactoryMain {
	public static void main(String[] args) {
		Samsung samsung = new Samsung();
		SamsungFactory factory1 = new SamsungFactory(samsung);
		SamsungFactory factory2 = new SamsungFactory(samsung);
		
		factory1.produce("갤럭시s").showInfo();;
		factory2.produce("갤럭시s2").showInfo();
		factory1.produce("갤럭시s3").showInfo();

	}

}
