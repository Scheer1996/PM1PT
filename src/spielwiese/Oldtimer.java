package spielwiese;

public class Oldtimer implements Vermoegenswerte {
	private String auto;
	private int alter;
	private double basiswert;

	public Oldtimer(String auto, int alter, double basiswert) {
		this.auto = auto;
		this.alter = alter;
		this.basiswert = basiswert;
	}
	@Override
	public String getName() {
		return auto;
	}
	@Override
	public double getEuroWert() {
		return alter * basiswert;
	}
	@Override
	public Risiko getRisko() {
		return Risiko.HOCH;
	}
}