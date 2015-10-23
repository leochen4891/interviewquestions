import java.util.HashMap;
import java.util.Map;

public class LongestValidParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = ")())(";
		System.out.println(longestValidParentheses(input));
	}

	public static int longestValidParentheses(String s) {
		if (null == s || s.length() <= 1)
			return 0;

		int maxLength = 0;
		int counter = 0;
		int length = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				counter++;
				length++;
			} else {
				if (counter > 0) {
					counter--;
					length++;
					if (counter == 0) {
						maxLength = Math.max(maxLength, length);
					}
				} else {
					counter = 0;
					length = 0;
				}
			}
		}

		counter = 0;
		length = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == ')') {
				counter++;
				length++;
			} else {
				if (counter > 0) {
					counter--;
					length++;
					if (counter == 0) {
						maxLength = Math.max(maxLength, length);
					}
				} else {
					counter = 0;
					length = 0;
				}
			}
		}

		return maxLength;
	}

	public static int longestValidParentheses1(String s) {
		if (null == s || s.length() <= 1)
			return 0;

		int maxLength = 0;
		int counter = 0;
		Map<Integer, Integer> stackSize2Index = new HashMap<>();

		stackSize2Index.put(counter, -1);

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				counter++;
				if (!stackSize2Index.containsKey(counter))
					stackSize2Index.put(counter, i);
			} else if (c == ')') {
				if (counter > 0) {
					counter--;
					int prevSize = stackSize2Index.get(counter);
					int length = i - prevSize;
					maxLength = Math.max(maxLength, length);
				} else {
					stackSize2Index.clear();
					stackSize2Index.put(0, i);
				}
			}
		}

		return maxLength;
	}
}
