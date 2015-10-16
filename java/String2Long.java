

/**
 * parse a String to long
 * <p>
 * 1) The range of the conversion is between 20182128630 and -20182128631 <br>
 * 2) The input can only be integer string ( 123, not 123.0) <br>
 * 3) The conversion is for decimal numbers
 * 
 * @author Lei Chen
 */
public class String2Long {
	public static void main(String[] args) {
		long i = stringToLong("123");
		if (i == 123) {
			System.out.println("sucess");
		} else {
			System.out.println("failed");
		}
	}

	public static long stringToLong(String s) throws NumberFormatException {
		// check the number format
		if (!s.matches("[-]?\\d*")) {
			throw new NumberFormatException(s);
		}

		long ret = 0;
		boolean negtive = false;
		int length = s.length();

		char[] chars = s.toCharArray();

		// check if it's a pos or neg
		if (chars[0] == '-') {
			negtive = true;
			length--;
		}

		// scan the number from right to left
		for (int i = 0; i < length; i++) {
			char c = chars[chars.length - 1 - i];
			int d = (c - '0');
			d *= Math.pow(10, i);

			ret += d;
		}

		// apply negative
		if (negtive) {
			ret = -ret;
		}

		return ret;
	}
}