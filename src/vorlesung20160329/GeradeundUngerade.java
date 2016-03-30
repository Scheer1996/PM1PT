package vorlesung20160329;

import java.util.Scanner;
/**
 * 
 * @author Philip Scheer <philip@philip-scheer.de>
 *
 */
public class GeradeundUngerade {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int zahl = scanner.nextInt();
		scanner.close();
		
		System.out.println(zahl % 2 == 0 ? "Gerade" : "Ungerade");
	}

}
