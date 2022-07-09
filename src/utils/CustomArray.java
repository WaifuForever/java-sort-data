package src.utils;

import java.lang.reflect.Array;

public class CustomArray<T> {

    private int size = 0;

    @SuppressWarnings("unchecked")
    public CustomArray(T[] array) {
        this.array = (T[]) Array.newInstance(array[0].getClass(), array.length);

        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
        size = array.length;
    }

    @SuppressWarnings("unchecked")
    public CustomArray(T[] array, int size) {
        this.array = (T[]) Array.newInstance(array[0].getClass(), size);

        this.size = size;
    }

    @SuppressWarnings("unchecked")
    public CustomArray(int length) {
        this.array = (T[]) new Object[length > 0 ? length : 50];

    }

    @SuppressWarnings("unchecked")
    public CustomArray() {
        this.array = (T[]) new Object[40];
    }

    private T[] array;

    public void shuffleArray(int skip) {
        T[] tempArray = getArray(skip);
        @SuppressWarnings("unchecked")
        final T[] trunkedArray = (T[]) new Object[skip];

        ArrayHandler.shuffleArray(tempArray);
        for (int i = 0; i < skip; i++) {
            trunkedArray[i] = array[i];
        }

        array = ArrayHandler.concatWithArrayCopy(trunkedArray, tempArray);

    }

    private T[] getArray(int skip) {
        return ArrayHandler.sliceArray(array, skip, size);
    }

    public T[] getArray() {
        return ArrayHandler.sliceArray(array, 0, size);
    }

    @SuppressWarnings("unchecked")
    public void add(T element) {
        if (size == array.length)
            doubleArray();

        array[size] = element;
        size++;
    }

    public T get(int n) {
        if (n > size || n < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[n];
    }

    public void update(int index, T newValue) {
        array[index] = newValue;
    }

    public void remove(int index) {
        size--;
        for (int i = index; index < size; i++) {
            array[i] = array[i + 1];
        }
    }

    public int getSize() {
        return size;
    }

    private void doubleArray() {
        T[] temp = (T[]) new Object[array.length * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;

    }

    private void doubleArray(Class<T> c) {
        @SuppressWarnings("unchecked")
        final T[] result = (T[]) Array.newInstance(c, array.length * 2);

        for (int i = 0; i < size; i++) {
            result[i] = array[i];
        }
        array = result;

    }

}