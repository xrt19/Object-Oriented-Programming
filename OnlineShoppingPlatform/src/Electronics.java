
public class Electronics extends Product implements Orderable {
	
	private String brand;
	private int warrantyPeriod, quantityInStock;

	public Electronics(String productId, String productName, double price, String brand, int warrantyPeriod,
			int quantityInStock) {
		super(productId, productName, price);
		this.brand = brand;
		this.warrantyPeriod = warrantyPeriod;
		this.quantityInStock = quantityInStock;
	}

	@Override
	public void displayOrderDetails() {
		System.out.println("Product ID    : " + productId);
		System.out.println("Product Name  : " + productName);
		System.out.println("Product Price : " + price);
	}

	@Override
	public void addToOrder(Order order) {
		quantityInStock--;
	}

	@Override
	public void displayProductInfo() {
		System.out.println("Product ID    : " + productId);
		System.out.println("Product Name  : " + productName);
		System.out.println("Product Price : " + price);
		System.out.println("Product Brand : " + brand);
		System.out.println("Availability  : " + (isAvailable() ? "In Stock" : "Out of Stock"));
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public boolean isAvailable() {
		return (quantityInStock > 0) ? true : false;
	}

}
