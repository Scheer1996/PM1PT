package aufgabenblatt02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SatelliteTime {

	public static void main(String[] args)
	{
		//vars
		int tage, stunden, minuten, sekunden;
		int satelliteTime;
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.print("Bitte Satellitenzeit eingeben: ");
			satelliteTime = scanner.nextInt();
			
			// Berechnung
			tage = satelliteTime / (86400);
			satelliteTime %= (86400);
			
			stunden = satelliteTime / (3600);
			satelliteTime %= (3600);
			
			minuten = satelliteTime / (60);
			sekunden = satelliteTime % (60);
			
			
			// Ausgabe
			System.out.format("%d Tage %d:%d:%d", tage, stunden, minuten, sekunden);
			
			
		} catch(InputMismatchException e) {
			System.err.println("Bitte eine Zahl eingeben");
		} finally {
			scanner.close();
		}
		
	}

}
