package src.utils;
import src.interfaces.Callable2;

class orderLength implements Callable2 {
    public boolean call(String[] a, String[] b, boolean asc){
        return compare(a, b, 2, asc);
    }
    private boolean compare(String[] a, String[] b, int index, boolean asc) {
        if (asc ? a[index].compareTo(b[index]) < 0 : a[index].compareTo(b[index]) <= 0) {
            return true;
        }
        return false;
    }
}
class orderDate implements Callable2 {
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
        return asc ? Integer.parseInt(a[index]) < Integer.parseInt(b[index])
                : Integer.parseInt(a[index]) <= Integer.parseInt(b[index]);
    }
}
    
 /*
public class HelloWorld{
    public static void invoke(Callable2 callable, int param){
        callable.call(param);
    }
     public static void main(String []args){
        Callable cmd = new Test();
        invoke(cmd, 10);

    }
}*/

public class AlgoritmsCalculateResults {

    /*private static class Test implements Callable2 {
        public boolean orderDate(String[] a, String[] b, boolean asc) {
            int index = 3;
            String [] temp = a.clone();
            String [] date = temp[index].split("/", 3);
            temp[index] = date[2].concat(date[1]).concat(date[0]);
            String [] temp1 = b.clone();
            String [] date1 = temp1[index].split("/", 3);
            temp1[index] = date1[2].concat(date1[1]).concat(date1[0]);
            System.out.println(temp[index].concat(" ").concat(temp1[index]));
            return compareArrayOfStringByString(temp, temp1, index, asc);
        }

        public boolean orderLength(String[] a, String[] b, boolean asc) {
            return compareArrayOfStringByString(a, b, 2, asc);
        }

    }*/
    


    public static void main(String[] args) {
        // string
        String[][] temp = new String[2][4];
        String[] a = {"0","senha","5","20/01/2025"};
        String[] b = {"1","senha2","6","20/01/2024"};

        temp[0] = a;
        temp[1] = b;
        orderLength c1 = new orderLength();
        orderDate c2 = new orderDate();

        sort(temp, c1);
        sort(temp, c2);
        
    }
    public static void sort(String[][] arr, Callable c){
        //for(int i = 0; i<arr.length; i++){

        //}
        System.out.println(c.call(arr[0],arr[1], true));  
    }
   
    public static boolean compareArrayOfStringByString(String[] a, String[] b, int index, boolean asc) {
        if (asc ? a[index].compareTo(b[index]) < 0 : a[index].compareTo(b[index]) <= 0) {
            return true;
        }
        return false;
    }

    // {"2","klara-tershina3H","16","2016-04-10 19:00:01","Muito Boa","Muito Boa"}
    // compareArrayOfStringByInt :: String[] -> String[] -> int -> Boolean ->
    // Boolean
    public static boolean compareArrayOfStringByInt(String[] a, String[] b, int index, boolean asc) {
        return asc ? Integer.parseInt(a[index]) < Integer.parseInt(b[index])
                : Integer.parseInt(a[index]) <= Integer.parseInt(b[index]);
    }
}