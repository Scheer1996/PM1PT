package vorlesung20160422;

public class Mobiltelefon {
	private String typ;
	private Display display;

	public Mobiltelefon(String typ, Display display) {
		this.typ = typ;
		this.display = display;
	}

	public static void main(String[] args) {
		Display display = new Display(5);
		
		Mobiltelefon iPhone = new Mobiltelefon("iPhone", display);
		iPhone.anrufen();
	}
	
	private void anrufen() {
		this.display.ausgabe(this.typ+ ": Hallo");
	}

}
