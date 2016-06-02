package aufgabenblatt06;

public class Brief extends Sendung {


	private final boolean istEinEinschreiben;
	private boolean istAusgeliefert;
	
	
	public Brief(Person sender, Person empfaenger,
			int startZeitpunkt, boolean istEinEinschreiben) {
		super(sender, empfaenger, startZeitpunkt);
		this.istEinEinschreiben = istEinEinschreiben;
		istAusgeliefert = false;
	}
	
	
	public boolean istEinEinschreiben() {
		return istEinEinschreiben;
	}
	
	@Override
	public void aktualisiereZeitpunkt(int zeitpunkt) {
		if(!istAusgeliefert && zeitpunkt > startZeitpunkt + transportDauer) {
			istAusgeliefert = true;
		}
	}
	
	@Override
	public boolean istAusgeliefert() {
		return istAusgeliefert;
	}
}
