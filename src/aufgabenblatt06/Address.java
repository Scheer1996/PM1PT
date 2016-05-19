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
 * Representation of an address
 * 
 * @author Moritz Höwer
 */
public class Address {

	/**
	 * the street of the address
	 */
	private final String street;

	/**
	 * the house number of the address
	 */
	private final int houseNumber;

	/**
	 * the postal code of the address
	 */
	private final int postalCode;

	/**
	 * the City of the address
	 */
	private final City city;

	/**
	 * Constructs a new Address from the parameters
	 * 
	 * @param street
	 *            the street
	 * @param houseNumber
	 *            the house number
	 * @param postalCode
	 *            the postal code
	 * @param city
	 *            the city
	 */
	public Address(String street, int houseNumber, int postalCode, City city) {
		this.street = street;
		this.houseNumber = houseNumber;
		this.postalCode = postalCode;
		this.city = city;
	}

	// Getters
	public String getStreet() {
		return street;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public City getCity() {
		return city;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", houseNumber=" + houseNumber
				+ ", postalCode=" + postalCode + ", city=" + city + "]";
	}
}
