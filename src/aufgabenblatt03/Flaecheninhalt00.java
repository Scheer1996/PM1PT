package aufgabenblatt03;

import java.util.Scanner;

public class Flaecheninhalt00 {

	public static void main(String[] args) {
		double x;
		int index;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Menü: \n Flächeninhalt für \n [1] einen Kreis \n [2] ein Quadrats\n [3] eines Sechsecks \n Bitte wählen: ");
		index = scanner.nextInt();
		
		System.out.println("Bitte geben Sie die Seitelänge/Radius ein:");
		x = scanner.nextDouble();
		scanner.close();
		
		if(index == 1) { // Kreis
			System.out.format("Der Flächeninhalt des Kreis mit dem Radius %f ist: %f", x, (Math.PI * Math.pow(x, 2)));
			
		} else if(index == 2) { // Quadrat
			System.out.format("Der Flächeninhalt des Quadrates mit der Seitenlänge %f ist: %f", x, Math.pow(x, 2));
			
		} else if(index == 3) { // Sechseck
			System.out.format("Der Flächeninhalt des Sechsecks mit der Seitenlänge %f ist : %f", x, ( 3 * Math.sqrt(3) * Math.pow(x, 2)) / 2);
			
		} else { //Fehlerhaft
			System.out.format("Der angegeben index war ungültig. Flächeninhalt: -1");
		}
		
	}

}
