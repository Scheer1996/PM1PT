package aufgabenblatt03;

public class Arrays {

	public static void main(String[] args) {
		final int[][] daten = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14},
								{12, 14, 9, 12, 15, 16, 15, 15, 11, 8, 13, 13, 15, 12}};
		
		//Berechnungen
		//Durchschnittstemperatur
		int summe = 0;
		int i;
		
		//Min/Max
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		//Schwankung
		int dtMax = 0;
		int indexD1 = 0;
		int indexD2 = 0;
		
		for(i = 0; i < daten[1].length; i++){
			int datum = daten[1][i];
			
			//F�r Durchschnitt
			summe += datum;
			
			//F�r min / max
			min = Math.min(min, datum);
			max = Math.max(max, datum);
			
			//h�chste Schwankung
			if(i >= 1){ //Mn braucht mindestens 2 Werte
				
				//�nderung berechnen
				int dt = Math.abs(datum - daten[1][i-1]);
				
				//War die �nderung gr��er als zuvor?
				if(dt > dtMax){
					dtMax = dt;
					indexD1 = i-1;
					indexD2 = i;
				}
			}
		}
		
		double durchschnitt = (double)summe / i;
		
		//Ausgabe
		System.out.format("Die Durchschnitstemperatur betr�gt ca. %.2f�.\n", durchschnitt);
		System.out.format("Die h�chste Temperatur war %d�, die Niedrigste %d�.\n", max, min);
		System.out.format("Den h�chsten Temperaturumschwung von %d� gab es vom %d. zum %d. Tag.\n", dtMax, daten[0][indexD1], daten[0][indexD2]);
		
		//Tabelle
		//Tage
		System.out.println();
		System.out.print("Tag:        |");
		for(i = 0; i < daten[0].length; i++){
			System.out.format(" %3d  |", daten[0][i]);
		}
		
		//Trennstrich
		System.out.println();
		System.out.print("------------|");
		for(i = 0; i < daten[0].length; i++){
			System.out.print("------|");
		}
		
		//Temperaturen
		System.out.println();
		System.out.print("Temperatur: |");
		for(i = 0; i < daten[1].length; i++){
			System.out.format(" %3d� |", daten[1][i]);
		}
		
	}

}
