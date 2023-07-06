package test01;

public class Main01 {

	public static void main(String[] args) {
		Order order = Order.builder()
				.orderId(100)
				.productName("Samsung GalaxyBook2 Pro")
				.consumerName("홍길동")
				.price(1450000)
				.stock(2)
				.build();

		order.showOrderInfo();
		
		
	}

}
