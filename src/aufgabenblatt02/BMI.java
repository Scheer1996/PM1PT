/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Aufgabe: Aufgabenblatt 2 - Aufgabe 2
 */

package aufgabenblatt02;

import java.util.Scanner;

/**
 * calculates BMI from size and weight
 *
 */
public class BMI {

	public static void main(String[] args)
	{
		//vars
		double size, weight;
		int bmi;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Geben Sie ihre Größe in m ein: ");
		size = scanner.nextDouble();
		System.out.print("Geben Sie ihr Gewicht in kg ein: ");
		weight = scanner.nextDouble();
		
		//clean up
		scanner.close();
		
		//calculate bmi
		bmi = (int) (weight / (size * size));
		
		System.out.format("Ihr BMI beträgt: %d", bmi);
	}
}
