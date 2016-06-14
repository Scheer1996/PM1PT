/*
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 02.06.2016 
 * Aufgabe: Aufgabenblatt 7
 */

package aufgabenblatt07;

import java.util.List;

/**
 * Application entry point for Aufgabenblatt 7
 */
public class Aufgabenblatt07_Application {

	/**
	 * entry point
	 * 
	 * @param args
	 *            commandline args
	 */
	public static void main(String[] args) throws NoRootFoundException{
		PolynomialFunction pf = new PolynomialFunction(1, 5, 7, 6, 2, -1);
		Roots r = new Roots(pf);
		
		List<Double> roots  = r.findRootsRandomised(-50, 50, 100);
		System.out.println(roots);
	}
}
