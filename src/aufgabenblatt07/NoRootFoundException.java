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
 * custom exception class when Roots can't find a root
 */
@SuppressWarnings("serial")
public class NoRootFoundException extends Exception {

	/**
	 * the cause for this exception
	 */
	private NoRootFoundExceptionCause cause;
	
	public NoRootFoundException(NoRootFoundExceptionCause cause){
		this.cause = cause;
	}
	
	@Override
	public String getMessage(){
		if(cause == null){
			return null;
		}
		
		return cause.getMessage();
	}	
}
