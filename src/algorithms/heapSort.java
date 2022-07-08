package src.algorithms;

import src.interfaces.Sorter;
import src.utils.ArrayHandler;

import java.util.Arrays;

public class heapSort implements Sorter {

    /*public static void main(String[] args) {

        int[] dados = { 16, 7, 22, 3, 19, 9, 36, 11 };

        heapSort heap = new heapSort();
        heap.sortArray(dados, dados.length);
        System.out.println(Arrays.toString(dados));
    }*/

    public void sortArray(int[] dados) {
        for (int i = dados.length / 2 - 1; i >= 0; i--) {
            montar(dados, dados.length, i);
        }
        for (int i = dados.length - 1; i >= 0; i--) {
            int time = dados[0];
            dados[0] = dados[i];
            dados[i] = time;
            montar(dados, i, 0);
        }
    }

    public void montar(int[] dados, int size, int i) {
        int largest = i;
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;

        if (left < size && dados[left] > dados[largest]) {
            largest = left;
        }
        if (right < size && dados[right] > dados[largest]) {
            largest = right;
        }
        if (largest != i) {
            int time = dados[i];
            dados[i] = dados[largest];
            dados[largest] = time;
            montar(dados, size, largest);
        }
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