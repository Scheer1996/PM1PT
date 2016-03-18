package aufgabenblatt03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class fibonacci {

	public static void main(String[] args) {
		//vars
		int count;
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("Die wievielte Fibonacci Zahl wollen Sie haben ?");
			count = scanner.nextInt();
			
			while()
			
		} catch (InputMismatchException e) {
			System.err.println("Fehlerhafte Eingabe!");
			
		} finally {
			scanner.close();
		}
		
	}

}
