
public class PaketB extends Menu
{

	public PaketB(String namaPaket, int jumlah)
	{
		super(namaPaket, jumlah);
		// TODO Auto-generated constructor stub
		setHarga(39000);
	}

	@Override
	public int hitungSubTotal()
	{
		return getHarga() * getJumlah();
	}

}