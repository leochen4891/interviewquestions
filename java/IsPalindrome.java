public class IsPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPalindrome(123));
		System.out.println(isPalindrome(111));
		System.out.println(isPalindrome(131));
		System.out.println(isPalindrome(1221));
	}

	public static boolean isPalindrome(int x) {
		String str = Integer.toString(x);
		char[] chars = str.toCharArray();
		int left = 0;
		int right = chars.length - 1;
		while (left < right && left < chars.length && right >= 0) {
			if (chars[left] != chars[right]) {
				return false;
			} else {
				left++;
				right--;
			}
		}

		return true;
	}

}
