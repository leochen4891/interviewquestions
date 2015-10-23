import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = new int[] { 3, 2, 4 };
		int target = 6;
		TwoSum ts = new TwoSum();

		System.out.println(Arrays.toString(ts.twoSum(input, target)));
	}

	// @formatter:off
	/*Given an array of integers, find two numbers such that they add up to a specific target number.

	The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

	You may assume that each input would have exactly one solution.

	Input: numbers={2, 7, 11, 15}, target=9
	Output: index1=1, index2=2
	*/
	// @formatter:on

	public int[] twoSum(int[] nums, int target) {
		return twoSum1(nums, target);
	}

	public int[] twoSum1(int[] nums, int target) {
		if (null == nums || nums.length < 2)
			return null;

		int[] ret = new int[2];

		Map<Integer, Integer> pool = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			pool.put(target - nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			if (pool.containsKey(nums[i]) && pool.get(nums[i]) != i) {
				ret[0] = pool.get(nums[i]) + 1;
				ret[1] = i + 1;
				break;
			}
		}

		if (ret[0] > ret[1]) {
			int temp = ret[0];
			ret[0] = ret[1];
			ret[1] = temp;
		}
		return ret;
	}

	// WRONG, indices will change due to sorting
	public int[] twoSum2(int[] nums, int target) {
		if (null == nums || nums.length < 2)
			return null;

		int[] ret = new int[2];
		Arrays.sort(nums);

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target) {
				ret[0] = left + 1;
				ret[1] = right + 1;
				break;
			} else if (sum < target) {
				left++;
			} else { // sum > target
				right--;
			}
		}
		return ret;
	}

}
