package aufgabenblatt06;

public class Anwendung {

	
	public static void main(String[] args) {
		Adresse adresse1 = new Adresse("Norderquerweg", 2, 21037, Staedte.HAMBURG);
		Adresse adresse2 = new Adresse("Hirtenstraße", 18, 80335, Staedte.MUENCHEN);
		
		Person person1 = new Person(adresse1);
		Person person2 = new Person(adresse2);
		
		Sendung sendung1 = new Brief(person1, person2, 0, true);
		
		
	}
}
