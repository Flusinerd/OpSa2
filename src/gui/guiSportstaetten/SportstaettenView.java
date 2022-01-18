package gui.guiSportstaetten;

import business.freizeitbad.FreizeitbaederModel;
import business.sporthalle.SporthallenModel;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class SportstaettenView {
    private final SportstaettenControl control;

    //---Anfang Attribute der grafischen Oberflaeche---
    private final Pane pane
            = new Pane();
    private final Label lblAnzeigeFreizeitbaeder
            = new Label("Anzeige Freizeitbäder");
    private final TextArea txtAnzeigeFreizeitbaeder = new TextArea();
    private final Button btnAnzeigeFreizeitbaeder = new Button("Freizeitbäder anzeigen");

    // Sporthallen
    private SporthallenModel sporthallenModel;
    private Label lblAnzeigeSporthallen = new Label("Anzeige Sporthallen");
    private TextArea txtAnzeigeSporthallen = new TextArea();
    private Button btnAnzeigeSporthallen = new Button("Sporthallen anzeigen");

    // Menu
    private final MenuBar mnbrMenuLeiste = new MenuBar();
    private final Menu mnDatei = new Menu("Datei");

    // Submenu sporthallen
    private final Menu subMenuSporthallen = new Menu("Sporthallen");
    private final MenuItem mnItemCsvImportSporthallen = new MenuItem("csv-Import");
    //-------Ende Attribute der grafischen Oberflaeche-------

    public SportstaettenView(SportstaettenControl control, Stage primaryStage) {
        Scene scene = new Scene(this.pane, 560, 340);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Anzeige von Sportstätten");
        primaryStage.show();
        FreizeitbaederModel freizeitbaederModel = FreizeitbaederModel.getInstance();
        this.control = control;


        this.initSporthallenKomponenten();
        this.initFreizeitbaederKomponenten();
        this.initFreizeitbaederListener();
        this.initSporthallenListener();
        this.initMenuListeners();
    }

    private void initSporthallenKomponenten() {
        // Label
        Font font = new Font("Arial", 20);
        lblAnzeigeSporthallen.setLayoutX(20);
        lblAnzeigeSporthallen.setLayoutY(40);
        lblAnzeigeSporthallen.setFont(font);
        lblAnzeigeSporthallen.setStyle("-fx-font-weight: bold;");
        pane.getChildren().add(lblAnzeigeSporthallen);

        //Textbereich
        txtAnzeigeSporthallen.setEditable(false);
        txtAnzeigeSporthallen.setLayoutX(20);
        txtAnzeigeSporthallen.setLayoutY(90);
        txtAnzeigeSporthallen.setPrefWidth(220);
        txtAnzeigeSporthallen.setPrefHeight(185);
        pane.getChildren().add(txtAnzeigeSporthallen);

        // Button
        btnAnzeigeSporthallen.setLayoutX(20);
        btnAnzeigeSporthallen.setLayoutY(290);
        pane.getChildren().add(btnAnzeigeSporthallen);

        initMenu();
    }


    private void initMenu() {
        this.mnbrMenuLeiste.getMenus().add(mnDatei);
        this.mnDatei.getItems().add(subMenuSporthallen);

        this.subMenuSporthallen.getItems().add(mnItemCsvImportSporthallen);
        pane.getChildren().add(mnbrMenuLeiste);
    }

    private void initMenuListeners() {
        this.mnItemCsvImportSporthallen.setOnAction(
                e -> control.leseSporthallenAusCSVDatei()
        );
    }

    private void initFreizeitbaederKomponenten() {
        // Label
        Font font = new Font("Arial", 20);
        lblAnzeigeFreizeitbaeder.setLayoutX(310);
        lblAnzeigeFreizeitbaeder.setLayoutY(40);
        lblAnzeigeFreizeitbaeder.setFont(font);
        lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;");
        pane.getChildren().add(lblAnzeigeFreizeitbaeder);
        // Textbereich
        txtAnzeigeFreizeitbaeder.setEditable(false);
        txtAnzeigeFreizeitbaeder.setLayoutX(310);
        txtAnzeigeFreizeitbaeder.setLayoutY(90);
        txtAnzeigeFreizeitbaeder.setPrefWidth(220);
        txtAnzeigeFreizeitbaeder.setPrefHeight(185);
        pane.getChildren().add(txtAnzeigeFreizeitbaeder);
        // Button
        btnAnzeigeFreizeitbaeder.setLayoutX(310);
        btnAnzeigeFreizeitbaeder.setLayoutY(290);
        pane.getChildren().add(btnAnzeigeFreizeitbaeder);
    }



    private void initFreizeitbaederListener() {
        btnAnzeigeFreizeitbaeder.setOnAction(
                e -> control.zeigeFreizeitbaederAn());
    }

    private void initSporthallenListener() {
        btnAnzeigeSporthallen.setOnAction(
                e -> control.zeigeSporthallenAn()
        );
    }

    public void zeigeFehlermeldungsfensterAn(String fehlertyp, String meldung) {
        new MeldungsfensterAnzeiger(Alert.AlertType.ERROR, fehlertyp + "Fehler", meldung).zeigeMeldungsfensterAn();
    }

    public void zeigeInformationsfensterAn(String meldung) {
        new MeldungsfensterAnzeiger(Alert.AlertType.INFORMATION,
                "Information", meldung).zeigeMeldungsfensterAn();
    }

    public TextArea getTxtAnzeigeFreizeitbaeder() {
        return txtAnzeigeFreizeitbaeder;
    }

    public TextArea getTxtAnzeigeSporthallen() {
        return txtAnzeigeSporthallen;
    }
}