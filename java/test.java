public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 5 };
		System.out.println(binarySearchLeftEdge(arr, 0, arr.length - 1, 3));
	}

	public static int binarySearchLeftEdge(int[] arr, int l, int r, int x) {
		if (l > r)
			return -1;

		if (l == r) {
			if (arr[l] == x)
				return l;
			else
				return -1;
		}

		if ((r - l) == 1) {
			if (arr[l] < x && arr[r] < x) {
				return -1;
			} else if (arr[l] < x && arr[r] == x) {
				return r;
			} else if (arr[l] == x && arr[r] == x) {
				return l;
			} else if (arr[l] == x && arr[r] > x) {
				return l;
			} else if (arr[l] > x && arr[r] > x) {
				return -1;
			}
		}

		int m = (l + r) / 2;
		if (arr[m] < x) {
			return binarySearchLeftEdge(arr, m + 1, r, x);
		} else {
			int ret = binarySearchLeftEdge(arr, l, m - 1, x);
			if (ret == -1 && arr[m] == x)
				ret = m;
			return ret;
		}
	}

	public static int atoi(String str) {
		int ret = 0;

		if (null == str) {
			return ret;
		}

		try {
			str = str.trim();
			ret = Integer.parseInt(str);
		} catch (Exception e) {
			return ret;
		}
		return ret;
	}

}
