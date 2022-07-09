package src.utils;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import src.interfaces.Callable;

public class FileHandler {

    // String fileNameDownloaded = "passwords.csv";

    public CustomArray<String> read(String filename) {
        CustomArray<String> data = new CustomArray<String>();
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
                data.add(sc.nextLine());

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

    public CustomArray<String> read(String filename, int limit) {
        CustomArray<String> data = new CustomArray<String>();
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
                data.add(sc.nextLine());

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

    public void write(String filename, CustomArray<String> data, Callable callable, int index) {
        try (PrintWriter newFile = new PrintWriter("output/" + filename, "UTF-8")) {

            for (int i = 0; i < data.getSize(); i++) {
                if (callable.call(((String) data.get(i)).split(",")[index]))
                    newFile.println(data.get(i));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void write(String filename, CustomArray<String> data, int index, boolean formatDate) {
        try (PrintWriter newFile = new PrintWriter("output/" + filename, "UTF-8")) {

            if (formatDate) {
                for (int i = index; i < data.getSize(); i++) {
                    String[] line = ((String) data.get(i)).split(",", 5);
                    line[3] = formateDate(line[3]);
                    newFile.println(ArrayHandler.concatArray(line));
                }
            } else {
                for (int i = index; i < data.getSize(); i++) {
                    newFile.println(data.get(i));
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void writeTime(String title, long[] array) throws IOException {
        try (PrintWriter newFile =  new PrintWriter(new BufferedWriter(new FileWriter("output/benchmark.csv", true)))) {
           
            for (int i = 0; i < array.length - 1; i++) {

                title += "," + String.valueOf(array[i]);
            }

            newFile.println(title);

        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static String formateDate(String date) {// 2016-12-18 03:21:51
        // System.out.println(date.split(" ", 2)[0]);
        String[] temp;
        if (date.matches("^[0-9]{8}$")) {
            temp = new String[] { date.substring(0, 4), date.substring(4, 6), date.substring(6) };
        } else {
            temp = date.split(" ", 2)[0].split("-", 3);
        }
        return ArrayHandler.concatArray(ArrayHandler.reverseArray(temp), "/");

    }

    public static void main(String[] args) {
        FileHandler fh = new FileHandler();
        CustomArray<String> temp = fh.read("passwords.csv");
        System.out.println(temp.get(0));

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