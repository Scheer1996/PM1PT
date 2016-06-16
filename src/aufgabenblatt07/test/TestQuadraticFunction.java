/*
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 02.06.2016 
 * Aufgabe: Aufgabenblatt 7 - Aufgabe 1
 */

package aufgabenblatt07.test;

import aufgabenblatt07.QuadraticFunction;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestQuadraticFunction {

	@Test
	public void testCalculateValueFor() {
		QuadraticFunction qf = new QuadraticFunction(1, 0, 0);
		assertEquals("f(0) is wrong", qf.calculateValueFor(0), 0, 1e-5);
		assertEquals("f(1) is wrong", qf.calculateValueFor(1), 1, 1e-5);
		assertEquals("f(5) is wrong", qf.calculateValueFor(5), 25, 1e-5);
	}

	@Test
	public void testCalculateValueOfDerivateFor() {
		QuadraticFunction qf = new QuadraticFunction(1, 0, 0);
		assertEquals("f'(0) is wrong", qf.calculateValueOfDerivateFor(0), 0, 1e-5);
		assertEquals("f'(1) is wrong", qf.calculateValueOfDerivateFor(1), 2, 1e-5);
		assertEquals("f'(5) is wrong", qf.calculateValueOfDerivateFor(5), 10, 1e-5);
	}

}
