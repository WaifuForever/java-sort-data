package src.utils;

import src.interfaces.Callable;

public class CallableUtils {
    private Password p1 = new Password();

    private class FilterCallable implements Callable {

        @Override
        public boolean call(String field) {
            return p1.isBestPassword(field);
        }

    }

    public FilterCallable filterCallable = new FilterCallable();

}
