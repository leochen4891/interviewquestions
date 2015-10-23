public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(s.lengthOfLongestSubstring("bbbb"));
	}

	/*
	 * Given a string, find the length of the longest substring without repeating characters. For example, the longest
	 * substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest
	 * substring is "b", with the length of 1.
	 */
	public int lengthOfLongestSubstring(String s) {
		if (null == s || s.length() <= 0)
			return 0;

		int charSetSize = 255;
		char[] arr = s.toCharArray();
		int size = arr.length;

		int left = 0;
		int right = 0;
		int length = 1;

		int maxLength = 1;

		int[] charsPos = new int[charSetSize];
		for (int i = 0; i < charSetSize; i++) {
			charsPos[i] = -1;
		}

		for (int i = 0; i < size; i++) {
			char c = arr[i];
			int index = c;
			if (charsPos[index] >= 0) { // char in prefix
				// move the left to first old char's right
				int nextLeft = charsPos[index] + 1;
				for (int j = left; j < nextLeft; j++) {
					char oldC = arr[j];
					int oldIndex = oldC;
					charsPos[oldIndex] = -1;
				}

				left = nextLeft;
			}

			right = i;
			length = right - left + 1;
			charsPos[index] = i;

			if (length > maxLength) {
				maxLength = length;
			}
		}

		return maxLength;

	}
}