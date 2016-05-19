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
 * Representation of a train built from Locomotives and Wagons
 * 
 * @author Moritz Höwer
 */
public class Train {

	/**
	 * reference to the Locomotive pulling this Train
	 */
	private Locomotive loco;

	public Train(Locomotive locomotive) {
		loco = locomotive;
	}

	/**
	 * returns the last Wagon in this Train or null, if there is no Wagon
	 * 
	 * @return the last Wagon in the Train or null
	 */
	private Wagon getLastWagon() {
		Wagon wagon = loco.getFirstWagon();
		if (wagon != null) {
			while (wagon.getNextWagon() != null) {
				wagon = wagon.getNextWagon();
			}
		}
		return wagon;

	}

	/**
	 * appends a Wagon to the Train
	 * 
	 * @param wagon
	 *            the Wagon to append.
	 */
	public void addWagon(Wagon wagon) {
		Wagon last = getLastWagon();

		// Is there a Wagon or is the Train empty?
		if (last == null) {
			loco.setFirstWagon(wagon);
		} else {
			last.setNextWagon(wagon);
		}
	}

	/**
	 * removes and returns the first Wagon from the train, moving all following Wagons
	 * forward
	 * 
	 * @return the Wagon that was removed
	 */
	public Wagon removeFirstWagon() {
		// Is there a Wagon?
		if (loco.getFirstWagon() == null) {
			return null;
		} else {
			Wagon first = loco.getFirstWagon();

			// move Locomotives pointer to the next Wagon in line
			loco.setFirstWagon(first.getNextWagon());

			// break the joint to the next Wagon
			first.setNextWagon(null);

			return first;
		}
	}

	/**
	 * removes all Wagons from the other Train and appends them to this Train
	 * 
	 * @param train
	 *            the Train to append
	 */
	public void appendTrain(Train train) {
		// make my last Wagon point to the first Wagon in the other Train
		addWagon(train.loco.getFirstWagon());

		// disconnect the other trains Locomotive from its Wagons
		train.loco.setFirstWagon(null);
	}

	/**
	 * calculates and returns the number of Wagons in this train
	 * 
	 * @return Wagon count
	 */
	public int getWagonCount() {
		int count = 0;

		// Go through all the Wagons
		Wagon currentWagon = loco.getFirstWagon();
		while (currentWagon != null) {
			count++;
			currentWagon = currentWagon.getNextWagon();
		}

		return count;
	}

	/**
	 * calculates and returns the total passenger capacity of this train
	 * 
	 * @return total passenger capacity
	 */
	public int getPassengerCapacity() {
		int capacity = 0;

		// go through all the Wagons
		Wagon currentWagon = loco.getFirstWagon();
		while (currentWagon != null) {
			capacity += currentWagon.getCapacity();

			currentWagon = currentWagon.getNextWagon();
		}

		return capacity;
	}

	/**
	 * calculates and returns the total length of this train
	 * 
	 * @return total length
	 */
	public int getLength() {
		// initialise with length of Locomotive
		int length = loco.getLength();

		// go through all the Wagons
		Wagon currentWagon = loco.getFirstWagon();
		while (currentWagon != null) {
			length += currentWagon.getLength();

			currentWagon = currentWagon.getNextWagon();
		}

		return length;
	}

	@Override
	public String toString() {
		String details = loco.toString();

		// Go through all the Wagons
		Wagon currentWagon = loco.getFirstWagon();
		while (currentWagon != null) {
			details += currentWagon.toString();
			currentWagon = currentWagon.getNextWagon();
		}

		return String.format(
				"=== Train ===\nPassenger capacity: %dpax\nTotal length: %dm\nWagon count: %d\nTrain details:\n%s",
				getPassengerCapacity(), getLength(), getWagonCount(), details);
	}

}
