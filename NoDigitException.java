/*@ author Estifanos Kebebew
 * Exception class for Password that doesn’t contain a numeric character*/
public class NoDigitException extends Exception{

	/**
	 * Constructor that displays the message if the exception is thrown
	 */
	public NoDigitException()
	{
		super("The password must contain at least one digit");
		
	}
	/**
	 * Single argument constructor
	 * @param message pulls the message that is printed when the exception is thrown
	 */
	public NoDigitException(String message)
	{
		super(message);
	}
}