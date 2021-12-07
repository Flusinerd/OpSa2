package gui.guiSportstaetten;

import business.FreizeitbaederModel;
import javafx.stage.Stage;

public class SportstaettenControl {
    private final SportstaettenView view;
    private final FreizeitbaederModel model;

    public SportstaettenControl(Stage fensterSportstaetten) {
        this.view = new SportstaettenView(this, fensterSportstaetten);
        this.model = FreizeitbaederModel.getInstance();
    }

    public void zeigeFreizeitbaederAn(){
        if(model.getFreizeitbad() != null){
            view.getTxtAnzeigeFreizeitbaeder().setText(
                    this.model.getFreizeitbad()
                            .gibFreizeitbadZurueck(' '));
        }
        else{
            view.zeigeInformationsfensterAn(
                    "Bisher wurde kein Freizeitbad aufgenommen!");
        }
    }
}
