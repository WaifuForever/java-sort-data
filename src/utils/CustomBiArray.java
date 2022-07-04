package src.utils;

public class CustomBiArray <T> {
    
    private int size = 0;
    private int innerSize = 0;

    //warning all inner arrays must have the same length
    public CustomBiArray(T[][] array) {
        this.array = (T[][]) new Object[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
        this.size = array.length;
        this.innerSize = array[0].length;
    }

    public CustomBiArray() {
        array = (T[][]) new Object[50][0];
    
    }

    T[][] array;

    public void updateIntern(int exIndex, int iIndex, T value){
        
        increaseIntern(iIndex);
        
        this.array[exIndex][iIndex] = value;
    }
    

    public void add(T[] element) {
        if (size == array.length)
            doubleArray();
        if(innerSize<element.length){
            innerSize = element.length;
        }
        array[size] = element;
        size++;
    }

    public T[] get(int index) {
        return array[index];
    }

    public int getInnerSize(int index){
        return array[index].length;
    }

    public void update(int index, T[] newValue) {
        System.out.printf("index: %d, %d == %d\n",index, newValue.length, innerSize);
        if(newValue.length == innerSize)
        System.out.printf("alter: true\n");
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

    //it adds an extra position to all inner arrays
    private void increaseIntern(int index){
        //System.out.println("increaseIntern");
        if(index >= innerSize){
            for(int i = 0; i < array.length; i++){
                T[] temp =  (T[]) new String[index+1];
                for(int j = 0; j < array[i].length; j++){
                    //System.out.printf("%d === %d\n", j, array[i].length);
                    temp[j] = array[i][j];
                }
                temp[index]=null;
                this.array[i] = temp;
            }            
            innerSize++;
        }
        
    }

    private void doubleArray() {
        T[][] temp = (T[][]) new Object[array.length * 2][innerSize];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

}