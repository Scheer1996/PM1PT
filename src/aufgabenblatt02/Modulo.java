package aufgabenblatt02;

import java.util.Scanner;

public class Modulo {

	public static void main(String[] args) {
		int a, b;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Bitte a eingeben: ");
		a = scanner.nextInt();

		System.out.print("Bitte b eingeben: ");
		b = scanner.nextInt();
		scanner.close();
		
		System.out.println("Modulo operator: " + (a % b)); //Module mit Modulo Operator
		System.out.println("Modulo Formel (a- (a / b) * b): " + (a - (a / b) * b)); //Modulo manuell

	}

}
