package viewCards;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class CardsView extends ScrollPane{
	private VBox cardList;
	
	public CardsView() {
		this.cardList = new VBox();
		
		this.setStyle("-fx-background-color: #68CABE");
		
		this.setContent(this.cardList);
	}
	
	public void setCards(CardPane cp) {
		this.cardList.getChildren().add(cp);
	}

	public VBox getCardList() {
		return cardList;
	}
}