/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * Datum: 05.04.2016
 * Aufgabe: Aufgabenblatt X - Aufgabe x
 */
package vorlesung20160405;

import java.util.Arrays;

public class ArraysBeispiel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] tiere = {"Affe", "Elefant", "Katze"};
		System.out.println(Arrays.toString(tiere));
		
		
		for(String tier: tiere)
		{
			System.out.println(tier);
		}
	}

}