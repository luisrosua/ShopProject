package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import Database.ShopDB;
import DatabaseClasses.Product;
import DatabaseClasses.User;
import DatabaseClasses.Card;
import DatabaseClasses.Message;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mainMenu.MainMenuView;
import viewCards.CardPane;
import viewCards.CardsView;
import viewCards.InsertCardView;
import viewLogin.LoginView;
import viewMessages.MessagesView;
import viewMessages.SendMessageView;
import viewProducts.CatalogueView;
import viewProducts.ProductPane;
import viewProfile.EditProfileView;
import viewProfile.ProfileView;
import viewRegister.RegisterView;
import viewSell.SellView;

public class Controller {
	private ShopDB db;
	
	private LoginView login;
	private ProfileView profile;
	private RegisterView register;
	private EditProfileView editProfile;
	private MessagesView seeMessages;
	private SendMessageView sendMessage;
	private CatalogueView catalogue;
	private SellView sell;
	private InsertCardView insertCard;
	private CardsView cards;
	private MainMenuView main;
	
	private Scene scene1;
	private Scene scene2;
	private Scene scene3;
	private Scene scene4;
	
	private User u;
	private ArrayList<Message> m;
	private ArrayList<Product> p;
	private ArrayList<Card> userCards;
	
	private String[] provinces;
	
	private File productImage;
	
