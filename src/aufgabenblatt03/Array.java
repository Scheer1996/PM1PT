package aufgabenblatt03;

public class Array {

	public static void main(String[] args) {
		int[][] temperaturDaten = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14},
								  {12, 14, 9, 12, 15, 16, 15, 15, 11, 8, 13, 13, 15, 12}};

		// durchschnittstemperatur
		int totalTemp = 0;
		int i;
		
		// Min/Max
		int minTemp = Integer.MAX_VALUE;
		int maxTemp = Integer.MIN_VALUE;
		
		// schwankung
		int tempDifferenzMax = 0;
		String differenzTageString = "";
		
		for(i = 0; i < temperaturDaten[1].length; i++) {
			int temp = temperaturDaten[1][i];
			
			//temps aufaddieren
			totalTemp += temp;
			
			//max/min temp rausfinden/durchrreichen
			minTemp = Math.min(minTemp, temp);
			maxTemp = Math.max(maxTemp, temp);
			
			//differenzen zwischen den Tagen
			if(i >= 1) { //fange erst bei tag 2 an
			
				//differenz
				int tempDifferenz = Math.abs(temp - temperaturDaten[1][i-1]);
			
				if(tempDifferenz > tempDifferenzMax) { // war die Änderung größer -> neuer String
					tempDifferenzMax = tempDifferenz;
					differenzTageString = " vom "+temperaturDaten[0][i-1]+". zum "+temperaturDaten[0][i]+". Tag";
					
				} else if(tempDifferenz == tempDifferenzMax) { // war die Änderung gleich -> String erweitern
					differenzTageString += " und vom "+temperaturDaten[0][i-1]+". zum "+temperaturDaten[0][i]+". Tag";
				}
			}
		}
		
		double durchschnitt = (double)totalTemp / i;
		
		// Aufgaben b) bis d)
		System.out.format("Die Temperatur beträgt im durchschnitt %.2f°.\n", durchschnitt);
		System.out.format("Die Höchsttemperatur war %d° und die Niedrigste %d°.\n", maxTemp, minTemp);
		System.out.format("Den höchsten Temperaturumschwung von %d° gab es %s.\n", tempDifferenzMax, differenzTageString);
		
		// Ausgabe für e)
		System.out.println("  Tag  | Temperatur");
		System.out.println("-------------------");
		for(i = 0; i < temperaturDaten[0].length; i++) {
			System.out.format(" %3d   |  %3d° \n", temperaturDaten[0][i], temperaturDaten[1][i]);
			System.out.println("-------------------");
		}

	}

}
