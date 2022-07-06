package src.utils;

public class TagHandler {

    public CustomArray<String> reorderArray(Integer tags[], CustomArray<String> data, int skip, int index, boolean isString) {
        CustomArray<String> newCustomArray = new CustomArray<String>(data.getSize());
        if(isString){
            String[] oldTags = getStringTagsFromArray(data, skip, index);
            return newCustomArray;
        }else{
            Integer[] oldTags = getNumberTagsFromArray(data, skip, index);
            for (int i = 0; i < skip; i++) {
                newCustomArray.add(data.get(i));
            }
            for (int i = 0; i < tags.length; i++) {
                newCustomArray.add(data.get(ArrayHandler.sequentialSearch(oldTags, tags[i]) + skip));
            }
            return newCustomArray;
        }
    }


    public Integer[] getStringTagsFromArray(CustomArray<String> data, int skip, int index) {
        if( index < 0 || index > 5) index = 0;
        int size = data.getSize() - skip;
        Integer[] arr = new Integer[size];

        for (int i = 0; i < size; i++) {
            String[] date = data.get(i + skip).split(",")[index].split("/", 3);
            arr[i] = Integer.parseInt(date[2].concat(date[1]).concat(date[0]));
        }

        return arr;
    }

    public Integer[] getNumberTagsFromArray(CustomArray<String> data, int skip, int index) {
        if(index<0 || index>5) index=0;
        int size = data.getSize() - skip;
        Integer[] arr = new Integer[size];

        for (int i = 0; i < size; i++) {
            // System.out.printf("i = %d, skip = %d\n", i, skip);

            // System.out.println(data.get(i + skip));
            arr[i] = Integer.parseInt(data.get(i + skip).split(",")[index]);
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
