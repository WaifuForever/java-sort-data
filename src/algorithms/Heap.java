package src.algorithms;

import src.interfaces.Sorter;

public class Heap implements Sorter {

    public void sortArray(int[] data) {
        for (int i = data.length / 2 - 1; i >= 0; i--) {
            mount(data, data.length, i);
        }
        for (int i = data.length - 1; i >= 0; i--) {
            int time = data[0];
            data[0] = data[i];
            data[i] = time;
            mount(data, i, 0);
        }
    }

    public void mount(int[] data, int size, int i) {
        int largest = i;
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;

        if (left < size && data[left] > data[largest]) {
            largest = left;
        }
        if (right < size && data[right] > data[largest]) {
            largest = right;
        }
        if (largest != i) {
            int time = data[i];
            data[i] = data[largest];
            data[largest] = time;
            mount(data, size, largest);
        }
    }

    @Override
    public void bestCase(int[] arr) {
        // Best Case is when the all elements are equal
        sortArray(arr);
    }

    @Override
    public void worstCase(int[] arr) {
        // The worst case for heap sort might happen when all elements in the list are distinct.
        sortArray(arr);
       
    }
}