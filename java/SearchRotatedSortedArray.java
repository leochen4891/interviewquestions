public class SearchRotatedSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] nums = new int[] { 0, 1, 2, 3, 4, 5, 6 };
		System.out.println(search(nums, 3));
		nums = new int[] { 5, 6, 0, 1, 2, 3, 4 };
		System.out.println(search(nums, 3));
		nums = new int[] { 2, 3, 4, 5, 6, 0, 1 };
		System.out.println(search(nums, 3));

		System.out.println(Double.MAX_EXPONENT);
		System.out.println(Double.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY);
	}

	public static int search(int[] nums, int target) {
		if (null == nums || nums.length == 0)
			return -1;
		return search(nums, 0, nums.length - 1, target);
	}

	private static int search(int[] nums, int left, int right, int target) {
		if (left >= nums.length || right < 0 || left > right)
			return -1;

		int mid = (left + right) / 2;

		if (nums[mid] == target)
			return mid;

		if (nums[left] <= nums[mid]) { // rotation pivot is on the right half part
			if (nums[left] <= target && target <= nums[mid])
				return search(nums, left, mid - 1, target);
			else
				return search(nums, mid + 1, right, target);
		} else {
			if (nums[mid] <= target && target <= nums[right])
				return search(nums, mid + 1, right, target);
			else
				return search(nums, left, mid - 1, target);
		}
	}

}
