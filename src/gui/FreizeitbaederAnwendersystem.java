package gui;

import business.FreizeitbaederControl;
import javafx.stage.Stage;

public class FreizeitbaederAnwendersystem {
	// speichert temporaer ein Objekt vom Typ Freizeitbad
	private FreizeitbaederControl control;

	public FreizeitbaederAnwendersystem(Stage primaryStage) {
		this.control = new FreizeitbaederControl(primaryStage);
	}
}
