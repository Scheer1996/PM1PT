/*
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 23.04.2016 
 * Aufgabe: Aufgabenblatt 4 - Aufgabe 2
 */

package aufgabenblatt04;

/**
 * This class represents a car race
 */
public class Race {

	/**
	 * used to keep track of how many cars are currently in the race
	 */
	private int carCount;

	/**
	 * stores the cars that are in the race
	 */
	private Racecar[] cars;

	/**
	 * stores the length of the racetrack
	 */
	private final double trackLength;

	/**
	 * Instantiates a new Race with 0 cars and the specified track length
	 * 
	 * @param trackLength
	 *            specifies how long the race track is going to be
	 */
	public Race(double trackLength) {
		this.trackLength = trackLength;
		carCount = 0;
		cars = new Racecar[1];
	}

	/**
	 * Adds a new car to the race
	 * 
	 * @param racecar
	 *            the Racecar to be added
	 */
	public void addRacecar(Racecar racecar) {
		// do we need to expand the array?
		if (carCount == cars.length) {
			// create new array
			Racecar[] temp = new Racecar[cars.length * 2];

			// copy references from old array to the new one
			System.arraycopy(cars, 0, temp, 0, cars.length);

			// make cars point to new array
			cars = temp;
		}

		// add the new car
		cars[carCount] = racecar;
		carCount++;
	}

	/**
	 * Determines which car has completed the entire track.<br>
	 * If no car has completed the track yet, <i>null</i> is returned.
	 * 
	 * @return the car that won or <i>null</i> if no car has won
	 */
	public Racecar getWinner() {
		// go through the cars and find the first one that completetd the track
		for (int i = 0; i < carCount; i++) {
			if (cars[i].getDistanceTraveled() >= trackLength) {
				// this car has won
				return cars[i];
			}
		}

		// if we end up here, then no car has won
		return null;
	}

	/**
	 * Makes all cars move forward by one time step
	 */
	private void step() {
		for (int i = 0; i < carCount; i++) {
			cars[i].drive();
		}
	}

	/**
	 * Performs the race by making all cars drive until one has completed the
	 * entire track
	 */
	public void perform() {
		// continue stepping as long as there is no winner
		do {
			step();
		} while (getWinner() == null);

		System.out.println(getWinner().getDriverName() + " has won the race");
	}

	public static void main(String[] args) {
		Race race = new Race(3000);
		race.addRacecar(new Racecar("Moritz", "Ford Fiesta", 140));
		race.addRacecar(new Racecar("Gitta", "Renault Clio", 160));
		race.addRacecar(new Racecar("Jochen", "Renault CLio", 150));

		race.perform();

	}

}
