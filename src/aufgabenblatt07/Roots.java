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
 * This class uses newtons method to estimate roots of a function
 */
public class Roots {

	/**
	 * if |f(x)| is less than or equal to EPSILON, then x is root 
	 */
	private final double EPSILON = 1e-5;
	
	/**
	 * the function to perform calculations on
	 */
	private final Function function;
	
	public Roots(Function f){
		this.function = f;
	}
	
	
	
	/**
	 * finds the closest root to a starting value
	 * 
	 * @param startingValue
	 *            the value to start newtons method at
	 * @return the x value of the closest root
	 */
	public double findRoot(double startingValue) {
		double xn = startingValue;		
		double y = function.calculateValueFor(xn);
		
		while(Math.abs(y) > EPSILON){
			xn = xn - function.calculateValueFor(xn) / function.calculateValueOfDerivateFor(xn);
			y = function.calculateValueFor(xn);
		}
		
		return xn;
	}
}
