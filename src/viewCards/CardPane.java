package viewCards;

import DatabaseClasses.Card;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class CardPane extends VBox{
	private Label number;
	private Label cvv;
	private Label expiration;
	private Button use;
	
	public CardPane(Card c) {
		this.number = new Label(String.valueOf(c.getNumber()));
		this.cvv = new Label(String.valueOf(c.getCvv()));
		this.expiration = new Label(String.valueOf(c.getExpiration()));
		this.use = new Button("Use");
		
		setStyles();
		
		this.getChildren().addAll(number, cvv, expiration, use);
		this.setAlignment(Pos.CENTER);
	}

	private void setStyles() {
		Font f = new Font("Comic Sans MS", 13);
		
		this.number.setFont(f);
		this.cvv.setFont(f);
		this.expiration.setFont(f);
		this.use.setFont(f);
		
		this.use.setStyle("-fx-background-color: #59A9A0");
		this.setStyle("-fx-background-color: #68CABE");
	}

	public Label getNumber() {
		return number;
	}

	public Label getCvv() {
		return cvv;
	}

	public Label getExpiration() {
		return expiration;
	}

	public Button getUse() {
		return use;
	}
	
}