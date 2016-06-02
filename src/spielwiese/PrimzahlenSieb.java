package spielwiese;

public class PrimzahlenSieb {

	public static void main(String[] args) {
		
		final int ANZAHL = 20000;
		
		boolean prims[] = new boolean[20000];
		prims[0] = false;
		prims[1] = false;
		
		for(int i = 2; i < 20000; i++) {
			prims[i] = true;
		}
		
		for(int i = 0; i < Math.sqrt(ANZAHL); i++) {
			if(prims[i] == true) {
				for (int j = i + i; j < ANZAHL; j = j + i) {
					prims[j] = false;
				}
			}
		}
		for(int i = 0; i < prims.length; i++) {
			if(prims[i] == true) {
				System.out.print(i + ", ");
			}
		}
		
		

	}

}
