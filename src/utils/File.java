package src.utils;

import java.io.FileInputStream;
import java.util.Scanner;

public class File {

    private static FileInputStream inputStream;
    //String fileNameDownloaded = "passwords.csv";

    public static String[][] read(String filename){
        CustomArray data = new CustomArray<String[]>();
        try (Scanner sc = new Scanner(inputStream, "UTF-8")) {
            //File passwords_classifier = new File("passwords_classifier.csv");
            inputStream = new FileInputStream(filename);
          
            String lineOne = sc.nextLine();

            //PrintWriter passwords_classifier = new PrintWriter(fileNameClassifier, "UTF-8");
            //PrintWriter passwords_formated_data = new PrintWriter(fileNameFormatedDate, "UTF-8");
            //passwords_classifier.println(lineOne.concat(",classification"));
            //passwords_formated_data.println(lineOne.concat(",classification"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                data.add(line.split("(,)", 4));
                //String formatedDate = formateDate(lineArray[3]);
                
                
              
                // System.out.println(line);
            }
          
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
           
        }
    }
    

}