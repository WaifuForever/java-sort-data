package src.algorithms;

import src.interfaces.Sorter;
//import src.utils.ArrayHandler;

public class Quick implements Sorter {
    private void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }

    private int partition(int[] arr, int left, int right) {
        int p = arr[left];
        int i = left + 1;
        int j = right;

        while (i <= j) {
            if (arr[i] <= p)
                i++;
            else if (arr[j] > p)
                j--;
            else
                swap(arr, i, j);
        }
        swap(arr, left, j);
        return j;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public void sortArray(int[] arr) {
        quickSort(arr, 0, arr.length - 1);

    }

    @Override
    public void bestCase(int[] arr) {
        // Best Case is when the pivot element divides the list into two equal halves by
        // coming exactly in the middle position.
        partition(arr, 0, arr.length - 1);

    }

    @Override
    public void worstCase(int[] arr) {
        // Already sorted worst case occurs when the pivot element is either greatest or
        // smallest element.
        // The current implementation will already perform the worstcase when the array
        // is already sorted
        sortArray(arr);

    }
}
