package src.utils;

import src.interfaces.SetFieldString;

public class SetLenght implements SetFieldString {
    public void call(CustomBiArray<String> arr, int exIndex, int a){
        arr.updateIntern(exIndex, 2, String.valueOf(a));
    }
}
