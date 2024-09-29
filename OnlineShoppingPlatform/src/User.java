
public class User {

	protected String userId, username, email;

	public User(String userId, String username, String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}
	
	public void displayUserInfo() {
		System.out.println("Customer ID  : " + userId);
		System.out.println("Username     : " + username);
		System.out.println("Email        : " + email);
	}
	
	public void updateEmail(String email) {
		this.email = email;
	}
	
	public void placeOrder(Order order) {
		
	}

}
