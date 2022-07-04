package src.utils;

import src.interfaces.Callable;


public class FilterCallable implements Callable {
    public boolean call(String field){
        return new Password().isBestPassword(field);
    }
}
