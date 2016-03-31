package aufgabenblatt03;

import java.util.Scanner;

public class Flaecheninhalt01 {

	public static void main(String[] args) {
		double x;
		int index;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Menü: \n Flächeninhalt für \n [1] einen Kreis \n [2] ein Quadrats\n [3] eines Sechsecks \n Bitte wählen: ");
		index = scanner.nextInt();
		
		System.out.format("Bitte geben Sie %s ein:", (index == 1) ? "den Radius" : "die Seitenlänge");
		x = scanner.nextDouble();
		
		//Aufräumen
		scanner.close();
	
		switch(index) {
			case 1: //Kreis
				System.out.format("Der Flächeninhalt des Kreis mit dem Radius %.2f ist etwa: %.2f", x, (Math.PI * Math.pow(x, 2)));
				break;
				
			case 2: //Quadrat 
				System.out.format("Der Flächeninhalt des Quadrates mit der Seitenlänge %.2f ist etwa: %.2f", x, Math.pow(x, 2));
				break;
				
			case 3: //Sechseck
				System.out.format("Der Flächeninhalt des Sechsecks mit der Seitenlänge %.2f ist etwa: %.2f", x, ( 3 * Math.sqrt(3) * Math.pow(x, 2)) / 2);
				break;
				
			default:
				System.out.format("Der angegeben index war ungültig.");
		}
	}

}
