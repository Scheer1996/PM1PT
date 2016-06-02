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
 * Representation of a quadratic function
 */
public class QuadraticFunction implements Function {

	/**
	 * the coefficients for this quadratic equation
	 */
	private final double a,b,c;
	
	public QuadraticFunction(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}	
	
	/* (non-Javadoc)
	 * @see aufgabenblatt07.Function#calculateValueFor(double)
	 */
	@Override
	public double calculateValueFor(double x) {
		return a * x * x + b * x + c;
	}

	/* (non-Javadoc)
	 * @see aufgabenblatt07.Function#calculateValueOfDerivateFor(double)
	 */
	@Override
	public double calculateValueOfDerivateFor(double x) {
		return 2 * a * x + b;
	}

}
