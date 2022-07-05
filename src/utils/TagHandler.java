package src.utils;

public class TagHandler {

    public CustomArray<String> reorderArray(Integer tags[], CustomArray<String> data, int skip) {
        CustomArray<String> newCustomArray = new CustomArray<String>(data.getSize());

        Integer[] oldTags = getTagsArray(data, skip);

        for (int i = 0; i < skip; i++) {
            newCustomArray.add(data.get(i));
        }
        for (int i = 0; i < tags.length; i++) {
            newCustomArray.add(data.get(ArrayHandler.sequentialSearch(oldTags, tags[i]) + skip));
        }

        ArrayHandler.printArray(tags);
        System.out.printf("tags = %d, data = %d\n", tags.length, newCustomArray.getSize());
        /*
         * for (int i = 0; i < newCustomArray.getSize(); i++) {
         * System.out.println(newCustomArray.get(i));
         * }
         */

        return newCustomArray;
    }

    public Integer[] getTagsArray(CustomArray<String> data, int index) {
        int size = data.getSize() - index;
        Integer[] arr = new Integer[size];

        for (int i = 0; i < size; i++) {
            // System.out.printf("i = %d, index = %d\n", i, index);

            // System.out.println(data.get(i + index));
            arr[i] = Integer.parseInt(data.get(i + index).split(",")[0]);
        }

        return arr;
    }

    public <T> CustomArray<Object[]> toCustomTag(CustomArray<T> data) {
        CustomArray<Object[]> array = new CustomArray<Object[]>(data.getSize());

        for (int i = 0; i < data.getSize(); i++) {
            array.add(new Object[] { i, data.get(i) });
        }

        return array;
    }
}
