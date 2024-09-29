import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main
{	
		Scanner scan = new Scanner(System.in);
		Random random = new Random();	
		String noTransaksi;
		ArrayList<Menu> listMenu = new ArrayList<>();
		
		public Main()
		{
			int choice;
			noTransaksi = randomNoTransaksi();
			
			while(true)
			{
				System.out.println("Hokben Cashier");
				System.out.println("Tanggal: " + LocalDateTime.now());
				System.out.println("No. Transaksi: " + noTransaksi);
				System.out.println("+====================+==========+==========+==========+");
				System.out.println("| Menu               + Harga    + Jumlah   + Subtotal +");
				System.out.println("+====================+==========+==========+==========+");
				
				for (Menu menu : listMenu)
				{
					System.out.printf("| %-18s | %-8s | %-8d | %-8d |\n", 
							menu.getNamaPaket(), menu.getHarga(), menu.getJumlah(), menu.hitungSubTotal());
				}	
				
				System.out.println("Total: " + hitungTotalHarga());
				System.out.println("Hokben Cashier");
				System.out.println("1. Add item");
				System.out.println("2. Print receipt");
				System.out.println("3. Exit");
				System.out.print(">> ");
				
				choice = scan.nextInt(); scan.nextLine(); 
				
				if (choice == 1)
				{
					addItem();
				}
				else if (choice == 2)
				{
					printreceipt();
				}
				else if (choice == 3)
				{
					break;
				}
			}
		}
		
		public void addItem()
		{
			int choice;
			while(true)
			{
				System.out.println("Hokben Menu");
				
				System.out.println("1. Paket A Ekkado");
				System.out.println("2. Paket B Shrimp Roll");
				System.out.println("3. Paket C Beef Yakiniku");
				System.out.println("0. Back");
				System.out.print(">> ");
				
				choice = scan.nextInt(); scan.nextLine();
				
				if (choice == 0)
				{
					return;
				}
				
				if (choice >= 1 && choice <= 3)
				{
					int jumlah;
					
					while(true)
					{
						System.out.print("Jumlah: ");
						jumlah = scan.nextInt(); scan.nextLine();
						
						if (jumlah > 0)
						{
							break;
						}
					}
					
					if (choice == 1)
					{
						listMenu.add(new PaketA("Paket A", jumlah));
					}
					else if (choice == 2)
					{
						listMenu.add(new PaketB("Paket B", jumlah));
					}
					else if (choice == 3)
					{
						listMenu.add(new PaketC("Paket C", jumlah));
					}
					
					return;
				}
			}
		}
		
		public void printreceipt()
		{
			listMenu.clear();
		}
		
		public int hitungTotalHarga()
		{
			int totalHarga = 0;
			
			for (Menu menu : listMenu)
			{
				totalHarga += menu.hitungSubTotal();
			}
			return totalHarga;
		}
		
		public String randomNoTransaksi()
		{
			int res = random.nextInt(100000); // ini 100k
			
			return String.format("HK%05d",res);
		}
		
	
	public static void main(String[] args)
	{
		new Main();
	}
}
