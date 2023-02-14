/*
 * @author Estifanos Kebebew
 * @ Password doesn’t contain an uppercase alpha character 
 */
public class NoUpperAlphaException extends Exception{

	/**
	 * Constructor that displays the message if the exception is thrown
	 */
	public NoUpperAlphaException()
	{
		super("Password must contain at least one uppercase alphabetic character");
	}
	/**
	 * Single argument constructor
	 * @param message pulls the message that is printed when the exception is thrown
	 */
	public NoUpperAlphaException(String message)
	{
		super(message);
	}
	
}