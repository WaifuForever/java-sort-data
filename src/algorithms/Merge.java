package src.algorithms;

import java.util.Arrays;

import src.interfaces.Sorter;

public class Merge implements Sorter {
    private class PermutateWorstCase {

        // Function to join left and right subarray
        public void join(int arr[], int left[], int right[],
                int l, int m, int r) {
            int i;
            for (i = 0; i <= m - l; i++)
                arr[i] = left[i];

            for (int j = 0; j < r - m; j++)
                arr[i + j] = right[j];
        }

        // Function to store alternate elements in left
        // and right subarray
        void split(int arr[], int left[], int right[],
                int l, int m, int r) {
            for (int i = 0; i <= m - l; i++)
                left[i] = arr[i * 2];

            for (int i = 0; i < r - m; i++)
                right[i] = arr[i * 2 + 1];
        }

        // Function to generate Worst Case of Merge Sort
        void generateWorstCase(int arr[], int l, int r) {
            if (l < r) {
                int m = l + (r - l) / 2;

                // create two auxiliary arrays
                int[] left = new int[m - l + 1];
                int[] right = new int[r - m];

                // Store alternate array elements in left
                // and right subarray
                split(arr, left, right, l, m, r);

                // Recurse first and second halves
                generateWorstCase(left, l, m);
                generateWorstCase(right, m + 1, r);

                // join left and right subarray
                join(arr, left, right, l, m, r);
            }
        }
    }

    private void mergeSort(int[] arr) {
        int length = arr.length;

        if (length < 2)
            return;

        int[] left = Arrays.copyOfRange(arr, 0, length / 2), right = Arrays.copyOfRange(arr, (length / 2), length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private void merge(int[] arr, int[] left, int[] right) {
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

    public void sortArray(int[] arr) {
        mergeSort(arr);

    }

    @Override
    public void bestCase(int[] arr) {
        // we would need a permutation that allows the merge sort to make fewest swaps possible
    }

    @Override
    public void worstCase(int[] arr) {
        new PermutateWorstCase().generateWorstCase(arr, 0, arr.length - 1);

    }
}
