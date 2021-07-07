package viewProducts;

import DatabaseClasses.Product;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ProductPane extends BorderPane{
	
	private Label name;
	private Label description;
	private Label seller;
	private Label price;
	private Image img;
	
	private Button buy;
	
	public ProductPane(Product p) {
		name = new Label(p.getName());
		description = new Label(p.getDescription());
		seller = new Label(p.getSeller());
		price = new Label(String.valueOf(p.getPrice()));
		img = p.getImg();
		buy = new Button("Buy!");
		
		Font f = new Font("Comic Sans MS", 13);
		
		setStyles(f);
		
		ImageView i = new ImageView(img);
		i.setFitHeight(150);
		i.setFitWidth(250);
		
		StackPane sp = new StackPane();
		sp.getChildren().add(i);
		sp.setAlignment(Pos.CENTER_LEFT);
		
		VBox vb = new VBox(6);
		vb.getChildren().addAll(i, name, description, seller, price, buy);
		vb.setAlignment(Pos.CENTER_RIGHT);
		
		this.setLeft(sp);
		this.setCenter(vb);
	}

	public void setStyles(Font f) {
		name.setFont(f);
		description.setFont(f);
		seller.setFont(f);
		price.setFont(f);
		buy.setFont(f);
		
		buy.setStyle("-fx-background-color: #59A9A0");
		
		this.setStyle("-fx-background-color: #68CABE");
	}

	public Button getBuy() {
		return buy;
	}

	public Label getName() {
		return name;
	}

	public Label getDescription() {
		return description;
	}

	public Label getSeller() {
		return seller;
	}

	public Label getPrice() {
		return price;
	}

	public Image getImg() {
		return img;
	}
}