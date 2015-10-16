public class SingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = new int[] { 5, 1, 3, 4, 4, 1, 5 };
		System.out.println(singleNumber(input));
	}

	public static int singleNumber(int[] A) {
		int ret = 0;
		for (int i = 0; i < A.length; i++) {
			ret = ret ^ A[i];
		}
		return ret;
	}

}
