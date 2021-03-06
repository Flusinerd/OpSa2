package factory.freizeitbaeder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.freizeitbad.Freizeitbad;

public class TextWriter extends Writer {
	
	BufferedWriter aus;

	@Override
	public void fuegeInDateiHinzu(Freizeitbad freizeitbad) throws IOException {
		if (this.aus == null) {
			this.aus = new BufferedWriter(
					new FileWriter("Freizeitbaeder.txt", true));
		}
		String output = "Daten des Freizeitbades\n"+
		"Name des Freizeitbads: \t\t"+freizeitbad.getName()
		+"\n�ffnungszeiten des Freizeitbads: \t\t" + freizeitbad.getGeoeffnetVon()+" - "+freizeitbad.getGeoeffnetBis()
		+"\nBeckenl�nge des Freizeitbads: \t\t" + freizeitbad.getBeckenlaenge()
		+"\nWassertemperatur des Freizeitbads: \t\t" + freizeitbad.getTemperatur();
		aus.write(output+"\n"+"\n");
	}

	@Override
	public void schliesseDatei() throws IOException {
		this.aus.close();
	}
	
	
	
}
