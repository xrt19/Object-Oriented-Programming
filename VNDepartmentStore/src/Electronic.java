
public class Electronic extends Product
{
	private String brand;

	public Electronic(String name, String category, int price, String brand)
	{
		super(name, category, price);
		this.brand = brand;
	}

	@Override
	public void showInfo()
	{
		// TODO Auto-generated method stub
		System.out.println("Name: " + name);
		System.out.println("Price: " + price);
		System.out.println("Category: " + category);
		System.out.println("Brand: " + brand);
	}
	
}
