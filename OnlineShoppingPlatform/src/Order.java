import java.util.ArrayList;

public class Order {
	
	private String orderId, orderDate, status;
	private ArrayList<Product> orderItems;
	
	public Order(String orderId, String orderDate, ArrayList<Product> orderItems) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.status = "Ordered";
		this.orderItems = orderItems;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public String getStatus() {
		return status;
	}

	public ArrayList<Product> getOrderItems() {
		return orderItems;
	}

	public void displayOrderInfo() {
		System.out.println("Order ID     : " + orderId);
		System.out.println("Order Date   : " + orderDate);
		System.out.print("Total Price  : "); calculateTotalPrice();
	}
	
	public void calculateTotalPrice() {
		double totalPrice = 0;
		for (Product order : orderItems) {
			totalPrice = order.getPrice();
		}
		System.out.println(totalPrice);
	}
	
	public void processOrder() {
		for (Product product : ShoppingSystem.products) {
			for (Product order : orderItems) {
				if (order.getProductId().equals(product.getProductId())) {
					if (product instanceof Clothing) {
						((Clothing) product).addToOrder(this);
					} else {
						((Electronics) product).addToOrder(this);
					}
				}	
			}
		}
		
		System.out.println("Order is placed"); 
	}

}
