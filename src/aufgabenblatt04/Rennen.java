/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * Datum: 24.04.2016
 * Aufgabe: Aufgabenblatt 4
 */
package aufgabenblatt04;

/**
 * 
 */
public class Rennen {

	private int anzahlRennautos;
	private double streckenlaenge;
	private Rennauto[] rennautos;
	
	public Rennen(double streckenlaenge) {
		this.streckenlaenge = streckenlaenge;
		rennautos = new Rennauto[0];
		anzahlRennautos = 0;
	}
	
	public void addRennauto(Rennauto neuesRennauto) {
		Rennauto[] tempArray = new Rennauto[rennautos.length + 1];
		System.arraycopy(rennautos, 0, tempArray, 0, rennautos.length);
		
		rennautos = tempArray;

		rennautos[anzahlRennautos] = neuesRennauto;
		anzahlRennautos ++;
	}
	
	private void schritt() {
		for(Rennauto auto : rennautos) {
			auto.fahren();
		}
	}
	
	private Rennauto ermittleSieger() {
		for(Rennauto auto : rennautos) {
			if(auto.getGefahreneStrecke() >= this.streckenlaenge) {
				return auto;
			}
		}
		return null;
	}

	public void durchfuehren() {
		boolean keinSieger = true;
		while(keinSieger) {
			this.schritt();
			if(this.ermittleSieger() != null) {
				keinSieger = false;
			}
		}
	}
	
	public Rennauto getSieger()
	{
		return this.ermittleSieger();
	}
	
	public void getInfos() {
		for(Rennauto auto : rennautos) {
			System.out.println(auto.getName());
		}
	}
	
}
