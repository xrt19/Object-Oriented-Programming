
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main 
{
	
	public static int createRandom1() 
	{
		Random rand = new Random();
		
		int randInt = 0;
		
		while(true) 
		{
			randInt = rand.nextInt(1000);
			
			if(randInt >= 30 && randInt <= 50)
				break;
		}
		
		return randInt;
		
	}
	
	public static int createRandom2() 
	{
			Random rand = new Random();
			
			int randInt = 0;
			
			while(true) 
			{
				randInt = rand.nextInt(1000);
				
				if(randInt >= 2 && randInt <= 5)
					break;
			}
			
			
			return randInt;
			
	}
	
	public static void main(String[] args)
	{
		System.out.println("Tamagochi Emulator\n");
		
		ArrayList<Cat> catList = new ArrayList<>();
		ArrayList<Dog> dogList = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1. Add\n2. Show\n3. Train\n4. Feed\n5. Clean");
			
			System.out.print("Input choice [1-5]: ");
		
				
			int choice = sc.nextInt(); 
			sc.nextLine();
			
			if (choice == 1)
			{
				// add menu
				System.out.println("Add Menu");
				System.out.print("Input type [Dog / Cat]: ");
				String tipe = sc.next();
				sc.nextLine();
				
				System.out.print("Input name: ");
				String nama = sc.nextLine();
				System.out.println("Data added");
				
				int a = createRandom1();
				int b = createRandom1();
				int c = createRandom1();
				
				if (tipe.equals("Cat"))
				{
					catList.add(new Cat (nama, tipe, a, b, c));
				}
				else if (tipe.equals("Dog")) 
				{
					dogList.add(new Dog (nama, tipe, a, b, c));
				}
			}
			else if (choice == 2)
			{
				// show menu
				System.out.println("Show Menu");
				if (catList.isEmpty() && dogList.isEmpty())
				{
					System.out.println("Data empty! No pet!");
				}
				else 
				{
					if (!catList.isEmpty())
					{
						for (Cat cat : catList)
						{
							System.out.println("===");
							System.out.print("Name:" + cat.getNama() + "\n");
							System.out.print("Type:" + cat.getTipe() + "\n");
							System.out.print("Training Meter:" + cat.getTrain() + "\n");
							System.out.print("Hunger Meter:" + cat.getFeed() + "\n");
							System.out.print("Happy Meter:" + cat.getClean() + "\n");
							System.out.println("===");
						}
					}
					if (!dogList.isEmpty())
					{
						for (Dog dog : dogList)
						{
							System.out.println("===");
							System.out.print("Name:" + dog.getNama() + "\n");
							System.out.print("Type:" + dog.getTipe() + "\n");
							System.out.print("Training Meter:" + dog.getTrain() + "\n");
							System.out.print("Hunger Meter:" + dog.getFeed() + "\n");
							System.out.print("Happy Meter:" + dog.getClean() + "\n");
							System.out.println("===");
						}
					}
					
					
				}
			}
			else if (choice == 3)
			{
				// train menu
				System.out.println("Train Menu");
				System.out.print("Input type [Dog / Cat]: ");
				String tipe = sc.next();
				sc.nextLine();
				
				System.out.print("Input name: ");
				String nama = sc.nextLine();
				// sc.nextLine();
				
				if (tipe.equals("Cat"))
				{
					for (Cat cat : catList)
					{
						if (cat.getNama().equals(nama))
						{
							// increase Training Meter and
							// Decrease Hunger and Happy Meter
							cat.setTrain(cat.getTrain() + createRandom2());
							cat.setFeed(cat.getFeed() - createRandom2());
							cat.setClean(cat.getClean() - createRandom2());		
							break;
						}
					}
				}
				else if (tipe.equals("Dog")) 
				{
					for (Dog dog : dogList)
					{
						if (dog.getNama().equals(nama))
						{
							// increase Training Meter and
							// Decrease Hunger and Happy Meter
							dog.setTrain(dog.getTrain() + createRandom2());
							dog.setFeed(dog.getFeed() - createRandom2());
							dog.setClean(dog.getClean() - createRandom2());		
							break;
						}
					}
				}
			}
			else if (choice == 4) 
			{
				System.out.println("Feed Menu");
				
				System.out.print("Input type [Dog / Cat]: ");
				String tipe = sc.next();
				sc.nextLine();
				
				System.out.print("Input name: ");
				String nama = sc.nextLine();
				// sc.nextLine();
				
				if (tipe.equals("Cat"))
				{
					for (Cat cat : catList)
					{
						if (cat.getNama().equals(nama))
						{
							// increase Hunger Meter and
							// Decrease Happy and Training Meter
							cat.setFeed(cat.getFeed() + createRandom2());
							cat.setTrain(cat.getTrain() - createRandom2());
							cat.setClean(cat.getClean() - createRandom2());		
							break;
						}
					}
				}
				else if (tipe.equals("Dog")) 
				{
					for (Dog dog : dogList)
					{
						if (dog.getNama().equals(nama))
						{
							dog.setFeed(dog.getFeed() + createRandom2());
							dog.setTrain(dog.getTrain() - createRandom2());
							dog.setClean(dog.getClean() - createRandom2());		
							break;
						}
					}
				}
				
			}
			
			else if (choice == 5) 
			{
				System.out.println("Clean Menu");
				
				System.out.print("Input type [Dog / Cat]: ");
				String tipe = sc.next();
				sc.nextLine();
				
				System.out.print("Input name: ");
				String nama = sc.nextLine();
				// sc.nextLine();
				
				if (tipe.equals("Cat"))
				{
					for (Cat cat : catList)
					{
						if (cat.getNama().equals(nama))
						{
							// increase Happy Meter and
							// Decrease Hunger and Training
							cat.setClean(cat.getClean() + createRandom2());
							cat.setFeed(cat.getFeed() - createRandom2());
							cat.setTrain(cat.getTrain() - createRandom2());	
							break;
						}
					}
				}
				else if (tipe.equals("Dog")) 
				{
					for (Dog dog : dogList)
					{
						if (dog.getNama().equals(nama))
						{
							dog.setClean(dog.getClean() + createRandom2());	
							dog.setFeed(dog.getFeed() - createRandom2());
							dog.setTrain(dog.getTrain() - createRandom2());	
							break;
						}
					}
				}
				
			}
			else 
			{
				System.out.println("Wrong input");
			}
			
			
			
		}
	}
}