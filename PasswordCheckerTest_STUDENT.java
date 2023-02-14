
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.lang.model.element.ExecutableElement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Estifanos Kebebew
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwordsArray;
	String validPassword = "MypassWord@123";
	@Before
	public void setUp() throws Exception {
		String[] passwords = {"a1A#b1Bc1Cd1D", "bertha22", "a11bb"};
		passwordsArray = new ArrayList<String>();
		passwordsArray.addAll(Arrays.asList(passwords));
	}

	@After
	public void tearDown() throws Exception {
		passwordsArray = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidLength("Y53!Bb"));
			PasswordCheckerUtility.isValidLength("Y53!");
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a LengthExcetion", true);
		}

	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("Bertha22"));
			PasswordCheckerUtility.hasUpperAlpha("bertha22");
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaException", true);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha("334455Bb#"));
			PasswordCheckerUtility.hasLowerAlpha("334455BB#");
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaException", true);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 * @throws NoSpecialCharacterException 
	 * @throws NoDigitException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 * @throws LengthException 
	 * @throws InvalidSequenceException 
	 */
//	@Test
//	public void testIsWeakPassword() throws InvalidSequenceException, LengthException, NoUpperAlphaException, NoLowerAlphaException, 
//	NoDigitException, NoSpecialCharacterException
//	{
//		try {
//			assertTrue(PasswordCheckerUtility.isWeakPassword("1234@aA342"));
//			PasswordCheckerUtility.isWeakPassword("1234@aA");
		
//		catch(WeakPasswordException e)
/*		{
			assertTrue("Successfully threw a WeakPasswordException", true);
		}
	}*/
	
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertTrue(PasswordCheckerUtility.isWeakPassword("northest8"));
			assertFalse(PasswordCheckerUtility.isWeakPassword("Adfdtolife14!"));
		}
		catch(Exception e)
		{
			assertTrue("Threw other exception and not NoLowerAlphaException", false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.NoSameCharInSequence("AAbb@123"));
			PasswordCheckerUtility.NoSameCharInSequence("AAAbb@123");
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw a InvalidSequenceException", true);
		}
	}
	
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasDigit("MyPassword@123"));
			PasswordCheckerUtility.hasDigit("MyPassword@");
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException", true);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try 
		{
			assertEquals(true,PasswordCheckerUtility.isValidPassword​(validPassword));
		}
		catch(Exception e)
		{
			assertTrue("Threw some incorrect exception",false);
		}
		
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwordsArray);
		assertEquals(results.size(), 2);
		assertEquals(results.get(0), "bertha22 Password must contain at least one uppercase alphabetic character");
		assertEquals(results.get(1), "a11bb The password must be atleast six charactes long");
	}
	
}
