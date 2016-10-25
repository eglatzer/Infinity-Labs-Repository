package stringCalculator;

import java.io.InvalidObjectException;

public class InvalidNumberException extends InvalidObjectException {
	private static final long serialVersionUID = 1L;
	private static final String REASON = "The Number is invalid: ";
	private static final String NOT_APPROPRIATE = "One or more Digit(s) in the" +
			" Number is (are) inappropriate to the Source Radix!";
	private static final String NOT_EXIST = "One or more Digit(s) in the Number" +
			" is (are) not exist at all in the Digits List!";
	
	public static String getReason(boolean isDigitExist) {
		if(isDigitExist) {
			return REASON + NOT_APPROPRIATE;
		} else {
			return REASON + NOT_EXIST;
		}
	}

	public InvalidNumberException(boolean isDigitExist) {
		super(getReason(isDigitExist));
	}
}
