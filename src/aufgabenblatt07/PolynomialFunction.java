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

	public final double EPSILON = 1e-5;

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
		// if there are no coefficients then this is not a function
		if (coefficients.length == 0) {
			return Double.NaN;
		}

		double y = coefficients[0];
		for (int i = 1; i < coefficients.length; i++) {
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
		if (coefficients.length == 0) {
			return Double.NaN;
		} else if (coefficients.length == 1) {
			return 0;
		}

		return getDerivate().calculateValueFor(x);
	}

	/**
	 * calculates and returns the derivate for this function
	 * 
	 * @return a PolynomialFunction object representing the derivate of this
	 *         function
	 */
	public PolynomialFunction getDerivate() {
		if (coefficients.length == 0) {
			return new PolynomialFunction();
		} else if (coefficients.length == 1) {
			return new PolynomialFunction(0);
		}

		// create array for coefficients of derivate
		double[] newCoeffs = new double[coefficients.length - 1];

		for (int i = 1; i < coefficients.length; i++) {
			newCoeffs[i - 1] = coefficients[i] * i;
		}

		return new PolynomialFunction(newCoeffs);
	}

	@Override
	public String toString() {
		String s = "f(x) = ";

		boolean isFirst = true;

		// go through all coefficients starting at the highest one
		for (int i = coefficients.length - 1; i >= 0; i--) {

			if (Math.abs(coefficients[i]) < EPSILON) {
				continue;
			}

			// is this the first coefficient? if not add +/-
			if (!isFirst) {
				if (coefficients[i] < 0) {
					s += " - ";
				} else {
					s += " + ";
				}
			} else {
				if (coefficients[i] < 0) {
					s += "-";
				}

				isFirst = false;
			}

			// it's not a 1
			if (Math.abs(coefficients[i]) - 1 > EPSILON || i == 0) {
				s += Math.abs(coefficients[i]);
			}
			if (i == 0) {
				continue;
			}
			if (i == 1) {
				s += "x";
			} else {
				s += "x^" + i;
			}
		}

		// we havent printed any coefficients
		if (isFirst) {
			if (coefficients.length == 0) {
				s += "undefined";
			} else {
				s += "0";
			}
		}

		return s;
	}

	@Override
	public boolean equals(Object o) {
		// is the other object a PolynomialFunction?
		if (!(o instanceof PolynomialFunction)) {
			return false;
		}

		PolynomialFunction other = (PolynomialFunction) o;

		// do we have the same number of coefficients
		if (coefficients.length != other.coefficients.length) {
			return false;
		}

		// are all coefficients equal?
		for (int i = 0; i < coefficients.length; i++) {
			if (Math.abs(coefficients[i] - other.coefficients[i]) > EPSILON) {
				return false;
			}
		}

		return true;
	}

}
