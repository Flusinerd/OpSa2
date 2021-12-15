package gui.guiSportstaetten;

import business.FreizeitbaederModel;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import observer.Observer;
import ownUtil.*;

public class SportstaettenView {
    private final SportstaettenControl control;

    //---Anfang Attribute der grafischen Oberflaeche---
    private final Pane pane
            = new Pane();
    private final Label lblAnzeigeFreizeitbaeder
            = new Label("Anzeige Freizeitbäder");
    private final TextArea txtAnzeigeFreizeitbaeder = new TextArea();
    private final Button btnAnzeigeFreizeitbaeder = new Button("Anzeige");
    //-------Ende Attribute der grafischen Oberflaeche-------

    public SportstaettenView(SportstaettenControl control, Stage primaryStage) {
        Scene scene = new Scene(this.pane, 560, 340);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Anzeige von Sportstätten");
        primaryStage.show();
        FreizeitbaederModel freizeitbaederModel = FreizeitbaederModel.getInstance();
        this.control = control;

        this.initKomponenten();
        this.initListener();
    }

    private void initKomponenten() {
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

    private void initListener() {
        btnAnzeigeFreizeitbaeder.setOnAction(
                e -> control.zeigeFreizeitbaederAn());
    }

    public void zeigeInformationsfensterAn(String meldung) {
        new MeldungsfensterAnzeiger(Alert.AlertType.INFORMATION,
                "Information", meldung).zeigeMeldungsfensterAn();
    }

    public TextArea getTxtAnzeigeFreizeitbaeder() {
        return txtAnzeigeFreizeitbaeder;
    }
}