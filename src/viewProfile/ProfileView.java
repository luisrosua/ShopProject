package viewProfile;

import DatabaseClasses.User;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import viewNav.NavMenuPane;

public class ProfileView extends BorderPane{
	private Label user;
	private Label email;
	private Label province;
	
	private Button editProfile;
	
	public ProfileView() {
		this.user = new Label();
		email = new Label();
		province = new Label();
		
		editProfile = new Button("Edit profile");
		
		setStyles();
		
		VBox vb = new VBox();
		
		vb.getChildren().addAll(user, email, province, editProfile);
		vb.setAlignment(Pos.CENTER);
		
		this.setCenter(vb);
	}

	public void setStyles() {
		Font f = new Font("Comic Sans MS", 13);
		
		user.setFont(f);
		email.setFont(f);
		province.setFont(f);
		editProfile.setFont(f);
		
		editProfile.setStyle("-fx-background-color: #59A9A0");
		this.setStyle("-fx-background-color: #4F9088");
	}

	public Label getUser() {
		return user;
	}
	
	public Label getEmail() {
		return email;
	}

	public Label getProvince() {
		return province;
	}

	public Button getEditProfile() {
		return editProfile;
	}
}