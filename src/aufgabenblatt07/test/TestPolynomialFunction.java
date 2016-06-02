package aufgabenblatt07.test;

import aufgabenblatt07.PolynomialFunction;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestPolynomialFunction {

	@Test
	public void testCalculateValueForEmpty() {
		PolynomialFunction pf = new PolynomialFunction();
		assertEquals("Empty function failed", pf.calculateValueFor(0), Double.NaN, 0);
	}
	
	@Test
	public void testCalculateValueFor0Degree() {
		PolynomialFunction pf = new PolynomialFunction(10);
		assertEquals("0th degree function failed f(0)", pf.calculateValueFor(0), 10, 1e-5);
		assertEquals("0th degree function failed f(1)", pf.calculateValueFor(1), 10, 1e-5);
		assertEquals("0th degree function failed f(-1)", pf.calculateValueFor(-1), 10, 1e-5);
		assertEquals("0th degree function failed f(5)", pf.calculateValueFor(5), 10, 1e-5);
		assertEquals("0th degree function failed f(-5)", pf.calculateValueFor(-5), 10, 1e-5);
	}
	
	@Test
	public void testCalculateValueForLinear() {
		PolynomialFunction pf = new PolynomialFunction(10, -2);
		assertEquals("linear function failed f(0)", pf.calculateValueFor(0), 10, 1e-5);
		assertEquals("linear function failed f(1)", pf.calculateValueFor(1), 8, 1e-5);
		assertEquals("linear function failed f(-1)", pf.calculateValueFor(-1), 12, 1e-5);
		assertEquals("linear function failed f(5)", pf.calculateValueFor(5), 0, 1e-5);
		assertEquals("linear function failed f(-5)", pf.calculateValueFor(-5), 20, 1e-5);
	}
	
	@Test
	public void testCalculateValueFor5Degree() {
		PolynomialFunction pf = new PolynomialFunction(10, 2, -5, -3, Math.PI, 1.35);
		assertEquals("5th degree function failed f(0)", pf.calculateValueFor(0), 10, 1e-5);
		assertEquals("5th degree function failed f(1)", pf.calculateValueFor(1), 8.49159, 1e-5);
		assertEquals("5th degree function failed f(-1)", pf.calculateValueFor(-1), 7.79159, 1e-5);
		assertEquals("5th degree function failed f(5)", pf.calculateValueFor(5), 5702.245408, 1e-5);
		assertEquals("5th degree function failed f(-5)", pf.calculateValueFor(-5), -2005.254592, 1e-5);
	}

	@Test
	public void testCalculateValueOfDerivateForEmpty() {
		PolynomialFunction pf = new PolynomialFunction();
		assertEquals("Empty function failed", pf.calculateValueOfDerivateFor(0), Double.NaN, 0);
	}
	
	@Test
	public void testCalculateValueOfDerivateFor0Degree() {
		PolynomialFunction pf = new PolynomialFunction(10);
		assertEquals("0th degree function failed f'(0)", pf.calculateValueOfDerivateFor(0), 0, 1e-5);
		assertEquals("0th degree function failed f'(1)", pf.calculateValueOfDerivateFor(1), 0, 1e-5);
		assertEquals("0th degree function failed f'(-1)", pf.calculateValueOfDerivateFor(-1), 0, 1e-5);
		assertEquals("0th degree function failed f'(5)", pf.calculateValueOfDerivateFor(5), 0, 1e-5);
		assertEquals("0th degree function failed f'(-5)", pf.calculateValueOfDerivateFor(-5), 0, 1e-5);
	}
	
	@Test
	public void testCalculateValueOfDerivateForLinear() {
		PolynomialFunction pf = new PolynomialFunction(10, -2);
		assertEquals("linear function failed f'(0)", pf.calculateValueOfDerivateFor(0), -2, 1e-5);
		assertEquals("linear function failed f'(1)", pf.calculateValueOfDerivateFor(1), -2, 1e-5);
		assertEquals("linear function failed f'(-1)", pf.calculateValueOfDerivateFor(-1), -2, 1e-5);
		assertEquals("linear function failed f'(5)", pf.calculateValueOfDerivateFor(5), -2, 1e-5);
		assertEquals("linear function failed f'(-5)", pf.calculateValueOfDerivateFor(-5), -2, 1e-5);
	}
	
	@Test
	public void testCalculateValueOfDerivateFor5Degree() {
		PolynomialFunction pf = new PolynomialFunction(1,1,1,1,1,1);
		assertEquals("5th degree function failed f'(0)", pf.calculateValueOfDerivateFor(0), 1, 1e-5);
		assertEquals("5th degree function failed f'(1)", pf.calculateValueOfDerivateFor(1), 15, 1e-5);
		assertEquals("5th degree function failed f'(-1)", pf.calculateValueOfDerivateFor(-1), 3, 1e-5);
		assertEquals("5th degree function failed f'(5)", pf.calculateValueOfDerivateFor(5), 3711, 1e-5);
		assertEquals("5th degree function failed f'(-5)", pf.calculateValueOfDerivateFor(-5), 2691, 1e-5);
	}

}
