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

    public static int sequentialSearch(Integer[] list, int target) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == target)
                return i;
        }
        return -1;
    }

    public static boolean isSorted(Integer[] array, int n) {
        if (n == 1 || n == 0)
            return true;
        return array[n - 2] <= array[n - 1] && isSorted(array, n - 1);
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

    public static <T> T[] sliceArray(T[] array, int startIndex, int endIndex) {
        return Arrays.copyOfRange(array, startIndex, endIndex);
    }

    public static String concatArray(String[] array) {
        String temp = Arrays.toString(array);
        return temp.substring(1, temp.length() - 1).replace(", ", ",");

    }

    public static <T> T[] concatWithArrayCopy(T[] array1, T[] array2) {
        T[] result = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }

    public static String concatArray(String[] array, String inBetween) {
        String temp = "";
        for (int i = 0; i < array.length - 1; i++) {
            temp += array[i] + inBetween;
        }

        temp += array[array.length - 1];
        return temp;

    }

    public static <T> T[] reverseArray(T[] arr) {
        T[] temp = arr.clone();
        int index = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            temp[index] = arr[i];
            index++;
        }
        return temp;
    }

    public static <T> void printArray(T[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void printArray(long[] array) {
        System.out.println(Arrays.toString(array));
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
