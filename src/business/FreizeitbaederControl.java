package business;

import java.io.IOException;

import gui.FreizeitbaederView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;
import ownUtil.PlausiException;

public class FreizeitbaederControl {

	private FreizeitbaederView view;
	private FreizeitbaederModel model;

	public FreizeitbaederControl(Stage primaryStage) {
		this.view = new FreizeitbaederView(this, primaryStage);
		this.model = new FreizeitbaederModel(this);
	}

	public void nehmeFreizeitbadAuf(String name, String geoeffnet, String geoeffnetBis, String beckenlaenge,
			String wasserTemp) {
		try {
			Freizeitbad bad = new Freizeitbad(name, geoeffnet, geoeffnetBis, beckenlaenge, wasserTemp);
			this.model.setFreizeitbad(bad);
			view.zeigeInformationsfensterAn("Das Freizeitbad wurde aufgenommen!");
		} catch (PlausiException exc) {
			view.zeigeFehlermeldungsfensterAn(exc.getPlausiTyp() + "er ", exc.getMessage());
		}
	}

	public void zeigeFreizeitbaederAn() {

		if (this.model.getFreizeitbad() != null) {
			this.view.getTxtAnzeige().setText(this.model.getFreizeitbad().gibFreizeitbadZurueck(' '));
		} else {
			view.zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
		}
	}
	
	public void schreibeFreizeitbaederInDatei(String typ) {
		System.out.println("Typ: " + typ);
		try {
			if("csv".equals(typ)) {
				model.schreibeFreizeitbaederInCsvDatei();
				view.zeigeInformationsfensterAn("CSV Datei erfolgreich gespeichert");
			} else {
				view.zeigeInformationsfensterAn("Noch nicht Implementiert");
			}
		}catch(IOException exc) {
			view.zeigeFehlermeldungsfensterAn("IOException", "IOException beim Speichern!");
		}
		catch(Exception exc) {
			view.zeigeFehlermeldungsfensterAn("Exception", "Unbekannter Feheler beim Speichern");
		}
	}
}
