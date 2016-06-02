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
 * Representation of a general polynomial function
 */
public class PolynomialFunction implements Function {

	/**
	 * the coefficients for this function
	 */
	private final double[] coefficients;

	/**
	 * creates a new PolynomialFunction
	 * 
	 * @param coefficients
	 *            the coefficients a_0, a_1, ... a_n
	 */
	public PolynomialFunction(double... coefficients) {
		this.coefficients = coefficients;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see aufgabenblatt07.Function#calculateValueFor(double)
	 */
	@Override
	public double calculateValueFor(double x) {
		//if there are no coefficients then this is not a function
		if(coefficients.length == 0){
			return Double.NaN;
		}
		
		double y = coefficients[0];
		for(int i = 1; i < coefficients.length; i++){
			y += coefficients[i] * Math.pow(x, i);
		}
		
		return y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see aufgabenblatt07.Function#calculateValueOfDerivateFor(double)
	 */
	@Override
	public double calculateValueOfDerivateFor(double x) {
		if(coefficients.length == 0){
			return Double.NaN;
		}
		else if(coefficients.length == 1){
			return 0;
		}
		
		//create array for coefficients of derivate
		double[] newCoeffs = new double[coefficients.length - 1];
		
		for(int i = 1; i < coefficients.length; i++){
			newCoeffs[i - 1] = coefficients[i] * i;
		}
				
		PolynomialFunction derivate = new PolynomialFunction(newCoeffs);
		return derivate.calculateValueFor(x);
	}

}
