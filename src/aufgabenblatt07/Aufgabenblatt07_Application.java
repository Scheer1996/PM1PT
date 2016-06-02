/*
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 02.06.2016 
 * Aufgabe: Aufgabenblatt 7
 */

package aufgabenblatt07;

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
		new Roots(new PolynomialFunction(1,2,3)).findRoot(0);
	}
}
