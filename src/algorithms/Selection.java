package src.algorithms;

import src.utils.ArrayHandler;
import src.utils.CustomBiArray;
import src.interfaces.Callable2;
import src.interfaces.Sorter;

public class Selection implements Sorter {
    private Callable2 comp;
    private int startIndex;

    public Selection (int startIndex) {
        this.startIndex = startIndex;
    }

    public void setCallable (Callable2 comp){
        this.comp = comp;
    }

    private void selectionSort(CustomBiArray<String> arr) {
        for (int i = startIndex; i < arr.getSize() - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.getSize(); j++) {
                // System.out.printf("%d > %d\n", arr[smallest], arr[j]);
                if (comp.call(arr.get(j), arr.get(smallest), true)){
                    smallest = j;
                }
            }
            // System.out.printf("smallest: %d [%d]", arr[smallest], smallest);
            System.out.printf("%d, %d\n", smallest, i);
            ArrayHandler.swap(arr, smallest, i);
            // System.out.printf("%s\n", Arrays.toString(arr));

        }
        // System.out.println();

    }
    // String [][] arr = [{value: "dasdas", index: 0}...]
    // String [][] arr = [{"0", "daD32sdas", "5", "17-02-2022", "2"}...]
    // String [][] arr = [{"0", "daD32sdas", "5", "17-02-2022", "2"}...]



    /*private <T> void selectionSort(String[][] arr, Callable func) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                // System.out.printf("%d > %d\n", arr[smallest], arr[j]);
                if (func.call(arr[smallest], arr[j]), true){
                    smallest = j;
            }
            // System.out.printf("smallest: %d [%d]", arr[smallest], smallest);
            swap(arr, smallest, i);
            // System.out.printf("%s\n", Arrays.toString(arr));

        }
        // System.out.println();

    }*/

    public void sortArray(CustomBiArray<String> arr) {
        selectionSort(arr);
    }

	@Override
	public void bestCase(CustomBiArray<String> arr) {
		// array already sorted
		
	}

	@Override
	public void worstCase(CustomBiArray<String> arr) {
		// reversed array
		
	}
}
