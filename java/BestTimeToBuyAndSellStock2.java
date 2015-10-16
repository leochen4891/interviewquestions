public class BestTimeToBuyAndSellStock2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock2 ins = new BestTimeToBuyAndSellStock2();
		int[] input = new int[] { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5 };
		System.out.println(ins.maxProfit(input));
	}

	public int maxProfit(int[] prices) {
		// check the input
		if (null == prices || prices.length <= 1)
			return 0;

		// the total profit will be all the rising edges
		// save first price when started increasing, and get profit when decreasing or end
		int maxProfit = 0;
		int size = prices.length;
		int startPoint = 0;
		for (int i = 1; i < size; i++) {
			if (prices[i] < prices[i - 1]) { // last one is the highest
				maxProfit += Math.max(0, prices[i - 1] - prices[startPoint]);
				startPoint = i;
			}
		}
		if (startPoint < size - 1) {
			maxProfit += Math.max(0, prices[size - 1] - prices[startPoint]);
		}

		return maxProfit;
	}

}
