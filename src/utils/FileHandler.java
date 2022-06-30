package src.utils;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

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

    public void write(String filename, CustomArray<String> data) {
        try (PrintWriter newFile = new PrintWriter("output/" + filename, "UTF-8")) {

            for (int i = 0; i < data.getSize(); i++) {
                newFile.println(data.get(i));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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