

import java.util.Collection;
import java.util.LinkedList;

public class MatrixStringFinder {
	private static int ROW = 5;
	private static int COL = 5;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] matrix = "ACPRCXSOPCVOVNIWGFMNQATIT".toCharArray();
		System.out.println(findString(matrix, "MICROSOFT"));
		System.out.println(findString(matrix, "MICROHARD"));
		System.out.println(findString(matrix, "GIANTSOFT"));
	}

	public static boolean findString(char[] matrix, String target) {
		if (null == target || target.length() <= 0)
			return true;
		char c = target.charAt(0);
		String subTarget = target.substring(1);

		for (int i = 0; i < ROW * COL; i++) {
			if (c == matrix[i]) {
				boolean found = findString(matrix, i, subTarget);
				if (found)
					return true;
			}
		}
		return false;
	}

	private static boolean findString(char[] matrix, int start, String target) {
		if (null == target || target.length() <= 0)
			return true;

		char c = target.charAt(0);
		String subTarget = target.substring(1);
		for (int i : getNeighbors(start)) {
			if (c == matrix[i]) {
				boolean found = findString(matrix, i, subTarget);
				if (found)
					return true;
			}
		}
		return false;
	}

	private static Collection<Integer> getNeighbors(int center) {
		LinkedList<Integer> ret = new LinkedList<Integer>();
		if (center < 0 || center >= ROW * COL)
			return null;
		int row = center / COL;
		int col = center % COL;
		int index;
		// up
		index = getIndexFromRowCol(row - 1, col);
		if (index >= 0)
			ret.add(index);
		index = getIndexFromRowCol(row + 1, col);
		if (index >= 0)
			ret.add(index);
		index = getIndexFromRowCol(row, col - 1);
		if (index >= 0)
			ret.add(index);
		index = getIndexFromRowCol(row, col + 1);
		if (index >= 0)
			ret.add(index);
		index = getIndexFromRowCol(row - 1, col - 1);
		if (index >= 0)
			ret.add(index);
		index = getIndexFromRowCol(row + 1, col + 1);
		if (index >= 0)
			ret.add(index);
		index = getIndexFromRowCol(row - 1, col + 1);
		if (index >= 0)
			ret.add(index);
		index = getIndexFromRowCol(row + 1, col - 1);
		if (index >= 0)
			ret.add(index);
		return ret;
	}

	private static int getIndexFromRowCol(int row, int col) {
		if (row < 0 || col < 0 || row >= ROW || col >= COL)
			return -1;
		return row * COL + col;
	}
}