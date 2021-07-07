package viewSell;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class SellView extends BorderPane{
	private Label textName;
	private Label textDesc;
	private Label textPrice;
	
	private TextField name;
	private TextField description;
	private TextField price;
	private Button browse;
	
	private Button sell;
	
	public SellView() {
		this.textName = new Label("Name: ");
		this.textDesc = new Label("Description: ");
		this.textPrice = new Label("Price: ");
		
		this.name = new TextField();
		this.description = new TextField();
		this.price = new TextField();
		
		this.browse = new Button("Browse image");		
		this.sell = new Button("Sell");
		
		Font f = new Font("Comic Sans MS", 13);
		setStyles(f);
		
		GridPane gp = new GridPane();
		gp.setVgap(5);
		gp.setHgap(5);
		
		gp.add(textName, 0, 0);
		gp.add(name, 1, 0);
		gp.add(textDesc, 0, 1);
		gp.add(description, 1, 1);
		gp.add(textPrice, 0, 2);
		gp.add(price, 1, 2);
		gp.add(browse, 1, 3);
		gp.add(sell, 1, 4);
		
		gp.setAlignment(Pos.CENTER);
		
		this.setCenter(gp);
	}

	private void setStyles(Font f) {
		this.textName.setFont(f);
		this.textDesc.setFont(f);
		this.textPrice.setFont(f);
		this.name.setFont(f);
		this.description.setFont(f);
		this.price.setFont(f);
		this.browse.setFont(f);
		this.sell.setFont(f);
		
		this.browse.setStyle("-fx-background-color: #59A9A0");
		this.sell.setStyle("-fx-background-color: #59A9A0");
		this.setStyle("-fx-background-color: #4F9088");
	}

	public TextField getName() {
		return name;
	}

	public TextField getDescription() {
		return description;
	}

	public TextField getPrice() {
		return price;
	}

	public Button getSell() {
		return sell;
	}

	public Button getBrowse() {
		return browse;
	}
	
	
	
}