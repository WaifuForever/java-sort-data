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

    private static void routine(String title, Sorter sorter, int permutation, CustomArray<String> mainArray,
            Integer[] data,
            int circleSize) {

        Integer[] shuffledData = null;
        long time[] = new long[circleSize];
        String[] cases = new String[] { "piorCaso", "medioCaso", "melhorCaso" };

        ArrayHandler.shuffleArray(data);
        Integer[] originalData = ArrayHandler.copyArray(data);

        
        System.out.println(title +" -- " + cases[permutation]);
 
        
        for (int i = 0; i < circleSize; i++) {
            ArrayHandler.shuffleArray(data);

            switch (permutation) {
                case 0:
                    sorter.worstCase(data);
                    break;
                case 2:
                    sorter.bestCase(data);
                    break;
                default:
                    permutation = 1;
                    break;
            }

            shuffledData = ArrayHandler.copyArray(data);

            long startTime = System.nanoTime();
            sorter.sortArray(data);
            long endTime = System.nanoTime();
            /*
             * System.out.println();
             * System.out.println();
             * 
             * ArrayHandler.printArray(shuffledData);
             */

            time[i] = endTime - startTime;
        }
        
         
        ArrayHandler.printArray(averageTime(time, 3));
        ArrayHandler.printArray(shuffledData);
        ArrayHandler.printArray(originalData);
        
       

        originalData = ArrayHandler.generateIndexArray(shuffledData, originalData);
        shuffledData = ArrayHandler.generateIndexArray(shuffledData, ArrayHandler.copyArray(data));

        ArrayHandler.printArray(originalData);
        System.out.println();
        System.out.println();

        mainArray = tagHandler.reorderArray(originalData, mainArray, 1);
        mainArray = tagHandler.reorderArray(shuffledData, mainArray, 1);
        title = "passwords_" + title + "_" + sorter.getClass().getSimpleName() + "Sort_" + cases[permutation] + "_.csv";

        fh.write(title, mainArray, 0, true);
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

    public static void sortData(CustomArray<String> mainArray) {
        int size = 1000;
        Integer[] dates = new Integer[mainArray.getSize() - 1],
                months = new Integer[mainArray.getSize() - 1], lenghts = new Integer[mainArray.getSize() - 1];

        // String prefix, string case, int index
        // 3 sort date
        for (int j = 1; j < mainArray.getSize(); j++) {
            String[] line = ((String) mainArray.get(j)).split(",", 5);
            dates[j - 1] = dateToInt(line[3]);

        }

        for (int j = 1; j < mainArray.getSize(); j++) {
            String[] line = ((String) mainArray.get(j)).split(",", 5);
            months[j - 1] = Integer.parseInt(line[3].substring(5, 7));

        }

        lenghts = tagHandler.getNumberTagsFromArray(mainArray, 1, 2);

        for (int i = 0; i < sorters.length; i++) {
            for (int j = 0; j < 3; j++) {
                routine("length", sorters[i], j, mainArray, lenghts, size);
                routine("mes", sorters[i], j, mainArray, months, size);
                routine("data", sorters[i], j, mainArray, dates, size);
            }
        }

    }
}
