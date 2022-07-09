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

    public static void shuffleArray(int[] arr) {
        Random r = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
    }

    public static <T> T[] copyArray(T[] array) {
        return Arrays.copyOf(array, array.length);
    }

    public static int[] copyArray(int[] array) {
        return Arrays.copyOf(array, array.length);
    }

    public static <T> void reorderArray(int positions[], CustomArray<T> mainArray, int skip) {
        CustomArray<T> temp = new CustomArray<T>(mainArray.getArray());

        for (int i = 0; i < positions.length; i++)
            mainArray.update(i + skip, temp.get(positions[i] + skip));

    }

    public static int[] generateIndexArray(int[] original, int[] doppelganger) {
        /*
         * generate an index array refering the relation of the original array with the
         * doppelganger array original -> doppelganger
         */
        int[] indexArray = new int[original.length];

        if (original.length != doppelganger.length)
            return indexArray;

        for (int i = 0; i < indexArray.length; i++) {
            indexArray[i] = sequentialSearch(original, doppelganger[i]);
            doppelganger[i] = -1;

        }

        return indexArray;
    }

    public static int sequentialSearch(int[] list, int target) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == target) {
                list[i] = -1;
                return i;
            }

        }
        return -1;
    }

    public static boolean isSorted(int[] array, int n) {
        if (n == 1 || n == 0)
            return true;
        return array[n - 2] <= array[n - 1] && isSorted(array, n - 1);
    }

    public static <T> T[] sliceArray(T[] array, int startIndex, int endIndex) {
        return Arrays.copyOfRange(array, startIndex, endIndex);
    }

    public static int[] sliceArray(int[] array, int startIndex, int endIndex) {
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

    public static int[] concatWithArrayCopy(int[] array1, int[] array2) {
        int[] result = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }

    public static String concatArray(String[] array, String inBetween) {
        String temp = "";
        for (int i = 0; i < array.length - 1; i++) {
            temp += array[i] + inBetween;
        }

        temp += array[array.length - 1];
        return temp;

    }

    public static <T> void reverseArrayInPlace(T[] arr) {
        int index = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            T ax = arr[index];
            if (index < i) {
                arr[index] = arr[i];
                arr[i] = ax;
            }
            index++;
        }
        // return temp;
    }

    public static void reverseArrayInPlace(int[] arr) {
        int index = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int ax = arr[index];
            if (index < i) {
                arr[index] = arr[i];
                arr[i] = ax;
            }
            index++;
        }
        // return temp;
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

    public static int[] reverseArray(int[] arr) {
        int[] temp = arr.clone();
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

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));

    }

    public static void printArray(long[] array) {
        System.out.println(Arrays.toString(array));

    }

    public static <T> void printArray(CustomArray<T> array) {
        for (int i = 0; i < array.getSize(); i++) {
            System.out.println(array.get(i));
        }

    }

    public static void mirrorArray(int[] arr, int[] arr2) {

        if (arr.length == arr2.length)

            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr2[i];
            }

    }
}