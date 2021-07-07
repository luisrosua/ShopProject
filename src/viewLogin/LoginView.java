package viewLogin;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class LoginView extends BorderPane{
	private Label alertMessage;
	
	private TextField user;
	private TextField pass;
	
	private Label us;
	private Label pss;
	
	private Button login;
	private Button register;
	
	public LoginView() {
		Label title = new Label("SECOND HAND SHOP!");
		title.setFont(new Font("Impact", 35));
		title.setAlignment(Pos.TOP_CENTER);
		
		alertMessage = new Label();
		
		user = new TextField();
		pass = new TextField();
		
		us = new Label("Username: ");
		pss = new Label("Password: ");
		
		login = new Button("Login");
		register = new Button("Click here to register");
		
		setStyles();
		
		GridPane gp = new GridPane();
		gp.setVgap(5);
		gp.setHgap(5);
		insertGridPane(gp);
		
		register.setAlignment(Pos.BOTTOM_CENTER);
		
		this.setTop(title);
		this.setCenter(gp);
		this.setBottom(register);
		
	}

	public void insertGridPane(GridPane gp) {
		gp.add(us, 0, 0);
		gp.add(user, 1, 0);
		gp.add(pss, 0, 1);
		gp.add(pass, 1, 1);
		gp.add(alertMessage, 0, 3);
		gp.add(login, 1, 2);
		
		gp.setAlignment(Pos.CENTER);
	}



	public void setStyles() {
		Font f = new Font("Comic Sans MS", 13);
		
		user.setFont(f);
		pass.setFont(f);
		us.setFont(f);
		pss.setFont(f);
		alertMessage.setFont(f);
		login.setFont(f);
		register.setFont(f);
		
		login.setStyle("-fx-background-color: #59A9A0");
		register.setStyle("-fx-background-color: #59A9A0");
		
		this.setStyle("-fx-background-color: #68CABE");
	}

	public TextField getUser() {
		return user;
	}

	public TextField getPass() {
		return pass;
	}
	
	public Button getLogin() {
		return login;
	}

	public Button getRegister() {
		return register;
	}
	public Label getAlertMessage() {
		return alertMessage;
	}

	public void setAlertMessage(Label alertMessage) {
		this.alertMessage = alertMessage;
	}
}