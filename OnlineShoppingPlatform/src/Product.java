
public abstract class Product {
	
	protected String productId, productName;
	protected double price;
	
	public Product(String productId, String productName, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public abstract void displayProductInfo();
	public abstract double getPrice();
	public abstract boolean isAvailable();
	
}
