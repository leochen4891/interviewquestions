

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PairToASum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] input = new int[] { 8, 1, 5, 7, 3, 4, 9, 2, 6, 6, 6, 2, 3 };
		int[] input = new int[] { 1, 1, 3, 3, 3 };
		List<Pair> pairs = getPairs(input, 4);
		for (Pair pair : pairs) {
			System.out.println(pair);
		}
	}

	public static List<Pair> getPairs(int[] input, int sum) {
		if (null == input || input.length <= 0)
			return null;

		Arrays.sort(input);
		List<Pair> ret = new LinkedList<Pair>();
		int left = 0;
		int right = input.length - 1;
		while (left < right) {
			int s = input[left] + input[right];
			if (s < sum) {
				left++;
			} else if (s > sum) {
				right--;
			} else {
				Pair pair = new Pair(input[left], input[right]);
				ret.add(pair);
				if (left + 1 < input.length && input[left + 1] == input[left]) {
					left++;
				} else if (right - 1 >= 0 && input[right - 1] == input[right]) {
					right--;
				} else {
					left++;
				}
			}
		}

		return ret;
	}
}

class Pair {
	int a;
	int b;

	public Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public String toString() {
		return "(" + a + ", " + b + ")";
	}
}
