package viewRegister;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class RegisterView extends BorderPane{
	
	private Button next;
	private Button backLogin;
	
	private Label us;
	private Label pss;
	private Label em;
	
	private TextField user;
	private TextField pass;
	private TextField email;
	private ListView<String> provinces;
	
	public RegisterView() {
		Label title = new Label("SECOND HAND SHOP!");
		title.setFont(new Font("Impact", 35));
		title.setAlignment(Pos.CENTER);
		
		next = new Button("Next");
		
		backLogin = new Button("Back to login");
		backLogin.setAlignment(Pos.CENTER_LEFT);
		
		us = new Label("Username");
		pss = new Label("Password");
		em = new Label("Email");
		
		user = new TextField();
		pass = new TextField();
		email = new TextField();
		provinces = new ListView<String>();
		
		Font f = new Font("Comic Sans MS", 13);
		setStyles(f);
		
		GridPane gp = new GridPane();
		gp.setVgap(5);
		gp.setHgap(5);
		
		insertGridPane(gp);
		
		gp.setAlignment(Pos.CENTER);
		
		this.setTop(title);
		this.setCenter(gp);
		this.setBottom(backLogin);
	}

	public void setStyles(Font f) {
		next.setFont(f);
		backLogin.setFont(f);
		us.setFont(f);
		pss.setFont(f);
		em.setFont(f);
		user.setFont(f);
		pass.setFont(f);
		email.setFont(f);
		
		next.setStyle("-fx-background-color: #59A9A0");
		backLogin.setStyle("-fx-background-color: #59A9A0");
		this.setStyle("-fx-background-color: #68CABE");
	}

	public void insertGridPane(GridPane gp) {
		gp.add(us, 0, 0);
		gp.add(user, 1, 0);
		gp.add(pss, 0, 1);
		gp.add(pass, 1, 1);
		gp.add(em, 0, 2);
		gp.add(email, 1, 2);
		gp.add(provinces, 0, 3);
		gp.add(next, 1, 4);
	}
	
	public void setNames(String[] names) {
		ObservableList<String> provNames = FXCollections.observableArrayList();
		
		for(int i = 0; i < names.length; i++) {
			provNames.add(names[i]);
		}
		
		this.provinces.setItems(provNames);
	}

	public Button getNext() {
		return next;
	}

	public Button getBackLogin() {
		return backLogin;
	}

	public Label getUs() {
		return us;
	}

	public Label getPss() {
		return pss;
	}

	public Label getEm() {
		return em;
	}

	public TextField getUser() {
		return user;
	}

	public TextField getPass() {
		return pass;
	}

	public TextField getEmail() {
		return email;
	}

	public ListView<String> getProvinces() {
		return provinces;
	}

}