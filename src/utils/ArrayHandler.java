package src.utils;

import java.util.Arrays;
import java.util.Random;

public class ArrayHandler {
    public static <T> void shuffleArray(T[] arr) {
        Random r = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
    }
    public static <T> void worstCase(T[] array){
        reverseArray(array);
    };
    public static <T> void bestCase (T[] array){

    };
    

    public static boolean isSorted(int[] array, int n) {
        if (n == 1 || n == 0)
            return true;
        return array[n - 2] <= array[n - 1] && isSorted(array, n - 1);
    }

    public static <T> void printArray(T[] array){
        System.out.println(Arrays.toString(array));
    }

    public static String[] pushIntoArray(String[] arr, String element) {

        String[] newArray = new String[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }

        newArray[newArray.length - 1] = element;
        // System.out.println(Arrays.toString(newArray));
        return newArray;
    }

    public static String concatArray(String[] array) {
        String temp = Arrays.toString(array);
        return temp.substring(1, temp.length() - 1).replace(", ", ",");

    }

    public static <T> void swap(CustomBiArray<T> arr, int i, int j) {
        System.out.println("----------------");
        //ArrayHandler.printArray(arr.get(i).clone());
        //ArrayHandler.printArray(arr.get(j).clone());
        T[] temp = arr.get(i);
        arr.update(i, arr.get(j).clone());
        arr.update(j, temp.clone());
        //ArrayHandler.printArray(arr.get(i).clone());
    }

    public static String concatArray(String[] array, String inBetween) {
        String temp = "";
        for (int i = 0; i < array.length - 1; i++) {
            temp += array[i] + inBetween;
        }

        temp += array[array.length - 1];
        return temp;

    }

    public static <T> void reverseArray(T[] arr) {
        int index = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            T ax = arr[index];
            if(index<i){
                arr[index] = arr[i];
                arr[i] = ax;
            }
            index++;
        }
       //return temp;
    }

    public static int[] pushIntoArray(int[] arr, int element) {

        int[] newArray = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }

        newArray[newArray.length - 1] = element;
        // System.out.println(Arrays.toString(newArray));
        return newArray;
    }
}
