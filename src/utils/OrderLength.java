package src.utils;

import src.interfaces.Callable2;

public class OrderLength implements Callable2 {
    public boolean call(String[] a, String[] b, boolean asc){
        return compare(a, b, 2, asc);
    }
    
    private boolean compare(String[] a, String[] b, int index, boolean asc) {
        return asc ? Integer.parseInt(a[index]) < Integer.parseInt(b[index])
                : Integer.parseInt(a[index]) <= Integer.parseInt(b[index]);
    }
}
