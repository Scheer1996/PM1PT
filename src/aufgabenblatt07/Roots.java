/*
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 02.06.2016 
 * Aufgabe: Aufgabenblatt 7 - Aufgabe 1
 */

package aufgabenblatt07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Iterator;

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
	private final int MAX_ITERATIONS = 100;

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
	 * @throws NoRootFoundException no root could be found
	 */
	public double findRoot(double startingValue) throws NoRootFoundException {
		double xn = startingValue;
		double y = function.calculateValueFor(xn);

		if (y == Double.NaN) {
			throw new NoRootFoundException(
					NoRootFoundExceptionCause.NO_CONVERGENCE);
		}

		int count = 0;
		while (Math.abs(y) > EPSILON) {

			if (count > MAX_ITERATIONS) {
				throw new NoRootFoundException(
						NoRootFoundExceptionCause.NO_CONVERGENCE);
			}

			double dy = function.calculateValueOfDerivateFor(xn);

			if (dy == 0) {
				throw new NoRootFoundException(
						NoRootFoundExceptionCause.DIVIDE_BY_ZERO);
			}

			// new xn is xn - ( f(xn) / f'(xn) )
			xn = xn - function.calculateValueFor(xn) / dy;
			y = function.calculateValueFor(xn);

			count++;
		}

		return xn;
	}

	/**
	 * returns a sorted List of Doubles containing all the roots hat were
	 * randomly found in the given interval
	 * 
	 * @param min
	 *            lower boundary of search interval
	 * @param max
	 *            upper boundary of search interval
	 * @param numberOfTries
	 * 			  the number of tries to find a new root
	 * @return sorted list of roots
	 */
	public List<Double> findRootsRandomised(int min, int max,
			int numberOfTries) {
		HashSet<UnpreciseDoubleValue> set = new HashSet<>();
		double x0;

		for (int i = 0; i < numberOfTries; i++) {
			try {
				x0 = findRoot(getRandomDoubleInInterval(min, max));
				set.add(new UnpreciseDoubleValue(x0));
			} catch (NoRootFoundException ex) {
				// do nothing, just skip
			}
		}
		
		List<Double> list = new ArrayList<>();
		for(Iterator<UnpreciseDoubleValue> it = set.iterator();it.hasNext();){
			list.add(it.next().getValue());
		}
		
		list.sort(null);
		return list;
	}

	/**
	 * returns a random double between min and max
	 * 
	 * @param min
	 *            lower boundary of interval
	 * @param max
	 *            upper boundary of interval
	 * @return a random double bewtween min and max
	 */
	private double getRandomDoubleInInterval(int min, int max) {
		int lower = Math.min(min, max);
		int upper = Math.max(min, max);

		int width = upper - lower;

		return Math.random() * width + lower;
	}
}
