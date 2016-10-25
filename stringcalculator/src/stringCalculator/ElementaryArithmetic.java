package stringCalculator;

public class ElementaryArithmetic {
	private static int resultOfDigitsAction;
	private static char resultAsChar;
	private static final String DIVISION_BY_ZERO =
			"You are trying to divide by zero!";
	
	public static String addition(String a, String b)
				throws InvalidNumberException {
		check(a, b);
		a = removeZeroes(a);
		b = removeZeroes(b);
		String result = "";
		char left = '0';
		int aLength = a.length();
		int bLength = b.length();
		int maxLength = (aLength > bLength ? aLength : bLength);
		String longerNumber = (aLength > bLength ? a : b);
		for(int i = 0; i < maxLength; ++i) {
			if(0 > aLength - i - 1 || 0 > bLength - i - 1) {
				resultOfDigitsAction =
						longerNumber.charAt(maxLength - i - 1) + left - 2 * '0';
			} else {
				resultOfDigitsAction =
						a.charAt(aLength - i - 1) + b.charAt(bLength - i - 1)
						+ left - 3 * '0';
			}
			resultAsChar = (char)((resultOfDigitsAction % 10) + '0');
			left = (char)((resultOfDigitsAction / 10) + '0');
			result = resultAsChar + result;
		}
		result = left + result;
		return removeZeroes(result);
	}
	
	public static String subtraction(String a, String b)
				throws InvalidNumberException {
		check(a, b);
		a = removeZeroes(a);
		b = removeZeroes(b);
		String result = "";
		int aLength = a.length();
		int bLength = b.length();
		if(-1 == compare(a, b)) {
			return "-" + subtraction(b, a);
		}
		for(int i = 0; i < aLength; ++i) {
			if(0 > bLength - i - 1) {
				result = a.charAt(aLength - i - 1) + result;
			} else {
				resultOfDigitsAction =
						a.charAt(aLength - i - 1) - b.charAt(bLength - i - 1)
						+ 10;
				resultAsChar = (char)((resultOfDigitsAction % 10) + '0');
				if(10 > resultOfDigitsAction) {
					a = reduceOne(a, aLength - i - 2);
				}
				result = resultAsChar + result;
			}
		}
		return removeZeroes(result);
	}
	
	public static String multiplication(String a, String b)
				throws InvalidNumberException {
		check(a, b);
		a = removeZeroes(a);
		b = removeZeroes(b);
		String result = "";
		String intermediateResult;
		char left;
		int aLength = a.length();
		int bLength = b.length();
		for(int i = 0; i < aLength; ++i) {
			intermediateResult = "" + getZeroes(i);
			left = '0';
			for(int j = 0; j < bLength; ++j) {
				resultOfDigitsAction =
						(a.charAt(aLength - i - 1) - '0') *
						(b.charAt(bLength - j - 1) - '0') + (left - '0');
				resultAsChar = (char)((resultOfDigitsAction % 10) + '0');
				left = (char)((resultOfDigitsAction / 10) + '0');
				intermediateResult =
						('0' == left || j < bLength - 1 ?
						resultAsChar + intermediateResult :
						"" + left + resultAsChar + intermediateResult);
			}
			result = addition(intermediateResult, result);
		}
		return result;
	}
	
	public static String remainderDivision(String a, String b)
				throws InvalidNumberException {
		return division(a, b, false);
	}
	
	public static String nonRemainderDivision(String a, String b)
				throws InvalidNumberException {
		return division(a, b, true);
	}
	
	public static boolean isIntNumber(String number) {
		for(int i = 0; i < number.length(); ++i) {
			char c = number.charAt(i);
			if('0' > c || '9' < c) {
				return false;
			}
		}
		return true;
	}
	
	public static String removeZeroes(String number) {
		int length = number.length();
		if(0 == length) {
			return "0";
		}
		int i = 0;
		while('0' == number.charAt(i) && length - 1 != i) {
			++i;
		}
		number = number.substring(i);
		return number;
	}
	
	public static int compare(String a, String b) throws InvalidNumberException {
		check(a, b);
		a = removeZeroes(a);
		b = removeZeroes(b);
		int aLength = a.length();
		int bLength = b.length();
		if(aLength > bLength) {
			return 1;
		}
		if(aLength < bLength) {
			return -1;
		}
		for(int i = 0; i < aLength; ++i) {
			if(a.charAt(i) > b.charAt(i)) {
				return 1;
			}
			if(a.charAt(i) < b.charAt(i)) {
				return -1;
			}
		}
		return 0;
	}
	
	private static void check(String a, String b) throws InvalidNumberException {
		if(!isIntNumber(a) || !isIntNumber(b)) {
			throw new InvalidNumberException(true);
		}
	}
	private static String reduceOne(String number, int index) {
		while(0 <= index) {
			char replacement =
					('0' == number.charAt(index) ?
					 '9' : (char)(number.charAt(index) - 1));
			number = number.substring(0, index) + replacement +
					 number.substring(index + 1);
			
			if('9' != replacement) {
				break;
			}
			--index;
		}
		return number;
	}
	
	private static String getZeroes(int numberOfZeroes) {
		String result = "";
		for(int i = 0; i < numberOfZeroes; ++i) {
			result += "0";
		}
		return result;
	}
	
	private static String division(String a, String b, boolean toReturnComplete)
				throws InvalidNumberException {
		check(a, b);
		a = removeZeroes(a);
		b = removeZeroes(b);
		if(b.equals("0")) {
			throw new ArithmeticException(DIVISION_BY_ZERO);
		}
		String complete = "";
		String remainder = "";
		String quotientDigit;
		String intermediateResult = "";
		int aLength = a.length();
		for(int i = 0; i < aLength; ++i) {
			for(char c = '0'; c <= '9'; ++c) {
				quotientDigit = "" + c;
				intermediateResult += a.substring(i, i + 1);
				remainder =
						subtraction
						(intermediateResult, multiplication(quotientDigit, b));
				if(-1 == compare(remainder, b)) {
					complete += quotientDigit;
					intermediateResult = remainder;
					break;
				} else {
					intermediateResult =
							intermediateResult.
							substring(0, intermediateResult.length() - 1);
				}
			}
		}
		return (toReturnComplete ? removeZeroes(complete) : remainder);
	}
}
