package src.algorithms;

import src.interfaces.Sorter;
import src.utils.ArrayHandler;

public class MedianQuickSort implements Sorter {

	public static void quickSort(int[] arr, int low, int high) {
		if (high - low + 1 <= 3)
			new Bubble().sortArray(arr);
		else {
			int pivot = partitionIt(arr, low, high, medianOf3(arr, low, high));
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	public static int medianOf3(int[] arr, int low, int high) {
		int mid = (low + high) / 2;

		if (arr[low] > arr[mid])
			ArrayHandler.swap(arr, low, mid);

		if (arr[low] > arr[high])
			ArrayHandler.swap(arr, low, high);

		if (arr[mid] > arr[high])
			ArrayHandler.swap(arr, mid, high);

		ArrayHandler.swap(arr, mid, high - 1);
		return arr[high - 1];
	}

	public static int partitionIt(int[] arr, int low, int high, double pivot) {
		int highPtr = high - 1;

		while (true) {
			while (arr[++low] < pivot)
				;
			while (arr[--highPtr] > pivot)
				;
			if (low >= highPtr)
				break;
			else
				ArrayHandler.swap(arr, low, highPtr);
		}
		ArrayHandler.swap(arr, low, high - 1);
		return low;
	}

	@Override
	public void bestCase(int[] arr) {
		// Best Case is when the pivot element divides the list into two equal halves by
		// coming exactly in the middle position.
		// partition(arr, 0, medianPivot(arr, 0, arr.length - 1));

	}

	@Override
	public void worstCase(int[] arr) {
		// Already sorted worst case occurs when the pivot element is either greatest or
		// smallest element.
		// The current implementation can't perform the worstcase
		// because the pivot is defined by the algorithm
		sortArray(arr);

	}

	@Override
	public void sortArray(int[] arr) {
		quickSort(arr, 0, arr.length - 1);

	}
}
