package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	protected Connection con;
	private String url;
	private String user;
	private String pass;
	
	public Database() throws Exception{
		con = null;
		this.url = "jdbc:mysql://localhost:3306/shop";
		this.user = "root";
		this.pass = "";
		con = DriverManager.getConnection(url, user, pass);
	}
}
