public class BestTimeToBuyAndSellStock3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock3 ins = new BestTimeToBuyAndSellStock3();
		int[] input = new int[] { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5 };
		System.out.println(ins.maxProfit(input));
	}

	public int maxProfit(int[] prices) {
		// check the input
		if (null == prices || prices.length <= 0)
			return 0;

		// @formatter:off
		/*
		use dynamic programming, the 1st row is the money we have if buy at the price, the 2nd is if sell
		the 3 arrays are P(n), B(n), and S(n)

		if only one transaction is allowed
		B(n) = max(B(n-1), 0-P(n))
		S(n) = max(S(n-1), B(n-1)+P(n))
		prices:           | 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5 
		if buy: MIN_VALUE |-3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1
		if sell:        0 | 0, 0, 3, 3, 4, 8, 8, 8, 8, 8, 8 (at price = 9, it's max(4, -1+9) = 8)
		
		if two transactions is allowed, we need 2 more rows, 2nd buy, and 2nd sell
		B1(n) = max(B1(n-1), 0-P(n))
		S1(n) = max(S1(n-1), B1(n-1)+P(n))
		B2(n) = max(B2(n-1), S1(n-1)-P(n))
		S2(n) = max(S2(n-1), B2(n-1)+P(n))
		prices:            | 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5 
		1st buy: MIN_VALUE |-3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1
		1st sell:        0 | 0, 0, 3, 3, 4, 8, 8, 8, 8, 8, 8 
		2nd buy: MIN_VALUE |-3,-1,-1, 2, 2, 2, 6, 6, 6, 6, 6 (at price = 2, it's max(2, 8-2) = 6)
		2nd sell:        0 | 0, 0, 3, 3, 7,11,11,12,12,12,12 (at price = 9, it's max(7, 2+9) = 11)
		
		More over, since column n only depends on n-1, we need 2 columns in total
		*/
		// @formatter:on
		final int B1 = 0;
		final int S1 = 1;
		final int B2 = 2;
		final int S2 = 3;

		int[][] status = new int[2][4];
		int prev = 0;
		int cur = 1;
		int size = prices.length;
		status[prev][B1] = Integer.MIN_VALUE;
		status[prev][S1] = 0;
		status[prev][B2] = Integer.MIN_VALUE;
		status[prev][S2] = 0;

		for (int i = 0; i < size; i++) {
			int p = prices[i];
			status[cur][B1] = Math.max(status[prev][B1], 0 - p);
			status[cur][S1] = Math.max(status[prev][S1], status[prev][B1] + p);
			status[cur][B2] = Math.max(status[prev][B2], status[prev][S1] - p);
			status[cur][S2] = Math.max(status[prev][S2], status[prev][B2] + p);

			for (int j = 0; j < 4; j++) {
				System.out.print(status[cur][j] + " , ");
			}
			System.out.println();

			int temp = prev;
			prev = cur;
			cur = temp;
		}

		return Math.max(status[prev][S2], status[cur][S2]);
	}
}
