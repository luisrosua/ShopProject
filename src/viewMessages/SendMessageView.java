package viewMessages;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import viewNav.NavMenuPane;

public class SendMessageView extends BorderPane{

	private Label adr;
	private Label mess;

	private TextField adressee;
	private TextField message;
	
	private Button send;
	
	public SendMessageView() {
		adr = new Label("Adressee: ");
		mess = new Label("Message: ");
		
		adressee = new TextField();
		message = new TextField();
		
		send = new Button("Send");
		
		GridPane gp = new GridPane();
		gp.setVgap(5);
		gp.setHgap(5);
		
		gp.add(adr, 0, 0);
		gp.add(adressee, 1, 0);
		gp.add(mess, 0, 1);
		gp.add(message, 1, 1);
		gp.add(send, 1, 2);
		
		this.setCenter(gp);
	}		

	public TextField getAdressee() {
		return adressee;
	}

	public TextField getMessage() {
		return message;
	}

	public Button getSend() {
		return send;
	}

}