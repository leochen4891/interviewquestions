public class LengthCoding {
	public static final String input = null;
	public static final String input1 = "";
	public static final String input2 = "a";
	public static final String input3 = "aaabbc";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(lengthCoding(input));
		System.out.println(lengthCoding(input1));
		System.out.println(lengthCoding(input2));
		System.out.println(lengthCoding(input3));
	}

	public static String lengthCoding(String input) {
		if (null == input || input.length() <= 0) {
			return null;
		}
		if (input.length() == 1) {
			return input;
		}

		StringBuilder sb = new StringBuilder();
		char[] chars = input.toCharArray();

		int count = 1;
		char c = chars[0];
		for (int i = 1; i < chars.length; i++) {
			if (c != chars[i]) {
				sb.append(c);
				sb.append(Integer.toString(count));
				c = chars[i];
				count = 1;
			} else {
				count++;
			}
		}
		sb.append(c);
		sb.append(count);

		return sb.toString();
	}
}
