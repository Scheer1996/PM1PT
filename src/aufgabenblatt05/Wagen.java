/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * Datum: 25.04.2016
 * Aufgabe: Aufgabenblatt 5 - Aufgabe 5.2
 */
package aufgabenblatt05;

/**
 * 
 */
public class Wagen {

	/**
	 * Länge in Metern
	 */
	private final int laenge;
	
	/**
	 * Passagierkapazität in Personen
	 */
	private final int kapazitaet;
	
	private Wagen naechsterWagen = null;
	
	public Wagen(int laenge, int kapazitaet) {
		this.laenge = laenge;
		this.kapazitaet = kapazitaet;
	}

	public Wagen getNaechsterWagen() {
		return naechsterWagen;
	}

	public void setNaechsterWagen(Wagen naechsterWagen) {
		this.naechsterWagen = naechsterWagen;
	}

}
