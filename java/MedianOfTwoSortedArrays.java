public class MedianOfTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = new int[] { 1, 3 };
		int[] arr2 = new int[] { 2, 4 };
		System.out.println(findMedianSortedArrays(arr1, arr2));
	}

	public static double findMedianSortedArrays(int A[], int B[]) {
		if (null == A && null == B) {
			return 0f;
		}

		double ret = 0;
		int sizeA = null == A ? 0 : A.length;
		int sizeB = null == B ? 0 : B.length;
		int curA = 0;
		int curB = 0;

		int size = sizeA + sizeB;
		if (size > 0) {
			int skip = (size - 1) / 2;
			for (int i = 0; i < skip; i++) {
				char next = 'X';
				if (null == A || curA > A.length - 1) {
					next = 'B';
				} else if (null == B || curB > B.length - 1) {
					next = 'A';
				} else {
					if (A[curA] < B[curB]) {
						next = 'A';
					} else {
						next = 'B';
					}
				}
				if (next == 'A') {
					curA++;
				} else {
					curB++;
				}
			}

			if ((size & 1) == 0 && size > 0) {
				for (int i = 0; i < 2; i++) {
					char next = 'X';
					if (null == A || curA > A.length - 1) {
						next = 'B';
					} else if (null == B || curB > B.length - 1) {
						next = 'A';
					} else {
						if (A[curA] < B[curB]) {
							next = 'A';
						} else {
							next = 'B';
						}
					}
					if (next == 'A') {
						ret += A[curA];
						curA++;
					} else {
						ret += B[curB];
						curB++;
					}
				}
				ret = ret / 2;
			} else {
				if (null == A || curA > A.length - 1) {
					return B[curB];
				} else if (null == B || curB > B.length - 1) {
					return A[curA];
				} else {
					if (A[curA] < B[curB]) {
						return A[curA];
					} else {
						return B[curB];
					}
				}
			}
		}

		return ret;
	}
}
