package spielwiese;

public class KeineAhnung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSumme(3000));
	}
	
	public static int getSumme(int n) {
		if(n == 1) {
			return 1;
		}
		return n + getSumme(n - 1);
	}

}
