package src.algorithms;

import src.interfaces.Sorter;

public class Counting implements Sorter {

    private void countingSort(Integer[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (k < arr[i])
                k = arr[i];
        }
        Integer[] arr2 = new Integer[k + 1];
        Integer[] output = new Integer[arr.length];

        for (int i = 0; i <= k; i++)
            arr2[i] = 0;

        for (int i = 0; i < arr.length; i++) {
            arr2[arr[i]]++;
        }

        for (int i = 1; i <= k; i++)
            arr2[i] = arr2[i] + arr2[i - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            // System.out.printf("arr[%d] = %d | arr2[%d] = %d | output[%d] = %d\n", i,
            // arr[i], arr[i], arr2[arr[i]], arr2[arr[i]], output[arr2[arr[i]]-1]);
            output[arr2[arr[i]] - 1] = arr[i];
            arr2[arr[i]]--;

        }

        for (int i = 0; i < arr.length; i++)
            arr[i] = output[i];
    }

    public void sortArray(Integer[] arr) {
        countingSort(arr);

    }
}
