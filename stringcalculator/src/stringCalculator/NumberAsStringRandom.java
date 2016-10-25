package stringCalculator;

import java.util.Random;

public class NumberAsStringRandom extends Random {
	private static final long serialVersionUID = 1L;
	private static final Random random = new Random();
	private static boolean toRemoveZeroes = true;
	
	public static String numberAsStringRandomizer(int length, boolean isExact) {
		String result = "";
		if(1 < length && isExact) {
			toRemoveZeroes = false;
			result = (random.nextInt(9) + 1) +
					numberAsStringRandomizer(length - 1, false);
			toRemoveZeroes = true;
			return result;
		}
		if(1 > length) {
			return "0";
		}
		int digit;
		for(int i = 0; i < length; ++i) {
			digit = random.nextInt(10);
			result = result + digit;
		}
		return
			(toRemoveZeroes ? ElementaryArithmetic.removeZeroes(result) : result);
	}
	
	public static String numberAsStringRandomizer(int maxLength) {
		int length = random.nextInt(maxLength) + 1;
		return numberAsStringRandomizer(length, false);
	}
}