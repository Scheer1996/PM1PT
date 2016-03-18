package aufgabenblatt02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SatelliteTime {

	public static void main(String[] args)
	{
		//vars
		int tage, stunden, minuten, sekunden;
		int eingabeZeit;
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.print("Bitte Satellitenzeit eingeben: ");
			eingabeZeit = scanner.nextInt();
			
			tage = eingabeZeit / (86400);
			eingabeZeit %= (86400);
			
			stunden = eingabeZeit / (3600);
			eingabeZeit %= (3600);
			
			minuten = eingabeZeit / (60);
			sekunden = eingabeZeit % (60);
			
			System.out.format("%d Tage %d:%d:%d", tage, stunden, minuten, sekunden);
			
			
		} catch(InputMismatchException e) {
			System.err.println("Bitte eine Zahl eingeben");
		} finally {
			scanner.close();
		}
		
	}

}
