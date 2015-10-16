public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
	}

	public static int reverse(int x) {
		int ret = x;
		try {
			String str = Integer.toString(x);
			boolean neg = false;
			if (str.charAt(0) == '-') {
				neg = true;
				str = str.substring(1);
			}
			char[] chars = str.toCharArray();
			int left = 0;
			int right = chars.length - 1;
			while (left < right && left < chars.length && right >= 0) {
				char temp = chars[left];
				chars[left] = chars[right];
				chars[right] = temp;
				left++;
				right--;
			}
			ret = Integer.parseInt(new String(chars));
			if (neg) {
				ret = -ret;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
}
