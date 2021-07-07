package mainMenu;

import javafx.scene.layout.BorderPane;
import viewNav.NavMenuPane;

public class MainMenuView extends BorderPane{
	NavMenuPane nav;
	
	public MainMenuView() {
		this.nav = new NavMenuPane();
		
		this.setTop(nav);

	}

	public NavMenuPane getNav() {
		return nav;
	}
}