package vorlesung20160329;

import java.util.Scanner;

public class Max3if {

	public static void main(String[] args) {
		/*
		 * int zahl1, zahl2, zahl3; int groessteZahl = 0;
		 * 
		 * Scanner scanner = new Scanner(System.in);
		 * 
		 * zahl1 = scanner.nextInt(); zahl2 = scanner.nextInt(); zahl3 =
		 * scanner.nextInt();
		 * 
		 * scanner.close();
		 * 
		 * if (zahl1 >= zahl2 && zahl1 >= zahl3) { groessteZahl = zahl1; }
		 * 
		 * if (zahl2 >= zahl2 && zahl2 >= zahl3) { groessteZahl = zahl3;
		 * 
		 * }
		 * 
		 * if (zahl3 >= zahl1 && zahl3 >= zahl2) { groessteZahl = zahl3; }
		 * 
		 * System.out.println("Die größte Zahl ist: " + groessteZahl);
		 */

		int zahl = 2;
		switch (zahl) {
			case 1 :
				System.out.println("Eins");
				break;

			case 2 :
				System.out.println("Zwei");
				break;

			default :
				System.out.println("Alles andere");
				break;
		}
	}

	
}
