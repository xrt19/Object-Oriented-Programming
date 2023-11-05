import java.util.*;
public class Main
{
	public static void main(String[] args)
	{
		// init
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Regular> regularMenu = new ArrayList<>();
		ArrayList<Special> specialMenu = new ArrayList<>();
		
		System.out.println("Family Restaurant");
		
		System.out.println("=====================");
		
		while(true)
		{
			System.out.println("1. Add Regular Menu");
			System.out.println("2. Add Special Menu");
			System.out.println("3. Show All Menu");
			System.out.println("4. Delete Regular Menu");
			System.out.println("5. Delete Special Menu");
			System.out.println("6. Exit");
			
			System.out.print("Choice [1-6]: ");
			int choice = scan.nextInt();
			
			if (choice == 1)
			{
				System.out.println("Add Regular Menu");
				System.out.println("=====================");
				
				String kode, name;
				double price;
				
				while(true)
				{
					while(true)
					{
						System.out.print("Input menu code [R...]: ");
						kode = scan.next();
						
						if (kode.charAt(0) == 'R' && kode.length() == 4)
						{
							break;
						}
					}
					
					while(true)
					{
						System.out.print("Input menu name [5 - 20]: ");
						name = scan.nextLine();
						
						int lenName = name.length();
						if (lenName >= 5 && lenName <= 20)
						{
							break;
						}
					}
					
					while(true)
					{
						System.out.print("Input menu price [10k - 100k]: ");
						price = scan.nextDouble();
						
						if(price >= 10000 && price <= 100000){
							{
								break;
							}
						}
					}
					
				}
				// kode, name, price
				// dogList.add(new Dog (nama, tipe, a, b, c));
				regularMenu.add(new Regular(kode, name, price));
				
				
			}
			else if (choice == 6) {
				break;
			}
			
			
		}
	}

}
