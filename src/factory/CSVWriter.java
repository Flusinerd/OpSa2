package factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class CSVWriter extends Writer{
	
	BufferedWriter aus;

	@Override
	public void fuegeInDateiHinzu(Freizeitbad freizeitbad) throws IOException {
		if (this.aus == null) {
			this.aus = new BufferedWriter(
					new FileWriter("Freizeitbaeder.csv", true));
		}
		this.aus.write(freizeitbad.gibFreizeitbadZurueck(';') + "\n");
	}

	@Override
	public void schliesseDatei() throws IOException {
		this.aus.close();
	}
	
}
