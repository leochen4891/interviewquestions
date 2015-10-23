public class ContainerMostWater {

	/*
	 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical
	 * lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
	 * with x-axis forms a container, such that the container contains the most water.
	 * 
	 * Note: You may not slant the container.
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = new int[25000];
		for (int i = input.length - 1; i >= 0; i--) {
			input[i] = i + 1;
		}
		ContainerMostWater c = new ContainerMostWater();
		for (int i = 0; i < 10000; i++) {
			c.maxArea(input);
		}
		System.out.println("done");
	}

	public int maxArea(int[] height) {
		if (null == height || height.length <= 1)
			return 0;

		int size = height.length;
		int left = 0;
		int right = size - 1;
		int maxWater = 0;

		while (left < right) {
			int vol = Math.min(height[left], height[right]) * (right - left);
			if (vol > maxWater) {
				maxWater = vol;
			}

			if (height[left] < height[right]) {
				// int next = left + 1;
				// while (height[next] <= height[left] && next < right)
				// next++;
				// left = next;
				left++;
			} else {
				// int next = right - 1;
				// while (height[next] <= height[right] && next > left)
				// next--;
				// right = next;
				right--;
			}
		}

		return maxWater;
	}

};
