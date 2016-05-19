/*
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 06.05.2016 
 * Aufgabe: Aufgabenblatt 5 - Aufgabe 2
 */

package aufgabenblatt05;

/**
 * Quite a dumb abstraction for a locomotive that can't actually do anything
 * 
 * @author Moritz Höwer
 */
public class Locomotive {

	/**
	 * object counter for ensuring unique serial numbers
	 */
	private static int objectCounter = 1;

	/**
	 * the type of Locomotive (an arbitrary number)
	 */
	private final int type;

	/**
	 * the unique serial number of the Locomotive
	 */
	private final int serialNumber;

	/**
	 * the length of the Locomotive in meters
	 */
	private final int length;

	/**
	 * reference to the first wagon behind the Locomotive
	 */
	private Wagon firstWagon;

	/**
	 * Constructs a new Locomotive
	 * 
	 * @param type
	 *            arbitrary number representing the type
	 * @param length
	 *            length of the Locomotive
	 */
	public Locomotive(int type, int length) {
		this.length = length;
		this.type = type;
		this.firstWagon = null;

		serialNumber = objectCounter;
		objectCounter++;
	}

	@Override
	public String toString() {
		return String.format("----------------\n"
				+ "Locomotive #%d\n"
				+ "Type: %d\n"
				+ "Length: %dm\n",
				serialNumber, type, length);
	}

	// Getters
	public int getType() {
		return type;
	}

	public int getLength() {
		return length;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public Wagon getFirstWagon() {
		return firstWagon;

	}

	// Setter
	public void setFirstWagon(Wagon w) {
		firstWagon = w;
	}
}
