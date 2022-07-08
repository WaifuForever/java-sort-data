package src.algorithms;

import src.interfaces.Sorter;
import src.utils.ArrayHandler;
import src.utils.CustomArray;

public class Bucket implements Sorter {

    private int getMax(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (k < arr[i])
                k = arr[i];
        }
        return k;
    }

    public void bucketSort(int[] arr, int chunkSize) {

        if (chunkSize <= 0)
            return;

        int k = String.valueOf(getMax(arr)).length();

        CustomArray<CustomArray<Integer>> buckets = new CustomArray<>(chunkSize);

        // Create empty bucketss
        for (int i = 0; i < chunkSize; i++)
            buckets.add(new CustomArray<>());

        // Add elements into the buckets
        for (int i = 0; i < arr.length; i++) {
            buckets.get((arr[i] / (int) Math.pow(chunkSize, k - 1))).add(arr[i]);
            
        }

        // Sort the elements of each bucket
        for (int i = 0; i < chunkSize; i++) {
            System.out.println("here");
            ArrayHandler.printArray(buckets.get(i).getArray());
            
            System.out.println("here2");
            new Radix().sortArray((buckets.get(i).getArray()));
        }

        // Get the sorted array
        int index = 0;
        for (int i = 0; i < chunkSize; i++) {
            for (int j = 0, size = buckets.get(i).getArray().length; j < size; j++) {
                arr[index++] = buckets.get(i).get(j);
            }
        }
    }

    /*
     * It is not suitable for sorting arbitrary strings.
     * It is only good for sorting data uniformly distributed over the range [0, 1].
     * It is not an in-place sorting because the buckets require additional space to
     * be sorted.
     * It is ineffective if we have a huge array since it increases the cost.
     */
    public void sortArray(int[] arr) {
        bucketSort(arr, 10);
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
