/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * Datum: 24.04.2016
 * Aufgabe: Aufgabenblatt 4
 */
package aufgabenblatt04;

/**
 * 
 */
public class Wette {
	private String fahrerin, spieler;
	private int wettEinsatz;
	
	
	public Wette(String fahrerin, int wettEinsatz, String spieler)
	{
		this.fahrerin = fahrerin;
		this.wettEinsatz = wettEinsatz;
		this.spieler = spieler;
	}
	
	public String getFahrerin() {
		return fahrerin;
	}
	
	public int getWettEinsatz() {
		return wettEinsatz;
	}
	
	public String getSpieler() {
		return spieler;
	}

}
