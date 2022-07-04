package src;
import java.io.IOException;
import src.utils.Password;
import src.utils.ArrayHandler;
import src.utils.CustomBiArray;
import src.utils.FileHandler;
import src.utils.FilterCallable;
import src.utils.ManagerFieldLength;
import src.algorithms.Selection;
import src.algorithms.Bubble;
import src.algorithms.Insertion;
import src.algorithms.Quick;
import src.algorithms.Radix;
import src.utils.OrderDate;
import src.utils.OrderLength;

import src.interfaces.Sorter;

public class App {
    private static Password p1 = new Password();

    private static FileHandler fh = new FileHandler();

    private static void sortFile(Sorter sort, CustomBiArray<String> data){
        sort.sortArray(data);
        fh.write(sort.getClass().getSimpleName() + ".csv", data);
       
    }


    public static void main(String[] args) throws IOException {

        String[] filenames = { "passwords.csv", "passwords_classifier.csv",
                "passwords_formated_data.csv", "best_password_classifier.csv" };

        CustomBiArray<String> data = fh.read(filenames[0], 100);
        data.updateIntern(0, 4, "classification");
        
        for (int i = 1; i < data.getSize(); i++) {
            //ArrayHandler.printArray((String[])data.get(i));
            String passTier = p1.classifyPassword( data.get(i)[1], true);
            data.updateIntern(i, 4, passTier);
        
        }
        fh.write(filenames[1], data); 
        fh.write(filenames[3], data, new FilterCallable(), 4);
        //fh.write(filenames[2], data, new FilterCallable());

        //data == data[][]

        for (int i = 1; i < data.getSize(); i++) {
           
            data.updateIntern(i, 3, formateDate(data.get(i)[3]));
        }
        fh.write(filenames[2], data);

        Radix sort = new Radix(new ManagerFieldLength(), 1);
        sort.sortArray(data);
        fh.write("Radix.csv", data);
        /*
        sortFile(new Selection(1), data);;
        sortFile(new Quick(1), data);
        sortFile(new Bubble(1), data);
        sortFile(new Insertion(1), data);
      */

        
        /*


        fh.write(filenames[2], data);

        System.out.println(data.getSize());
        for (int i = 0; i < data.getSize(); i++) {
            System.out.println(data.get(i));
        }
        */
    }

    public static String formateDate(String date) {// 2016-12-18 03:21:51
        // System.out.println(date.split(" ", 2)[0]);
        String[] temp = date.split(" ", 2)[0].split("-");
        ArrayHandler.reverseArray(temp);
        return ArrayHandler.concatArray(temp, "/");

    }

}
