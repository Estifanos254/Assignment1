
public class LengthException extends Exception {

	public LengthException() {
		super("The password must be atleast six charactes long");
	}
	/*
	 * @argument construct?or
	 */
	public LengthException(String message) {
		super(message);
	}
}
  