	public Controller(Stage primaryStage, LoginView login, ProfileView profile, RegisterView register, EditProfileView editProfile, MessagesView seeMessages, SendMessageView sendMessage, CatalogueView catalogue, MainMenuView main, InsertCardView insertCard, SellView sell, CardsView cards, Scene scene1, Scene scene2, Scene scene3, Scene scene4) throws Exception{
		this.login = login;
		this.profile = profile;
		this.register = register;
		this.editProfile = editProfile;
		this.seeMessages = seeMessages;
		this.sendMessage = sendMessage;
		this.catalogue = catalogue;
		this.insertCard = insertCard;
		this.cards = cards;
		this.sell = sell;
		this.main = main;
		
		this.scene1 = scene1;
		this.scene2 = scene2;
		this.scene3 = scene3;
		this.scene4 = scene4;
		
		this.db = new ShopDB();
		
		this.provinces = db.getAllProvinces();
		
		//LOGIN
		
		login.getLogin().setOnAction(e -> {
			try {
				this.u = new User(login.getUser().getText(), db.getUserData(login.getUser().getText()).getEmail(), login.getPass().getText(), db.getUserData(login.getUser().getText()).getProvince());
			  
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				if(db.checkUser(u) && db.checkPass(u)) {
					this.p = db.getProducts(this.u);
					loadProvinces();
					loadProducts();
					loadMessages();
					loadProfile();
					this.main.setCenter(this.catalogue);
					primaryStage.setScene(scene2);
					primaryStage.show();
					 
				} else {
					login.getAlertMessage().setText("Something is wrong, please try again!");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		//REGISTER
		
		login.getRegister().setOnAction(e -> {
			this.register.setNames(provinces);
			primaryStage.setScene(scene3);
			primaryStage.show();
		});
		
		register.getBackLogin().setOnAction(e -> {
			primaryStage.setScene(scene1);
			primaryStage.show();
		});
		
		register.getNext().setOnAction(e -> {
			String user = register.getUser().getText();
			String email = register.getEmail().getText();
			String pass = register.getPass().getText();
			String province = register.getProvinces().getSelectionModel().getSelectedItem();
			
			this.u = new User(user, email, pass, province);
			
			try {
				insertRegister();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			primaryStage.setScene(scene1);
			primaryStage.show();
		});
		
		// NAV
		
		this.main.getNav().getHome().setOnAction(e -> {
			this.main.setCenter(this.catalogue);
		});
		
		this.main.getNav().getProfile().setOnAction(e -> {
			
			this.main.setCenter(this.profile);
			
			try {
				profileEdit(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		this.main.getNav().getLogout().setOnAction(e -> {
			primaryStage.setScene(scene1);
			primaryStage.show();
		});
		
		this.main.getNav().getSell().setOnAction(e -> {
			this.main.setCenter(this.sell);
		});
		
		// MESSAGES
		
		this.main.getNav().getMessages().setOnAction(e -> {
			this.main.setCenter(this.seeMessages);

		});
		
		this.seeMessages.getSend().setOnAction(e -> {
			this.main.setCenter(this.sendMessage);
			sendMessages();
		});
		
		// SELL
		
		this.sell.getBrowse().setOnAction(e ->{
			FileChooser f = new FileChooser();
			f.setTitle("Image of the product");
			this.productImage = f.showOpenDialog(primaryStage);
		});
		
		this.sell.getSell().setOnAction(e -> {
			Product p = new Product(this.sell.getName().getText(), this.sell.getDescription().getText(), this.u.getUsername(), Double.parseDouble(this.sell.getPrice().getText()));
			try {
				db.sellProduct(p, this.productImage);
				this.main.setCenter(new Label("You have successfully uploaded your product!"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		// FILTER 
		
		this.catalogue.getFilter().getFilter().setOnAction(e ->{
			String name = this.catalogue.getFilter().getProvinces().getSelectionModel().getSelectedItem();
			try {
				this.p = db.getFilteredProducts(name, this.u.getUsername());
				loadProducts();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
	}
	
	private void loadProvinces() throws Exception {
		this.catalogue.getFilter().setNames(provinces);
	}
	
	private void loadProducts() throws Exception {
		this.catalogue.getProductList().getChildren().clear();
		for(int i = 0; i < p.size(); i++) {
			ProductPane product = new ProductPane(p.get(i));
			product.getBuy().setOnAction(e ->{
				Button select = new Button("Select card");
				Button insert = new Button("Insert new card");
				
				select.setFont(new Font("Comic Sans MS", 13));
				insert.setFont(new Font("Comic Sans MS", 13));
				
				select.setStyle("-fx-background-color: #59A9A0");
				insert.setStyle("-fx-background-color: #59A9A0");
				try {
					selectCard(product, select);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				insert.setOnAction(ee -> {
					this.main.setCenter(this.insertCard);
					this.insertCard.getFinish().setOnAction(eee -> {
						try {
							inputCard(product);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					});
					
				});
				HBox hb = new HBox();
				hb.getChildren().addAll(select, insert);
				hb.setAlignment(Pos.CENTER);
				hb.setStyle("-fx-background-color: #68CABE");
				this.main.setCenter(hb);
			});
			this.catalogue.setProducts(product);
		}
	}
	private void selectCard(ProductPane product, Button select) throws Exception{
		select.setOnAction(e ->{
			try {
				loadCards(product.getSeller().getText(), product.getName().getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.main.setCenter(this.cards);
		});
	}
	
	private void inputCard(ProductPane product) throws Exception {
		Card c = new Card(Long.parseLong(this.insertCard.getNum().getText()), Integer.parseInt(this.insertCard.getCvv().getText()), Integer.parseInt(this.insertCard.getYear().getText()), Integer.parseInt(this.insertCard.getMonth().getText()));
		System.out.println(c.getExpiration());
		db.insertCard(c, this.u.getUsername());
		
		db.boughtProduct(product.getSeller().getText(), product.getName().getText(), this.u.getUsername());
		
		Label l = new Label("You have successfully bought this product!");
		this.main.setCenter(l);
		db.sendMessage(new Message("Hey, I have just bought your product!", this.u.getUsername(), product.getSeller().getText()));
	}
	
	
	
	private void loadProfile() {
		this.profile.getUser().setText(u.getUsername());
		this.profile.getEmail().setText(u.getEmail());
		this.profile.getProvince().setText(u.getProvince());
	}
	
	private void loadCards(String seller, String name) throws Exception{
		this.cards.getCardList().getChildren().clear();
		
		this.userCards = db.getCards(this.u.getUsername());
		
		for(int i = 0; i < userCards.size(); i++) {
			CardPane cp = new CardPane(userCards.get(i));
			cp.getUse().setOnAction(e ->{
				try {
					db.boughtProduct(seller, name, this.u.getUsername());
					db.sendMessage(new Message("Hey, I have just bought your product!", this.u.getUsername(), seller));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Label l = new Label("You have successfully bought this product!");
				this.main.setCenter(l);
			});
			this.cards.setCards(cp);
		}
	}
	
    private void loadMessages() {
    	this.seeMessages.getMessageList().getChildren().clear();
    	try {
    		m= db.getMessages(this.u);
    		for(int i = 0; i < m.size(); i++) {
    			this.seeMessages.setMessages(m.get(i));
    		}
    	}catch (Exception e) {
    		System.out.println(e);
    	}
		
		
    }
	public void sendMessages() {
		this.sendMessage.getSend().setOnAction(e -> {
			Message mess = new Message(this.sendMessage.getMessage().getText(), this.u.getUsername(), this.sendMessage.getAdressee().getText());
			this.main.setCenter(this.seeMessages);
			try {
				db.sendMessage(mess);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	public void insertRegister() throws Exception {
		if(!db.checkUser(u)) {
			db.insertUser(u);
		} else {
			this.register.getUser().setText("That user already exists! Try with another");
		}
	}

	public void profileEdit(Stage primaryStage) throws Exception{
		this.profile.getEditProfile().setOnAction(e -> {
			this.main.setCenter(this.editProfile);
			this.editProfile.setNames(provinces);
			
			try {
				editProfileGetData(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	public void editProfileGetData(Stage primaryStage) throws Exception{
		this.editProfile.getEdit().setOnAction(e -> {
			String user = this.editProfile.getUser().getText();
			String email = this.editProfile.getEmail().getText();
			String pass = this.editProfile.getPass().getText();
			String province = this.editProfile.getProvinces().getSelectionModel().getSelectedItem();
			
			User newuser = new User(user, email, pass, province);
			
			try {
				changeUser(newuser);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			primaryStage.setScene(scene1);
			primaryStage.show();
		});
	}

	public void changeUser(User newuser) throws Exception{
		if(db.checkUser(newuser)) {
			this.editProfile.getUser().setText("This user already exists!");
		} else {
			db.updateUser(newuser, this.u.getUsername());
			this.u = newuser;
		}
	}
	
	
}