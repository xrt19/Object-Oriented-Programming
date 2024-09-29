
public class PaketA extends Menu
{

	public PaketA(String namaPaket, int jumlah)
	{
		super(namaPaket, jumlah);
		// TODO Auto-generated constructor stub
		setHarga(29000);
	}

	@Override
	public int hitungSubTotal()
	{
		return getHarga() * getJumlah();
	}

}
