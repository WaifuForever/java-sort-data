package src.utils;
import src.interfaces.Callable2;

public class OrderAltDate implements Callable2 {
    public boolean call(String[] a, String[] b, boolean asc){
        int index = 3;
        String [] temp = a.clone();
        String [] date = temp[index].split("/", 3);
        temp[index] = date[2].concat(date[1]).concat(date[0]);
        String [] temp1 = b.clone();
        String [] date1 = temp1[index].split("/", 3);
        temp1[index] = date1[2].concat(date1[1]).concat(date1[0]);
        System.out.println(temp[index].concat(" ").concat(temp1[index]));
        return compare(temp, temp1, index, asc);
    }
    private boolean compare(String[] a, String[] b, int index, boolean asc) {
        if (asc ? a[index].compareTo(b[index]) < 0 : a[index].compareTo(b[index]) <= 0) {
            return true;
        }
        return false;
    }
}
