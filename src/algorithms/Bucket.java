package src.algorithms;

import src.interfaces.Sorter;
import src.utils.ArrayHandler;
import src.utils.CustomArray;

public class Bucket implements Sorter {
    private class intArray {
        private int size = 0;
        private int[] arr;

        intArray(int size) {
            arr = new int[size];
            this.size = size - 1;
        }

        intArray() {
            arr = new int[0];
        }

        public void add(int n) {
            if (isFull())
                doubleSize();

            arr[size] = n;
            size++;
        }

        public int get(int n) {
            if (n > size || n < 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return arr[n];
        }

        public boolean isFull() {
            return arr.length == size;
        }

        public int[] getArray() {
            return arr;
        }

        private void doubleSize() {
            int[] newArr = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }

    }

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

        CustomArray<intArray> buckets = new CustomArray<intArray>(chunkSize);

        // Create empty bucketss
        for (int i = 0; i < chunkSize; i++)
            buckets.add(new intArray());

        // Add elements into the buckets
        for (int i = 0; i < arr.length; i++)
            buckets.get((arr[i] / (int) Math.pow(chunkSize, k - 1))).add(arr[i]);

        // Sort the elements of each bucket
        for (int i = 0; i < chunkSize; i++)
            new Radix().sortArray(buckets.get(i).getArray());

        // Get the sorted array
        int index = 0;
        for (int i = 0; i < chunkSize; i++) {

            for (int j = 0, size = buckets.get(i).getArray().length; j < size; j++) {
                arr[index++] = buckets.get(i).get(j);
                // System.out.println(buckets.get(i).get(j));
            }
        }

    }

    public void bucketSort(int[] arr, int chunkSize, int skip) {

        if (chunkSize <= 0)
            return;

        int k = String.valueOf(getMax(arr)).length();

        CustomArray<intArray> buckets = new CustomArray<intArray>(chunkSize);

        // Create empty bucketss
        for (int i = 0; i < chunkSize; i++)
            buckets.add(new intArray());

        // Add elements into the buckets
        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i] % (int) (skip * Math.pow(10, k - String.valueOf(skip).length())))
                    / (int) Math.pow(chunkSize, k - String.valueOf(skip).length() - 1);
            buckets.get(index).add(arr[i]);

        }

        // Sort the elements of each bucket
        for (int i = 0; i < chunkSize; i++) {
            // ArrayHandler.printArray(buckets.get(i).getArray());
            new Radix().sortArray(buckets.get(i).getArray());

        }

        // Get the sorted array
        int index = 0;
        for (int i = 0; i < chunkSize; i++) {

            for (int j = 0, size = buckets.get(i).getArray().length; j < size; j++) {
                arr[index++] = buckets.get(i).get(j);
                // System.out.println(buckets.get(i).get(j));
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
        // is when the elements are evenly grouped in the buckets
        // linear
        sortArray(arr);
    }

    @Override
    public void worstCase(int[] arr) {
        // is when all the elements are placed in a single bucket
        // linear
        sortArray(arr);
        ArrayHandler.reverseArrayInPlace(arr);
    }
}
