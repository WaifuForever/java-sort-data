package src.utils;

public class CustomTag {
    


    public <T> CustomArray<Object[]> toCustomTag(CustomArray<T> data){
        CustomArray<Object[]> array = new CustomArray<Object[]>(data.getSize());
        
        for (int i=0; i < data.getSize(); i++){
            array.add(new Object[]{i, data.get(i)});
        }

        return array;
    }
}
