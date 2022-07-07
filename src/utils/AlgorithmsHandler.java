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

    private static Sorter[] sorters = new Sorter[] { new Quick() };

    private static void routine(Sorter sorter, CustomArray<String> data) {
        int size = 1000;
        long time[] = new long[size];
        // String prefix, string case, int index
        // 3 sort date
        Integer[] dates = new Integer[data.getSize()-1];
        for (int j = 1; j < data.getSize(); j++) {
            String[] line = ((String) data.get(j)).split(",", 5);
            dates[j-1] = dateToInt(line[3]);
            System.out.println(dates[j-1]);
        }
        Integer[] indexesArray = null;
        for (int i = 0; i < size; i++) {
            data.shuffleArray(1);

            Integer[] dateIndexes = ArrayHandler.copyArray(dates);

            sorter.worstCase(dateIndexes);
            long startTime = System.nanoTime();
            sorter.sortArray(dateIndexes);
            long endTime = System.nanoTime();

            indexesArray = ArrayHandler.generateIndexArray(dateIndexes, data);

            //data = 
            time[i] = endTime - startTime;
        }
        ArrayHandler.printArray(indexesArray);
        ArrayHandler.printArray(averageTime(time, 3));
        fh.write("passwords_data_".concat(sorter.getClass().getSimpleName()).concat("Sort_piorCaso_").concat(".csv"), tagHandler.reorderArray(indexesArray, data, 1), 0, true);
    }

    private static Integer dateToInt(String line) {
        String[] date = line.split(" ", 2)[0].split("-", 3);
        // System.out.println(ArrayHandler.concatArray(date));
        return Integer.parseInt(date[0].concat(date[1]).concat(date[2]));
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
