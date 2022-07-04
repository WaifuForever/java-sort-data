package src.utils;

import java.util.concurrent.Callable;


interface Callable {
    public void call(int param);
}
    
 /*
public class HelloWorld{
    public static void invoke(Callable callable, int param){
        callable.call(param);
    }
     public static void main(String []args){
        Callable cmd = new Test();
        invoke(cmd, 10);

    }
}*/

public class AlgoritmsCalculateResults {

    private class Test implements Callable {
        public void call(int param) {
            System.out.println( param );
        }
    }
    


    public static void main(String[] args) {
        // string
        String[][] temp = new ;
        sort(temp, orderLength);
    }
    public <T> void sort(String[][] arr, T func){
        //for(int i = 0; i<arr.length; i++){

        //}
        func.call();
    }
    public boolean orderDate(String[] a, String[] b, boolean asc) {
        return compareArrayOfStringByString(a, b, 1, asc);
    }

    public boolean orderLength(String[] a, String[] b, boolean asc) {
        return compareArrayOfStringByString(a, b, 4, asc);
    }

    public boolean compareArrayOfStringByString(String[] a, String[] b, int index, boolean asc) {
        if (asc ? a[index].compareTo(b[index]) < 0 : a[index].compareTo(b[index]) <= 0) {
            return true;
        }
        return false;
    }

    // {"2","klara-tershina3H","16","2016-04-10 19:00:01","Muito Boa","Muito Boa"}
    // compareArrayOfStringByInt :: String[] -> String[] -> int -> Boolean ->
    // Boolean
    public boolean compareArrayOfStringByInt(String[] a, String[] b, int index, boolean asc) {
        return asc ? Integer.parseInt(a[index]) < Integer.parseInt(b[index])
                : Integer.parseInt(a[index]) <= Integer.parseInt(b[index]);
    }
}