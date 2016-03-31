package aufgabenblatt03;

import java.util.Scanner;

public class Fibonacci {

	/*
	 * Berechnen der Fibonacci Zahl bis einer größe von 2^64
	 */
	public static void main(String[] args) {
		//vars
		int startCount, count,
			vorletzterWert = 1, 
			letzterWert = 1,
			aktuellerWert = 1;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Die wievielte Fibonacci Zahl wollen Sie haben ?");
		startCount = scanner.nextInt();
		
		//Aufräumen
		scanner.close();
		
		count = startCount;
		
		while(count > 2) { //wenn count größer als 2 sonst bleibt aktuellerWert = 1
			aktuellerWert = vorletzterWert + letzterWert;
	        vorletzterWert = letzterWert;
	        letzterWert = aktuellerWert;    
			count--;
		}
		
		System.out.format("Die %d. Fibonacci Zahl ist: %d", startCount, aktuellerWert);
			
		
	}

}
