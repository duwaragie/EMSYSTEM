package main.hr;

public class HR {
	private int id;
	private String name;
	private String phone;
	private String email;
	private String username;
	private String password;
	
	public HR(int id, String name, String phone, String email, String username, String password) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}


	public String getPhone() {
		return phone;
	}

	

	public String getEmail() {
		return email;
	}

	
	public String getUsername() {
		return username;
	}

	
	public String getPassword() {
		return password;
	}


	
	

}
