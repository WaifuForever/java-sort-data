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

    private static Sorter[] sorters2 = new Sorter[] { new Bubble(), new Bucket(), new Counting(), new Insertion(),
            new Selection(),
            new Merge(), new Quick(), new Radix(), new Selection() };

    private static Sorter[] sorters = new Sorter[] { new Counting() };

    private static void routine(Sorter sorter, CustomArray<String> data) {
        int size = 10;
        long time[] = new long[size];

        // 3 sort date
        for (int j = 1; j < data.getSize(); j++) {
            String[] line = ((String) data.get(j)).split(",", 5);
            line[3] = dateToInt(line[3]);
            data.update(j, ArrayHandler.concatArray(line));
        }
        for (int i = 0; i < size; i++) {
            data.shuffleArray(1);

            Integer[] tagsDate = tagHandler.getNumberTagsFromArray(data, 1, 3);
            Integer[] dateIndexes = ArrayHandler.copyArray(tagsDate);

            long startTime = System.nanoTime();
            sorter.sortArray(dateIndexes);
            long endTime = System.nanoTime();

            Integer[] indexesArray = ArrayHandler.generateIndexArray(dateIndexes, tagsDate);

            data = tagHandler.reorderArray(indexesArray, data, 1);
            time[i] = endTime - startTime;
        }
        ArrayHandler.printArray(averageTime(time, 3));
        fh.write(/* "password_length" + "wostcase" */ sorter.getClass().getSimpleName() + ".csv", data, 0, true);

    }

    private static String dateToInt(String line) {
        String[] date = line.split(" ", 2)[0].split("-", 3);
        // System.out.println(ArrayHandler.concatArray(date));
        return date[0].concat(date[1]).concat(date[2]);
    }

    private static long[] averageTime(long[] array, int minorSteps) {
        long[] media = { 0, 0 };
        for (int i = 0; i < array.length; i++) {
            if (i < minorSteps) {
                media[0] += array[i];
            }
            media[1] += array[i];
        }
        if (minorSteps < array.length) {
            media[0] = media[0] / minorSteps;
        } else {
            media[0] = media[0] / array.length;
        }
        media[1] = media[1] / array.length;
        return media;
    }

    public static void sortData(CustomArray<String> data) {
        for (int i = 0; i < sorters.length; i++) {
            routine(sorters[i], data);
        }
    }
}
