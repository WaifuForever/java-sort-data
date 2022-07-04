package src.utils;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import src.interfaces.Callable;

public class FileHandler {

    // String fileNameDownloaded = "passwords.csv";

    public CustomBiArray<String> read(String filename) {
        CustomBiArray<String> data = new CustomBiArray<String>();
        try (FileInputStream inputStream = new FileInputStream("output/" + filename);
                Scanner sc = new Scanner(inputStream, "UTF-8");) {
            // File passwords_classifier = new File("passwords_classifier.csv");

            // String lineOne = sc.nextLine();

            // PrintWriter passwords_classifier = new PrintWriter(fileNameClassifier,
            // "UTF-8");
            // PrintWriter passwords_formated_data = new PrintWriter(fileNameFormatedDate,
            // "UTF-8");
            // passwords_classifier.println(lineOne.concat(",classification"));
            // passwords_formated_data.println(lineOne.concat(",classification"));
            while (sc.hasNextLine()) {
                data.add(sc.nextLine().split(","));
                
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

    public CustomBiArray<String> read(String filename, int limit) {
        CustomBiArray<String> data = new CustomBiArray<String>();
        if(limit < 1){
            return data;
        }
        try (FileInputStream inputStream = new FileInputStream("output/" + filename);
                Scanner sc = new Scanner(inputStream, "UTF-8");) {
            // File passwords_classifier = new File("passwords_classifier.csv");

            // String lineOne = sc.nextLine();

            // PrintWriter passwords_classifier = new PrintWriter(fileNameClassifier,
            // "UTF-8");
            // PrintWriter passwords_formated_data = new PrintWriter(fileNameFormatedDate,
            // "UTF-8");
            // passwords_classifier.println(lineOne.concat(",classification"));
            // passwords_formated_data.println(lineOne.concat(",classification"));
            int i = 0;
            
            while (sc.hasNextLine()) {
                if (i > limit)
                    break;
                
                
                data.add(sc.nextLine().split(","));                
               

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

    public void write(String filename, CustomBiArray<String> data, Callable callable, int index) {
        try (PrintWriter newFile = new PrintWriter("output/" + filename, "UTF-8")) {

            for (int i = 0; i < data.getSize(); i++) {
                if(callable.call(data.get(i)[index]))
                    newFile.println(ArrayHandler.concatArray(data.get(i), ","));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void write(String filename, CustomBiArray<String> data) {
        try (PrintWriter newFile = new PrintWriter("output/" + filename, "UTF-8")) {

            for (int i = 0; i < data.getSize(); i++) {
                newFile.println(ArrayHandler.concatArray(data.get(i), ","));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        FileHandler fh = new FileHandler();
        CustomBiArray<String> temp = fh.read("passwords.csv", 100);
        ArrayHandler.printArray((String []) temp.get(0));

        /*
         * for (int i = 0; i < arr.length - 1; i++) {
         * arr[i] = ((String[]) temp.get(0))[i];
         * }
         * arr[arr.length - 1] = "classification";
         * temp.update(0, arr);
         * System.out.println(temp.getSize());
         * for (int i = 0; i < temp.getSize(); i++) {
         * System.out.println(Arrays.toString((String[]) temp.get(i)));
         * }
         */
    }

}