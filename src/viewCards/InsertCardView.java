package viewCards;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class InsertCardView extends BorderPane{
	private Label numText;
	private Label cvvText;
	private Label yearText;
	private Label monthText;
	
	private TextField num;
	private TextField cvv;
	private TextField year;
	private TextField month;
	
	private Button finish;
	
	public InsertCardView() {
		numText = new Label("Card number: ");
		cvvText = new Label("CVV: ");
		yearText = new Label("Expiration year: ");
		monthText = new Label("Expiration month (in numbers): ");
		
		num = new TextField();
		cvv = new TextField();
		year = new TextField();
		month = new TextField();
		
		finish = new Button("Finish");
		
		setStyles();
		
		GridPane gp = new GridPane();
		gp.setVgap(4);
		gp.setHgap(3);
		
		gp.add(numText, 0, 0);
		gp.add(num, 1, 0);
		gp.add(cvvText, 0, 1);
		gp.add(cvv, 1, 1);
		gp.add(yearText, 0, 2);
		gp.add(year, 1, 2);
		gp.add(monthText, 0, 3);
		gp.add(month, 1, 3);
		gp.add(finish, 1, 4);
		
		this.setCenter(gp);
		gp.setAlignment(Pos.CENTER);
	}

	private void setStyles() {
		Font f = new Font("Comic Sans MS", 13);
		
		this.numText.setFont(f);
		this.cvvText.setFont(f);
		this.yearText.setFont(f);
		this.monthText.setFont(f);
		this.num.setFont(f);
		this.cvv.setFont(f);
		this.year.setFont(f);
		this.month.setFont(f);
		this.finish.setFont(f);
		
		this.finish.setStyle("-fx-background-color: #59A9A0");
		this.setStyle("-fx-background-color: #68CABE");
	}

	public TextField getNum() {
		return num;
	}

	public TextField getCvv() {
		return cvv;
	}

	public TextField getYear() {
		return year;
	}

	public TextField getMonth() {
		return month;
	}

	public Button getFinish() {
		return finish;
	}
	
	
}