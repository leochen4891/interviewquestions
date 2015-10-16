package org.leochen.algorithms;

import java.util.Arrays;
import java.util.Random;

public class Sortings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		int testCount = 10;

		boolean pass = true;
		for (int count = 0; count < testCount; count++) {
			int testSize = rand.nextInt(100);
			int[] arr = null;
			if (0 != testSize)
				arr = new int[testSize];

			for (int i = 0; i < testSize; i++) {
				arr[i] = rand.nextInt(1 + testSize);
			}
			// System.out.println(Arrays.toString(arr));
			int[] sorted = null;
			sorted = insertSort(arr);
			sorted = selectionSort(arr);
			sorted = mergeSort(arr);
			sorted = quickSort(arr);
			sorted = heapSort(arr);
			// System.out.println(Arrays.toString(sorted));
			if (!verify(sorted)) {
				pass = false;
				System.out.println(Arrays.toString(sorted));
				break;
			}
			// System.out.println();
		}
		System.out.println(pass ? "Pass" : "Failed");
	}

	public static int[] heapSort(int[] input) {
		int[] heap = heapSortBuildHeap(input, input.length);
		int[] sorted = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			sorted[i] = getMin(heap, input.length - i);
		}
		return sorted;
	}

	private static void swim(int[] arr, int i, int size) {
		if (i <= 0 || i >= size)
			return;
		int parent = (i - 1) / 2;
		if (arr[i] < arr[parent])
			swap(arr, i, parent);
		swim(arr, parent, size);
	}

	private static void sink(int[] arr, int i, int size) {
		if (i < 0 || i >= size)
			return;
		int leftChild = i * 2 + 1;
		int rightChild = leftChild + 1;
		int min = i;
		if (leftChild < size && arr[leftChild] < arr[min])
			min = leftChild;
		if (rightChild < size && arr[rightChild] < arr[min])
			min = rightChild;

		if (min != i) {
			swap(arr, i, min);
			sink(arr, min, size);
		}
	}

	private static int[] heapSortBuildHeap(int[] input, int size) {
		for (int i = input.length - 1; i >= 0; i--) {
			sink(input, i, size);
			// System.out.println(i + ", " + Arrays.toString(input));
		}
		return input;
	}

	private static int getMin(int[] heap, int size) {
		if (size <= 0)
			return Integer.MIN_VALUE;
		int ret = heap[0];
		heap[0] = heap[size - 1];
		sink(heap, 0, size - 1);
		return ret;
	}

	public static int[] quickSort(int[] input) {
		if (null == input || input.length <= 1) {
			return input;
		}

		quickSortPartition(input, 0, input.length);
		return input;
	}

	public static void quickSortPartition(int[] arr, int l, int r) {
		if (l >= r || l < 0 || r >= arr.length)
			return;

		// LAME DESIGN: pick the last element as the pivot
		int key = arr[r];
		int write = l;
		for (int i = l; i < r; i++) {
			if (arr[i] > key) {
				continue;
			} else {
				swap(arr, write, i);
				write++;
			}
		}
		swap(arr, write, r);
		quickSortPartition(arr, l, write - 1);
		quickSortPartition(arr, write + 1, r);
	}

	public static int[] mergeSort(int[] input) {
		if (null == input || input.length <= 1)
			return input;
		mergeSortHelper(input, 0, input.length - 1);
		return input;
	}

	public static void mergeSortHelper(int[] arr, int l, int r) {
		if (l >= r)
			return;

		int mid = (l + r) / 2;
		mergeSortHelper(arr, l, mid);
		mergeSortHelper(arr, mid + 1, r);
		int[] buffer = new int[(r - l) + 1];
		int write = 0;
		int lread = l;
		int rread = mid + 1;
		while (lread <= mid && rread <= r) {
			if (arr[lread] <= arr[rread]) {
				buffer[write] = arr[lread];
				lread++;
			} else {
				buffer[write] = arr[rread];
				rread++;
			}
			write++;
		}
		while (lread <= mid) {
			buffer[write] = arr[lread];
			write++;
			lread++;
		}
		while (rread <= r) {
			buffer[write] = arr[rread];
			write++;
			rread++;
		}
		for (int i = 0; i < r - l + 1; i++) {
			arr[l + i] = buffer[i];
		}
	}

	public static int[] selectionSort(int[] input) {
		if (null == input || input.length <= 1)
			return input;

		for (int i = 0; i < input.length; i++) {
			int min = i;
			for (int j = i + 1; j < input.length; j++) {
				if (input[j] < input[min]) {
					min = j;
				}
				swap(input, min, i);
			}
		}
		return input;
	}

	public static int[] insertSort(int[] input) {
		if (null == input || input.length <= 1)
			return input;

		for (int i = 1; i < input.length; i++) {
			int cur = i;
			while (cur >= 1 && (input[cur] < input[cur - 1])) {
				swap(input, cur, cur - 1);
				cur--;
			}
		}
		return input;
	}

	public static boolean verify(int[] arr) {
		if (null == arr || arr.length <= 1)
			return true;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1])
				return false;
		}
		return true;
	}

	public static void swap(int[] arr, int i, int j) {
		if (null == arr || i < 0 || j < 0 || i >= arr.length || j >= arr.length)
			return;

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
