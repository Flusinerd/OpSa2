package gui.guiSportstaetten;

import business.freizeitbad.Freizeitbad;
import business.freizeitbad.FreizeitbaederModel;
import business.sporthalle.Sporthalle;
import business.sporthalle.SporthallenModel;
import javafx.stage.Stage;
import observer.Observer;
import ownUtil.PlausiException;

import java.io.IOException;

public class SportstaettenControl {
    private final SportstaettenView view;
    private final FreizeitbaederModel freizeitbaederModel;
    private final SporthallenModel sporthallenModel;

    // Using private inner classes to differentiate between different observables
    /**
     * Observer for sporthallen updates
     */
    private class SporthallenObserver implements Observer {
        @Override
        public void update() {
            zeigeSporthallenAn();
        }
    }

    /**
     * Observer for freizeitbaeder updates
     */
    private class FreizeitbaederObserver implements Observer {
        @Override
        public void update() {
            zeigeFreizeitbaederAn();
        }
    }

    public SportstaettenControl(Stage fensterSportstaetten) {
        this.view = new SportstaettenView(this, fensterSportstaetten);
        this.freizeitbaederModel = FreizeitbaederModel.getInstance();
        this.sporthallenModel = SporthallenModel.getInstance();

        // Subscribe to model changes
        this.freizeitbaederModel.addObserver(new FreizeitbaederObserver());
        this.sporthallenModel.addObserver(new SporthallenObserver());
    }

    public void zeigeFreizeitbaederAn(){
        if(freizeitbaederModel.getFreizeitbaeder().size() > 0){
            StringBuilder text = new StringBuilder();

            for (Freizeitbad freizeitbad: this.freizeitbaederModel.getFreizeitbaeder()) {
                text.append(freizeitbad.gibFreizeitbadZurueck(' ')).append("\n");
            }
            this.view.getTxtAnzeigeFreizeitbaeder().setText(text.toString());
        }
        else{
            view.zeigeInformationsfensterAn(
                    "Bisher wurde kein Freizeitbad aufgenommen!");
        }
    }

    public void zeigeSporthallenAn(){
        if(sporthallenModel.getSporthallen().size() > 0){
            StringBuilder text = new StringBuilder();

            for (Sporthalle sporthalle: this.sporthallenModel.getSporthallen()) {
                text.append(sporthalle.gibSporthalleZurueck(' ')).append("\n");
            }
            this.view.getTxtAnzeigeSporthallen().setText(text.toString());
        }
        else{
            view.zeigeInformationsfensterAn(
                    "Bisher wurde keine Sporthalle aufgenommen!\nImportieren Sie die Sporthallen bitte unter dem Menüpunkt Datei > Sporthallen > csv-Import");
        }
    }

    public void leseSporthallenAusCSVDatei() {
        try {
            this.sporthallenModel.leseSporthallenAusCsvDatei();
            view.zeigeInformationsfensterAn("Import erfolgreich");
        } catch (IOException e) {
            view.zeigeFehlermeldungsfensterAn("IOException", "IOException beim lesen der Datei!");
        } catch (PlausiException e) {
            view.zeigeFehlermeldungsfensterAn("PlausiException", "Plausiexception beim lesen der Datei!");
        }
    }
}
