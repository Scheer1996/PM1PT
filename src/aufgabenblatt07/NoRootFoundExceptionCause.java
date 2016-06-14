/*
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 02.06.2016 
 * Aufgabe: Aufgabenblatt 7 - Aufgabe 2
 */

package aufgabenblatt07;

/**
 * enum for the possible causes of failure of newtons method
 */
public enum NoRootFoundExceptionCause {
	DIVIDE_BY_ZERO("Division by 0 in Newtons Method"), 
	NO_CONVERGENCE("Newtons Method didn't converge");
	
	private String message;
	
	private NoRootFoundExceptionCause(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}
}
