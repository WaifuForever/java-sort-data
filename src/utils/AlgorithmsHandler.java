package src.utils;

import src.algorithms.Bubble;
import src.algorithms.Counting;
import src.algorithms.Insertion;
import src.algorithms.Merge;
import src.algorithms.Selection;
import src.interfaces.Sorter;

public class AlgorithmsHandler {
    private static TagHandler tagHandler = new TagHandler();
    private static FileHandler fh = new FileHandler();

    private static Sorter[] sorters = new Sorter[] { new Bubble(), new Insertion(), new Selection(), new Counting(),
            new Merge() };

    private static void routine(Sorter sorter, CustomArray<String> data) {
        int size = 10;
        long time[] = new long[size];

        for (int i = 0; i < size; i++) {
            data.shuffleArray(1);

            Integer[] tags = tagHandler.getTagsArray(data, 1);
            long startTime = System.nanoTime();
            // ArrayHandler.printArray(tags);
            sorter.sortArray(tags);
            long endTime = System.nanoTime();

            data = tagHandler.reorderArray(tags, data, 1);
            time[i] = endTime - startTime;
        }
        ArrayHandler.printArray(time);
        fh.write(sorter.getClass().getSimpleName() + ".csv", data, 0);

    }

    public static void sortData(CustomArray<String> data) {
        for (int i = 0; i < sorters.length; i++) {
            routine(sorters[i], data);
        }
    }
}
