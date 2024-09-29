import java.util.*;

public class Main
{
	Scanner scan = new Scanner(System.in);
	ArrayList<Product> listProduct = new ArrayList<>(); 
	
	public Main()
	{
		int choice;
		
		do
		{
			// TODO Auto-generated constructor stub
			System.out.println("VN Department Store Product Management");
			System.out.println("======================================");
			
			System.out.println("1. Add Product");
			System.out.println("2. View Products");
			System.out.println("3. Remove Product");
			System.out.println("4. Exit");
			
			System.out.print(">> ");
			choice = scan.nextInt(); scan.nextLine();
			
			if (choice == 1)
			{
				add();
			}
			else if (choice == 2) {
				view();
			}
			else if (choice == 3) {
				remove();
			}
			else if (choice == 4) {
				exit();
			}
		} while (choice != 4);
		
		
	}
	
	public void exit()
	{
		System.out.println("Thank you for using our program ...\nHave a nice day! :D");
	}
	
	public void add()
	{
		System.out.println("Add Product");
		System.out.println("======================================");
		
		String name, category, size, brand;
		int price, expired;
		
		do
		{
			System.out.print("Input product name [5 - 20 characters]: ");
			name = scan.nextLine();
		} while (!validateName(name));
		
		do
		{
			System.out.print("Input product price [20k - 5 mill]: ");
			price = scan.nextInt(); scan.nextLine();
		} while (!validatePrice(price));
		
		do
		{
			System.out.print("Input product category [Clothing | Food | Electronic]: ");
			category = scan.nextLine();
		} while (!validateCategory(category));
		
		if (category.equals("Clothing"))
		{
			do
			{
				System.out.print("Input product size [Small | Medium | Large | Extra Large]: ");
				size = scan.nextLine();
			} while (!validateSize(size));
			listProduct.add(new Clothing(name, category, price, size));
		}
		else if (category.equals("Food")) 
		{
			do
			{
				System.out.print("Input product expiration year [2023 - 2028]: ");
				expired = scan.nextInt(); scan.nextLine();
			} while (!validateExpired(expired));
			listProduct.add(new Food(name, category, price, expired));
		}
		else if (category.equals("Electronic")) 
		{
			do
			{
				System.out.print("Input product brand [2 - 10]: ");
				brand = scan.nextLine();
			} while (!validateBrand(brand));
			listProduct.add(new Electronic(name, category, price, brand));
		}
		
		System.out.println("Successfully added new " + category);
	}
	
	public boolean validateBrand(String brand)
	{
		int len = brand.length();
		if (len >= 2 && len <= 20) return true;
		return false;
	}
	
	public boolean validateExpired(int year)
	{
		if (year >= 2023 && year <= 2028) return true;
		return false;
	}
	
	public boolean validateCategory(String category)
	{
		if (category.equals("Clothing")) return true;
		if (category.equals("Food")) return true;
		if (category.equals("Electronic")) return true;
		return false;
	}
	
	public boolean validateSize(String size)
	{
		if (size.equals("Small")) return true;
		if (size.equals("Medium")) return true;
		if (size.equals("Large")) return true;
		if (size.equals("Extra Large")) return true;
		return false;
	}
	
	public boolean validatePrice(int price)
	{
		if (price >= 20000 && price <= 5000000) return true;
		return false;
	}
	
	public boolean validateName(String name)
	{
		int len = name.length();
		
		if (len >= 5 && len <= 20) return true;
		return false;
	}
	
	public void view()
	{
		
		if (listProduct.isEmpty())
		{
			System.out.println("There is no product in the list");
			return;
		}
		System.out.println("View Product");
		int no = 1;
		for (Product product : listProduct)
		{
			System.out.println("======================================");
			System.out.println("No: " + no);
			no += 1;
			product.showInfo();
		}
	}
	
	public void remove()
	{
		view();
		if (listProduct.isEmpty()) return;
		
		System.out.println("Delete Product");
		
		System.out.print("Input product no want to delete [1 - " + listProduct.size() + " ]: ");
		int productNoWantToRemove = scan.nextInt();
		
		if (listProduct.size() < productNoWantToRemove) 
		{
			System.out.println("There is no product no " + productNoWantToRemove);
			return;
		}
		
		int realIdx = productNoWantToRemove - 1;
		
		System.out.println("Product " + listProduct.get(realIdx).getName() + " succesfully deleted");
		listProduct.remove(realIdx);
	}
	
	

	public static void main(String[] args)
	{
		new Main();
	}
}
