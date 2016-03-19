package aufgabe02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BMIndex {

	public static void main(String[] args) {
		//Variablen
		double koerpergroesse, gewicht;
		int bmi;
		
		Scanner scanner = new Scanner(System.in);
		
		//Eingabe holen
		try{
			System.out.print("Geben Sie Ihre Größe in m ein: ");
			koerpergroesse = scanner.nextDouble();
			
			System.out.print("Geben Sie ihr Gewicht ein: ");
			gewicht = scanner.nextDouble();
			
			//Ausrechnen
			bmi = (int)( gewicht / (koerpergroesse * koerpergroesse) );
			
			//Ausgeben
			System.out.println("Ihr BMI beträgt etwa " + bmi);
			
			
		} catch (InputMismatchException e){
			System.err.println("Das war keine Zahl...");
			
		} finally {
			scanner.close();
			
		}
	}

}
