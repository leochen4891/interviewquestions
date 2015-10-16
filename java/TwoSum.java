import java.util.Arrays;

public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = new int[] { 2, 7, 11, 15 };
		int target = 9;
		System.out.println(Arrays.toString(twoSum(input, target)));
	}

	public static int[] twoSum(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;
		int temp;
		while (left < right) {
			temp = numbers[left] + numbers[right];
			if (temp == target) {
				break;
			} else if (temp > target) {
				right--;
			} else {
				left++;
			}
		}

		int ret[] = new int[2];
		ret[0] = left + 1;
		ret[1] = right + 1;
		return ret;
	}

}
