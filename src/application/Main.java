package application;

import Controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainMenu.MainMenuView;
import viewCards.CardsView;
import viewCards.InsertCardView;
import viewLogin.LoginView;
import viewMessages.MessagesView;
import viewMessages.SendMessageView;
import viewProducts.CatalogueView;
import viewProfile.EditProfileView;
import viewProfile.ProfileView;
import viewRegister.RegisterView;
import viewSell.SellView;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception{
		LoginView root = new LoginView();
		RegisterView register = new RegisterView();
		CatalogueView catalogue = new CatalogueView();
		ProfileView profile = new ProfileView();
		EditProfileView editProfile = new EditProfileView();
		MessagesView messages = new MessagesView();
		SendMessageView sendMessage = new SendMessageView();
		SellView sell = new SellView();
		InsertCardView insertCard = new InsertCardView();
		CardsView cards = new CardsView();
		MainMenuView main = new MainMenuView();
		
		Scene scene1 = new Scene(root, 900,600);
		Scene scene2 = new Scene(main, 900,600);
		Scene scene3 = new Scene(register, 900,600);
		Scene scene4 = new Scene(insertCard, 900, 600);
		
		Controller c = new Controller(primaryStage, root, profile, register, editProfile, messages, sendMessage, catalogue, main, insertCard, sell, cards, scene1, scene2, scene3, scene4);
		
		primaryStage.setScene(scene1);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}