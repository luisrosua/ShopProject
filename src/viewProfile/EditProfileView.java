package viewProfile;

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
import viewNav.NavMenuPane;

public class EditProfileView extends BorderPane{
	private Label us;
	private Label pss;
	private Label em;
	
	private TextField user;
	private TextField pass;
	private TextField email;
	private ListView<String> provinces;
	
	private Button edit;
	
	public EditProfileView() {
		us = new Label("Username: ");
		pss = new Label("Password: ");
		em = new Label("Email: ");
		
		user = new TextField();
		pass = new TextField();
		email = new TextField();
		provinces = new ListView<String>();
		
		edit = new Button("Edit");
		
		setStyles();
		
		GridPane gp = new GridPane();
		gp.setHgap(5);
		gp.setVgap(5);
		
		insertGridPane(gp);
		gp.setAlignment(Pos.CENTER);
		
		this.setCenter(gp);
		
	}
	
	public void setNames(String[] names) {
		ObservableList<String> provNames = FXCollections.observableArrayList();
		
		for(int i = 0; i < names.length; i++) {
			provNames.add(names[i]);
		}
		
		this.provinces.setItems(provNames);
	}

	public void setStyles() {
		Font f = new Font("Comic Sans MS", 13);
		us.setFont(f);
		pss.setFont(f);
		em.setFont(f);
		user.setFont(f);
		pass.setFont(f);
		email.setFont(f);
		edit.setFont(f);
		
		edit.setStyle("-fx-background-color: #59A9A0");
		this.setStyle("-fx-background-color: #4F9088");
	}

	public void insertGridPane(GridPane gp) {
		gp.add(us, 0, 0);
		gp.add(user, 1, 0);
		gp.add(pss, 0, 1);
		gp.add(pass, 1, 1);
		gp.add(em, 0, 2);
		gp.add(email, 1, 2);
		gp.add(provinces, 0, 3);
		gp.add(edit, 1, 4);
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

	public Button getEdit() {
		return edit;
	}

	public ListView<String> getProvinces() {
		return provinces;
	}
}