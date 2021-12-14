package gui.guiFreizeitbaeder;

import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class FreizeitbaederView{

	private final FreizeitbaederControl control;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private final Pane pane = new Pane();
	private final Label lblEingabe = new Label("Eingabe");
	private final Label lblAnzeige = new Label("Anzeige");
	private final Label lblName = new Label("Name:");
	private final Label lblGeoeffnetVon = new Label("Ge�ffnet von:");
	private final Label lblGeoeffnetBis = new Label("Ge�ffnet bis:");
	private final Label lblBeckenlaenge = new Label("Beckenl�nge:");
	private final Label lblWassTemperatur = new Label("Wassertemperatur:");
	private final TextField txtName = new TextField();
	private final TextField txtGeoeffnetVon = new TextField();
	private final TextField txtGeoeffnetBis = new TextField();
	private final TextField txtBeckenlaenge = new TextField();
	private final TextField txtWassTemperatur = new TextField();
	private final TextArea txtAnzeige = new TextArea();

	public TextArea getTxtAnzeige() {
		return txtAnzeige;
	}

	private final Button btnEingabe = new Button("Eingabe");
	private final Button btnAnzeige = new Button("Anzeige");
	private final MenuBar mnbrMenuLeiste = new MenuBar();
	private final Menu mnDatei = new Menu("Datei");
	private final MenuItem mnItmCsvExport = new MenuItem("csv-Export");
	private final MenuItem mnItmTxtExport = new MenuItem("txt-Export");
	// -------Ende Attribute der grafischen Oberflaeche-------

	public FreizeitbaederView(FreizeitbaederControl control, Stage primaryStage) {
		this.initKomponenten();
		this.initListener();
		this.control = control;
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Verwaltung von Freizeitb�dern");
		primaryStage.show();
	}

	private void initKomponenten() {
		// Labels
		lblEingabe.setLayoutX(20);
		lblEingabe.setLayoutY(40);
		Font font = new Font("Arial", 24);
		lblEingabe.setFont(font);
		lblEingabe.setStyle("-fx-font-weight: bold;");
		lblAnzeige.setLayoutX(310);
		lblAnzeige.setLayoutY(40);
		lblAnzeige.setFont(font);
		lblAnzeige.setStyle("-fx-font-weight: bold;");
		lblName.setLayoutX(20);
		lblName.setLayoutY(90);
		lblGeoeffnetVon.setLayoutX(20);
		lblGeoeffnetVon.setLayoutY(130);
		lblGeoeffnetBis.setLayoutX(20);
		lblGeoeffnetBis.setLayoutY(170);
		lblBeckenlaenge.setLayoutX(20);
		lblBeckenlaenge.setLayoutY(210);
		lblWassTemperatur.setLayoutX(20);
		lblWassTemperatur.setLayoutY(250);
		pane.getChildren().addAll(lblEingabe, lblAnzeige, lblName, lblGeoeffnetVon, lblGeoeffnetBis, lblBeckenlaenge,
				lblWassTemperatur);

		// Textfelder
		txtName.setLayoutX(130);
		txtName.setLayoutY(90);
		txtGeoeffnetVon.setLayoutX(130);
		txtGeoeffnetVon.setLayoutY(130);
		txtGeoeffnetBis.setLayoutX(130);
		txtGeoeffnetBis.setLayoutY(170);
		txtBeckenlaenge.setLayoutX(130);
		txtBeckenlaenge.setLayoutY(210);
		txtWassTemperatur.setLayoutX(130);
		txtWassTemperatur.setLayoutY(250);
		pane.getChildren().addAll(txtName, txtGeoeffnetVon, txtGeoeffnetBis, txtBeckenlaenge, txtWassTemperatur);

		// Textbereich
		txtAnzeige.setEditable(false);
		txtAnzeige.setLayoutX(310);
		txtAnzeige.setLayoutY(90);
		txtAnzeige.setPrefWidth(220);
		txtAnzeige.setPrefHeight(185);
		pane.getChildren().add(txtAnzeige);

		// Buttons
		btnEingabe.setLayoutX(20);
		btnEingabe.setLayoutY(290);
		btnAnzeige.setLayoutX(310);
		btnAnzeige.setLayoutY(290);
		pane.getChildren().addAll(btnEingabe, btnAnzeige);

		// Menu
		this.mnbrMenuLeiste.getMenus().add(mnDatei);
		this.mnDatei.getItems().add(mnItmCsvExport);
		this.mnDatei.getItems().add(mnItmTxtExport);
		pane.getChildren().add(mnbrMenuLeiste);
	}

	private void initListener() {
		btnEingabe.setOnAction(e -> control.nehmeFreizeitbadAuf(txtName.getText(), txtGeoeffnetVon.getText(), txtGeoeffnetBis.getText(),
				txtBeckenlaenge.getText(), txtWassTemperatur.getText()));

		btnAnzeige.setOnAction(e -> control.zeigeFreizeitbaederAn());
		
		mnItmCsvExport.setOnAction(e -> control.schreibeFreizeitbaederInDatei("csv"));
		
		mnItmTxtExport.setOnAction(e -> control.schreibeFreizeitbaederInDatei("txt"));
	}

	public void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(Alert.AlertType.INFORMATION,
				"Information", meldung).zeigeMeldungsfensterAn();
	}

	public void zeigeFehlermeldungsfensterAn(String fehlertyp, String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, fehlertyp + "Fehler", meldung).zeigeMeldungsfensterAn();
	}
	
	
}
