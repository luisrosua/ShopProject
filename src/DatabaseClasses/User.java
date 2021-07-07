package DatabaseClasses;

public class User {
	private String username;
	private String email;
	private String pass;
	private String province;
	
	public User(String username, String email, String pass, String province) {
		this.username = username;
		this.email = email;
		this.pass = pass;
		this.province = province;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
}
