package model;

public class Login {

	private String Username;
	private String Password;
	
	public Login() {
		
	}
	
	public Login(String username, String password) {
		super();
		Username = username;
		Password = password;
	}


	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Login [Username=" + Username + ", Password=" + Password + "]";
	}

	

}
