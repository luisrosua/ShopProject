package Database;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Statement;

import DatabaseClasses.User;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import DatabaseClasses.Product;
import DatabaseClasses.Card;
import DatabaseClasses.Message;

public class ShopDB extends Database{
	Statement stm;
	
	public ShopDB() throws Exception{
		this.stm = (Statement) this.con.createStatement();
	}
	
	public User getUserData(String username) throws Exception {
		String sql = "SELECT * FROM users WHERE username = '"+username+"'";
		
		ResultSet result = this.stm.executeQuery(sql);
		
		User u = new User("--","--","--","--");
		
		if(result.next()) {
			u = new User(result.getString("username"), result.getString("email"), result.getString("password"), getProvinceName(result.getInt("province_id")));
		}
		return u;
	}
	
	public boolean checkUser(User u) throws Exception{
		String sql = "SELECT username FROM users WHERE username = '"+u.getUsername()+"'";
		
		ResultSet result = this.stm.executeQuery(sql);
		
		if(result.next()) {
			return true;
		}
		return false;
	}
	
	public boolean checkPass(User u) throws Exception{
		String sql = "SELECT password FROM users WHERE username = '"+u.getUsername()+"'";
		
		ResultSet result = this.stm.executeQuery(sql);
		
		if(result.next()) {
			return true;
		}
		return false;
	}
	
	public void insertUser(User u) throws Exception{
		
		int prov = searchProvinceId(u.getProvince());
		
		String sql = "INSERT INTO users VALUES ('"+u.getUsername()+"', '"+u.getEmail()+"', '"+u.getPass()+"', "+prov+");";
		
		this.stm.executeUpdate(sql);
	}
	
	public boolean searchProvince(String prov) throws Exception{
		String sql = "SELECT name FROM provinces WHERE name = '"+prov+"'";
		
		ResultSet result = this.stm.executeQuery(sql);
		
		if(result.next()) {
			return true;
		}
		return false;
	}
	
	public int searchProvinceId(String prov) throws Exception{
		String sql = "SELECT province_id FROM provinces WHERE name = '"+prov+"'";
		
		ResultSet result = this.stm.executeQuery(sql);
		
		int id = 0;
		
		if(result.next()) {
			id = result.getInt("province_id");
		}
		
		return id;
	}
	
	public String getProvinceName(int prov) throws Exception{
		String sql = "SELECT name FROM provinces WHERE province_id = "+prov;
		
		ResultSet result = this.stm.executeQuery(sql);
		
		String name = "";
		if(result.next()) {
			name = result.getString("name");
		}
		
		return name;
	}
	
	public String[] getAllProvinces() throws Exception{
		String[] provinces = new String[52];
		
		String sql = "SELECT name FROM provinces";
		
		ResultSet result = this.stm.executeQuery(sql);
		
		int i = 0;
		while(result.next()) {
			provinces[i] = result.getString("name");
			i++;
		}
		
		return provinces;
	}
	
	public void updateUser(User u, String oldUser) throws Exception{
		String sql = "UPDATE users SET username = '"+u.getUsername()+"', email = '"+u.getEmail()+"', password = '"+u.getPass()+"', province_id = "+searchProvinceId(u.getProvince())+" WHERE username = '"+oldUser+"';";
		
		this.stm.executeUpdate(sql);
	}
	
	public ArrayList<Message> getMessages(User u) throws Exception{
		ArrayList<Message> m = new ArrayList<Message>();
		String sql = "SELECT * FROM messages WHERE addressee_id = '"+u.getUsername()+"'";
		ResultSet result = this.stm.executeQuery(sql);
		
		while(result.next()) {
			Message me = new Message(result.getString("message"), result.getString("remitter_id"), result.getString("addressee_id"));
			m.add(me);
		}
		
		return m;
	}
	
