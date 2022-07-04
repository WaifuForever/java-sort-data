package src.utils;
import src.interfaces.ManagerFieldInt;

public class ManagerFieldLength implements ManagerFieldInt {
    public int call(String[] a){
        return Integer.parseInt(a[2]);
    }
    public void call(CustomBiArray<String> arr, int index, int a){
        arr.update(index, String.valueOf(a));
    }
}
