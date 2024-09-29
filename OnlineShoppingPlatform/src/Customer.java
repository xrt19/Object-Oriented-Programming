import java.util.ArrayList;

public class Customer extends User {
	
	private String address;
	private ArrayList<Order> orders;
	private ArrayList<Product> cart;
	
	public Customer(String userId, String username, String email, String address) {
		super(userId, username, email);
		this.address = address;
		this.orders = new ArrayList<>();
		this.cart = new ArrayList<>();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public ArrayList<Product> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Product> cart) {
		this.cart = cart;
	}
	
	public void displayCustomerInfo() {
		displayUserInfo();
		System.out.println("Address       : " + address);
	}
	
	public void addToCart(Product product) {
		cart.add(product);
	}
	
	public void viewCart() {
		double totalPrice = 0;
		for (Product product : cart) {
			product.displayProductInfo();
			totalPrice += product.getPrice();
		}
		
		System.out.println("Total Price: " + totalPrice);
	}
	
	public void placeOrder(Order order) {
		orders.add(order);
	}

}
