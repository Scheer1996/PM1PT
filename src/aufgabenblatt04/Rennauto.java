/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * Datum: 24.04.2016
 * Aufgabe: Aufgabenblatt 4
 */
package aufgabenblatt04;

public class Rennauto {
	private String name, typ;
	private double maximalGeschwindigkeit, gefahreneStrecke;
	
	
	public Rennauto (String name, String typ, double maximalGeschwindigkeit) {
		this.name = name;
		this.typ = typ;
		this.maximalGeschwindigkeit = maximalGeschwindigkeit;
	}
	
	public void fahren() {
		this.gefahreneStrecke += Math.random() * maximalGeschwindigkeit;
	}
	
	public void ausgeben() {
		System.out.format("%.2f \n", gefahreneStrecke);
	}
	
	public String toString() {
		return "";
	}

	public void main(String[] args) {
	}
	
	public double getGefahreneStrecke() {
		return this.gefahreneStrecke;
	}
	
	public String getName() {
		return this.name;
	}
}
