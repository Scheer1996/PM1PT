package aufgabenblatt07.test;

import aufgabenblatt07.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestRoots {

	@Test
	public void testFindRootNoRoot()  throws NoRootFoundException{
		Roots r = new Roots(new PolynomialFunction());
		assertEquals("No root failed NaN", r.findRoot(0), Double.NaN, 0);
	}
	
	@Test
	public void testFindRootLinearGoodStartingValue() throws NoRootFoundException {
		Roots r = new Roots(new PolynomialFunction(1, 2));
		assertEquals("Linear Root failed 2x + 1 = 0 for starting value 0", r.findRoot(0), -0.5, 1e-5);
		
		r = new Roots(new PolynomialFunction(2, -1));
		assertEquals("Linear Root failed -x + 2 = 0 for starting value 0", r.findRoot(0), 2, 1e-5);
	}
	
	@Test
	public void testFindRootQuadraticGoodStartingValue() throws NoRootFoundException {
		Roots r = new Roots(new PolynomialFunction(1, 2, -1));
		assertEquals("Quadratic Root 1 failed -x² + 2x + 1 = 0 for starting value 0", r.findRoot(0), -0.41421, 1e-5);
		assertEquals("Quadratic Root 1 failed -x² + 2x + 1 = 0 for starting value -5", r.findRoot(-5), -0.41421, 1e-5);
		assertEquals("Quadratic Root 2 failed -x² + 2x + 1 = 0 for starting value 1.5", r.findRoot(1.5), 2.41421, 1e-5);
		assertEquals("Quadratic Root 2 failed -x² + 2x + 1 = 0 for starting value 8", r.findRoot(8), 2.41421, 1e-5);
		
	}
	
	@Test
	public void testFindRootQuadraticBadStartingValue() throws NoRootFoundException {
		Roots r = new Roots(new PolynomialFunction(1, 2, -1));
		assertEquals("Quadratic Root failed NaN -x² + 2x + 1 = 0 for starting value 1", r.findRoot(1), Double.NaN, 0);
	}
	
	@Test
	public void testFindRoot5thDegreeGoodStartingValue() throws NoRootFoundException{
		Roots r = new Roots(new PolynomialFunction(1, 1, 1, 1, 1, 1));
		assertEquals("5th degree Root failed x^5 + x^4 + x^3 + x^2 + x + 1 = 0 for starting value 0", r.findRoot(0), -1, 1e-5);
		assertEquals("5th degree Root failed x^5 + x^4 + x^3 + x^2 + x + 1 = 0 for starting value -15", r.findRoot(-15), -1, 1e-5);
		assertEquals("5th degree Root failed x^5 + x^4 + x^3 + x^2 + x + 1 = 0 for starting value 30", r.findRoot(30), -1, 1e-5);
	}
	
	@Test
	public void testFindRoot5thDegreeBadStartingValue() throws NoRootFoundException{
		Roots r = new Roots(new PolynomialFunction(3, 1, 1, 1, -3, 1));
		assertEquals("5th degree Root failed x^5 -3*x^4 + x^3 + x^2 + x + 3 = 0 for starting value 0", r.findRoot(0), -0.870916, 1e-5);
		assertEquals("5th degree Root failed x^5 -3*x^4 + x^3 + x^2 + x + 3 = 0 for starting value 2.5", r.findRoot(2.5), -0.870916, 1e-5);
	}

}
