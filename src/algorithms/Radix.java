package src.algorithms;

import src.interfaces.Sorter;
import src.utils.ArrayHandler;

public class Radix implements Sorter {
    private int getMax(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (k < arr[i])
                k = arr[i];
        }
        return k;
    }

    private void countingSort(int[] arr, int place) {
        int k = 0, temp = 0;

        for (int i = 0; i < arr.length; i++) {
            temp = (arr[i] / (int) Math.pow(10, place)) % 10;
            if (k < temp)
                k = temp;

        }

        int[] arr2 = new int[k + 1];

        int[] output = new int[arr.length];

        for (int i = 0; i <= k; i++)
            arr2[i] = 0;
        // System.out.println(Arrays.toString(arr2));
        for (int i = 0; i < arr.length; i++) {
            arr2[(arr[i] / (int) Math.pow(10, place)) % 10]++;

        }
        // System.out.println(Arrays.toString(arr2));

        for (int i = 1; i <= k; i++)
            arr2[i] = arr2[i] + arr2[i - 1];

        // System.out.println(Arrays.toString(arr2));

        for (int i = arr.length - 1; i >= 0; i--) {
            // System.out.printf("arr[%d] = %d | arr2[%d] = %d | output[%d] = %d\n", i,
            // arr[i], arr[i], arr2[arr[i]], arr2[arr[i]], output[arr2[arr[i]]-1]);
            output[arr2[(arr[i] / (int) Math.pow(10, place)) % 10] - 1] = arr[i];
            arr2[(arr[i] / (int) Math.pow(10, place)) % 10]--;

        }

        for (int i = 0; i < arr.length; i++)
            arr[i] = output[i];
    }

    public void sortArray(int[] arr) {
        int k = String.valueOf(getMax(arr)).length();

        for (int i = 0; i < k; i++)
            countingSort(arr, i);

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
