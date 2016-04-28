/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Aufgabe: Aufgabenblatt 2 - Aufgabe 3
 */

package aufgabenblatt02;

import java.util.Scanner;

/**
 * calculates the modulus with the modulus operator and with formula.
 */
public class Modulo {

	public static void main(String[] args) {
		int a, b;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Bitte a eingeben: ");
		a = scanner.nextInt();

		System.out.print("Bitte b eingeben: ");
		b = scanner.nextInt();
		scanner.close();
		
		//Modulus with operator
		System.out.println("Modulo operator: " + (a % b));
		//Modulus with formula
		System.out.println("Modulo Formel (a- (a / b) * b): " + (a - (a / b) * b));

	}

}
