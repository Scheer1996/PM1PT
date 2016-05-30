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
 * Abstract superclass for representing a Shipment
 * 
 * @author Moritz Höwer
 */
public abstract class Shipment {

	/**
	 * the sender of this Shipment
	 */
	protected final Person sender;

	/**
	 * the Receiver of this Shipment
	 */
	protected final Person receiver;

	/**
	 * the ID of this Shipment
	 */
	protected final int shipmentID;

	/**
	 * the start time of this Shipment
	 */
	protected final int startTime;

	/**
	 * the estimated duration for the transport of this Shipment
	 */
	protected final int transportDuration;

	/**
	 * static object counter for ensuring unique Shipment IDs
	 */
	protected static int shipmentCounter = 0;

	/**
	 * Initializes a new Shipment
	 * 
	 * @param sender
	 *            the Person that sent this Shipment
	 * @param receiver
	 *            the Person to receive this Shipment
	 * @param startTime
	 *            the start time
	 * @param transportDuration
	 *            the (estimated) duration of this transport
	 */
	public Shipment(Person sender, Person receiver, int startTime,
			int transportDuration) {
		this.sender = sender;
		this.receiver = receiver;
		this.startTime = startTime;
		this.transportDuration = transportDuration;

		shipmentID = shipmentCounter;
		shipmentCounter++;
	}

	/**
	 * Has the Shipment been delivered yet?
	 * 
	 * @return true = delivered, false = still in transport
	 */
	public abstract boolean isDelivered();

	/**
	 * updates the current time for simulation purposes
	 * 
	 * @param currentTime
	 *            the current time in the simulation
	 */
	public abstract void updateTime(int currentTime);

	// Getters
	public int getShipmentID() {
		return shipmentID;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getTransportDuration() {
		return transportDuration;
	}

	@Override
	public String toString() {
		return "Shipment [shipmentID=" + shipmentID + ", sender=" + sender
				+ ", receiver=" + receiver + ", startTime=" + startTime
				+ " min, transportDuration=" + transportDuration + " min]";
	}

}
