
public class Menu
{
	public Menu(String kode, String nama, double harga)
	{
		super();
		this.kode = kode;
		this.nama = nama;
		this.harga = harga;
	}
	String kode, nama;
	double harga;
	public String getKode()
	{
		return kode;
	}
	public void setKode(String kode)
	{
		this.kode = kode;
	}
	public String getNama()
	{
		return nama;
	}
	public void setNama(String nama)
	{
		this.nama = nama;
	}
	public double getHarga()
	{
		return harga;
	}
	public void setHarga(double harga)
	{
		this.harga = harga;
	}
	

	

}
