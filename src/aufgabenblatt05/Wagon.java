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
 * Quite a dumb abstraction for a Wagon that doesn't really do anything
 * 
 *@author Moritz Höwer
 */
public class Wagon {
	
	/**
	 * create a random 4 digit Integer based on System.currentTimeMillis()
	 */
	private static int currentSerial = (int)(System.currentTimeMillis() - System.currentTimeMillis() / 10000 * 10000);
	
	/**
	 * the passenger capacity of the Wagon
	 */
	private final int capacity;

	/**
	 * the unique serial number of the Wagon
	 */
	private final int serialNumber;

	/**
	 * the length of the Wagon in meters
	 */
	private final int length;

	/**
	 * reference to the next wagon behind the Wagon
	 */
	private Wagon nextWagon;

	/**
	 * Constructs a new Wagon
	 * 
	 * @param capacity
	 *            specifies the passenger capacity of the Wagon
	 * @param length
	 *            length of the Locomotive
	 */
	public Wagon(int capacity, int length) {
		this.length = length;
		this.capacity = capacity;
		this.nextWagon = null;

		serialNumber = currentSerial;
		currentSerial++;
	}

	@Override
	public String toString() {
		return String.format("----------------\n"
				+ "Wagon #%d\n"
				+ "Capacity: %d pax\n"
				+ "Length: %dm\n",
				serialNumber, capacity, length);
	}

	// Getters
	public int getCapacity() {
		return capacity;
	}

	public int getLength() {
		return length;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public Wagon getNextWagon() {
		return nextWagon;

	}

	// Setter
	public void setNextWagon(Wagon w) {
		nextWagon = w;
	}
}
