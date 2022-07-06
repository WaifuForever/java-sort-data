package src.utils;

import src.algorithms.Bubble;
import src.algorithms.Bucket;
import src.algorithms.Counting;
import src.algorithms.Insertion;
import src.algorithms.Merge;
import src.algorithms.Quick;
import src.algorithms.Radix;
import src.algorithms.Selection;
import src.interfaces.Sorter;

public class AlgorithmsHandler {
    private static TagHandler tagHandler = new TagHandler();
    private static FileHandler fh = new FileHandler();

    private static Sorter[] sorters2 = new Sorter[] { new Bubble(), new Bucket(), new Counting(), new Insertion(), new Selection(),
            new Merge(), new Quick(), new Radix(), new Selection() };

    private static Sorter[] sorters = new Sorter[] { new Counting() };

    private static void routine(Sorter sorter, CustomArray<String> data) {
        int size = 10;
        long time[] = new long[size];

        for (int i = 0; i < size; i++) {
            data.shuffleArray(1);

            Integer[] tags = tagHandler.getTagsArray(data, 1);

            long startTime = System.nanoTime();
            sorter.sortArray(tags);
            long endTime = System.nanoTime();

            data = tagHandler.reorderArray(tags, data, 1);
            time[i] = endTime - startTime;
        }
        System.out.println(averageTime(time));
        fh.write(sorter.getClass().getSimpleName() + ".csv", data, 0);

    }

    private static long averageTime(long[] array) {
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    public static void sortData(CustomArray<String> data) {
        for (int j = 0; j < 200; j++){
            for (int i = 0; i < sorters.length; i++) {
                routine(sorters[i], data);
            }
        }

    }
}
