/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * Datum: 25.04.2016
 * Aufgabe: Aufgabenblatt 5 - Aufgabe 5.2
 */
package aufgabenblatt05;

import aufgabenblatt04.Rennauto;

/**
 * 
 */
public class Zug {

	private Lokomotive lok;

	/**
	 * Hängt lok an den Zug an
	 * @param lok
	 */
	public Zug(Lokomotive lok) {
		this.lok = lok;
	}
	
	/**
	 * Fügt einen Wagen am Ende des Zuges hinzu
	 * @param neuerWagen
	 */
	public void wagenHinzufuegen(Wagen neuerWagen) {
		if (lok.getErsterWagen() == null) {
			lok.setErsterWagen(neuerWagen);
		} else {
			Wagen[] wagen = getWagen();
			wagen[wagen.length - 1].setNaechsterWagen(neuerWagen);
		}
	}
	
	/**
	 * Entfernt den ersten Wagen ab und liefert diesen als Ergebnis zurück. Alle anderen Wagen rücken auf. Falls kein Wagen vorhanden wird null zurückgegeben
	 * @return Entfernter Wagen
	 */
	public Wagen erstenWagenEntfernen() {
		if(lok.getErsterWagen() != null) {
			Wagen entfernterWagen = lok.getErsterWagen();
			this.lok.setErsterWagen(entfernterWagen.getNaechsterWagen());
			entfernterWagen.setNaechsterWagen(null);
			return entfernterWagen;
		} else {
			return null;
		}
		
	}
	
	/**
	 * Hängt alle Wagen eines andereren Zuges an diesen Zug an
	 * @param andererZug
	 */
	public void zugAnhaengen(Zug andererZug) {
		/**
		 * Variante A
		 * Alle Wagen Manuell umhängen
		 * Lt. Aufgabenstellung soll man das hier machen?!
		 */
		while(andererZug.lok.getErsterWagen() != null) { // evtl. =
			wagenHinzufuegen(andererZug.erstenWagenEntfernen());
		}
		/**
		 * Variante B
		 * Nur den ersten Wagen umhängen und 
		 * die Verknüpfungen zu den anderen Wagen lassen
		 */
		if(andererZug.lok.getErsterWagen() != null) {
			wagenHinzufuegen(andererZug.lok.getErsterWagen());
		}
	}
	
	/**
	 * Gibt die Wagenanzahl zurück
	 * @return
	 */
	public int getWagenAnzahl() {
		return getWagen().length;
	}

	/**
	 * Gibt die Kapazität der Wagen zurück
	 * @return
	 */
	public int getKapazitaet() {
		int kapazitaet = 0;
		for(Wagen item: getWagen()) {
			kapazitaet += item.getKapazitaet();
		}
		return kapazitaet;
	}
	
	/**
	 * Gibt die länge des Zuges zurück
	 * @return
	 */
	public int getLaenge() {
		int laenge = lok.getLeange();
		if (lok.getErsterWagen() != null) {
			for(Wagen item: getWagen()) {
				laenge += item.getLaenge();
			}
		}
		return laenge;
	}
	
	/**
	 * Gibt eine Beschreibung des Zuges zurück, 
	 * inklusive einer Beschreibung jedes Wagens
	 */
	public String toString() {
		String string = "Zug Typ:         " + lok.getTyp() + "\n"
				  	  + "Loklänge:        " + lok.getLeange() + "m\n"
					  + "Gesamtlaenge:    " + getLaenge() + "m\n"
					  + "Wagenanzahl:     " + getWagenAnzahl() + " Stück\n"
					  + "Gesamtkapazität: " + getKapazitaet() + " Personen\n"
					  + "----------------------------------\n";

		for(Wagen item: this.getWagen()) {
			string += item.toString();
		}
		
		return string;
	}
	
	/**
	 * Hilfmethode
	 * Gibt alle Wagen in einem Array zurück
	 * @return
	 */
	private Wagen[] getWagen() {
		Wagen wagen[] = new Wagen[0];
		int anzahlWagen = 0;
		if (this.lok.getErsterWagen() != null) {
			Wagen naechsterWagen = this.lok.getErsterWagen();
			while (naechsterWagen != null) {
				Wagen[] temp = new Wagen[wagen.length + 1];
				System.arraycopy(wagen, 0, temp, 0, wagen.length);
				
				wagen = temp;
				
				wagen[anzahlWagen] = naechsterWagen;
				anzahlWagen++;
				
				naechsterWagen = naechsterWagen.getNaechsterWagen();
			}
		}
		
		return wagen;
	}
	
	
}
