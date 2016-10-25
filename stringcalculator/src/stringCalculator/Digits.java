package stringCalculator;

public enum Digits {
	ZERO('0'),
	ONE('1'),
	TWO('2'),
	THREE('3'),
	FOUR('4'),
	FIVE('5'),
	SIX('6'),
	SEVEN('7'),
	EIGHT('8'),
	NINE('9'),
	
	UPPERCASE_A('A'), LOWERCASE_A('a'),
	UPPERCASE_B('B'), LOWERCASE_B('b'),
	UPPERCASE_C('C'), LOWERCASE_C('c'),
	UPPERCASE_D('D'), LOWERCASE_D('d'),
	UPPERCASE_E('E'), LOWERCASE_E('e'),
	UPPERCASE_F('F'), LOWERCASE_F('f'),
	UPPERCASE_G('G'), LOWERCASE_G('g'),
	UPPERCASE_H('H'), LOWERCASE_H('h'),
	UPPERCASE_I('I'), LOWERCASE_I('i'),
	UPPERCASE_J('J'), LOWERCASE_J('j'),
	UPPERCASE_K('K'), LOWERCASE_K('k'),
	UPPERCASE_L('L'), LOWERCASE_L('l'),
	UPPERCASE_M('M'), LOWERCASE_M('m'),
	UPPERCASE_N('N'), LOWERCASE_N('n'),
	UPPERCASE_O('O'), LOWERCASE_O('o'),
	UPPERCASE_P('P'), LOWERCASE_P('p'),
	UPPERCASE_Q('Q'), LOWERCASE_Q('q'),
	UPPERCASE_R('R'), LOWERCASE_R('r'),
	UPPERCASE_S('S'), LOWERCASE_S('s'),
	UPPERCASE_T('T'), LOWERCASE_T('t'),
	UPPERCASE_U('U'), LOWERCASE_U('u'),
	UPPERCASE_V('V'), LOWERCASE_V('v'),
	UPPERCASE_W('W'), LOWERCASE_W('w'),
	UPPERCASE_X('X'), LOWERCASE_X('x'),
	UPPERCASE_Y('Y'), LOWERCASE_Y('y'),
	UPPERCASE_Z('Z'), LOWERCASE_Z('z'),
	
	ALEPH('א'),
	BET('ב'),
	GIMEL('ג'),
	DALET('ד'),
	HE('ה'),
	WAW('ו'),
	ZAYIN('ז'),
	HET('ח'),
	TET('ט'),
	YODH('י'),
	KAPH('כ'), FINAL_KAPH('ך'),
	LAMEDH('ל'),
	MEM('מ'), FINAL_MEM('ם'),
	NUN('נ'), FINAL_NUN('ן'),
	SAMEKH('ס'),
	AYIN('ע'),
	PE('פ'), FINAL_PE('ף'),
	TSADE('צ'), FINAL_TSADE('ץ'),
	QOPH('ק'),
	RESH('ר'),
	SHIN('ש'),
	TAW('ת'),
	
	AMPERSAND('&'),
	VERTICAL_BAR('|'),
	LESS_THAN_SIGN('<'),
	GREATER_THAN_SIGN('>'),
	AT_SIGN('@'),
	TILDE('~');
	
	private char digit;
	private int value;
	
	private Digits(char digit_) {
		digit = digit_;
		value = convertDigitToValue();
	}

	private int convertDigitToValue() {
		if('0' <= digit && '9' >= digit) {
			return digit - '0';
		}
		if('A' <= digit && 'Z' >= digit) {
			return digit - 'A' + 10;
		}
		if('a' <= digit && 'z' >= digit) {
			return digit - 'a' + 10;
		}
		if('א' <= digit && 'י' >= digit) {
			return digit - 'א' + 36;
		}
		if('כ' == digit || 'ך' == digit) {
			return 46;
		}
		if('ל' == digit) {
			return 47;
		}
		if('מ' == digit || 'ם' == digit) {
			return 48;
		}
		if('נ' == digit || 'ן' == digit) {
			return 49;
		}
		if('ס' == digit || 'ע' == digit) {
			return digit - 'ס' + 50;
		}
		if('פ' == digit || 'ף' == digit) {
			return 52;
		}
		if('צ' == digit || 'ץ' == digit) {
			return 53;
		}
		if('ק' <= digit && 'ת' >= digit) {
			return digit - 'ק' + 54;
		}
		return ordinal() - 31;
	}
	
	public static int convertDigitToValue(char digit_)
				throws InvalidNumberException {
		for(Digits d : Digits.values()) {
			if(d.digit == digit_) {
				return d.value;
			}
		}
		throw new InvalidNumberException(false);
	}
	
	public static char convertValueToDigit(int value_)
				throws InvalidNumberException {
		for(Digits d : Digits.values()) {
			if(d.value == value_) {
				return d.digit;
			}
		}
		throw new InvalidNumberException(false);
	}
	
	public static int getMaxRadix() {
		return Digits.values()[Digits.values().length - 1].value + 1;
	}
	
	private String getDigitProperties() {
		return "name: " + name() + "\t digit: " + digit + "\t value: " + value;  
	}
	
	public static String getDigitsList() {
		String digitsList = "";
		for(Digits d: Digits.values()) {
			digitsList += d.getDigitProperties() + "\n";
		}
		return digitsList;
	}
}
