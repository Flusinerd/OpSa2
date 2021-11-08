package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ownUtil.PlausiException;

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
		BufferedWriter aus = new BufferedWriter(
				new FileWriter("Freizeitbaeder.csv", true));
		aus.write(freizeitbad.gibFreizeitbadZurueck(';'));
		aus.close();
	}
}
