package src.algorithms;

import java.util.Arrays;
import java.util.Random;

import src.interfaces.Sorter;
import src.utils.ArrayHandler;

public class MedianQuickSort implements Sorter{

	public static int n = 16;// Controls size of array
	static int numSwaps = 0;
	static int numComps = 0;

	/*public static void main(String[] args) {
		int arr[] = { -3, 9, 6, 11, 4, 55, 60 };
		// int arr[] = new int[n];
		int n = arr.length - 1;
		// Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			// arr[i] = rand.nextInt(100);
		}

		System.out.println("\n\n unsorted array:");
		printArray(arr);
		System.out.println();
		medianQuickSort(arr, 0, n);
		System.out.println("\n\n sorted array:");
		printArray(arr);
		System.out.println("\n\tSwaps: " + numSwaps);
		System.out.println("\tComparisons: " + numComps);
	}*/

	public static int medianPivot(int arr[], int low, int high) {
		/*
		 * create subarray with low, high, and middle elements in the array sort the
		 * subarray and use index 1 as the median of 3
		 */

		int first = arr[low];
		int last = arr[arr.length - 1];
		int mid = (high) / 2;

		System.out.println("\tMiddle of Arr at Index= " + mid + " : " + arr[mid]);
		int[] sortingArr = { arr[low], arr[mid], arr[high] };

		Arrays.sort(sortingArr);

		int middleValue = sortingArr[1];
		System.out.println("\t" + Arrays.toString(sortingArr));
		// printArray(sortingArr);

		// swap with the last to serve as pivot
		int temp = arr[high];
		arr[high] = middleValue;
		if (middleValue == arr[low]) {
			arr[low] = temp;
		} else if (middleValue == arr[mid]) {
			arr[mid] = temp;
		}

		// System.out.println("median: ");
		return partition(arr, low, high);
	}

	// ----------------------------------------------------------------------
	/* method for medianQuicksort */
	public void sortArray(int arr[]) {
		if (0 >= arr.length)
			return;
		if (0 < arr.length) {
			int pi = medianPivot(arr, 0, arr.length);
			QuickSort(arr, 0, arr.length);
		}
	}

	// -----------------------------------------------------------------------
	public static void QuickSort(int arr[], int low, int high) {

		if (low < high) {
			int pi = partition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			QuickSort(arr, low, pi - 1);
			QuickSort(arr, pi + 1, high);
		}
	}

	// -----------------------------------------------------------------------
	public static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element

		for (int j = low; j < high; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (arr[j] <= pivot) {
				i++;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				numSwaps++;
			}
			numComps++;
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		numSwaps++;
		return i + 1;
	}

    @Override
    public void bestCase(int[] arr) {
        // Best Case is when the pivot element divides the list into two equal halves by
        // coming exactly in the middle position.
        sortArray(arr);
    }

    @Override
    public void worstCase(int[] arr) {
        // Already sorted worst case occurs when the pivot element is either greatest or
        // smallest element.
        // The current implementation will already perform the worstcase when the array
        // is already sorted
        sortArray(arr);
        ArrayHandler.reverseArrayInPlace(arr);
    }
}
