package src.algorithms;

import src.interfaces.Sorter;
import src.utils.ArrayHandler;

public class Insertion2 implements Sorter {
    private void swap(Integer[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }

    private void insertionSort(Integer[] arr) {
        int j;
        for (int k = 1; k < arr.length; k++) {
            j = k - 1;
            while (j >= 0 && arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
                j--;

            }
        }
    }

    public void sortArray(Integer[] arr) {
        insertionSort(arr);
    }

    @Override
    public void bestCase(Integer[] arr) {
        // Best Case is when the pivot element divides the list into two equal halves by
        // coming exactly in the middle position.
        sortArray(arr);
    }

    @Override
    public void worstCase(Integer[] arr) {
        // Already sorted worst case occurs when the pivot element is either greatest or
        // smallest element.
        // The current implementation will already perform the worstcase when the array
        // is already sorted
        sortArray(arr);
        ArrayHandler.reverseArrayInPlace(arr);
    }
}
