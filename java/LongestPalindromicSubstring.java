public class LongestPalindromicSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestPalindromicSubstring s = new LongestPalindromicSubstring();
		System.out
				.println(s
						.longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}

	public String longestPalindrome(String s) {
		// TODO scan to get the 2-char and 3-char palindromes as the start points and skip when one is smaller than the
		// current longest
		return null;
	}

	public String longestPalindrome2(String s) {

		char[] arr = s.toCharArray();
		int size = arr.length;
		if (size <= 1)
			return s;
		int[][] m = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				m[i][j] = (i == j) ? 1 : -1;
			}
		}

		char curC = arr[0];
		int firstC = 0;
		for (int c = 1; c < size; c++) {
			if (c == size - 1 || arr[c] != curC) {
				if (c == size - 1)
					c++;
				for (int i = firstC; i < c; i++) {
					for (int j = i; j < c; j++) {
						m[i][j] = 1;
					}
				}
				m[firstC][c - 1] = 1;
				if (c >= size)
					break;
				curC = arr[c];
				firstC = c;
			}
		}

		int maxLength = 1;
		int maxi = 0;
		int maxj = 0;

		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				int length = j - i + 1;
				if (length <= maxLength)
					continue;
				if (isPalindrome(m, arr, i, j)) {
					maxLength = j - i + 1;
					maxi = i;
					maxj = j;
				}
			}
		}

		return String.valueOf(arr, Math.max(0, maxi), (maxj - maxi + 1));
	}

	private static boolean isPalindrome(int[][] matrix, char[] arr, int from, int to) {
		if (from < 0 || from >= arr.length || to < 0 || to >= arr.length)
			return false;

		if (matrix[from][to] != -1)
			return matrix[from][to] == 1;

		if (from >= to)
			return true;

		if (isPalindrome(matrix, arr, from + 1, to - 1) && (arr[from] == arr[to])) {
			matrix[from][to] = 1;
			System.out.println(String.valueOf(arr, Math.max(0, from), (to - from + 1)) + " true");
			return true;
		}
		matrix[from][to] = 0;
		return false;
	}

	private static final int CHARSET_COUNT = 256;

	class TrieNode {
		TrieNode[] children = new TrieNode[CHARSET_COUNT];

		public TrieNode() {
			for (int i = 0; i < CHARSET_COUNT; i++) {
				children[i] = null;
			}
		}

		public TrieNode getChild(int index) {
			return children[index];
		}

		public TrieNode addChild(int index) {
			this.children[index] = new TrieNode();
			return this.children[index];
		}
	}

	// Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is
	// 1000, and there exists one unique longest palindromic substring.
	public String longestPalindrome1(String s) {
		TrieNode root = new TrieNode();
		char[] arr = s.toCharArray();
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			TrieNode cur = root;
			for (int j = i; j < size; j++) {
				char c = arr[j];
				TrieNode child = cur.getChild(c);
				if (null == child)
					child = cur.addChild(c);
				cur = child;
			}
		}

		int maxLength = 0;
		int maxStart = 0;
		int maxStop = 0;

		int length = 0;

		for (int i = size - 1; i >= 0; i--) {
			TrieNode cur = root;
			int j = i;
			for (; j >= 0; j--) {
				char c = arr[j];
				TrieNode child = cur.getChild(c);
				if (null == child) {
					break;
				}
				cur = child;
			}

			length = i - j;
			if (length > maxLength) {
				maxLength = length;
				maxStart = j + 1;
				maxStop = i;
			}
		}

		return maxLength <= 0 ? "" : s.substring(maxStart, maxStop + 1);
	}
}
