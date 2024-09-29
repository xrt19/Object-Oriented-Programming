
public class Food extends Product
{
	private int expired;

	public Food(String name, String category, int price, int expired)
	{
		super(name, category, price);
		this.expired = expired;
	}

	@Override
	public void showInfo()
	{
		// TODO Auto-generated method stub
		System.out.println("Name: " + name);
		System.out.println("Price: " + price);
		System.out.println("Category: " + category);
		System.out.println("Expired: " + expired);
	}
	
}
