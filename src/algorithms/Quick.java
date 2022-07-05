package src.algorithms;

import src.interfaces.Sorter;

public class Quick implements Sorter {
    private void swap(Integer[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }

    private int partition(Integer[] arr, int left, int right) {
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

    private void quickSort(Integer[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public void sortArray(Integer[] arr) {
        quickSort(arr, 0, arr.length - 1);

    }
}
