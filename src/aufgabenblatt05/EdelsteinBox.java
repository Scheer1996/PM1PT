/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * Datum: 25.04.2016
 * Aufgabe: Aufgabenblatt 5 - Aufgabe - 5.1
 */
package aufgabenblatt05;

/**
 * Stellt eine Edelsteinbox dar, in dieser können sich 3 Typen von Edelsteinen
 * befinden. Siehe Enum Edelstein
 */
public class EdelsteinBox {

	/**
	 * Enum Edelstein enthält 3 Typen von Edelsteinen
	 */
	enum Edelstein {
		DIAMANT, RUBIN, SAMARAGD
	};

	/**
	 * Speichert die Anzahl der Edelsteine, index entspricht dem Enum ordinal.
	 */
	private int[] edelsteine;

	public static void main(String[] args) {
		//EdelsteinBox box = new EdelsteinBox(0, 0, 0);
		EdelsteinBox box = new EdelsteinBox(Edelstein.DIAMANT, Edelstein.DIAMANT,Edelstein.DIAMANT);
		box.hineinlegen(Edelstein.DIAMANT, 2);
		box.hineinlegen(Edelstein.RUBIN, 2);
		box.hineinlegen(Edelstein.SAMARAGD, 3);
		box.ausgeben();
		box.herausnehmen(Edelstein.RUBIN, 1);
		box.ausgeben();
	}

	/**
	 * Hier lassen sich beim erzeugen der EdelsteinBox bereits die 3
	 * Edelsteintypen hinzufügen
	 * 
	 * @param diamanten
	 * @param rubinen
	 * @param smaragde
	 */
	/*public EdelsteinBox(int diamanten, int rubinen, int smaragde) {
		edelsteine = new int[3];
		edelsteine[0] = diamanten;
		edelsteine[1] = rubinen;
		edelsteine[2] = smaragde;
	}*/
	public EdelsteinBox(Edelstein ...edelsteine) {
		this.edelsteine = new int[Edelstein.values().length];
		for(Edelstein stein: edelsteine) {
			this.edelsteine[stein.ordinal()] += 1;
		}
	}

	/**
	 * Gibt die Anzahl der angegeben sorte zurück
	 * 
	 * @param sorte
	 *            wessen Anzahl zurückgegeben werden soll
	 * @return Anzahl der vorhanden Steine der angegebenen Sorte
	 */
	public int getAnzahl(Edelstein sorte) {
		return edelsteine[sorte.ordinal()];
	}

	/**
	 * Erzeugt Ausgabe zur darstellen der Edelsteine in einer Zeile
	 */
	public String toString() {
		String text = "";
		//für jeden Wert in Edelstein Enum
		for (Edelstein stein : Edelstein.values()) {
			for (int i = 0; i < edelsteine[stein.ordinal()]; i++) {
				text += stein.name().charAt(0);
			}
		}
		return "(" + text + ")";
	}

	/**
	 * Gibt die Ausgabe von toString() aus
	 */
	public void ausgeben() {
		System.out.println(toString());
	}

	/**
	 * Fügt n Steine zur angebenen Sorte hinzu
	 * 
	 * @param sorte
	 * @param n
	 */
	public void hineinlegen(Edelstein sorte, int n) {
		edelsteine[sorte.ordinal()] += n;
	}

	/**
	 * Nimmt n Steine von der angebenen Sorte raus Sofern weniger ans n
	 * vorhanden sind wird nur die maximale Anzahl entnommen
	 * 
	 * @param sorte
	 * @param n
	 */
	public void herausnehmen(Edelstein sorte, int n) {
		// wenn nicht genug vorhanden sind
		if (n > edelsteine[sorte.ordinal()]) {
			edelsteine[sorte.ordinal()] = 0;
			// sonst ziehe normal ab
		} else {
			edelsteine[sorte.ordinal()] -= n;
		}
	}

	/**
	 * Wandelt alle Edelsteine von vonSorte zu zuSorte um.
	 * 
	 * @param vonSorte
	 * @param zuSorte
	 */
	public void umwandeln(Edelstein vonSorte, Edelstein zuSorte) {
		edelsteine[zuSorte.ordinal()] += edelsteine[vonSorte.ordinal()];
		edelsteine[vonSorte.ordinal()] = 0;
	}

	/**
	 * Leert die Edelsteinbox, so dass keine Edelsteine mehr darin vorhanden
	 * sind
	 */
	public void leeren() {
		for (Edelstein stein : Edelstein.values()) {
			edelsteine[stein.ordinal()] = 0;
		}
	}

}
