

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class NLargest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = new int[] { 5, 1, 2, 3, 6, 9, 4, 7, 8 };
		System.out.println(getNLargest(4, input));
	}

	public static List<Integer> getNLargest(int n, int[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(arr.length, Collections.reverseOrder());
		List<Integer> ret = new LinkedList<Integer>();
		if (null != arr && n > 0) {
			for (int i = 0; i < arr.length; i++) {
				pq.add(arr[i]);
			}

			for (int i = 0; i < n; i++) {
				if (pq.isEmpty())
					break;
				ret.add(pq.poll());
			}
		}

		return ret;
	}
}
