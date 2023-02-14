
/*
 * @author estifanos kebebew
 */
public class WeakPasswordException extends Exception {

	/**
	 * Constructor that displays the message if the exception is thrown
	 */
	public WeakPasswordException()
	{
		super("The password is OK but weak - it contain fewer than 10 characters.");
	}
	/**
	 * Single argument constructor
	 * @param message pulls the message that is printed when the exception is thrown
	 */
	public WeakPasswordException(String message)
	{
		super(message);
	}
}