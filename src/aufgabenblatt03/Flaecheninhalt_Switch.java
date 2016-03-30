package aufgabenblatt03;

import java.util.Scanner;

public class Flaecheninhalt_Switch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//Eingaben holen
		System.out.println("Was möchten Sie berechnen?");
		System.out.println("[1] für Kreis");
		System.out.println("[2] für Quadrat");
		System.out.println("[3] für Sechseck");
		System.out.print("Bitte geben Sie Ihre Wahl ein: ");

		int index = scanner.nextInt();
		
		//Formel gemäß dem Index auswählen
		double x, flaeche;
		
		switch(index){
		case 1: //Kreis
			System.out.print("Bitte geben Sie den Radius an: ");
			x = scanner.nextDouble();
			
			//Berechnen:
			flaeche = Math.PI * x * x;
			
			//Ausgabe
			System.out.format("Die Fläche beträgt etwa %.2f\n", flaeche);			
			break;
			
		case 2: //Quadrat
			System.out.print("Bitte geben Sie die Seitenlänge an: ");
			x = scanner.nextDouble();
			
			//Berechnen:
			flaeche = x * x;
			
			//Ausgabe
			System.out.format("Die Fläche beträgt etwa %.2f\n", flaeche);			
			break;
			
		case 3: //Sechseck
			System.out.print("Bitte geben Sie die Kantenlänge an: ");
			x = scanner.nextDouble();
			
			//Berechnen:
			flaeche = x * x * 3 / 2 * Math.sqrt(3);
			
			//Ausgabe
			System.out.format("Die Fläche beträgt etwa %.2f\n", flaeche);			
			break;
			
		default: //Fehler
			System.out.print("Ihre Eingabe konnte nicht erkannt werden...");
		}
		
		//Aufräumen
		scanner.close();

	}

}
