
public class UnmatchedException extends Exception {

	/**
	 * Constructor that displays the message if the exception is thrown
	 */
	public UnmatchedException()
	{
		super("Passwords do not match");
	}
	/**
	 * Single argument constructor
	 * @param message pulls the message that is printed when the exception is thrown
	 */
	public UnmatchedException(String message) {
		super(message);
	}
}



