package business;
import java.io.IOException;

import factory.CsvCreator;
import factory.TextCreator;
import factory.Writer;

public class FreizeitbaederModel {

	private FreizeitbaederControl controller;
	private Freizeitbad freizeitbad;

	public FreizeitbaederModel(FreizeitbaederControl controller) {
		this.controller = controller;
	}
	
	public Freizeitbad getFreizeitbad() {
		return freizeitbad;
	}

	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
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
