package src.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileHandler {

    // String fileNameDownloaded = "passwords.csv";

    public static CustomArray read(String filename) {
        CustomArray data = new CustomArray<String[]>();
        try (FileInputStream inputStream = new FileInputStream("output/" + filename);
                Scanner sc = new Scanner(inputStream, "UTF-8");) {
            // File passwords_classifier = new File("passwords_classifier.csv");

            //String lineOne = sc.nextLine();

            // PrintWriter passwords_classifier = new PrintWriter(fileNameClassifier,
            // "UTF-8");
            // PrintWriter passwords_formated_data = new PrintWriter(fileNameFormatedDate,
            // "UTF-8");
            // passwords_classifier.println(lineOne.concat(",classification"));
            // passwords_formated_data.println(lineOne.concat(",classification"));
            int i = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                data.add(line.split("(,)", 4));
                if (i > 200)
                    break;
                i++;
                // String formatedDate = formateDate(lineArray[3]);
                // System.out.println(line);
            }

            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return data;
    }
    
    public static void main(String[]args){
        CustomArray temp = read("output/passwords.csv");
        String[] arr = new String[((String[]) temp.get(0)).length+1];


        for(int i=0; i < arr.length-1; i++){
            arr[i] = ((String[]) temp.get(0))[i];
        }
        arr[arr.length-1] = "classification";
        temp.update(0, arr);
        System.out.println(temp.getSize());
        for (int i=0; i < temp.getSize(); i++){
            System.out.println(Arrays.toString((String[]) temp.get(i)));
        }
    }
    
}