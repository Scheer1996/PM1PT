/*
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 19.05.2016 
 * Aufgabe: Aufgabenblatt 6 - Aufgabe 4
 */

package aufgabenblatt06;

import static aufgabenblatt06.City.*;

/**
 * 
 *  
 * @author Moritz Höwer
 */
public class LogisticsSimulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoogleShipmentDurationEstimator ge = new GoogleShipmentDurationEstimator();
		
		Address a = new Address("Berliner Tor", 5, 2099, HAMBURG);
		Person p = new Person(a);
		
		Letter l = new Letter(p, p, 0, 200, false);
		Package pa = new Package(p, p, 0, 300, 20);

		OfflineShipmentDurationEstimator oe = new OfflineShipmentDurationEstimator();
		//oe.printMatrixOnScreen(ge);
		
		System.out.println(ge.getShipmentTransportDuration(HAMBURG, HAMBURG));
		System.out.println(oe.getShipmentTransportDuration(HAMBURG, HAMBURG));
		
		System.out.println(ge.getShipmentTransportDuration(HAMBURG, MUNICH));
		System.out.println(oe.getShipmentTransportDuration(MUNICH, HAMBURG));
		
		/*System.out.println(l);
		System.out.println(pa);*/
	
	}

}
