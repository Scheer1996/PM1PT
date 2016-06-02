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
	 * maximum number of iterations before an exception is thrown
	 */
	private final int MAX_ITERATIONS = 0;

	/**
	 * the function to perform calculations on
	 */
	private final Function function;

	public Roots(Function f) {
		this.function = f;
	}

	/**
	 * finds the closest root to a starting value
	 * 
	 * @param startingValue
	 *            the value to start newtons method at
	 * @return the x value of the closest root
	 */
	public double findRoot(double startingValue) throws NoRootFoundException {
		double xn = startingValue;
		double y = function.calculateValueFor(xn);

		int count = 0;
		
		while (Math.abs(y) > EPSILON) {
			
			if(count > MAX_ITERATIONS){
				throw new NoRootFoundException(NoRootFoundExceptionCause.NO_CONVERGENCE);
			}
			
			double dy = function.calculateValueOfDerivateFor(xn);
			xn = xn - function.calculateValueFor(xn) / dy;
			y = function.calculateValueFor(xn);
			count++;			
		}

		return xn;
	}
}
