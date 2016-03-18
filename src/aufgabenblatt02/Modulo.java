package aufgabenblatt02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Modulo {

	public static void main(String[] args) {
		// vars a, b
		int a, b;
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.print("Bitte a eingeben: ");
			a = scanner.nextInt();

			System.out.print("Bitte b eingeben: ");
			b = scanner.nextInt();
			
			System.out.println("Modulo operator: " + (a % b));
			System.out.println("Modulo Formel (a- (a / b) * b): " + (a - (a /b) * b));
			
			
		} catch(InputMismatchException e ) {
			System.out.println("Das war keine Zahl!");
			
		} finally {
			scanner.close();
		}
	}

}
