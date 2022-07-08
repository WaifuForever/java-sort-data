package src.utils;

public class TagHandler {

    public int[] getStringTagsFromArray(CustomArray<String> data, int skip, int index) {
        if (index < 0 || index > 5)
            index = 0;
        int size = data.getSize() - skip;
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.printf("%d %d\n", size, i);
            // System.out.println(data.get(i));
            String[] date = data.get(i + skip).split(",")[index].split("/", 3);
            // System.out.println(date);
            System.out.println(Integer.parseInt(date[2].concat(date[1]).concat(date[0])));
            arr[i] = Integer.parseInt(date[2].concat(date[1]).concat(date[0]));

        }
        return arr;
    }

    public int[] getNumberTagsFromArray(CustomArray<String> data, int skip, int index) {
        int size = data.getSize() - skip;
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            // System.out.printf("i = %d, skip = %d\n", i, skip);

            // System.out.println(data.get(i + skip));
            arr[i] = Integer.parseInt(data.get(i + skip).split(",")[index]);
        }

        return arr;
    }

    public int[] getTagsArray(CustomArray<String> data, int index) {
        int size = data.getSize() - index;
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            // System.out.printf("i = %d, index = %d\n", i, index);

            // System.out.println(data.get(i + index));
            arr[i] = Integer.parseInt(data.get(i + index).split(",")[0]);
        }

        return arr;
    }
}