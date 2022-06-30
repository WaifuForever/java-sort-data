package src.algorithms;

public class Counting implements Sorter {

    private void countingSort(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (k < arr[i])
                k = arr[i];
        }
        int[] arr2 = new int[k + 1];
        int[] output = new int[arr.length];

        for (int i = 0; i < k; i++)
            arr2[i] = 0;
        // System.out.println(Arrays.toString(arr2));
        for (int i = 0; i < arr.length; i++) {
            arr2[arr[i]]++;
        }
        // System.out.println(Arrays.toString(arr2));

        for (int i = 1; i <= k; i++)
            arr2[i] = arr2[i] + arr2[i - 1];

        // System.out.println(Arrays.toString(arr2));

        for (int i = arr.length - 1; i >= 0; i--) {
            // System.out.printf("arr[%d] = %d | arr2[%d] = %d | output[%d] = %d\n", i,
            // arr[i], arr[i], arr2[arr[i]], arr2[arr[i]], output[arr2[arr[i]]-1]);
            output[arr2[arr[i]] - 1] = arr[i];
            arr2[arr[i]]--;

        }

        for (int i = 0; i < arr.length; i++)
            arr[i] = output[i];
    }

    public void sortArray(int[] arr) {
        countingSort(arr);

    }
}
