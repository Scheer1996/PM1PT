package aufgabenblatt06;

public class Adresse {

	private final String strasse;
	private final int hausnummer;
	private final int postleitzahl;
	private final Staedte ort;
	
	
	public Adresse(String strasse, int hausnummer, int postleitzahl, Staedte ort) {
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.postleitzahl = postleitzahl;
		this.ort = ort;
	}


	public String getStrasse() {
		return strasse;
	}
	
	public int getHausnummer() {
		return hausnummer;
	}
	
	public int getPostleitzahl() {
		return postleitzahl;
	}
	
	public Staedte getOrt() {
		return ort;
	}
	
	@Override
	public String toString() {
		return "";
	}
}
