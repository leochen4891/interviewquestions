import java.util.Arrays;
import java.util.Random;

public class FindMIssingNumber {

	public static void main(String[] args) {
		tests();
	}

	/**
	 * return -1 means error of input
	 */
	public static int findMissingNumber(int[] arr) {
		// check the input
		if (null == arr || arr.length <= 0)
			return -1;

		return findMissingHelper(arr, 0, arr.length - 1);
	}

	private static int findMissingHelper(int[] arr, int left, int right) {
		if (left > right)
			return -1;

		// corner case when the missing is on the right edge of the array
		if (arr[right] == right && right == arr.length - 1)
			return right + 1;

		// corner case when the missing is on the left edge of the array
		if (left == 0 && arr[left] == left + 1)
			return left;

		int mid = (left + right) / 2;
		int midV = arr[mid];

		if (midV == mid + 1 && arr[mid - 1] == mid - 1)
			return mid;

		if (midV == mid) { // on the right side
			return findMissingHelper(arr, mid + 1, right);
		} else {
			return findMissingHelper(arr, left, mid - 1);
		}
	}

	public static boolean tests() {
		try {

			int[] arr = null;
			int missing = -1;
			int ret = findMissingNumber(arr);
			if (missing != ret)
				throw new Exception("Test failed for " + Arrays.toString(arr) + ", " + ret + " != " + missing);

			arr = new int[] {};
			missing = -1;
			ret = findMissingNumber(arr);
			if (missing != ret)
				throw new Exception("Test failed for " + Arrays.toString(arr) + ", " + ret + " != " + missing);

			arr = new int[] { 0 };
			missing = 1;
			ret = findMissingNumber(arr);
			if (missing != ret)
				throw new Exception("Test failed for " + Arrays.toString(arr) + ", " + ret + " != " + missing);

			arr = new int[] { 1 };
			missing = 0;
			ret = findMissingNumber(arr);
			if (missing != ret)
				throw new Exception("Test failed for " + Arrays.toString(arr) + ", " + ret + " != " + missing);

			arr = new int[] { 1, 2 };
			missing = 0;
			ret = findMissingNumber(arr);
			if (missing != ret)
				throw new Exception("Test failed for " + Arrays.toString(arr) + ", " + ret + " != " + missing);

			arr = new int[] { 0, 2 };
			missing = 1;
			ret = findMissingNumber(arr);
			if (missing != ret)
				throw new Exception("Test failed for " + Arrays.toString(arr) + ", " + ret + " != " + missing);

			arr = new int[] { 0, 1 };
			missing = 2;
			ret = findMissingNumber(arr);
			if (missing != ret)
				throw new Exception("Test failed for " + Arrays.toString(arr) + ", " + ret + " != " + missing);

			arr = new int[] { 1, 2, 3 };
			missing = 0;
			ret = findMissingNumber(arr);
			if (missing != ret)
				throw new Exception("Test failed for " + Arrays.toString(arr) + ", " + ret + " != " + missing);

			arr = new int[] { 0, 2, 3 };
			missing = 1;
			ret = findMissingNumber(arr);
			if (missing != ret)
				throw new Exception("Test failed for " + Arrays.toString(arr) + ", " + ret + " != " + missing);

			arr = new int[] { 0, 1, 3 };
			missing = 2;
			ret = findMissingNumber(arr);
			if (missing != ret)
				throw new Exception("Test failed for " + Arrays.toString(arr) + ", " + ret + " != " + missing);

			arr = new int[] { 0, 1, 2 };
			missing = 3;
			ret = findMissingNumber(arr);
			if (missing != ret)
				throw new Exception("Test failed for " + Arrays.toString(arr) + ", " + ret + " != " + missing);
			arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13 };
			missing = 8;
			ret = findMissingNumber(arr);
			if (missing != ret)
				throw new Exception("Test failed for " + Arrays.toString(arr) + ", " + ret + " != " + missing);

			// some random tests starts from N = 4
			Random rand = new Random();
			rand.setSeed(System.currentTimeMillis());
			for (int count = 1000; count >= 0; count--) {
				int size = 5 + rand.nextInt(100);
				arr = new int[size];
				missing = rand.nextInt(size);
				for (int num = 0, i = 0; i < size; i++) {
					if (missing == i)
						num++;
					arr[i] = num++;
				}
				System.out.println(Arrays.toString(arr) + ", missing = " + missing);
				ret = findMissingNumber(arr);
				if (missing != ret)
					throw new Exception("Test failed for " + Arrays.toString(arr) + ", " + ret + " != " + missing);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
		System.out.println("all tests passed!");
		return true;
	}
}
