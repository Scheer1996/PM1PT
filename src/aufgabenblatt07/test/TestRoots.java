package aufgabenblatt07.test;

import aufgabenblatt07.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestRoots {

	@Test
	public void testFindRootNoRoot() throws NoRootFoundException {
		Roots r = new Roots(new PolynomialFunction());
		assertEquals("No root failed to return 0", 0, r.findRoot(0), 0);
	}

	@Test
	public void testFindRootLinearGoodStartingValue()
			throws NoRootFoundException {
		Roots r = new Roots(new PolynomialFunction(1, 2));
		assertEquals("Linear Root failed 2x + 1 = 0 for starting value 0", -0.5,
				r.findRoot(0), 1e-5);

		r = new Roots(new PolynomialFunction(2, -1));
		assertEquals("Linear Root failed -x + 2 = 0 for starting value 0", 2,
				r.findRoot(0), 1e-5);
	}

	@Test
	public void testFindRootQuadraticGoodStartingValue()
			throws NoRootFoundException {
		Roots r = new Roots(new PolynomialFunction(1, 2, -1));
		assertEquals(
				"Quadratic Root 1 failed -x² + 2x + 1 = 0 for starting value 0",
				-0.41421, r.findRoot(0), 1e-5);
		assertEquals(
				"Quadratic Root 1 failed -x² + 2x + 1 = 0 for starting value -5",
				-0.41421, r.findRoot(-5), 1e-5);
		assertEquals(
				"Quadratic Root 2 failed -x² + 2x + 1 = 0 for starting value 1.5",
				2.41421, r.findRoot(1.5), 1e-5);
		assertEquals(
				"Quadratic Root 2 failed -x² + 2x + 1 = 0 for starting value 8",
				2.41421, r.findRoot(8), 1e-5);

	}

	@Test
	public void testFindRootExceptions() {
		Roots r = new Roots(new PolynomialFunction(1, 0, 1));
		try {
			r.findRoot(0);
			fail("Failed to throw NoRootFoundException");
		} catch (NoRootFoundException ex) {
			assertEquals("Message is not Divide by 0",
					NoRootFoundExceptionCause.DIVIDE_BY_ZERO.getMessage(),
					ex.getMessage());
		}

		r = new Roots(new PolynomialFunction(1, 2, 3));
		try {
			r.findRoot(0);
			fail("Failed to throw NoRootFoundException");
		} catch (NoRootFoundException ex) {
			assertEquals("Message is not No Convergence",
					NoRootFoundExceptionCause.NO_CONVERGENCE.getMessage(),
					ex.getMessage());
		}
	}

	@Test
	public void testFindRoot5thDegreeGoodStartingValue()
			throws NoRootFoundException {
		Roots r = new Roots(new PolynomialFunction(1, 1, 1, 1, 1, 1));
		assertEquals(
				"5th degree Root failed x^5 + x^4 + x^3 + x^2 + x + 1 = 0 for starting value 0",
				-1, r.findRoot(0), 1e-5);
		assertEquals(
				"5th degree Root failed x^5 + x^4 + x^3 + x^2 + x + 1 = 0 for starting value -15",
				-1, r.findRoot(-15), 1e-5);
		assertEquals(
				"5th degree Root failed x^5 + x^4 + x^3 + x^2 + x + 1 = 0 for starting value 30",
				-1, r.findRoot(30), 1e-5);
	}

	@Test
	public void testFindRoot5thDegreeBadStartingValue()
			throws NoRootFoundException {
		Roots r = new Roots(new PolynomialFunction(3, 1, 1, 1, -3, 1));
		assertEquals(
				"5th degree Root failed x^5 -3*x^4 + x^3 + x^2 + x + 3 = 0 for starting value 0",
				-0.870916, r.findRoot(0), 1e-5);
		assertEquals(
				"5th degree Root failed x^5 -3*x^4 + x^3 + x^2 + x + 3 = 0 for starting value 2.5",
				-0.870916, r.findRoot(2.5), 1e-5);
	}

	@Test
	public void testFindRandomRoots() {
		Roots r;
		List<Double> list;
		
		r = new Roots(new PolynomialFunction(1, 5, 7, 6, 2, -1));
		list = r.findRootsRandomised(-50, 50, 100);
		assertEquals("Didn't find the correct number of roots", 3, list.size());
		
		r = new Roots(new PolynomialFunction(0, 0, 2));
		list = r.findRootsRandomised(-50, 50, 100);
		assertEquals("Didn't find the correct number of roots", 1, list.size());
		
		r = new Roots(new PolynomialFunction(1, 0, 1));
		list = r.findRootsRandomised(-50, 50, 100);
		assertEquals("Didn't find the correct number of roots", 0, list.size());
		
		r = new Roots(new PolynomialFunction(-1, 0, 1));
		list = r.findRootsRandomised(-50, 50, 100);
		assertEquals("Didn't find the correct number of roots", 2, list.size());
	}

}
