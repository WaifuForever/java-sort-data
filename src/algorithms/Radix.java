package src.algorithms;

import src.utils.ArrayHandler;
import src.utils.CustomBiArray;
import src.interfaces.ManagerFieldInt;
import src.interfaces.Sorter;

public class Radix implements Sorter {
    private ManagerFieldInt mfield;
    private int startIndex;

    public Radix (ManagerFieldInt mfield, int startIndex){
        this.mfield = mfield;
        this.startIndex = startIndex;
    }

    private int getMax(int[] arr) {
        int k = 0;
        for (int i = startIndex; i < arr.length - 1; i++) {
            if (k < arr[i])
                k = arr[i];
        }
        return k;
    }

    private void countingSort(CustomBiArray<String> arr, ManagerFieldInt mfield, int place) {
        int k = 0, temp = 0;

        for (int i = startIndex; i < arr.getSize(); i++) {
            temp = (mfield.call(arr.get(i)) / (int) Math.pow(10, place)) % 10;
            if (k < temp)
                k = temp;
        }
        int[] arr2 = new int[k + 1];

        int[] output = new int[arr.getSize()];

        for (int i = startIndex; i < k; i++)
            arr2[i] = 0;
        // System.out.println(Arrays.toString(arr2));
        for (int i = startIndex; i < arr.getSize(); i++) {
            arr2[(mfield.call(arr.get(i)) / (int) Math.pow(10, place)) % 10]++;
        }
        // System.out.println(Arrays.toString(arr2));

        for (int i = startIndex; i <= k; i++)
            arr2[i] = arr2[i] + arr2[i - 1];

        // System.out.println(Arrays.toString(arr2));

        for (int i = arr.getSize() - 1; i >= startIndex; i--) {
            // System.out.printf("arr[%d] = %d | arr2[%d] = %d | output[%d] = %d\n", i,
            // arr[i], arr[i], arr2[arr[i]], arr2[arr[i]], output[arr2[arr[i]]-1]);
            output[arr2[(mfield.call(arr.get(i)) / (int) Math.pow(10, place)) % 10] - 1] = mfield.call(arr.get(i));
            arr2[(mfield.call(arr.get(i)) / (int) Math.pow(10, place)) % 10]--;
        }

        for (int i = startIndex; i < arr.getSize(); i++)
            mfield.call(arr, i, output[i]);
        //for (int i = 0; i < arr.length; i++)
        //    arr[i] = output[i];
    }

    public void sortArray(CustomBiArray<String> arr) {
        int[] allInt = new int[arr.getSize()];
        for(int n = startIndex; n < arr.getSize(); n++){
            allInt[n] = mfield.call(arr.get(n));
        }
        int k = String.valueOf(getMax(allInt)).length();

        for (int i = startIndex; i < k; i++)
            countingSort(arr, mfield, i);
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
