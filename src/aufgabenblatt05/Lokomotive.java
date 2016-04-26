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
public class Lokomotive {

	/**
	 * Länge in Metern
	 */
	private final int laenge;
	
	/**
	 * Tyo als Zahl
	 */
	private final int typ;
	
	private Wagen ersterWagen;
	
	public Lokomotive(int laenge, int typ) {
		this.laenge = laenge;
		this.typ = typ;
	}
	
	public Wagen getErsterWagen(){
		return ersterWagen;
	}
	
	public void setErsterWagen(Wagen ersterWagen) {
		this.ersterWagen = ersterWagen;
	}
	
}
