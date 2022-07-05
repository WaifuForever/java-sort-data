package src.algorithms;

public class Bubble implements Sorter{
    private void swap(Integer[] arr, int i, int j){
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }
    
    private void bubbleSort(Integer[] arr){
        for(int i=0; i < arr.length-1; i++){
            for(int j=0; j < arr.length-1; j++){
                if(arr[j] > arr[j+1])
                    swap(arr, j, j+1);
            }
        }
        
    }
    public void sortArray(Integer[] arr){
        bubbleSort(arr);
    
    }
}
