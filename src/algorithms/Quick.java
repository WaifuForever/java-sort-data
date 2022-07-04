package src.algorithms;

import src.utils.ArrayHandler;
import src.utils.CustomBiArray;
import src.interfaces.Callable2;
import src.interfaces.Sorter;

public class Quick implements Sorter {
    private Callable2 comp;
    private int startIndex;

    public Quick (int startIndex) {
        this.startIndex = startIndex;
    }

    public void setCallable (Callable2 comp){
        this.comp = comp;
    }

    private int partition(CustomBiArray<String> arr, int left, int right) {
        String[] p = arr.get(left);
        int i = left + 1;
        int j = right;

        while (i <= j) {
            if (comp.call(arr.get(i), p, false))
                i++;
            else if (comp.call(p,arr.get(j), true))
                j--;
            else
                ArrayHandler.swap(arr, i, j);
        }
        ArrayHandler.swap(arr, left, j);
        return j;
    }

    private void quickSort(CustomBiArray<String> arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public void sortArray(CustomBiArray<String> arr) {
        //selectionSort(arr, func, startIndex);
        quickSort(arr, startIndex, arr.getSize() - 1);

    }

	@Override
	public void bestCase(CustomBiArray<String> arr) {
		// Best Case is when the pivot element divides the list into two equal halves by coming exactly in the middle position.
		
	}

	@Override
	public void worstCase(CustomBiArray<String> arr) {
		// Already sorted worst case occurs when the pivot element is either greatest or smallest element.
		
	}
}
