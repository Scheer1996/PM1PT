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
 * Representation of a BettingOffice for betting on a Race
 */
public class BettingOffice {

	/**
	 * keeps track of how many Bets were placed
	 */
	private int betCount;

	/**
	 * stores the bets
	 */
	private Bet[] bets;

	/**
	 * the multiplication factor you get when you win
	 */
	private final double quote;

	/**
	 * reference to the Race the bets are about
	 */
	private Race race;

	/**
	 * Creates a new BettingOffice
	 * 
	 * @param race
	 *            the race which all the bets are placed on
	 * @param quote
	 *            the winning quote
	 */
	public BettingOffice(Race race, double quote) {
		this.race = race;
		this.quote = quote;
		bets = new Bet[1];
	}

	/**
	 * Accepts a new bet for the race
	 * 
	 * @param driverName the name of the driver the bet is placed on
	 * @param betAmount the amount of money placed
	 * @param playerName name of the person betting
	 */
	public void placeBet(String driverName, double betAmount, String playerName) {
		// do we need to expand the array?
		if (betCount == bets.length) {
			// create new array
			Bet[] temp = new Bet[bets.length * 2];

			// copy references from old array to the new one
			System.arraycopy(bets, 0, temp, 0, bets.length);

			// make bets point to new array
			bets = temp;
		}

		// create and add the new bet
		bets[betCount] = new Bet(driverName, betAmount, playerName);
		betCount++;
	}
	
	/**
	 * Evaluates the race
	 */
	public void evaluate(){
		//perform the race
		race.perform();
		
		//check who won
		String winner = race.getWinner().getDriverName();
		
		//go through the bets and check whether anyone has won
		for(int i = 0; i < betCount; i++){
			Bet b = bets[i];
			if(winner.equals(b.getDriverName())){
				System.out.format("%s has won %.2f€\n", b.getPlayerName(), b.getBetAmount() * quote);
			}
		}
	}
	
	public static void main(String[] args){
		Race race = new Race(3000);
		race.addRacecar(new Racecar("Moritz", "Ford Fiesta", 140));
		race.addRacecar(new Racecar("Gitta", "Renault Clio", 160));
		race.addRacecar(new Racecar("Jochen", "Renault CLio", 150));
		
		BettingOffice bo = new BettingOffice(race, 1.73);
		bo.placeBet("Moritz", 100, "SniperDude136");
		bo.placeBet("Jochen", 150, "PrincessPeach");
		bo.placeBet("Gitta", 283, "Steve");
		
		bo.evaluate();
	}
}
