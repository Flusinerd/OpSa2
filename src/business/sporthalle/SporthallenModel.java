package business.sporthalle;

import ownUtil.PlausiException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SporthallenModel extends SporthallenObservable {
    private ArrayList<Sporthalle> sporthallen = new ArrayList<>();
    private static SporthallenModel model;

    private SporthallenModel() {
    }

    public static SporthallenModel getInstance() {
        if (model == null) {
            model = new SporthallenModel();
        }
        return model;
    }

    public ArrayList<Sporthalle> getSporthallen() {
        return sporthallen;
    }

    public void addSporthalle(Sporthalle sporthalle) {
        this.sporthallen.add(sporthalle);
        this.notifyObservers();
    }

    public void leseSporthallenAusCsvDatei()
            throws IOException, PlausiException {
        BufferedReader ein = new BufferedReader(
                new FileReader("Sporthallen.csv"));
        String zeileStr = ein.readLine();
        while(zeileStr != null) {
            String[] zeile = zeileStr.split(";");
            this.addSporthalle(
                    new Sporthalle(zeile[0], zeile[1], zeile[2]));
            zeileStr = ein.readLine();
        }
        ein.close();
    }

}

