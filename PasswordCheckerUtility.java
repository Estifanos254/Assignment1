 /*
  * @author Estifanos Kebebew
  */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	
	// constructor
	public PasswordCheckerUtility() {}
	
	/**
	 * Compare equality of two passwords
	 * @param password password string to be checked for
	 * @param passwordConfirm passwordConfirm string to be checked against password for
	 * @throws UnmatchedException thrown if not same (case sensitive)
	 */
	
	
	public static void comparePasswords(java.lang.String password, java.lang.String passwordConfirm) throws UnmatchedException {
		if(!password.equals(passwordConfirm)) {
			throw new UnmatchedException();
		}
	}
	
	/**
	 * Compare equality of two passwords
	 * @param password  password string to be checked for
	 * @param passwordConfirm passwordConfirm string to be checked against password for
	 * @return true if both same (case sensitive), false otherwise
	 */
	
	public static boolean comparePasswordsWithReturn(java.lang.String password, java.lang.String passwordConfirm) {
		if(password.equals(passwordConfirm)){
			return true;
		}
		return false;    //false
	}
	
	/**
	 *  Checks the password length requirement - The password must be at least 6 characters long
	 * @param password password string to be checked for length
	 * @return true if meets minimum length requirement
	 * @throws LengthException thrown if does not meet minimum length requirement
	 */
	
	public static boolean isValidLength(java.lang.String password) throws LengthException {
		if (password.length() >= 6) {
			return true;
		}
		throw new LengthException();
	}
	
	/**
	 * Checks the password alpha character requirement - Password must contain an uppercase alpha character
	 * @param password password string to be checked for alpha character requirement
	 * @return true if meet alpha character requirement
	 * @throws NoUpperAlphaException  thrown if does not meet alpha character requirement
	 */
	
	
	public static boolean hasUpperAlpha(java.lang.String password) throws NoUpperAlphaException {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i)) == true) {
				return true;
			}
		}
		throw new NoUpperAlphaException();
	}
	
	/**
	 * Checks the password lowercase requirement - Password must contain at least one lowercase alpha character
	 * @param password password string to be checked for lowercase requirement
	 * @return true if meets lowercase requirement
	 * @throws NoLowerAlphaException thrown if does not meet lowercase requirement
	 */
	
	public static boolean hasLowerAlpha(java.lang.String password) throws NoLowerAlphaException {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i)) == true) {
				return true;
			}
		}
		throw new NoLowerAlphaException();
	}
	
	/**
	 * Checks the password Digit requirement - Password must contain a numeric character
	 * @param password password string to be checked for Digit requirement
	 * @return true if meet Digit requirement
	 * @throws NoDigitException thrown if does not meet Digit requirement
	 */
	public static boolean hasDigit(java.lang.String password) throws NoDigitException {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i)) == true) {
				return true;
			}
		}
		throw new NoDigitException();
	}
	
	
	/**
	 * Checks the password SpecialCharacter requirement - Password must contain a Special Character
	 * @param password password string to be checked for SpecialCharacter requirement
	 * @return true if meets SpecialCharacter requirement
	 * @throws NoSpecialCharacterException thrown if does not meet SpecialCharacter requirement
	 */
	
	public static boolean hasSpecialChar(java.lang.String password) throws NoSpecialCharacterException {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
		Matcher matcher = pattern.matcher(password);
		
		if (matcher.matches()) {
			throw new NoSpecialCharacterException();
		}
		
		return true;
	}
	/**
	 * Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
	 * @param password  password string to be checked for Sequence requirement
	 * @return false if does NOT meet Sequence requirement
	 * @throws InvalidSequenceException thrown if meets Sequence requirement
	 */
	
	public static boolean NoSameCharInSequence(java.lang.String password) throws InvalidSequenceException {
		
		char n = password.charAt(0);
		boolean hasSameCharInSequence = false;
		for(int i = 2; i < password.length(); i++)
		{
			if(n == password.charAt(i - 1) && n == password.charAt(i))
			{
				hasSameCharInSequence = true;
				i = password.length();
			}
			else
				n = password.charAt(i - 1);
		}
		

			if(hasSameCharInSequence == true)
				throw new InvalidSequenceException();
			else
				return true;
	}
	
	
	
	public static boolean isValidPassword​(java.lang.String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, 
	NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		PasswordCheckerUtility.isValidLength(password);
		PasswordCheckerUtility.hasUpperAlpha(password);
		PasswordCheckerUtility.hasLowerAlpha(password);
		PasswordCheckerUtility.hasDigit(password);
		PasswordCheckerUtility.hasSpecialChar(password);
		PasswordCheckerUtility.NoSameCharInSequence(password);
		
		return true;
	}
	
	public static boolean hasBetweenSixAndNineChars(java.lang.String password) {
		if (password.length() > 5 && password.length() < 10) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if password is VALID and the length is NOT between 6-9 characters
	 * @param password  string to be checked if weak password
	 * @return false if the password is valid and the length of password is NOT between 6 and 9 (inclusive).
	 * @throws WeakPasswordException  if length of password is between 6 and 9 (inclusive), ALTHOUGH the password may be VALID
	 * @throws NoSpecialCharacterException 
	 * @throws NoDigitException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 * @throws LengthException 
	 * @throws InvalidSequenceException 
	 */
		
	public static boolean isWeakPassword(String password) throws WeakPasswordException, InvalidSequenceException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException{

		if(isValidPassword​(password) && !hasBetweenSixAndNineChars(password)) {
			return false;
			
		}else if(hasBetweenSixAndNineChars(password)) {
			throw new WeakPasswordException();
		}
		
		return true;
	}
	
	/**
	 * This method will accept an ArrayList of passwords as the parameter and return an ArrayList with the status 
	 * of any invalid passwords (weak passwords are not considered invalid). The ArrayList of invalid passwords 
	 * will be of the following format: password BLANK message of the exception thrown
	 * @param passwords list of passwords
	 * @return ArrayList of invalid passwords in the correct format
	 */
	
	public static java.util.ArrayList<java.lang.String> getInvalidPasswords(java.util.ArrayList<java.lang.String> passwords) {
		java.util.ArrayList<String> invalidPasswords  = new java.util.ArrayList<String>();
		
		for(String password : passwords)
		{
			try 
			{
				if(!isValidPassword​(password) && !isWeakPassword(password))
					throw new Exception();
			}
			catch(Exception x)
			{
				invalidPasswords.add(password + " " + x.getMessage()); //->
			}
		}
		
		return invalidPasswords;
	}
	
}
	
	
