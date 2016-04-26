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
public class Wettbuero {
	private int anzahlWetten;
	private double faktor;
	private Wette[] wetten;
	private Rennen rennen;
	
	public Wettbuero(Rennen rennen, double faktor) {
		wetten = new Wette[0];
		this.rennen = rennen;
		this.faktor = faktor;
	}

	public void wetteAnnehmen(String fahrerin, int wettEinsatz, String spieler) {
		Wette neueWette = new Wette(fahrerin, wettEinsatz, spieler);
		
		Wette[] tempArray = new Wette[this.wetten.length + 1];
		System.arraycopy(wetten, 0, tempArray, 0, wetten.length);
		
		wetten = tempArray;

		wetten[anzahlWetten] = neueWette;
		anzahlWetten ++;
	}
	
	public void auswerten() {
		String sieger = rennen.getSieger().getName();
		for(Wette wette : wetten) {
			if(sieger.equals(wette.getFahrerin())) {
				System.out.println(wette.getSpieler() + " hat auf " + wette.getFahrerin() + " gesetzt und gewinnt " + wette.getWettEinsatz() * faktor);
			}
		}
	}
}
