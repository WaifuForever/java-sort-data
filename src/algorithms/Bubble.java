package src.algorithms;

import src.interfaces.Sorter;
import src.utils.ArrayHandler;

public class Bubble implements Sorter {

    private void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1])
                    ArrayHandler.swap(arr, j, j + 1);
            }
        }
    }

    public void sortArray(int[] arr) {
        bubbleSort(arr);
    }

    @Override
    public void bestCase(int[] arr) {
        // when the array is already sorted
        sortArray(arr);
    }

    @Override
    public void worstCase(int[] arr) {
       // reversed sorted array
        sortArray(arr);
        ArrayHandler.reverseArrayInPlace(arr);
    }
}
