package aufgabenblatt06;

public class Paket extends Sendung {


	private final int gewicht;
	private boolean istAusgeliefert;

	public Paket(Person sender, Person empfaenger,
			int startZeitpunkt, int gewicht) {
		super(sender, empfaenger, startZeitpunkt);
		this.gewicht = gewicht;
		istAusgeliefert = false;
	}
	
	
	public int getGewicht() {
		return gewicht;
	}
	
	public void aktualisiereZeitpunkt(int zeitpunkt) {
		if (!istAusgeliefert && zeitpunkt > startZeitpunkt + transportDauer) {
			istAusgeliefert = true;
		}
	}
	
	public boolean istAusgeliefert() {
		return istAusgeliefert;
	}
}
