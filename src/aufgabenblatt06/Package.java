/*
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 19.05.2016 
 * Aufgabe: Aufgabenblatt 6 - Aufgabe 2
 */

package aufgabenblatt06;

/**
 * Representation of a package as a subclass of Shipment
 * 
 * @author Moritz Höwer
 */
public class Package extends Shipment {

	/**
	 * the weight of this Package in kilograms
	 */
	private final int weight;

	/**
	 * has the package been delivered yet?
	 */
	private boolean isDelivered;

	/**
	 * Constructs a new Package
	 * 
	 * @param sender
	 *            the Person that sent this Shipment
	 * @param receiver
	 *            the Person to receive this Shipment
	 * @param startTime
	 *            the start time
	 * @param transportDuration
	 *            the (estimated) duration of this transport
	 * @param weight
	 *            the weight of this package in kilograms.
	 */
	public Package(Person sender, Person receiver, int startTime,
			int transportDuration, int weight) {
		super(sender, receiver, startTime, transportDuration);

		this.weight = weight;
		isDelivered = false;
	}

	@Override
	public boolean isDelivered() {
		return isDelivered;
	}

	@Override
	public void updateTime(int currentTime) {
		// the Shipment has been delivered if more than >>transportDuration<<
		// minutes have passed
		if (!isDelivered && currentTime > startTime + transportDuration) {
			isDelivered = true;
		}

	}
	
	//Getter
	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Package [weight=" + weight + "kg, isDelivered=" + isDelivered
				+ ", shipmentID=" + shipmentID + ", sender=" + sender
				+ ", receiver=" + receiver + ", startTime=" + startTime
				+ " min, transportDuration=" + transportDuration + " min]";
	}

}
