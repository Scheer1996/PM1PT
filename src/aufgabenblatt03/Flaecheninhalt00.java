/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Aufgabe: Aufgabenblatt 3 - Aufgabe 1 a
 */

package aufgabenblatt03;

import java.util.Scanner;

public class Flaecheninhalt00 {

	public static void main(String[] args) {
		double x;
		int index;

		// get input
		Scanner scanner = new Scanner(System.in);
		System.out.print(
				"Menü: \n Flächeninhalt für \n [1] einen Kreis \n [2] ein Quadrats\n [3] eines Sechsecks \n Bitte wählen: ");
		index = scanner.nextInt();

		System.out.format("Bitte geben Sie %s ein:", (index == 1) ? "den Radius" : "die Seitenlänge");
		x = scanner.nextDouble();

		// clean up
		scanner.close();

		if (index == 1) { // circle
			System.out.format("Der Flächeninhalt des Kreis mit dem Radius %.2f ist etwa: %.2f", x,
					(Math.PI * Math.pow(x, 2)));

		} else if (index == 2) { // square
			System.out.format("Der Flächeninhalt des Quadrates mit der Seitenlänge %.2f ist etwa: %.2f", x,
					Math.pow(x, 2));

		} else if (index == 3) { // hexagon
			System.out.format("Der Flächeninhalt des Sechsecks mit der Seitenlänge %.2f ist etwa: %.2f", x,
					(3 * Math.sqrt(3) * Math.pow(x, 2)) / 2);

		} else { // error
			System.out.format("Der angegeben index war ungültig.");
		}

	}

}
