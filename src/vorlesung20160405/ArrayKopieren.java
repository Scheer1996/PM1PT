/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * Datum: 05.04.2016
 * Aufgabe: Aufgabenblatt X - Aufgabe x
 */
package vorlesung20160405;

import java.util.Arrays;

/**
 * 
 */
public class ArrayKopieren {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [][] quelle = {{1,2,3},{4,5,6}};
		int [][] ziel = new int[3][3];

		int [] neueSpalte = {0,0,0};
		System.arraycopy(quelle, 0, ziel, 0, quelle.length);
		ziel[2] = neueSpalte;

		for (int[] zeile : ziel) {
			for (int wert : zeile) {
				System.out.format("%2d", wert);
			}
			System.out.println();
		}
	}

}
