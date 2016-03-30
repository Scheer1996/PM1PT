package aufgabenblatt02;

import java.util.Scanner;

public class BMI {

	public static void main(String[] args)
	{
		//vars
		double size, weight;
		int bmi;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Geben Sie ihre Größe in m ein: ");
		size = scanner.nextDouble();
		System.out.print("Geben Sie ihr Gewicht in kg ein: ");
		weight = scanner.nextDouble();
		scanner.close();
		
		//bmi berechnen
		bmi = (int) (weight / (size * size));
		
		System.out.format("Ihr BMI beträgt: %d", bmi);
	}
}
