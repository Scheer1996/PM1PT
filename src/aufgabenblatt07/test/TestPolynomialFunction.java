/*
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 02.06.2016 
 * Aufgabe: Aufgabenblatt 7 - Aufgabe 1
 */

package aufgabenblatt07.test;

import aufgabenblatt07.PolynomialFunction;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestPolynomialFunction {

	@Test
	public void testCalculateValueForEmpty() {
		PolynomialFunction pf = new PolynomialFunction();
		assertEquals("Empty function failed", pf.calculateValueFor(0),
				Double.NaN, 0);
	}

	@Test
	public void testCalculateValueFor0Degree() {
		PolynomialFunction pf = new PolynomialFunction(10);
		assertEquals("0th degree function failed f(0)", pf.calculateValueFor(0),
				10, 1e-5);
		assertEquals("0th degree function failed f(1)", pf.calculateValueFor(1),
				10, 1e-5);
		assertEquals("0th degree function failed f(-1)",
				pf.calculateValueFor(-1), 10, 1e-5);
		assertEquals("0th degree function failed f(5)", pf.calculateValueFor(5),
				10, 1e-5);
		assertEquals("0th degree function failed f(-5)",
				pf.calculateValueFor(-5), 10, 1e-5);
	}

	@Test
	public void testCalculateValueForLinear() {
		PolynomialFunction pf = new PolynomialFunction(10, -2);
		assertEquals("linear function failed f(0)", pf.calculateValueFor(0), 10,
				1e-5);
		assertEquals("linear function failed f(1)", pf.calculateValueFor(1), 8,
				1e-5);
		assertEquals("linear function failed f(-1)", pf.calculateValueFor(-1),
				12, 1e-5);
		assertEquals("linear function failed f(5)", pf.calculateValueFor(5), 0,
				1e-5);
		assertEquals("linear function failed f(-5)", pf.calculateValueFor(-5),
				20, 1e-5);
	}

	@Test
	public void testCalculateValueFor5Degree() {
		PolynomialFunction pf = new PolynomialFunction(10, 2, -5, -3, Math.PI,
				1.35);
		assertEquals("5th degree function failed f(0)", pf.calculateValueFor(0),
				10, 1e-5);
		assertEquals("5th degree function failed f(1)", pf.calculateValueFor(1),
				8.49159, 1e-5);
		assertEquals("5th degree function failed f(-1)",
				pf.calculateValueFor(-1), 7.79159, 1e-5);
		assertEquals("5th degree function failed f(5)", pf.calculateValueFor(5),
				5702.245408, 1e-5);
		assertEquals("5th degree function failed f(-5)",
				pf.calculateValueFor(-5), -2005.254592, 1e-5);
	}

	@Test
	public void testCalculateValueOfDerivateForEmpty() {
		PolynomialFunction pf = new PolynomialFunction();
		assertEquals("Empty function failed", pf.calculateValueOfDerivateFor(0),
				Double.NaN, 0);
	}

	@Test
	public void testCalculateValueOfDerivateFor0Degree() {
		PolynomialFunction pf = new PolynomialFunction(10);
		assertEquals("0th degree function failed f'(0)",
				pf.calculateValueOfDerivateFor(0), 0, 1e-5);
		assertEquals("0th degree function failed f'(1)",
				pf.calculateValueOfDerivateFor(1), 0, 1e-5);
		assertEquals("0th degree function failed f'(-1)",
				pf.calculateValueOfDerivateFor(-1), 0, 1e-5);
		assertEquals("0th degree function failed f'(5)",
				pf.calculateValueOfDerivateFor(5), 0, 1e-5);
		assertEquals("0th degree function failed f'(-5)",
				pf.calculateValueOfDerivateFor(-5), 0, 1e-5);
	}

	@Test
	public void testCalculateValueOfDerivateForLinear() {
		PolynomialFunction pf = new PolynomialFunction(10, -2);
		assertEquals("linear function failed f'(0)",
				pf.calculateValueOfDerivateFor(0), -2, 1e-5);
		assertEquals("linear function failed f'(1)",
				pf.calculateValueOfDerivateFor(1), -2, 1e-5);
		assertEquals("linear function failed f'(-1)",
				pf.calculateValueOfDerivateFor(-1), -2, 1e-5);
		assertEquals("linear function failed f'(5)",
				pf.calculateValueOfDerivateFor(5), -2, 1e-5);
		assertEquals("linear function failed f'(-5)",
				pf.calculateValueOfDerivateFor(-5), -2, 1e-5);
	}

	@Test
	public void testCalculateValueOfDerivateFor5Degree() {
		PolynomialFunction pf = new PolynomialFunction(1, 1, 1, 1, 1, 1);
		assertEquals("5th degree function failed f'(0)",
				pf.calculateValueOfDerivateFor(0), 1, 1e-5);
		assertEquals("5th degree function failed f'(1)",
				pf.calculateValueOfDerivateFor(1), 15, 1e-5);
		assertEquals("5th degree function failed f'(-1)",
				pf.calculateValueOfDerivateFor(-1), 3, 1e-5);
		assertEquals("5th degree function failed f'(5)",
				pf.calculateValueOfDerivateFor(5), 3711, 1e-5);
		assertEquals("5th degree function failed f'(-5)",
				pf.calculateValueOfDerivateFor(-5), 2691, 1e-5);
	}

	@Test
	public void testToString() {
		PolynomialFunction pf = new PolynomialFunction();
		assertEquals("toString failed undefined poly", pf.toString(),
				"f(x) = undefined");

		pf = new PolynomialFunction(0);
		assertEquals("toString failed f(x) = 0", pf.toString(), "f(x) = 0");

		pf = new PolynomialFunction(2, 2);
		assertEquals("toString failed two coefficients", pf.toString(),
				"f(x) = 2.0x + 2.0");

		pf = new PolynomialFunction(-2, 2);
		assertEquals("toString failed two coefficients negative", pf.toString(),
				"f(x) = 2.0x - 2.0");

		pf = new PolynomialFunction(0, 1);
		assertEquals("toString failed f(x) = x", pf.toString(), "f(x) = x");

		pf = new PolynomialFunction(1, 2, 0, 0, 3, 5, -1);
		assertEquals("toString failed many coefficients", pf.toString(),
				"f(x) = -x^6 + 5.0x^5 + 3.0x^4 + 2.0x + 1.0");
	}

	@Test
	public void testEquals() {
		PolynomialFunction pf1 = new PolynomialFunction();
		PolynomialFunction pf2 = new PolynomialFunction();

		assertEquals("Equals failed no coefficients", pf1, pf2);
		assertNotEquals("Equals failed - different type of object", pf1, this);

		pf1 = new PolynomialFunction(0);
		assertNotEquals(
				"Equals failed - they are different (1 coeff <=> 0 coeffs)",
				pf1, pf2);

		pf1 = new PolynomialFunction(0, 1, 2);
		pf2 = new PolynomialFunction(0, 1, 2);
		assertEquals("Equals failed 3 equal coefficients", pf1, pf2);
	}
}
