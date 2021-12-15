package gui.guiSportstaetten;

import business.Freizeitbad;
import business.FreizeitbaederModel;
import javafx.stage.Stage;
import observer.Observer;

public class SportstaettenControl implements Observer {
    private final SportstaettenView view;
    private final FreizeitbaederModel model;

    public SportstaettenControl(Stage fensterSportstaetten) {
        this.view = new SportstaettenView(this, fensterSportstaetten);
        this.model = FreizeitbaederModel.getInstance();

        // Subscribe to model changes
        this.model.addObserver(this);
    }

    @Override
    public void update() {
        this.zeigeFreizeitbaederAn();
    }

    public void zeigeFreizeitbaederAn(){
        if(model.getFreizeitbaeder().size() > 0){
            StringBuilder text = new StringBuilder();

            for (Freizeitbad freizeitbad: this.model.getFreizeitbaeder()) {
                text.append(freizeitbad.gibFreizeitbadZurueck(' ')).append("\n");
            }
            this.view.getTxtAnzeigeFreizeitbaeder().setText(text.toString());
        }
        else{
            view.zeigeInformationsfensterAn(
                    "Bisher wurde kein Freizeitbad aufgenommen!");
        }
    }
}
