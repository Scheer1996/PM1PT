package aufgabenblatt06;

public abstract class Sendung {
	
	protected final Person sender;
	protected final Person empfaenger;
	protected final int sendungsnummer;
	protected final int startZeitpunkt;
	protected final int transportDauer;
	
	protected static int sendungsnummerZaehler = 0;
	
	
	public Sendung(Person sender, Person empfaenger, int startZeitpunkt) {
		this.sender = sender;
		this.empfaenger = empfaenger;
		this.startZeitpunkt = startZeitpunkt;
		SendungsdauerSchaetzer schaetzer = new GoogleSendungsdauerSchaetzer();
		this.transportDauer = schaetzer.getSendungsTransportDauer(sender.getAdresse().getOrt(), empfaenger.getAdresse().getOrt());
		
		sendungsnummer = sendungsnummerZaehler;
		sendungsnummerZaehler++;
	}
	
	
	public int getSendungsnummer() {
		return sendungsnummer;
	}
	
	public int getTransportDauert() {
		return transportDauer;
	}
	
	public int getStartZeitpunkt() {
		return startZeitpunkt;
	}
	
	public abstract boolean istAusgeliefert();
	
	public abstract void aktualisiereZeitpunkt(int zeitpunkt);
}
