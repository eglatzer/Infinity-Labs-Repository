package stringCalculator;

import java.io.InvalidObjectException;

public class RadixConverter {
	private static final int MIN_RADIX = 2;
	private static final int MAX_RADIX = Digits.getMaxRadix();
	
	public static String convertFromSomeRadixToAnotherRadix
				(String number, int srcRadix, int destRadix)
				throws InvalidObjectException {
		if(!isValidRadixes(srcRadix, destRadix)) {
			throw new InvalidRadixException();
		}
		if(!isValidNumber(number, srcRadix)) {
			throw new InvalidNumberException(true);
		}
		if(srcRadix == destRadix) {
			return number;
		}
		if(10 == srcRadix) {
			return convertFrom10RadixToAnotherRadix(number, destRadix);
		}
		if(10 == destRadix) {
			return convertFromSomeRadixTo10Radix(number, srcRadix);
		}
		return convertFrom10RadixToAnotherRadix
				(convertFromSomeRadixTo10Radix(number, srcRadix), destRadix);
	}
	
	private static String convertFrom10RadixToAnotherRadix
				(String number, int destRadix) throws InvalidNumberException {
		if(number.equals("0")) {
			return number;
		}
		String result = "";
		String stringDestRadix =
				IntAndStringConverter.convertIntToString(destRadix);
		while(!number.equals("0")) {
			String tempString = ElementaryArithmetic.
					remainderDivision(number, stringDestRadix);
			int tempInt = IntAndStringConverter.convertStringToInt(tempString);
			result = Digits.convertValueToDigit(tempInt) + result;
			number = ElementaryArithmetic.
					nonRemainderDivision(number, stringDestRadix);
		}
		return result;
	}
	
	private static String convertFromSomeRadixTo10Radix
				(String number, int srcRadix) throws InvalidNumberException {
		String result = "0";
		String stringSrcRadix =
				IntAndStringConverter.convertIntToString(srcRadix);
		for(int i = 0; i < number.length(); ++i) {
			int tempInt = Digits.convertDigitToValue(number.charAt(i));
			String tempString = IntAndStringConverter.convertIntToString(tempInt);
			String tempResult = ElementaryArithmetic.
					multiplication(stringSrcRadix, result);
			result = ElementaryArithmetic.addition(tempResult, tempString);
		}
		return result;
	}
	
	public static int getMinRadix() {
		return MIN_RADIX;
	}
	
	public static int getMaxRadix() {
		return MAX_RADIX;
	}
	
	private static boolean isValidRadixes(int srcRadix, int destRadix) {
		return (srcRadix >= MIN_RADIX && srcRadix <= MAX_RADIX) &&
			   (destRadix >= MIN_RADIX && destRadix <= MAX_RADIX);
	}
	
	private static boolean isValidNumber(String number, int srcRadix)
				throws InvalidNumberException {
		for(int i = 0; i < number.length(); ++i) {
			if(Digits.convertDigitToValue(number.charAt(i)) >= srcRadix) {
				return false;
			}
		}
		return true;
	}
}
