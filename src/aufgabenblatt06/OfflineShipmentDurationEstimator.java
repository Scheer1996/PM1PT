/*
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 19.05.2016 
 * Aufgabe: Aufgabenblatt 6 - Aufgabe 3
 */

package aufgabenblatt06;

import java.util.Hashtable;

/**
 * Offline version of the {@link GoogleShipmentDurationEstimator} with cached
 * durations for all City pairs.
 * 
 * @author Moritz Höwer
 */
public class OfflineShipmentDurationEstimator
		implements
			ShipmentDurationEstimator {

	/**
	 * Stores the durations for each City pair
	 * 
	 * <b>Key:</b> String containing a concatenation of City1 and City2 where City1
	 * comes first in the alphabet 
	 * 
	 * <b>Value:</b> the duration in minutes.
	 */
	private Hashtable<String, Integer> cache;
	
	/**
	 * Initializes the OfflineShipmentDurationEstimator
	 */
	public OfflineShipmentDurationEstimator() {
		cache = new Hashtable<>();
		
		//Initialize cache based on output from printMatrixOnScreen();		
		cache.put("BERLINHAMBURG", 172);
		cache.put("BERLINMUNICH", 320);
		cache.put("BERLINCOLOGNE", 333);
		cache.put("BERLINFRANKFURT", 310);
		cache.put("BERLINSTUTTGART", 354);
		cache.put("BERLINDUESSELDORF", 324);
		cache.put("BERLINDORTMUND", 283);
		cache.put("BERLINESSEN", 305);
		cache.put("BERLINBREMEN", 226);
		cache.put("HAMBURGMUNICH", 422);
		cache.put("COLOGNEHAMBURG", 249);
		cache.put("FRANKFURTHAMBURG", 283);
		cache.put("HAMBURGSTUTTGART", 376);
		cache.put("DUESSELDORFHAMBURG", 236);
		cache.put("DORTMUNDHAMBURG", 202);
		cache.put("ESSENHAMBURG", 217);
		cache.put("BREMENHAMBURG", 79);
		cache.put("COLOGNEMUNICH", 323);
		cache.put("FRANKFURTMUNICH", 230);
		cache.put("MUNICHSTUTTGART", 141);
		cache.put("DUESSELDORFMUNICH", 351);
		cache.put("DORTMUNDMUNICH", 345);
		cache.put("ESSENMUNICH", 362);
		cache.put("BREMENMUNICH", 407);
		cache.put("COLOGNEFRANKFURT", 118);
		cache.put("COLOGNESTUTTGART", 214);
		cache.put("COLOGNEDUESSELDORF", 42);
		cache.put("COLOGNEDORTMUND", 70);
		cache.put("COLOGNEESSEN", 62);
		cache.put("BREMENCOLOGNE", 193);
		cache.put("FRANKFURTSTUTTGART", 130);
		cache.put("DUESSELDORFFRANKFURT", 146);
		cache.put("DORTMUNDFRANKFURT", 142);
		cache.put("ESSENFRANKFURT", 157);
		cache.put("BREMENFRANKFURT", 264);
		cache.put("DUESSELDORFSTUTTGART", 241);
		cache.put("DORTMUNDSTUTTGART", 246);
		cache.put("ESSENSTUTTGART", 253);
		cache.put("BREMENSTUTTGART", 361);
		cache.put("DORTMUNDDUESSELDORF", 55);
		cache.put("DUESSELDORFESSEN", 35);
		cache.put("BREMENDUESSELDORF", 177);
		cache.put("DORTMUNDESSEN", 31);
		cache.put("BREMENDORTMUND", 144);
		cache.put("BREMENESSEN", 158);
	}
	
	/**
	 * Prints cache.put() instructions for all City pairs based on the real {@link GoogleShipmentDurationEstimator}
	 * 
	 * @param ge the {@link GoogleShipmentDurationEstimator} to be used
	 */
	public void printMatrixOnScreen(GoogleShipmentDurationEstimator ge){
		City[] cities1 = new City[City.values().length - 1];
		City[] cities2 = new City[City.values().length - 1];
		
		//Copy all Cities except for the last one into c1
		System.arraycopy(City.values(), 0, cities1, 0, City.values().length - 1); 
		
		//Copy all Cities except for the first one into c2
		System.arraycopy(City.values(), 1, cities2, 0, City.values().length - 1);
		
		//Go through all pairs
		for(int i = 0; i < cities1.length; i++){
			City c1 = cities1[i];
			
			for(int j = i; j < cities2.length; j++){
				City c2 = cities2[j];
				
				//Put cities in alphabetical order
				City firstInAlphabet;
				City lastInAlphabet;
				if(c1.toString().compareTo(c2.toString()) < 0){
					firstInAlphabet = c1;
					lastInAlphabet = c2;
				} else{
					firstInAlphabet = c2;
					lastInAlphabet = c1;
				}
				
				//Get duration from Google
				int duration = ge.getShipmentTransportDuration(firstInAlphabet, lastInAlphabet);
				
				//create cache.put() instruction
				System.out.println("\tcache.put(\"" + firstInAlphabet + lastInAlphabet + "\", " + duration + ");");				
			}
		}
	}
	
	@Override
	public int getShipmentTransportDuration(City origin, City destination) {
		if(origin == destination){
			return 0;
		}
		
		//Put cities in alphabetical order
		City firstInAlphabet;
		City lastInAlphabet;
		if(origin.toString().compareTo(destination.toString()) < 0){
			firstInAlphabet = origin;
			lastInAlphabet = destination;
		} else{
			firstInAlphabet = destination;
			lastInAlphabet = origin;
		}
		
		//retrive duration from cache
		return cache.get(firstInAlphabet.toString() + lastInAlphabet.toString());
	}

}
