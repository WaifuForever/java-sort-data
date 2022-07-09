package src.algorithms;

import src.interfaces.Sorter;
import src.utils.ArrayHandler;

public class Counting implements Sorter {

    private void countingSort(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (k < arr[i])
                k = arr[i];
        }
        int[] arr2 = new int[k + 1];
        int[] output = new int[arr.length];

        for (int i = 0; i <= k; i++)
            arr2[i] = 0;

        for (int i = 0; i < arr.length; i++) {
            arr2[arr[i]]++;
        }

        for (int i = 1; i <= k; i++)
            arr2[i] = arr2[i] + arr2[i - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            output[arr2[arr[i]] - 1] = arr[i];
            arr2[arr[i]]--;

        }

        for (int i = 0; i < arr.length; i++)
            arr[i] = output[i];
    }

    public void sortArray(int[] arr) {
        countingSort(arr);

    }

    @Override
    public void bestCase(int[] arr) {
        //CONSTANT the smaller the elements the better
        sortArray(arr);
    }

    @Override
    public void worstCase(int[] arr) {
        //CONSTANT the bigger the elements the worst
        sortArray(arr);
        ArrayHandler.reverseArrayInPlace(arr);
    }
}
