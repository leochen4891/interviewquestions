

public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = new int[] { 10, 20, 30, 40, 50, 60, 70 };
		System.out.println(findBox(input, 5));
		System.out.println(findBox(input, 75));
		System.out.println(findBox(input, 45));
		System.out.println(findBox(input, 50));
	}

	public static int findBox(int[] boxes, int item) {
		return findBox(boxes, 0, boxes.length - 1, item);
	}

	private static int findBox(int[] boxes, int l, int r, int item) {
		if (l < 0 || r >= boxes.length || l > r)
			return -1;

		if (boxes[r] < item)
			return -1;

		if (boxes[l] >= item)
			return l;

		int m = (l + r) / 2;

		if (item <= boxes[m]) {
			if (item > boxes[m - 1]) {
				return m;
			} else {
				return findBox(boxes, l, m - 1, item);
			}
		} else if (item > boxes[m]) {
			return findBox(boxes, m + 1, r, item);
		}

		return -1;
	}
}
