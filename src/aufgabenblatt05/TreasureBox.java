/*
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 06.05.2016 
 * Aufgabe: Aufgabenblatt 5 - Aufgabe 1
 */

package aufgabenblatt05;

import java.util.Arrays;

/**
 * Provides a model for a Box where you store your gems
 * 
 * @author Moritz Höwer
 */
public class TreasureBox {

	/**
	 * Enum for the different types of Gems
	 */
	public enum Gem {
		DIAMOND, RUBY, SMARAGD
	}

	/**
	 * stores the amount of gems by ordinal number in the Gem-enum
	 */
	private int[] gemCounts;

	/**
	 * Constructor for TreasureBox which takes variable amount of Gems.
	 * 
	 * @param gems
	 *            variable number of Gems to put in
	 */
	public TreasureBox(Gem... gems) {
		// create array to store the Gems
		gemCounts = new int[Gem.values().length];

		// go through the Gems and put them into the array
		for (Gem gem : gems) {
			gemCounts[gem.ordinal()]++;
		}
	}

	/**
	 * returns the number of Gems of the kind <i>type</i> currently stored in
	 * this box
	 * 
	 * @param type
	 *            type of Gem to check for
	 * @return number of Gems of that kind stored in this box
	 */
	public int getGemCount(Gem type) {
		return gemCounts[type.ordinal()];
	}

	/**
	 * creates a representation of this TreasureBox as a String
	 */
	@Override
	public String toString() {
		String contents = "(";
		for (Gem gem : Gem.values()) {
			// get count of curent Gem
			int count = gemCounts[gem.ordinal()];

			// get first character of Gem name and use it as symbol
			char symbol = gem.toString().charAt(0);

			// create char array that contains a symbol for each gem
			char[] cArr = new char[count];
			Arrays.fill(cArr, symbol);

			// append to output string
			contents += new String(cArr);
		}
		contents += ")";
		return contents;
	}

	/**
	 * prints out this object on the console
	 */
	public void print() {
		System.out.println(toString());
	}

	/**
	 * stores a number of Gems in the box
	 * 
	 * <i>count</i> should be a positive number, otherwise an
	 * IllegalArgumentException is thrown
	 * 
	 * @param type
	 *            the type of Gem
	 * @param count
	 *            the number of Gems to be stored
	 * 
	 * @return <b>this</b> (for chaining)
	 */
	public TreasureBox putIn(Gem type, int count) {
		// handle negative counts
		if (count < 0) {
			throw new IllegalArgumentException(
					"Cannot put in a negative number of gems!");
		}

		// add Gems to box
		gemCounts[type.ordinal()] += count;

		return this;
	}

	/**
	 * takes out a number of Gems from the box
	 * 
	 * <i>count</i> should be a positive number, otherwise an
	 * IllegalArgumentException is thrown. Ideally, <i>count</i> should be less
	 * than or equal to the number of Gems of that type currently stored.
	 * 
	 * @param type
	 *            the type of Gem
	 * @param count
	 *            the number of Gems to be taken out
	 * 
	 * @return <b>this</b> (for chaining)
	 */
	public TreasureBox takeOut(Gem type, int count) {
		// handle negative counts
		if (count < 0) {
			throw new IllegalArgumentException(
					"Cannot take out a negative number of gems!");
		}

		// check if we have enough Gems in the box
		if (count > getGemCount(type)) {
			count = getGemCount(type);
		}

		// remove Gems from box
		gemCounts[type.ordinal()] -= count;

		return this;
	}

	/**
	 * converts Gems of type fromType to gems of type toType
	 * 
	 * @param fromType
	 *            origin type
	 * @param toType
	 *            target type
	 * 
	 * @return <b>this</b> (for chaining)
	 */
	public TreasureBox transform(Gem fromType, Gem toType) {
		// get the number of Gems of type fromType that are currently stored
		int fromTypeCount = getGemCount(fromType);

		// "move" Gems
		takeOut(fromType, fromTypeCount);
		putIn(toType, fromTypeCount);

		return this;
	}

	/**
	 * empties the TreasureBox
	 * 
	 * @return <b>this</b> (for chaining)
	 */
	public TreasureBox empty() {
		// override storage with new empty array
		gemCounts = new int[Gem.values().length];

		return this;
	}

	/**
	 * Entry point for the program
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		TreasureBox box = new TreasureBox(Gem.DIAMOND, Gem.DIAMOND);
		box.putIn(Gem.SMARAGD, 5).takeOut(Gem.DIAMOND, 1)
				.transform(Gem.SMARAGD, Gem.RUBY).putIn(Gem.SMARAGD, 2);
		box.print();
	}

}
