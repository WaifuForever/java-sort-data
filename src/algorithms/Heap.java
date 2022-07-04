package src.algorithms;
import src.interfaces.Callable2;
import src.interfaces.Sorter;
import src.utils.CustomBiArray;

public class Heap implements Sorter{

    public static void main(String[] args) {

        int[] data = { 16, 7, 22, 3, 19, 9, 36, 11 };

        Heap heap = new Heap();
        heap.sort(data, data.length);
       
       
    }

    public void sort(int[] data, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            mount(data, size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
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
	public void sortArray(CustomBiArray<String> arr, Callable2 func) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bestCase(CustomBiArray<String> arr) {
		// all elements are equal
		
	}

	@Override
	public void worstCase(CustomBiArray<String> arr) {
		// inversely sorted Array
		
	}
}