package aufgabenblatt02;

import java.util.Scanner;

public class Satelitenzeit {

	public static void main(String[] args) {
		//Variablen
		int tage, stunden, minuten, sekunden;
		int satelitenzeit;

		//Eingabe holen
		Scanner scanner = new Scanner(System.in);

		System.out.print("Bitte eine Sekundenanzahl eingeben: ");
		satelitenzeit = scanner.nextInt();

		//Ausrechnen
		tage = satelitenzeit / (24 * 60 * 60);
		satelitenzeit %= (24 * 60 * 60);

		stunden = satelitenzeit / (60 * 60);
		satelitenzeit %= (60 * 60);

		minuten = satelitenzeit / 60;

		sekunden = satelitenzeit % 60;

		//Ausgabe
		System.out.format("%d Tage %d:%d:%d\n", tage, stunden, minuten, sekunden);


		//Aufräumen
		scanner.close();

	}

}
