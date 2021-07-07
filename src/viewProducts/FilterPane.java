package viewProducts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class FilterPane extends VBox{
	private Label l;
	
	private ListView<String> provinces;
	
	private Button filter;
	
	public FilterPane() {
		this.filter = new Button("Filter");
		this.l = new Label("Filter by: ");
		
		provinces = new ListView<String>();
		
		this.getChildren().addAll(l, provinces, filter);
		this.setStyle("-fx-background-color: '#AFDCD6';");
		
	}
	
	public void setNames(String[] names) {
		ObservableList<String> provNames = FXCollections.observableArrayList();
		
		for(int i = 0; i < names.length; i++) {
			provNames.add(names[i]);
		}
		
		this.provinces.setItems(provNames);
	}

	public ListView<String> getProvinces() {
		return provinces;
	}

	public Button getFilter() {
		return filter;
	}
}