/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * Datum: 25.04.2016
 * Aufgabe: Aufgabenblatt 5 - Aufgabe 5.2
 */
package aufgabenblatt05;

/**
 * Dies ist die Anwendungsklasse zur Aufgabe 5.2
 */
public class Eisenbahnzuege {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Zug 1
		Lokomotive lok = new Lokomotive(20, 1);
		Zug neuerZug = new Zug(lok);
		
		Wagen neuerWagen = new Wagen(10001 ,20, 100);
		Wagen neuerWagen2 = new Wagen(10002, 10, 50);
		Wagen neuerWagen3 = new Wagen(10003, 5, 25);
		neuerZug.wagenHinzufuegen(neuerWagen);
		neuerZug.wagenHinzufuegen(neuerWagen2);
		neuerZug.wagenHinzufuegen(neuerWagen3);

		
		//Zug 2
		Lokomotive lok2 = new Lokomotive(20, 1);
		Zug neuerZug2 = new Zug(lok2);

		Wagen neuerWagen4 = new Wagen(20001, 20, 100);
		Wagen neuerWagen5 = new Wagen(20002, 10, 50);
		Wagen neuerWagen6 = new Wagen(20003, 5, 25);
		neuerZug2.wagenHinzufuegen(neuerWagen4);
		neuerZug2.wagenHinzufuegen(neuerWagen5);
		neuerZug2.wagenHinzufuegen(neuerWagen6);
		
		neuerZug.zugAnhaengen(neuerZug2);
		

		Lokomotive lok3 = new Lokomotive(20, 1);
		Zug neuerZug3 = new Zug(lok3);
		neuerZug3.erstenWagenEntfernen();
		
		System.out.println(neuerZug.toString());
	}

}
