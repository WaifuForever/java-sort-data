package src.algorithms;

import src.interfaces.Sorter;
import src.utils.ArrayHandler;

public class Insertion implements Sorter {
    private void insertionSort(int[] arr) {
        int j, key;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                // System.out.printf("[%d == %d]\n", arr[i], key);
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

    }

    public void sortArray(int[] arr) {
        insertionSort(arr);

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
