/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Aufgabe: Aufgabenblatt 3 - Aufgabe 3
 */

package aufgabenblatt03;

/**
 * Calculations with a temperature-array
 */
public class Array {

	public static void main(String[] args) {
		final int[][] TEMPERATURE_DATA = { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 },
				{ 12, 14, 9, 12, 15, 16, 15, 15, 11, 8, 13, 13, 15, 12 } };

		// mean temperature
		int totalTemp = 0;
		int i;

		// Min/Max
		int minTemp = Integer.MAX_VALUE;
		int maxTemp = Integer.MIN_VALUE;

		// temperature difference
		int tempDiffMax = 0;
		String differenceDaysString = "";

		for (i = 0; i < TEMPERATURE_DATA[1].length; i++) {
			int temp = TEMPERATURE_DATA[1][i];

			// add up temps
			totalTemp += temp;

			// update max/min temp
			minTemp = Math.min(minTemp, temp);
			maxTemp = Math.max(maxTemp, temp);

			// difference between days
			if (i >= 1) { // start at day 2

				// difference
				int tempDifferenz = Math.abs(temp - TEMPERATURE_DATA[1][i - 1]);

				// Bigger Change? -> generate new String
				if (tempDifferenz > tempDiffMax) {
					tempDiffMax = tempDifferenz;
					differenceDaysString = "vom " + TEMPERATURE_DATA[0][i - 1] + ". zum " + TEMPERATURE_DATA[0][i]
							+ ". Tag";

				}
				// Change was equal -> append to String
				else if (tempDifferenz == tempDiffMax) {
					differenceDaysString += " und vom " + TEMPERATURE_DATA[0][i - 1] + ". zum " + TEMPERATURE_DATA[0][i]
							+ ". Tag";
				}
			}
		}

		//calculate mean value form sum and count (loop counter is used for count)
		double durchschnitt = (double) totalTemp / i;

		System.out.format("Die Temperatur beträgt im durchschnitt %.2f°.\n", durchschnitt);
		System.out.format("Die Höchsttemperatur war %d° und die Niedrigste %d°.\n", maxTemp, minTemp);
		System.out.format("Den höchsten Temperaturumschwung von %d° gab es %s.\n", tempDiffMax,
				differenceDaysString);

		// Table
		// Days
		System.out.println();
		System.out.print("Tag:        |");
		for (i = 0; i < TEMPERATURE_DATA[0].length; i++) {
			System.out.format(" %3d  |", TEMPERATURE_DATA[0][i]);
		}

		// Separator
		System.out.println();
		System.out.print("------------|");
		for (i = 0; i < TEMPERATURE_DATA[0].length; i++) {
			System.out.print("------|");
		}

		// Temperature
		System.out.println();
		System.out.print("Temperatur: |");
		for (i = 0; i < TEMPERATURE_DATA[1].length; i++) {
			System.out.format(" %3d° |", TEMPERATURE_DATA[1][i]);
		}

	}

}
