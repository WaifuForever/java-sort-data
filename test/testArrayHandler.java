package test;

import src.utils.ArrayHandler;
import src.utils.CustomArray;
import src.utils.TagHandler;

public class testArrayHandler {
    private static TagHandler tagHandler = new TagHandler();

    public static void main(String[] args) {

        String[] words = new String[] { "0 - Abra", "1 - Beedril", "2 - Charmander", "3 - Darkrai", "4 - Electabuzz",
                "5 - Farfetch'd", "6 - Golduck", "7 - Hariyama", "8 - Incineroar", "9 - Jynx" };
        String[] words2 = new String[] { "dasdasdas", "0 - Abra", "1 - Beedril", "2 - Charmander", "3 - Darkrai",
                "4 - Electabuzz", "5 - Farfetch'd", "6 - Golduck", "7 - Hariyama", "8 - Incineroar", "9 - Jynx" };

        testReOrderArray(ArrayHandler.sliceArray(words2, 0, 6), 1);

    }

    private static void testReOrderArray(String[] words, int skip) {

        int[] wordPositions = new int[words.length - skip];
        for (int i = 0; i < words.length - skip; i++){
            wordPositions[i] = i;
        }

        int[] shuffledPositions = ArrayHandler.copyArray(wordPositions);
        ArrayHandler.shuffleArray(shuffledPositions);

        CustomArray<String> customArray = new CustomArray<>(words);
        // FIRST BLOCK
        ArrayHandler.printArray(customArray);
        ArrayHandler.printArray(wordPositions);
        ArrayHandler.printArray(shuffledPositions);
        System.out.println();
        System.out.println();
        System.out.println();

        int[] indexArray = ArrayHandler.generateIndexArray(ArrayHandler.copyArray(shuffledPositions),
                ArrayHandler.copyArray(shuffledPositions));
        tagHandler.reorderArray(indexArray, customArray, skip);
        // SECOND BLOCK
        ArrayHandler.printArray(indexArray);
        ArrayHandler.printArray(customArray);
        System.out.println();
        System.out.println();

        indexArray = ArrayHandler.generateIndexArray(ArrayHandler.copyArray(shuffledPositions), ArrayHandler.copyArray(wordPositions));
        System.out.println();
        tagHandler.reorderArray(indexArray, customArray, skip);
        ArrayHandler.printArray(wordPositions);

        ArrayHandler.printArray(customArray);

        indexArray = ArrayHandler.generateIndexArray(ArrayHandler.copyArray(wordPositions), ArrayHandler.copyArray(shuffledPositions));
        System.out.println();
        tagHandler.reorderArray(indexArray, customArray, skip);
        ArrayHandler.printArray(wordPositions);

        ArrayHandler.printArray(customArray);
    }

}
