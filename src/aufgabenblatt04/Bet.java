/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 23.04.2016 
 * Aufgabe: Aufgabenblatt 4 - Aufgabe 3
 */

package aufgabenblatt04;

/**
 * This class represents a bet on the outcome of a race
 */
public class Bet {
	
	/**
	 * stores which Driver the bet is on
	 */
	private final String driverName;
	
	/**
	 * stores the name of the person betting
	 */
	private final String playerName;
	
	/**
	 * stores the amount of money that was placed
	 */
	private final double betAmount;

	/**
	 * Creates a new bet
	 * 
	 * @param driverName name of the driver the bet is placed on
	 * @param betAmount amount of money placed
	 * @param playerName name of the player placing the bet
	 */
	public Bet(String driverName, double betAmount, String playerName){
		this.driverName = driverName;
		this.betAmount = betAmount;
		this.playerName = playerName;
	}
	
	public String getDriverName() {
		return driverName;
	}

	public String getPlayerName() {
		return playerName;
	}


	public double getBetAmount() {
		return betAmount;
	}
}
