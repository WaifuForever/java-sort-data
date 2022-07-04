package src.algorithms;

import src.utils.ArrayHandler;
import src.interfaces.Callable2;
import src.interfaces.Sorter;
import src.utils.CustomBiArray;

public class Bubble implements Sorter{
    private Callable2 comp;
    private int startIndex;

    public Bubble (int startIndex) {
       
        this.startIndex = startIndex;
    }

    public void setCallable (Callable2 comp){
        this.comp = comp;
    }
    
    private void bubbleSort(CustomBiArray<String> arr){
        for(int i=startIndex; i < arr.getSize()-1; i++){
            
            for(int j=startIndex; j < arr.getSize()-1; j++){
            
                if (comp.call(arr.get(j+1), arr.get(j), false)){
                    ArrayHandler.swap(arr, j, j+1);
                }
                   
            }
        }
        
    }
    public void sortArray(CustomBiArray<String> arr){
        bubbleSort(arr);
    
    }

	@Override
	public void bestCase(CustomBiArray<String> arr) {
		// array already sorted
	}

	@Override
	public void worstCase(CustomBiArray<String> arr) {
		// reversed array
		
	}
}
