package DatabaseClasses;

import javafx.scene.image.Image;

public class Product {
	private String name;
	private String description;
	private double price;
	private String seller;
	private Image img;
	
	public Product(String name, String description, String seller, double price, Image img) {
		this.name = name;
		this.description = description;
		this.seller = seller;
		this.price = price;
		this.img = img;
	}
	
	public Product(String name, String description, String seller, double price) {
		this.name = name;
		this.description = description;
		this.seller = seller;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getSeller() {
		return seller;
	}

	public Image getImg() {
		return img;
	}

}
