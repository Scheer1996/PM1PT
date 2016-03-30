package aufgabenblatt03;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		//Variablen
		int f0 = 0;
		int f1 = 1;
		int fn = -1;
		
		Scanner scanner = new Scanner(System.in);
		
		//Eingabe holen
		System.out.print("Bitte geben Sie ein, welche Stelle der Fibonacci-Reihe (>2) sie erhalten möchten: ");
		int eingabe = scanner.nextInt();
		
		//Aufräumen
		scanner.close();
		
		//Berechnen
		int i = 2;
		while(i <= eingabe){
			//Fibonacci Formel
			fn = f0 + f1;
			
			//vorherige Zahlen "weiterschieben"
			f0 = f1;			
			f1 = fn;
			
			//Schleifenzähler erhöhen
			i++;
		}
		
		//Ausgabe
		System.out.format("Die %d. Zahl der Fibonacci-Reihe lautet %d\n", eingabe, fn);

	}

}
