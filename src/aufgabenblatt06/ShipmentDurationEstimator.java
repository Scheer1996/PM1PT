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
 * Interface for estimating how long the transport of a Shipment will take
 * 
 * @author Moritz Höwer
 */
public interface ShipmentDurationEstimator {

	/**
	 * estimates the duration of the transport of a Shipment from one City to
	 * another
	 * 
	 * @param origin
	 *            City where the transport will start
	 * @param destination
	 *            City where the transport will end
	 * @return time in minutes
	 */
	public int getShipmentTransportDuration(City origin, City destination);
}
