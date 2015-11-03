import java.util.Stack;

public class LargestRectangleInHistogram {

	/*
	 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the
	 * area of largest rectangle in the histogram.
	 * 
	 * For example, Given height = [2,1,5,6,2,3], return 10.
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = new int[] { 2, 1, 5, 6, 2, 3 };
		input = new int[] { 1, 1 };
		System.out.println(largestRectangleArea(input));

	}

	public static int largestRectangleArea(int[] height) {
		// check input
		if (null == height || height.length == 0)
			return 0;

		if (height.length == 1)
			return height[0];

		// add two 0 height hist both at the left and right side
		int[] arr = new int[height.length + 2];
		for (int i = 0; i < height.length; i++) {
			arr[i + 1] = height[i];
		}
		arr[0] = arr[height.length + 1] = 0;
		int size = arr.length;

		Stack<Integer> s = new Stack<>();
		s.push(0);

		int cur = 1;
		int right = size - 1;
		int topIndex;
		int topHeight;
		int maxArea = 0;
		while (cur <= right) {
			topIndex = s.peek();
			topHeight = arr[topIndex];
			System.out.print("cur = " + cur + ", curHeight = " + arr[cur] + ", topIndex = " + topIndex
					+ ", topHeight = " + topHeight);
			if (arr[cur] >= arr[topIndex]) {
				s.push(cur);
				cur++;
			} else {
				s.pop();
				int width = cur - s.peek() - 1;
				int area = width * topHeight;
				System.out.print(", area = " + area);
				maxArea = Math.max(maxArea, area);
			}
			System.out.println("");
		}

		return maxArea;
	}
}
