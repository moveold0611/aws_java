package test01;

public class Order {
	private int orderId;
	private String productName;
	private String consumerName;
	private int price;
	private int stock;
	
	public Order(int orderId, String productName, String consumerName, int price, int stock) {
		super();
		this.orderId = orderId;
		this.productName = productName;
		this.consumerName = consumerName;
		this.price = price;
		this.stock = stock;
	}
	
	public static OrderBuilder builder() {	
		return new OrderBuilder();
	}
	
	public Order orderId(int orderId) {
		this.orderId = orderId;
		return this;
	}
	public Order productName(String productName) {
		this.productName = productName;
		return this;
	}
	public Order consumerName(String consumerName) {
		this.consumerName = consumerName;
		return this;
	}
	public Order price(int price) {
		this.price = price;
		return this;
	}
	public Order stock(int stock) {
		this.stock = stock;
		return this;
	}

	public void showOrderInfo() {	
		System.out.println("주문번호: " + orderId);
		System.out.println("상품명: " + productName);
		System.out.println("구매자: " + consumerName);
		System.out.println("가격: " + price);
		System.out.println("수량: " + stock);
	}

	public static class OrderBuilder {
		private int orderId;
		private String productName;
		private String consumerName;
		private int price;
		private int stock;
		

		
		public Order build() {
			return new Order(orderId, productName, consumerName, price, stock);
		}	
			
		public OrderBuilder orderId(int orderId) {
			this.orderId = orderId;
			return this;
		}
		public OrderBuilder productName(String productName) {
			this.productName = productName;
			return this;
		}
		public OrderBuilder consumerName(String consumerName) {
			this.consumerName = consumerName;
			return this;
		}
		public OrderBuilder price(int price) {
			this.price = price;
			return this;
		}
		public OrderBuilder stock(int stock) {
			this.stock = stock;
			return this;
		}
		
	}



				
}
