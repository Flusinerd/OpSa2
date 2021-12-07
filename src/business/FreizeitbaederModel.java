package business;
import java.io.IOException;

import factory.CsvCreator;
import factory.TextCreator;
import factory.Writer;

public class FreizeitbaederModel extends FreizeitbaederObservable{
	private Freizeitbad freizeitbad;
	private static FreizeitbaederModel model;

	private FreizeitbaederModel() {}

	public static FreizeitbaederModel getInstance() {
		if(model == null){
			model = new FreizeitbaederModel();
		}
		return model;
	}
	
	public Freizeitbad getFreizeitbad() {
		return freizeitbad;
	}

	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
		// Notify the observers about the new data
		this.notifyObservers();
	}

	public void schreibeFreizeitbaederInCsvDatei() throws IOException {
		Writer writer = new CsvCreator().factoryMethod();
		writer.fuegeInDateiHinzu(freizeitbad);
		writer.schliesseDatei();
	}
	
	public void schreibeFreizeitbaederInTextDate() throws IOException {
		Writer writer = new TextCreator().factoryMethod();
		writer.fuegeInDateiHinzu(freizeitbad);
		writer.schliesseDatei();
	}
}
