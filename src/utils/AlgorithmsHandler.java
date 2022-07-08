package src.utils;

import src.algorithms.Bubble;
import src.algorithms.Bucket;
import src.algorithms.Counting;
import src.algorithms.Heap;
import src.algorithms.Insertion;
import src.algorithms.MedianQuickSort;
import src.algorithms.Merge;
import src.algorithms.Quick;
import src.algorithms.Radix;
import src.algorithms.Selection;
import src.interfaces.Sorter;

public class AlgorithmsHandler {
    private static TagHandler tagHandler = new TagHandler();
    private static FileHandler fh = new FileHandler();

    private static Sorter[] sorters2 = new Sorter[] { new Bubble(), new Bucket(), new Counting(), new Heap(), new Insertion(),
            new Selection(), new Insertion(), new MedianQuickSort(),
            new Merge(), new Quick(), new Radix(), new Selection() };

    private static Sorter[] sorters = new Sorter[] { new MedianQuickSort() };

    private static void routine(String title, Sorter sorter, int permutation, CustomArray<String> mainArray,
            int[] data,
            int circleSize) {

        long time[] = new long[circleSize];
        String[] cases = new String[] { "piorCaso", "medioCaso", "melhorCaso" };

        int[] originalData = ArrayHandler.copyArray(data);

        /*
         * System.out.println("The way it is:");
         * ArrayHandler.printArray(mainArray);
         * System.out.println("\n");
         */

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

            long startTime = System.nanoTime();
            sorter.sortArray(data);
            long endTime = System.nanoTime();
          
            time[i] = endTime - startTime;
        }
        /*
         * System.out.println("Arrays relation");
         * System.out.printf("OriginalData: ");
         * ArrayHandler.printArray(originalData);
         * System.out.printf("Sorted Data: ");
         * ArrayHandler.printArray(data);
         */

        int[] indexArray = ArrayHandler.generateIndexArray(ArrayHandler.copyArray(originalData),
                ArrayHandler.copyArray(data));
        /*
         * System.out.printf("indexArray: ");
         * ArrayHandler.printArray(indexArray);
         * System.out.println();
         */
        ArrayHandler.reorderArray(indexArray, mainArray, 1);
        // System.out.println("Sorted:");

        // ArrayHandler.printArray(mainArray);
        // System.out.println();
        ArrayHandler.printArray(averageTime(time, 3));

        title = "passwords_" + title + "_" + sorter.getClass().getSimpleName() + "Sort_" + cases[permutation] + "_.csv";
        fh.write(title, mainArray, 0, true);

        indexArray = ArrayHandler.generateIndexArray(ArrayHandler.copyArray(data),
                ArrayHandler.copyArray(originalData));
        ArrayHandler.reorderArray(indexArray, mainArray, 1);
        /*
         * System.out.println("The way it was:");
         * ArrayHandler.printArray(mainArray);
         * System.out.println("\n");
         */
        ArrayHandler.mirrorArray(data, originalData);
    }

    private static int dateToInt(String line) {
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
        int size = 10000;
        int[] dates = new int[mainArray.getSize() - 1],
                months = new int[mainArray.getSize() - 1], lenghts = new int[mainArray.getSize() - 1];

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
                System.out.println(sorters[i].getClass().getSimpleName() + "Sort");
                routine("length", sorters[i], j, mainArray, lenghts, size);
                routine("mes", sorters[i], j, mainArray, months, size);
                routine("data", sorters[i], j, mainArray, dates, size);
                System.out.println();

            }

        }

    }
}
