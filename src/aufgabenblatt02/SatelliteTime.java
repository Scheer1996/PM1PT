/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Aufgabe: Aufgabenblatt 2 - Aufgabe 1
 */

package aufgabenblatt02;

import java.util.Scanner;

/**
 * converts SatteliteTime in days, hours, minutes and seconds
 */
public class SatelliteTime {

	public static void main(String[] args)
	{
		//vars
		final int HOURS_PER_DAY = 24,
				MINUTES_PER_HOUR = 60,
				SECONDS_PER_MINUTE = 60;
				
		int days, hours, minutes, seconds;
		int satelliteTime;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Bitte Satellitenzeit in Sekunden eingeben: ");
		satelliteTime = scanner.nextInt();
		scanner.close();
		
		// calculation
		days = satelliteTime / (HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE);
		satelliteTime %= (HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE);
		
		hours = satelliteTime / (MINUTES_PER_HOUR * SECONDS_PER_MINUTE);
		satelliteTime %= (MINUTES_PER_HOUR * SECONDS_PER_MINUTE);
		
		minutes = satelliteTime / SECONDS_PER_MINUTE;
		seconds = satelliteTime % SECONDS_PER_MINUTE;
		
		
		// output
		String daysString = (days == 1) ? "Tag" : "Tage";
		System.out.format("%d %s %02d:%02d:%02d", days, daysString, hours, minutes, seconds);
		
	}

}
