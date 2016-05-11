package spielwiese;

public interface Vermoegenswerte {
	public static enum Risiko {
		NIEDRIG, MITTEL, HOCH
	}
	public String getName();
	public double getEuroWert();
	public Risiko getRisko();
}