
public class Clothing extends Product
{
	private String size;

	public Clothing(String name, String category, int price, String size)
	{
		super(name, category, price);
		this.size = size;
	}

	public String getSize()
	{
		return size;
	}

	public void setSize(String size)
	{
		this.size = size;
	}

	@Override
	public void showInfo()
	{
		// TODO Auto-generated method stub
		System.out.println("Name: " + name);
		System.out.println("Price: " + price);
		System.out.println("Category: " + category);
		System.out.println("Size: " + size);
		
	}

}
