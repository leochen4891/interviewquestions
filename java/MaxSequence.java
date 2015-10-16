

public class MaxSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input1 = new int[] { -7, 4, -2, 5, 3, -6, 8, -9 };
		int[] input2 = new int[] { 5, -3, -4, -2, 6, -4, 1, 3 };
		printMaxSequence(input1);
		printMaxSequence(input2);
	}

	public static void printMaxSequence(int[] input) {
		if (null == input || input.length <= 0)
			return;

		int maxStart = 0;
		int maxStop = 0;
		int maxValue = 0;

		int curStart = 0;
		int curValue = 0;
		for (int i = 0; i < input.length; i++) {
			curValue += input[i];

			if (curValue > maxValue) {
				maxStart = curStart;
				maxStop = i;
				maxValue = curValue;
			}

			if (curValue < 0) {
				curValue = 0;
				curStart = i + 1;
			}
		}

		for (int i = maxStart; i <= maxStop; i++) {
			System.out.println(input[i] + ", ");
		}
	}
}
