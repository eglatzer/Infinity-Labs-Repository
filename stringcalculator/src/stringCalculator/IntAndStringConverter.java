package stringCalculator;

public class IntAndStringConverter {
	public static String convertIntToString(int number) {
		String result = "";
		if(0 == number) {
			return "0";
		}
		while(0 != number) {
			result = (number % 10) + result;
			number = (number / 10);
		}
		return result;
	}
	
	public static int convertStringToInt(String number)
				throws InvalidNumberException {
		if(!ElementaryArithmetic.isIntNumber(number)) {
			throw new InvalidNumberException(true);
		}
		int result = 0;
		for(int i = 0; i < number.length(); ++i) {
			result = 10 * result + number.charAt(i) - '0';
		}
		return result;
	}
}
