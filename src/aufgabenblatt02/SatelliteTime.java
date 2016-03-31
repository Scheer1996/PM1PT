package aufgabenblatt02;

import java.util.Scanner;

public class SatelliteTime {

	public static void main(String[] args)
	{
		//vars
		int tage, stunden, minuten, sekunden;
		int satelliteTime;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Bitte Satellitenzeit eingeben in Sekunden eingeben: ");
		satelliteTime = scanner.nextInt();
		scanner.close();
		
		// Berechnung
		tage = satelliteTime / (24 * 60 * 60);
		satelliteTime %= (24 * 60 * 60);
		
		stunden = satelliteTime / (60 * 60);
		satelliteTime %= (60 * 60);
		
		minuten = satelliteTime / 60;
		sekunden = satelliteTime % 60;
		
		
		// Ausgabe
		String tageString = (tage == 1) ? "Tag" : "Tage";
		System.out.format("%d %s %02d:%02d:%02d", tage, tageString, stunden, minuten, sekunden);
		
	}

}
