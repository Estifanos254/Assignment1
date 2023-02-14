/*
 * @author Estifanos 
* Password doesn’t contain a lowercase alpha character 
*/
public class NoLowerAlphaException extends Exception{

	/**
	 * Constructor that displays the message if the exception is thrown
	 */
	public NoLowerAlphaException()
	{
		super("The password must contain at least one lowercase alphabetic character");
	}
	/**
	 * Single argument constructor
	 * @param message pulls the message that is printed when the exception is thrown
	 */
	public NoLowerAlphaException(String message)
	{
		super(message);
	}
}