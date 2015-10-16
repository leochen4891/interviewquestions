

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FourNumSum {
	private static final int NUM_COUNT = 4;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		int k = 1000;

		List<Entry> ret = findFourNumSum(input, k);
		System.out.println(" = = = = = result = = = = =");
		System.out.println(ret);
	}

	public static List<Entry> findFourNumSum(int[] arr, int k) {
		List<Entry> ret = new LinkedList<Entry>();
		if (null == arr)
			return ret;

		// Set<Entry> entries = Collections.newSetFromMap(new ConcurrentHashMap<Entry, Boolean>());
		Queue<Entry> entries = new ConcurrentLinkedQueue<Entry>();
		Entry initEntry = new Entry(k);
		entries.add(initEntry);

		int count = 0;
		while (!entries.isEmpty()) {
			Entry entry = entries.remove();
			if (entry.count >= NUM_COUNT) {
				break;
			}

			// try subtract each number on the entry
			for (int i = 0; i < arr.length; i++) {
				count++;
				if (entry.comp >= arr[i]) {
					Entry newEntry = new Entry(entry);
					boolean success = newEntry.subtract(i, arr[i]);
					if (true == success) {
						if (newEntry.count == NUM_COUNT && newEntry.comp == 0) {
							ret.add(newEntry);
						}
						entries.add(newEntry);
					}
				}
			}
		}
		return ret;
	}
}

class Entry {
	public int k;
	public int comp;
	public int count;
	public Set<Integer> indices;
	public List<Integer> values;

	public Entry(Entry e) {
		this.k = e.k;
		this.comp = e.comp;
		this.count = e.count;
		this.indices = new HashSet<Integer>(e.indices);
		this.values = new LinkedList<Integer>(e.values);
	}

	public Entry(int k) {
		this.k = k;
		this.comp = k;
		this.count = 0;
		this.indices = new HashSet<Integer>();
		this.values = new LinkedList<Integer>();
	}

	public boolean subtract(int index, int value) {
		if (this.indices.contains(index))
			return false;

		this.comp -= value;
		this.count++;
		this.indices.add(index);
		this.values.add(value);

		return true;
	}

	public String toString() {
		String ret = k + " - ";
		for (int i = 0; i < count; i++) {
			ret += values.get(i);
			if (i < count - 1) {
				ret += " - ";
			}
		}
		ret += " = " + this.comp;
		return ret;
	}
}
