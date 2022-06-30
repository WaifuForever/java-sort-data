package src.utils;

public class CustomArray<T> {

    private int size = 0;

    T[] array = (T[]) new Object[50];

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