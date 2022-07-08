package src.algorithms;

import src.interfaces.Sorter;
import src.utils.ArrayHandler;

public class Insertion implements Sorter {

    private void insertionSort(int[] arr) {
        int j;
        for (int k = 1; k < arr.length; k++) {
            j = k - 1;
            while (j >= 0 && arr[j] > arr[j + 1]) {
                ArrayHandler.swap(arr, j, j + 1);
                j--;

            }
        }
    }

    public void sortArray(int[] arr) {
        insertionSort(arr);
    }

    @Override
    public void bestCase(int[] arr) {
        // when the array is already sorted.
        sortArray(arr);
    }

    @Override
    public void worstCase(int[] arr) {
        // when the array is already sorted and reversed.
        sortArray(arr);
        ArrayHandler.reverseArrayInPlace(arr);
    }
}
