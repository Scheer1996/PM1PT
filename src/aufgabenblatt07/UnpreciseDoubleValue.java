/*
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 14.06.2016 
 * Aufgabe: Aufgabenblatt X - Aufgabe X
 */

package aufgabenblatt07;

/**
 * A wrapper class for storing Doubles - they are counted as equal if they are
 * within a specific interval
 */
public class UnpreciseDoubleValue {

	/**
	 * width of interval for equality
	 */
	private final static double EPSILON = 5e-3;

	/**
	 * the value represented by this wrapper
	 */
	private final double value;

	// Constructor
	public UnpreciseDoubleValue(double value) {
		this.value = value;
	}

	// Getter
	public double getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return (int) value;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof UnpreciseDoubleValue) {
			double other = ((UnpreciseDoubleValue) o).value;
			return Math.abs(other - value) < EPSILON;
		}
		return false;
	}

}
