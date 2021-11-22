package factory;

import java.io.IOException;

import business.Freizeitbad;

public abstract class Writer {
	/**
	 * Fuegt das Object einer Datei hinzu
	 * @param Freizeitbad freizeitbad
	 * @throws IOException
	 */
	public abstract void fuegeInDateiHinzu(Freizeitbad freizeitbad) throws IOException;
	
	/**
	 * Schlieﬂt die Datei
	 * @throws IOException
	 */
	public abstract void schliesseDatei() throws IOException;
}
