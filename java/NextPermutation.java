import java.util.Arrays;

public class NextPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 3, 2, 1 };
		for (int i = 0; i < 6; i++) {
			nextPermutation(nums);
			System.out.println(Arrays.toString(nums));
		}
	}

	public static void nextPermutation(int[] nums) {
		if (null == nums || nums.length <= 1)
			return;

		// 3 1 9 8 5, next is
		// 3 5 1 8 9
		// 1. from right to left, find first nums[i] where nums[i] > nums[i-1]
		// 2. swap nums[i] and nums[j] where j >= i and nums[j] > is the smallest one larger than nums[i-1]
		// 3. sort the part of nums[i] to nums[n]

		// 1.
		int size = nums.length;
		int i = size - 1;
		for (; i > 0; i--) {
			if (nums[i] > nums[i - 1])
				break;
		}

		if (i == 0) {// last permutation
			Arrays.sort(nums);
			return;
		}

		// 2.
		int k = i;
		int val = nums[k - 1];
		int smallest = k;
		for (i = k; i < size; i++) {
			if (nums[i] > val && nums[i] < nums[smallest])
				smallest = i;
		}
		nums[k - 1] = nums[smallest];
		nums[smallest] = val;

		Arrays.sort(nums, k, size);
	}
}
