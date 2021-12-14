package factory;

import java.io.IOException;

import business.Freizeitbad;

public abstract class Writer {
	/**
	 * Fuegt das Object einer Datei hinzu
	 * @param freizeitbad freizeitbad das hinzugefügt werden soll
	 * @throws IOException Error of underlying Writer
	 */
	public abstract void fuegeInDateiHinzu(Freizeitbad freizeitbad) throws IOException;
	
	/**
	 * Schlie�t die Datei
	 * @throws IOException Error of underlying Writer
	 */
	public abstract void schliesseDatei() throws IOException;
}