	public void sendMessage(Message m) throws Exception{
		String sql = "INSERT INTO messages VALUES (NULL, '"+m.getMessage()+"', '"+m.getRemitter()+"', '"+m.getAddressee()+"');";
		
		this.stm.executeUpdate(sql);
	}
	
	public ArrayList<Card> getCards(String username) throws Exception{
		ArrayList<Card> cards = new ArrayList<Card>();
		String sql = "SELECT * FROM cards WHERE user = '"+username+"';";
		
		ResultSet result = this.stm.executeQuery(sql);
		
		while(result.next()) {
			Card c = new Card(result.getLong("card_number"), result.getInt("cvv"), result.getDate("expiration_date"));
			cards.add(c);
		}
		
		return cards;
	}
	
	public void insertCard(Card c, String username) throws Exception{
		System.out.println(c.getExpiration());
		String sql = "INSERT INTO cards VALUES("+c.getNumber()+", "+c.getCvv()+", '"+c.getExpiration()+"', '"+username+"');";
		
		this.stm.executeUpdate(sql);
	}
	
	public void boughtProduct(String seller, String name, String buyer) throws Exception{
		String sql = "UPDATE products SET buyer_id = '"+buyer+"' WHERE seller_id = '"+seller+"' AND name = '"+name+"';";
		
		this.stm.executeUpdate(sql);
	}
	
	public void sellProduct(Product p, File f) throws Exception{
		
		InputStream in = new FileInputStream(f.getAbsolutePath());
		
		String sql = "INSERT INTO products VALUES (NULL, '"+p.getName()+"', '"+p.getDescription()+"', "+p.getPrice()+", '"+p.getSeller()+"', NULL, ?);";
		
		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setBinaryStream(1, in);
		
		ps.executeUpdate();
		
	}
	
	public ArrayList<Product> getFilteredProducts(String name, String username) throws Exception{
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "SELECT p.* FROM products p, users u, provinces pr WHERE p.seller_id = u.username AND u.province_id = pr.province_id AND pr.name = '"+name+"' AND p.buyer_id IS NULL AND p.seller_id <> '"+username+"';";
		
		ResultSet result = this.stm.executeQuery(sql);
		
		while(result.next()) {
			Blob aBlob = (Blob) result.getBlob("image");
			byte[] imageByte = aBlob.getBytes(1, (int) aBlob.length());
            InputStream is=new ByteArrayInputStream(imageByte);
            BufferedImage imag=ImageIO.read(is);
            Image image=convertToFxImage(imag);
			Product p = new Product(result.getString("name"), result.getString("description"), result.getString("seller_id"), result.getDouble("price"), image);

			products.add(p);
		}
		return products;
	}
	
	public ArrayList<Product> getProducts(User u) throws Exception{
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM products WHERE buyer_id IS NULL AND seller_id <> '"+u.getUsername()+"'";
		
		ResultSet result = this.stm.executeQuery(sql);
		
		while(result.next()) {
			Blob aBlob = (Blob) result.getBlob("image");
			byte[] imageByte = aBlob.getBytes(1, (int) aBlob.length());
            InputStream is=new ByteArrayInputStream(imageByte);
            BufferedImage imag=ImageIO.read(is);
            Image image=convertToFxImage(imag);
			Product p = new Product(result.getString("name"), result.getString("description"), result.getString("seller_id"), result.getDouble("price"), image);

			products.add(p);
		}
		return products;
	}
	
	private static Image convertToFxImage(BufferedImage image) {
	    WritableImage wr = null;
	    if (image != null) {
	        wr = new WritableImage(image.getWidth(), image.getHeight());
	        PixelWriter pw = wr.getPixelWriter();
	        for (int x = 0; x < image.getWidth(); x++) {
	            for (int y = 0; y < image.getHeight(); y++) {
	                pw.setArgb(x, y, image.getRGB(x, y));
	            }
	        }
	    }

	    return new ImageView(wr).getImage();
	}
	
}