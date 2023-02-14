/**
 * 
 * @author Estifanos Kebebew
 * Exception for a password contains more than 2 of the same character in sequence 
 */

public class InvalidSequenceException extends RuntimeException {

	public InvalidSequenceException() {
	super("The password cannot contain more than two of the same character in sequence");
	}

}