package src.algorithms;

import java.util.Arrays;

public class MedianQuickSort {

	public static int medianPivot(int arr[], int low, int high) {
		/*
		 * create subarray with low, high, and middle elements in the array sort the
		 * subarray and use index 1 as the median of 3
		 */

		
		int mid = (high) / 2;

		int[] sortingArr = { arr[low], arr[mid], arr[high] };

		Arrays.sort(sortingArr);

		int middleValue = sortingArr[1];

		int temp = arr[high];
		arr[high] = middleValue;
		if (middleValue == arr[low]) {
			arr[low] = temp;
		} else if (middleValue == arr[mid]) {
			arr[mid] = temp;
		}

	
		return partition(arr, low, high);
	}

	
	public static void medianQuickSort(int arr[], int low, int high) {
		if (low >= high)
			return;
		if (low < high) {
			int pi = medianPivot(arr, low, high);
			QuickSort(arr, low, high);
		}
	}

	public static void QuickSort(int arr[], int low, int high) {

		if (low < high) {
			int pi = partition(arr, low, high);

			
			QuickSort(arr, low, pi - 1);
			QuickSort(arr, pi + 1, high);
		}
	}

	public static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);

		for (int j = low; j < high; j++) {
		
			if (arr[j] <= pivot) {
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
			}
			
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

	@Override
	public void bestCase(CustomBiArray<String> arr) {
		// Best Case is when the pivot element divides the list into two equal halves by coming exactly in the middle position.
		
	}

	@Override
	public void worstCase(CustomBiArray<String> arr) {
		// Already sorted worst case occurs when the pivot element is either greatest or smallest element.
		
	}
}
