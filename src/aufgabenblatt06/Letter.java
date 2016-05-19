/*
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 19.05.2016 
 * Aufgabe: Aufgabenblatt 6 - Aufgabe 1
 */

package aufgabenblatt06;

/**
 * Represents a Letter as a subclass of Shipment
 * 
 * @author Moritz Höwer
 */
public class Letter extends Shipment {

	/**
	 * does this Letter require to be signed when its delivered?
	 */
	private final boolean isRegisteredLetter;

	/**
	 * has the Letter been delivered?
	 */
	private boolean isDelivered;

	/**
	 * Constructs a new Letter
	 * 
	 * @param sender
	 *            the Person that sent this Shipment
	 * @param receiver
	 *            the Person to receive this Shipment
	 * @param startTime
	 *            the start time
	 * @param transportDuration
	 *            the (estimated) duration of this transport
	 * @param isRegisteredLetter
	 *            is this a registered Letter or a normal one?
	 */
	public Letter(Person sender, Person receiver, int startTime,
			int transportDuration, boolean isRegisteredLetter) {
		super(sender, receiver, startTime, transportDuration);
		this.isRegisteredLetter = isRegisteredLetter;
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

	// Getter
	public boolean isRegisteredLetter() {
		return isRegisteredLetter;
	}

	@Override
	public String toString() {
		return "Letter [isRegisteredLetter=" + isRegisteredLetter
				+ ", isDelivered=" + isDelivered + ", shipmentID=" + shipmentID
				+ ", sender=" + sender + ", receiver=" + receiver
				+ ", startTime=" + startTime + " min, transportDuration="
				+ transportDuration + " min]";
	}

}
