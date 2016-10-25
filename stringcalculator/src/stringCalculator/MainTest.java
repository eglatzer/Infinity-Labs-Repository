package stringCalculator;

import java.util.Random;

public class MainTest {
	private static Random random = new Random();
	
	public static void main(String[] args) throws Exception {
		int minRadix = RadixConverter.getMinRadix();
		int maxRadix = RadixConverter.getMaxRadix();
		int radixA = random.nextInt(maxRadix - 1) + minRadix;
		int radixB;
		do {
			radixB = random.nextInt(maxRadix - 1) + minRadix;
		} while(radixA == radixB);
		char a = Digits.convertValueToDigit(radixA);
		String number = NumberAsStringRandom.numberAsStringRandomizer(9, true);
		String from10ToA = RadixConverter.
				convertFromSomeRadixToAnotherRadix(number, 10, radixA);
		String from10ToB = RadixConverter.
				convertFromSomeRadixToAnotherRadix(number, 10, radixB);
		String fromATo10 = RadixConverter.
				convertFromSomeRadixToAnotherRadix(from10ToA, radixA, 10);
		String fromBTo10 = RadixConverter.
				convertFromSomeRadixToAnotherRadix(from10ToB, radixB, 10);
		String fromAToB = RadixConverter.
				convertFromSomeRadixToAnotherRadix(from10ToA, radixA, radixB);
		String fromBToA = RadixConverter.
				convertFromSomeRadixToAnotherRadix(fromAToB, radixB, radixA);
		System.out.println("minRadix = " + minRadix);
		System.out.println("maxRadix = " + maxRadix);
		System.out.println("radixA = " + radixA);
		System.out.println("radixB = " + radixB);
		System.out.println("number = " + number);
		System.out.println("from10ToA = " + from10ToA);
		System.out.println("from10ToB = " + from10ToB);
		System.out.println("fromATo10 = " + fromATo10);
		System.out.println("fromBTo10 = " + fromBTo10);
		System.out.println("fromAToB = " + fromAToB);
		System.out.println("fromBToA = " + fromBToA);
		System.out.println(Digits.getDigitsList());
		System.out.println("Digits.maxRadix = " + Digits.getMaxRadix());
		System.out.println(radixA + " = " + a);
		System.out.println(a + " = " + Digits.convertDigitToValue(a));
		int numberAsInt =
				IntAndStringConverter.convertStringToInt(number);
		System.out.println("number = " + number);
		System.out.println("numberAsInt = " + numberAsInt);
		numberAsInt = Math.abs(random.nextInt());
		number = IntAndStringConverter.convertIntToString(numberAsInt);
		System.out.println("number = " + number);
		System.out.println("numberAsInt = " + numberAsInt);
		String number1 = NumberAsStringRandom.numberAsStringRandomizer(9, false);
		String number2 = NumberAsStringRandom.numberAsStringRandomizer(9);
		System.out.println("number1 = " + number1);
		System.out.println("number2 = " + number2);
		String result = ElementaryArithmetic.addition(number1, number2);
		System.out.println(number1 + " + " + number2 + " = " + result);
		result = ElementaryArithmetic.subtraction(number1, number2);
		System.out.println(number1 + " - " + number2 + " = " + result);
		result = ElementaryArithmetic.multiplication(number1, number2);
		System.out.println(number1 + " * " + number2 + " = " + result);
		result = ElementaryArithmetic.nonRemainderDivision(number1, number2);
		System.out.println(number1 + " / " + number2 + " = " + result);
		result = ElementaryArithmetic.remainderDivision(number1, number2);
		System.out.println(number1 + " % " + number2 + " = " + result);
		switch (ElementaryArithmetic.compare(number, number1)) {
			case 1:
				System.out.println(number + " > " + number1);
				break;
			case 0:
				System.out.println(number + " == " + number1);
				break;
			case -1:
				System.out.println(number + " < " + number1);
				break;
			default:
				throw new Exception("Something's wrong in the compare method!");
		}
		System.out.println("Checking the removeZeroes method:");
		System.out.println("number = \"0001020\" + " + number);
		number = "0001020" + number;
		System.out.println("number = " + number);
		number = ElementaryArithmetic.removeZeroes(number);
		System.out.println("Now, after removeZeroes...");
		System.out.println("number = " + number);
		System.out.println(ElementaryArithmetic.isIntNumber(fromAToB) ?
				"fromAToB is int number" : "fromAToB is not int number");
	}
}
