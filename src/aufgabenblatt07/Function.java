/*
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 02.06.2016 
 * Aufgabe: Aufgabenblatt 7 - Aufgabe 1
 */

package aufgabenblatt07;

/**
 * Representation for a Function
 */
public interface Function {
	/**
	 * calculates the value y = f(x) for this function
	 * 
	 * @param x
	 *            the x-value
	 * @return the y value y = f(x)
	 */
	public double calculateValueFor(double x);

	/**
	 * calculates the value y = f'(x) for the first derivate of this function
	 * 
	 * @param x
	 *            the x-value
	 * @return the y value y = f'(x)
	 */
	public double calculateValueOfDerivateFor(double x);
}
