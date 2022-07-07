package src.algorithms;

import src.interfaces.Sorter;
import src.utils.ArrayHandler;

public class Bubble implements Sorter {
    private void swap(Integer[] arr, int i, int j){
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }

    private void bubbleSort(Integer[] arr){
        for(int i=0; i < arr.length-1; i++){
            for(int j=0; j < arr.length-1; j++){
                if(arr[j] > arr[j+1])
                    swap(arr, j, j+1);
            }
        }
    }

    public void sortArray(Integer[] arr){
        bubbleSort(arr);
    }

    @Override
    public void bestCase(Integer[] arr) {
        // Best Case is when the pivot element divides the list into two equal halves by
        // coming exactly in the middle position.
        sortArray(arr);
    }

    @Override
    public void worstCase(Integer[] arr) {
        // Already sorted worst case occurs when the pivot element is either greatest or
        // smallest element.
        // The current implementation will already perform the worstcase when the array
        // is already sorted
        sortArray(arr);
        ArrayHandler.reverseArrayInPlace(arr);
    }
}
