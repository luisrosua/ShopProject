package viewMessages;

import DatabaseClasses.Message;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import viewNav.NavMenuPane;

public class MessagesView extends BorderPane{
	private Button send;
	private VBox messageList;
	
	public MessagesView() {
		send = new Button("Send message");
		send.setAlignment(Pos.TOP_CENTER);
		send.setFont(new Font("Comic Sans MS", 13));
		send.setStyle("-fx-background-color: #59A9A0");
		
		messageList = new VBox(5);
		messageList.setAlignment(Pos.CENTER);
		
		this.setStyle("-fx-background-color: #4F9088");
		this.messageList.setStyle("-fx-background-color: #4F9088");
		
		ScrollPane sp = new ScrollPane();
		
		sp.setContent(messageList);
		
		this.setLeft(send);
		this.setCenter(sp);
	}
	
	public void setMessages(Message m) {
		MessagePane mp = new MessagePane(m);
		messageList.getChildren().add(mp);
	}

	public Button getSend() {
		return send;
	}

	public void setSend(Button send) {
		this.send = send;
	}

	public VBox getMessageList() {
		return messageList;
	}

	public void setMessageList(VBox messageList) {
		this.messageList = messageList;
	}
}
