package aufgabenblatt03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class fibonacci {

	/*
	 * Berechnen der Fibonacci Zahl bis einer größe von 2^64
	 */
	public static void main(String[] args) {
		//vars
		int startCount, count,
			value1 = 1, 
			value2 = 1,
			value3 = 1;
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("Die wievielte Fibonacci Zahl wollen Sie haben ?");
			startCount = scanner.nextInt();
			count = startCount;
			
			while(count > 2) { //wenn count größer als 2 sonst bleibt value3 = 1
				value3 = value1 + value2; //neuer Wert = letzter + vorletzter Wert   
		        value1 = value2;
		        value2 = value3;    
				count--;
			}
			
			System.out.format("Die %d. Fibonacci Zahl ist: %d", startCount, value3);
			
		} catch (InputMismatchException e) {
			System.err.println("Fehlerhafte Eingabe!");
			
		} finally {
			scanner.close();
		}
		
	}

}
