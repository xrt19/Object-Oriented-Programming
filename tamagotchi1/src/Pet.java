

public class Pet 
{
	// (Pet Name, Pet Type, Hunger Meter, Happy Meter, Training Meter)
	String nama, tipe;
	int train, feed, clean;
	public Pet(String nama, String tipe, int train, int feed, int clean) {
		super();
		this.nama = nama;
		this.tipe = tipe;
		this.train = train;
		this.feed = feed;
		this.clean = clean;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getTipe() {
		return tipe;
	}
	public void setTipe(String tipe) {
		this.tipe = tipe;
	}
	public int getTrain() {
		return train;
	}
	public void setTrain(int train) {
		this.train = train;
	}
	public int getFeed() {
		return feed;
	}
	public void setFeed(int feed) {
		this.feed = feed;
	}
	public int getClean() {
		return clean;
	}
	public void setClean(int clean) {
		this.clean = clean;
	}
	
}