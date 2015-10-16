

import java.util.LinkedHashSet;

public class CombinationsOfDigits {
	private static String[] NUM = new String[10];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initNUM();
		int input[] = new int[] { 2, 3, 4 };
		printCombinations(input);
	}

	public static void printCombinations(int[] input) {
		if (null == input || input.length <= 0)
			return;

		LinkedHashSet<String> existing = new LinkedHashSet<String>();
		existing.add("");
		for (int i = 0; i < input.length; i++) {
			existing = addNumber(existing, input[i]);
		}

		System.out.println(existing);
	}

	private static LinkedHashSet<String> addNumber(LinkedHashSet<String> existing, int newNumber) {
		LinkedHashSet<String> ret = new LinkedHashSet<String>();
		char[] chars = NUM[newNumber].toCharArray();
		for (String str : existing) {
			for (int i = 0; i < chars.length; i++) {
				ret.add(str + chars[i]);
			}
		}

		return ret;
	}

	private static void initNUM() {
		NUM[0] = "";
		NUM[1] = "";
		NUM[2] = "abc";
		NUM[3] = "def";
		NUM[4] = "ghi";
		NUM[5] = "jkl";
		NUM[6] = "mno";
		NUM[7] = "pqrs";
		NUM[8] = "tuv";
		NUM[9] = "wxyz";

		for (int i = 0; i < 10; i++) {
			System.out.println(i + ":" + NUM[i]);
		}
	}
}
