package src.interfaces;

import src.utils.CustomBiArray;

public interface Sorter {
    public void sortArray(CustomBiArray<String> arr);

    public void bestCase(CustomBiArray<String> arr);

    public void worstCase(CustomBiArray<String> arr);
}

/*
    foo(Sorter sorter){
        sort.bestCase(data);
        int startTime;
        sort.sortArray(data);
        int endTime;
        write(data);

        sort.worstCase(data);
        int startTime;
        sort.sortArray(data);
        int endTime;
        write(data);

        ArrayHandler.shuffle(data);
        int startTime;
        sort.sortArray(data);
        int endTime;
        write(data);
        sort.worstCase(data);

    }

*/