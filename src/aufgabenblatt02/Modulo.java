package aufgabenblatt02;

import java.util.Scanner;

public class Modulo {

	public static void main(String[] args) {
		//Variablen
		int a, b;

		Scanner scanner = new Scanner(System.in);

		//Eingabe holen
		System.out.print("Geben Sie a ein: ");
		a = scanner.nextInt();

		System.out.print("Geben Sie b ein: ");
		b = scanner.nextInt();

		//Ausgeben
		System.out.println("Modulo operator (a % b): " + (a % b));
		System.out.println("Modulo Formel (a - (a / b) * b): " + (a - (a / b) * b));

		//Aufräumen
		scanner.close();


	}

}
