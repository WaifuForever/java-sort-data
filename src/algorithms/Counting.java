package src.algorithms;

import src.interfaces.Callable2;
import src.utils.CustomBiArray;

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

  	@Override
	public <T> void sortArray(CustomBiArray<T> arr, Callable2 func) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bestCase(CustomBiArray<String> arr) {
		// when the elements are suited for countingSort
		
	}

	@Override
	public void worstCase(CustomBiArray<String> arr) {
		// when the range k of the elements is significantly larger than the other elements
		
	}
}
