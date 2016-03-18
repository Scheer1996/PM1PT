package aufgabenblatt02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BMI {

	public static void main(String[] args)
	{
		//vars
		double size, weight;
		int bmi;
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.print("Geben Sie ihre Größe in m ein: ");
			size = scanner.nextDouble();

			System.out.print("Geben Sie ihr Gewicht in kg ein: ");
			weight = scanner.nextDouble();
			
			//bmi berechnen
			bmi = (int) (weight / Math.pow(size, 2));
			
			System.out.format("Ihr BMI beträgt: %d", bmi);
			
		} catch (InputMismatchException e) {
			System.err.println("Das war keine Zahl!");
			
		} finally {
			scanner.close();
		}
	}
}
