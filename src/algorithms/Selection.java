package src.algorithms;

import src.interfaces.Sorter;
import src.utils.ArrayHandler;

public class Selection implements Sorter {
    private void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }

    private void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                // System.out.printf("%d > %d\n", arr[smallest], arr[j]);
                if (arr[smallest] > arr[j])
                    smallest = j;

            }
            // System.out.printf("smallest: %d [%d]", arr[smallest], smallest);
            swap(arr, smallest, i);
            // System.out.printf("%s\n", Arrays.toString(arr));

        }
        // System.out.println();

    }

    public void sortArray(int[] arr) {
        selectionSort(arr);

    }

    @Override
    public void bestCase(int[] arr) {
        // array already sorted
        sortArray(arr);
        
    }

    @Override
    public void worstCase(int[] arr) {
        // reversed array
        sortArray(arr);
        ArrayHandler.reverseArrayInPlace(arr);
    }
}
