package src.utils;

public class CustomArray<T> {

    private int size = 0;

    public CustomArray(T[] array) {
        this.array = (T[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
    }

    public CustomArray(int length) {

        array = (T[]) new Object[length > 0 ? length : 50];

    }

    public CustomArray() {
        array = (T[]) new Object[50];
    }

    private T[] array;

    public void shuffleArray(int skip) {
        T[] tempArray = getArray(skip);
        T[] trunkedArray = (T[]) new Object[skip];

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

    public void add(T element) {
        if (size == array.length)
            doubleArray();

        array[size] = element;
        size++;
    }

    public T get(int index) {
        return array[index];
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

}