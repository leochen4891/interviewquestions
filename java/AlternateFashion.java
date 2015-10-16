

import java.util.Arrays;

public class AlternateFashion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = new int[] { -3, -2, 6, 0, 7, -1, -8 };
		applyAlternateFashion(input);
		System.out.println(Arrays.toString(input));

	}

	public static void applyAlternateFashion(int[] input) {
		if (null == input || input.length == 0)
			return;

		// check the number of pos and neg
		int start = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] >= 0) {
				start++;
			} else {
				start--;
			}
		}
		if (start != 1 && start != -1) {
			System.out.println("input error, start = " + start);
			return;
		}

		int sign = start;

		for (int i = 0; i < input.length; i++) {
			if (!sameSign(input[i], sign)) {
				for (int j = i + 1; j < input.length; j++) {
					if (sameSign(input[j], sign)) {
						swap(input, i, j);
						break;
					}
				}
			}
			sign = -sign;
		}
	}

	private static boolean sameSign(int a, int b) {
		return (a >= 0 && b >= 0) || (a < 0 && b < 0);
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
