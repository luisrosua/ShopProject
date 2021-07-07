package viewNav;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class NavMenuPane extends HBox{
	private Label title;
	private Button home;
	private Button profile;
	private Button sell;
	private Button messages;
	private Button logout;
	
	public NavMenuPane() {
		title = new Label("SECOND HAND SHOP");
		title.setFont(new Font("Impact", 35));
		title.setAlignment(Pos.CENTER);
		
		home = new Button("Home");
		profile = new Button("Profile");
		sell = new Button("Sell product");
		messages = new Button("Messages");
		logout = new Button("Logout");
		
		setStyles();
		
		this.getChildren().addAll(title, home, profile, sell, messages, logout);
	}

	public void setStyles() {
		Font f = new Font("Comic Sans MS", 13);
		
		home.setFont(f);
		profile.setFont(f);
		sell.setFont(f);
		messages.setFont(f);
		logout.setFont(f);
		
		home.setStyle("-fx-background-color: #59A9A0");
		profile.setStyle("-fx-background-color: #59A9A0");
		sell.setStyle("-fx-background-color: #59A9A0");
		messages.setStyle("-fx-background-color: #59A9A0");
		logout.setStyle("-fx-background-color: #59A9A0");
		
		this.setStyle("-fx-background-color: #4F9088");
	}

	public Button getHome() {
		return home;
	}

	public Button getProfile() {
		return profile;
	}

	public Button getSell() {
		return sell;
	}

	public Button getMessages() {
		return messages;
	}

	public Button getLogout() {
		return logout;
	}

}