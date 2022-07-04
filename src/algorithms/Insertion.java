package src.algorithms;

import src.interfaces.Callable2;
import src.interfaces.Sorter;
import src.utils.ArrayHandler;
import src.utils.CustomBiArray;

public class Insertion implements Sorter {
    private Callable2 comp;
    private int startIndex;

    public Insertion (int startIndex) {
        this.startIndex = startIndex;
    }

    public void setCallable (Callable2 comp){
        this.comp = comp;
    }

    private void insertionSort(CustomBiArray<String> arr) {
        int j;
        for (int k = 1; k < arr.getSize(); k++) {
            j = k - 1;
             
            while (j >= startIndex && (comp.call(arr.get(j+1), arr.get(j), false))) {
                ArrayHandler.swap(arr, j, j + 1);
                j--;

            }
        }
    }

	public void sortArray(CustomBiArray<String> arr) {
		  insertionSort(arr);

	}

	@Override
	public void bestCase(CustomBiArray<String> arr) {
		// the array is already sorted
		
	}

	@Override
	public void worstCase(CustomBiArray<String> arr) {
		// inversely sorted Array
		
	}
}
