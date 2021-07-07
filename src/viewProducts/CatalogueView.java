package viewProducts;

import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import viewNav.NavMenuPane;

public class CatalogueView extends BorderPane{
	private VBox productList;
	private FilterPane filter;
	
	public CatalogueView() {
		
		productList = new VBox(5);
		productList.setAlignment(Pos.CENTER);
		
		filter = new FilterPane();
		
		ScrollPane scroll = new ScrollPane();
		
		scroll.setContent(productList);
		
		this.setCenter(scroll);
		this.setLeft(filter);
	}

	public VBox getProductList() {
		return productList;
	}

	public void setProducts(ProductPane pv) {
		this.productList.getChildren().add(pv);
	}

	public FilterPane getFilter() {
		return filter;
	}
}