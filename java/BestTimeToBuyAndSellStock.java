public class BestTimeToBuyAndSellStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock ins = new BestTimeToBuyAndSellStock();
		int[] input = new int[] { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5 };
		System.out.println(ins.maxProfit(input));
	}

	public int maxProfit(int[] prices) {
		// check the input
		if (null == prices || prices.length <= 0)
			return 0;

		// from right to left, save the highest price that can be sell after that point
		int size = prices.length;
		int[] highArr = new int[size];
		int max = prices[size - 1];
		for (int i = size - 1; i >= 0; i--) {
			if (prices[i] > max)
				max = prices[i];
			highArr[i] = max;
		}

		// from left to right, the profit is the highest price minus current price, get the max
		int maxProfit = highArr[0] - prices[0];
		for (int i = 0; i < size; i++) {
			int profit = highArr[i] - prices[i];
			maxProfit = Math.max(maxProfit, profit);
		}

		return maxProfit;
	}

}
