package viewMessages;

import DatabaseClasses.Message;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MessagePane extends VBox{
	private Label message;
	private Label remitter;
	private Label addressee;
	
	public MessagePane(Message m) {
		message = new Label("Message: "+m.getMessage());
		remitter = new Label("Remitter: "+m.getRemitter());
		addressee = new Label("Addressee: "+m.getAddressee());
		
		Font f= new Font("Comic Sans MS", 13);
		
		message.setFont(f);
		remitter.setFont(f);
		addressee.setFont(f);
		
		this.getChildren().addAll(remitter, addressee, message);
	}
}