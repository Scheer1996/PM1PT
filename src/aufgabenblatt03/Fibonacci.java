/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Aufgabe: Aufgabenblatt 3 - Aufgabe 2
 */

package aufgabenblatt03;

import java.util.Scanner;

/**
 * Calculates the n-th Number in the Fibonacci sequence.
 */
public class Fibonacci {

	public static void main(String[] args) {
		// vars
		int startCount, count, previousToLastValue = 1, lastValue = 1, currentValue = 1;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Die wievielte Fibonacci Zahl wollen Sie haben ?");
		startCount = scanner.nextInt();

		// clean up
		scanner.close();

		count = startCount;

		// if count is less than 2, the predefined value of 1 is kept
		while (count > 2) {
			currentValue = previousToLastValue + lastValue;
			previousToLastValue = lastValue;
			lastValue = currentValue;
			count--;
		}

		// output
		System.out.format("Die %d. Fibonacci Zahl ist: %d", startCount, currentValue);

	}

}
