package src.utils;

import java.util.Random;
import java.util.Arrays;

public class CustomArray<T> {
    
    private int size = 0;

    T[] array = (T[]) new Object[50];

    public void add(T element){
        if(size == array.length) doubleArray();

        array[size] = element;
        size++;
    }

    public T get(int index){
        return array[index];
    }

    public void update(int index, T newValue){
        array[index] = newValue;
    }

    public void remove(int index){
        size--;
        for (int i = index; index < size; i++){
            array[i] = array[i+1];
        }
    }

    public int getSize(){
        return size;
    }

    private void doubleArray(){
        T[] temp = (T[]) new Object[array.length * 2];
        for(int i = 0; i < size; i++){
            temp[i] = array[i];
        }
        array = temp;

    }

    public static void shuffleArray(int[] arr) {
        Random r = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
    }

    public static boolean isSorted(int[] array, int n) {
        if (n == 1 || n == 0)
            return true;
        return array[n - 2] <= array[n - 1] && isSorted(array, n - 1);
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

}