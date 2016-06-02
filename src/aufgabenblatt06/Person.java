/*
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 19.05.2016 
 * Aufgabe: Aufgabenblatt 6 - Aufgabe 1
 */

package aufgabenblatt06;

/**
 * Representation of a person
 * 
 * @author Moritz Höwer
 */
public class Person {
	
	/**
	 * the Address where this person lives
	 */
	private final Address address;
	
	/**
	 * Constructs a person with an Address
	 * 
	 * @param address the Address where this Person lives
	 */
	public Person(Address address){
		this.address = address;
	}

	//Getter
	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Person [address=" + address + "]";
	}
}
