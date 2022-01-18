package business.freizeitbad;

import java.io.IOException;
import java.util.ArrayList;

import factory.freizeitbaeder.CsvCreator;
import factory.freizeitbaeder.TextCreator;
import factory.freizeitbaeder.Writer;

public class FreizeitbaederModel extends FreizeitbaederObservable {
    private final ArrayList<Freizeitbad> freizeitbaeder = new ArrayList<>();
    private static FreizeitbaederModel model;

    private FreizeitbaederModel() {
    }

    public static FreizeitbaederModel getInstance() {
        if (model == null) {
            model = new FreizeitbaederModel();
        }
        return model;
    }

    public ArrayList<Freizeitbad> getFreizeitbaeder() {
        return freizeitbaeder;
    }

    public void addFreizeitbad(Freizeitbad freizeitbad) {
        // Only add if the freizeitbad is not already in the list
        if (!this.freizeitbaeder.contains(freizeitbad)) {
            this.freizeitbaeder.add(freizeitbad);
            // Notify observers
            this.notifyObservers();
        }
    }

    public void schreibeFreizeitbaederInCsvDatei() throws IOException {
        Writer writer = new CsvCreator().factoryMethod();
        for (Freizeitbad freizeitbad : freizeitbaeder) {
            writer.fuegeInDateiHinzu(freizeitbad);
        }
        writer.schliesseDatei();
    }

    public void schreibeFreizeitbaederInTextDate() throws IOException {
        Writer writer = new TextCreator().factoryMethod();
        for (Freizeitbad freizeitbad : freizeitbaeder) {
            writer.fuegeInDateiHinzu(freizeitbad);
        }
        writer.schliesseDatei();
    }
}
