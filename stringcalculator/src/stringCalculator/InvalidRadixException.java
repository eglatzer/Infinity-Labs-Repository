package stringCalculator;

import java.io.InvalidObjectException;

public class InvalidRadixException extends InvalidObjectException {
	private static final long serialVersionUID = 1L;
	private static final String REASON = "The Source Radix or the Destination" +
			" Radix is invalid: The Radix Converter deals with radixes between" +
			" " + RadixConverter.getMinRadix() + " and" +
			" " + RadixConverter.getMaxRadix();

	public InvalidRadixException() {
		super(REASON);
	}
}
