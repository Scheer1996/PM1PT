/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * Datum: 24.04.2016
 * Aufgabe: Aufgabenblatt 4
 */
package aufgabenblatt04;

public class Simulation {

	public static void main(String[] args) {
		
		// neues Rennen erstellen
		Rennen rennen1 = new Rennen(200);

		// rennautos erstelles
		Rennauto rennauto1 = new Rennauto("Rennauto 1", "Ferrari", 20);
		Rennauto rennauto2 = new Rennauto("Rennauto 2", "Porsche", 20);
		
		// rennautos hinzufügen
		rennen1.addRennauto(rennauto1);
		rennen1.addRennauto(rennauto2);
		
		// wettbüro erstellen & wetten annehmen
		Wettbuero wettbuero = new Wettbuero(rennen1, 20);
		wettbuero.wetteAnnehmen("Rennauto 1", 10, "hans Peter");
		wettbuero.wetteAnnehmen("Rennauto 2", 100, "Cooler Typ");
		
		// rennen durchführen und wetten auswerten
		rennen1.durchfuehren();
		wettbuero.auswerten();
		
	}

}
