package gui.guiFreizeitbaeder;

import business.freizeitbad.Freizeitbad;
import business.freizeitbad.FreizeitbaederModel;
import javafx.stage.Stage;
import observer.Observer;
import ownUtil.PlausiException;

import java.io.IOException;

public class FreizeitbaederControl implements Observer {

	private final FreizeitbaederView view;
	private final FreizeitbaederModel model;

	@Override
	public void update() {
		this.zeigeFreizeitbaederAn();
	}

	public FreizeitbaederControl(Stage primaryStage) {
		this.view = new FreizeitbaederView(this, primaryStage);
		this.model = FreizeitbaederModel.getInstance();

		// Subscribe to model changes
		this.model.addObserver(this);
	}

	public void nehmeFreizeitbadAuf(String name, String geoeffnet, String geoeffnetBis, String beckenlaenge,
			String wasserTemp) {
		try {
			Freizeitbad bad = new Freizeitbad(name, geoeffnet, geoeffnetBis, beckenlaenge, wasserTemp);
			this.model.addFreizeitbad(bad);
		} catch (PlausiException exc) {
			view.zeigeFehlermeldungsfensterAn(exc.getPlausiTyp() + "er ", exc.getMessage());
		}
	}

	public void zeigeFreizeitbaederAn() {

		if(model.getFreizeitbaeder().size() > 0){
			StringBuilder text = new StringBuilder();

			for (Freizeitbad freizeitbad: this.model.getFreizeitbaeder()) {
				text.append(freizeitbad.gibFreizeitbadZurueck(' ')).append("\n");
			}
			this.view.getTxtAnzeige().setText(text.toString());
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
				model.schreibeFreizeitbaederInTextDate();
				view.zeigeInformationsfensterAn("Text Datei erfolgreich gespeichert");
			}
		}catch(IOException exc) {
			view.zeigeFehlermeldungsfensterAn("IOException", "IOException beim Speichern!");
		}
		catch(Exception exc) {
			view.zeigeFehlermeldungsfensterAn("Exception", "Unbekannter Feheler beim Speichern");
		}
	}
}
