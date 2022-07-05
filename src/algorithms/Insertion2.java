package src.algorithms;

public class Insertion2 implements Sorter {
    private void swap(Integer[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }

    private void insertionSort(Integer[] arr) {
        int j;
        for (int k = 1; k < arr.length; k++) {
            j = k - 1;
            while (j >= 0 && arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
                j--;

            }
        }
    }

    public void sortArray(Integer[] arr) {
        insertionSort(arr);

    }
}
