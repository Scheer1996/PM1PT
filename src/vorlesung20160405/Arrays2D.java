/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * Datum: 05.04.2016
 * Aufgabe: Aufgabenblatt X - Aufgabe x
 */
package vorlesung20160405;

/**
 * 
 */
public class Arrays2D {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [][] array = {{1,2,3},{4,5,6}};
		
		for (int[] zeile : array) {
			for (int wert : zeile) {
				System.out.format("%2d", wert);
			}
			System.out.println();
		}

	}

}
