package IT_Support_Staff;

public class ITSupportStaff {
	private int ITSupportId;
	private String name;
	private String email;
	private int phone;
	private String username;
	private String password;
	public ITSupportStaff(int iTSupportId, String name, String email, int phone, String username, String password) {
		
		ITSupportId = iTSupportId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}
	public int getITSupportId() {
		return ITSupportId;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public int getPhone() {
		return phone;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setITSupportId(int iTSupportId) {
		ITSupportId = iTSupportId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}