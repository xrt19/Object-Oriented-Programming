import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingSystem {

	public static ArrayList<Product> products;
	private ArrayList<User> users;
	private Scanner scan = new Scanner(System.in);
	private User loggedInUser = null;
	
	public ShoppingSystem() {
		System.out.println("=== Online Shopping Platform ===");
		String userId;
		do {
			System.out.print("Input Customer ID: ");
			userId = scan.nextLine();
		} while (validateUser(userId) == null);
		
		loggedInUser = validateUser(userId);
		displayMainMenu();
	}
	
	public User validateUser(String id) {
		for (User user : users) {
			if (user.getUserId().equals(id)) return user;
		}
		return null;
	}
	
	public void displayMainMenu() {
		int choice;
		do {
			System.out.println("=== Online Shopping Platform ===");
			System.out.println("1. Shop for Products");
			System.out.println("2. View Shopping Cart");
			System.out.println("3. View Orders");
			System.out.println("4. Customer Info");
			System.out.println("5. Exit");
			System.out.print("Your Choice: ");
			choice = scan.nextInt(); scan.nextLine();
			
			if (choice == 1) {
				displayProductsMenu();
			} else if (choice == 2) {
				displayCartMenu();
			} else if (choice == 3) {
				displayOrdersMenu();
			} else if (choice == 4) {
				displayCustomerInfo();
			} else if (choice == 5) {
				exit();
			}
		} while (choice != 5);
	}
	
	public void displayProductsMenu() {
		int choice;
		do {
			System.out.println("=== Shop for Products ===");
			System.out.println("1. View All Products");
			System.out.println("2. Add Clothing to Cart");
			System.out.println("3. Add Electronics to Cart");
			System.out.println("4. Back to Main Menu");
			System.out.print("Your Choice: ");
			choice = scan.nextInt(); scan.nextLine();
			
			if (choice == 1) {
				System.out.println("=== View All Products ===");
				for (Product product : products) {
					product.displayProductInfo();
				}
				scan.nextLine();
			} else if (choice == 2) {
				System.out.println("=== Add Clothing to Cart ===");
				for (Product product : products) {
					if (product instanceof Clothing) {
						product.displayProductInfo();
					}
				}
				
				String clothingId;
				do {
					System.out.print("Enter the ID to add to your cart (or type 'back' to go back): ");
					clothingId = scan.nextLine();
				} while (validateProductId(clothingId) == null && !clothingId.equals("back"));
				
				if (clothingId.equals("back")) continue;
				
				((Customer) loggedInUser).addToCart(validateProductId(clothingId));
			} else if (choice == 3) {
				System.out.println("=== Add Electronics to Cart ===");
				for (Product product : products) {
					if (product instanceof Electronics) {
						product.displayProductInfo();
					}
				}
				
				String electronicId;
				do {
					System.out.print("Enter the ID to add to your cart (or type 'back' to go back): ");
					electronicId = scan.nextLine();
				} while (validateProductId(electronicId) == null && !electronicId.equals("back"));
				
				if (electronicId.equals("back")) continue;
				
				((Customer) loggedInUser).addToCart(validateProductId(electronicId));
			} 
		} while (choice != 4);
	}
	
	public Product validateProductId(String id) {
		for (Product product : products) {
			if (product.getProductId().equals(id)) return product;
		}
		return null;
	}
	
	public void displayCartMenu() {
		int choice;
		do {
			System.out.println("=== View Shopping Cart ===");
			System.out.println("1. View Cart Contents");
			System.out.println("2. Check Out");
			System.out.println("3. Back to Main Menu");
			System.out.print("Your Choice: ");
			choice = scan.nextInt(); scan.nextLine();
			
			if (choice == 1) {
				System.out.println("=== View Cart ===");
				((Customer) loggedInUser).viewCart();
				scan.nextLine();
			} else if (choice == 2) {
				System.out.println("=== Check Out ===");
				((Customer) loggedInUser).viewCart();
				
				String confirm;
				do {
					System.out.print("Do you want to proceed with the checkout (Y | N): ");
					confirm = scan.nextLine();
				} while (!confirm.equals("Y") && !confirm.equals("N"));
				
				if (confirm.equals("Y")) {
					Order order = new Order("O001", "09-01-2024", ((Customer)loggedInUser).getCart());
					order.processOrder();
					((Customer) loggedInUser).placeOrder(order);
					scan.nextLine();
				}
			}
		} while (choice != 3);
	}
	
	public void displayOrdersMenu() {
		int choice;
		do {
			System.out.println("=== View Orders ===");
			System.out.println("1. View Order History");
			System.out.println("2. Track Order");
			System.out.println("3. Back to Main Menu");
			System.out.print("Your Choice: ");
			choice = scan.nextInt(); scan.nextLine();
			
			if (choice == 1) {
				System.out.println("=== View Order History ===");
				ArrayList<Order> orders = ((Customer)loggedInUser).getOrders();
				for (Order order : orders) {
					order.displayOrderInfo();
				}
				
				String orderId;
				do {
					System.out.print("Enter the Order ID to view details (type 'back' to go back): ");
					orderId = scan.nextLine();
				} while (validateOrder(orders, orderId) == null && !orderId.equals("back"));
				
				if (orderId.equals("back")) continue;
				
				Order order = validateOrder(orders, orderId);
				System.out.println("=== Order Details ===");
				order.displayOrderInfo();
				
				System.out.println("Order Items:");
				for (Product product : order.getOrderItems()) {
					if (product instanceof Clothing) {
						((Clothing) product).displayOrderDetails();
					} else {
						((Electronics) product).displayOrderDetails();
					}
				}
				scan.nextLine();
			} else if (choice == 2) {
				System.out.println("=== Track Order ===");
				ArrayList<Order> orders = ((Customer)loggedInUser).getOrders();
				String orderId;
				do {
					System.out.print("Enter the Order ID to track (type 'back' to go back): ");
					orderId = scan.nextLine();
				} while (validateOrder(orders, orderId) == null && !orderId.equals("back"));
				
				if (orderId.equals("back")) continue;
				
				Order order = validateOrder(orders, orderId);
				System.out.println("=== Order Tracking ===");
				System.out.println("Order ID     : " + order.getOrderId());
				System.out.println("Order Status : " + order.getStatus());
				scan.nextLine();
			} 
		} while (choice != 3);
	}
	
	public Order validateOrder(ArrayList<Order> orders, String id) {
		for (Order order : orders) {
			if (order.getOrderId().equals(id)) return order;
		}
		return null;
	}
	
	public void displayCustomerInfo() {
		((Customer) loggedInUser).displayCustomerInfo();
		scan.nextLine();
	}
	
	public void exit() {
		loggedInUser = null;
		System.out.println("Thank you for using our program");
	}

	public static void main(String[] args) {
		new ShoppingSystem();
	}

}
