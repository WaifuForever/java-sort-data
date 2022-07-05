package src.algorithms;

import java.util.Arrays;

import src.interfaces.Sorter;

public class Merge implements Sorter {

    private void mergeSort(Integer[] arr) {
        int length = arr.length;

        if (length < 2)
            return;

        Integer[] left = Arrays.copyOfRange(arr, 0, length / 2), right = Arrays.copyOfRange(arr, (length / 2), length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private void merge(Integer[] arr, Integer[] left, Integer[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }

            k++;

        }

        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public void sortArray(Integer[] arr) {
        mergeSort(arr);

    }
}
