import java.io.FileInputStream;
import java.io.File; // Import the File class
import java.io.FileWriter; // Import the FileWriter class
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;
import src.utils.Password;
import src.utils.ArrayHandler;
import src.utils.CustomArray;
import src.utils.FileHandler;

public class read {
    private static Password p1 = new Password();

    private static FileHandler fh = new FileHandler();

    public static void main(String[] args) throws IOException {

        int posPasswordLength = 3;
        String originalFile = "passwords.csv";
        String fileNameClassifier = "passwords_classifier.csv";
        String fileNameFormatedDate = "passwords_formated_data.csv";
        //PrintWriter passwords_classifier = new PrintWriter(fileNameClassifier, "UTF-8");
        //PrintWriter passwords_formated_data = new PrintWriter(fileNameFormatedDate, "UTF-8");

        String[] classificationName = { "Muito Ruim", "Ruim", "Fraca", "Boa", "Muito Boa", "N/A" };
        String[][] arrayFileFormatedData = new String[0][5];

        CustomArray data = fh.read(originalFile);
       
        // File passwords_classifier = new File("passwords_classifier.csv");
       
        String[] arr = ArrayHandler.pushIntoArray((String[]) data.get(0), "classification");
        data.update(0, arr);

        for (int i = 1; i < data.getSize(); i++) {
            String passTier = classificationName[p1.classifyPassword(((String[]) data.get(i))[1])];
            data.update(i, ArrayHandler.pushIntoArray((String[]) data.get(i), passTier));

        }

        System.out.println(data.getSize());
        for (int i = 0; i < data.getSize(); i++) {
            System.out.println(Arrays.toString((String[]) data.get(i)));
        }

        /*
         * String line = sc.nextLine();
         * String[] lineArray = line.split("(,)", 4);
         * //String formatedDate = formateDate(lineArray[3]);
         * int classification = p1.classifyPassword(lineArray[1]);
         * passwords_classifier.println(lineArray[0].concat(",")
         * .concat(lineArray[1]).concat(",")
         * .concat(lineArray[2]).concat(",")
         * .concat(lineArray[3]).concat(",")
         * .concat(classificationName[classification])
         * );
         * String[] lineFormated = {
         * lineArray[0],
         * lineArray[1],
         * lineArray[2],
         * formateDate(lineArray[3]),
         * classificationName[classification]
         * };
         * if(classification>2 && classification<5){
         * passwords_formated_data.println(lineFormated[0].concat(",")
         * .concat(lineFormated[1]).concat(",")
         * .concat(lineFormated[2]).concat(",")
         * .concat(formateDate(lineFormated[3])).concat(",")
         * .concat(classificationName[classification])
         * );
         * arrayPush(arrayFileFormatedData,lineFormated);
         * }
         * 
         * System.out.println(arrayFileFormatedData.length);
         * // System.out.println(line);
         * }
         * passwords_classifier.close();
         * passwords_formated_data.close();
         * // algoritmos
         * insertionSort(arrayFileFormatedData,)
         * System.out.println(arrayFileFormatedData.length);
         * // note that Scanner suppresses exceptions
         */
    }

    public static void arrayPush(String[][] arr, String[] line) {
        // arr = Arrays.copyOf(arr, arr.length + 1);
        // arr[arr.length-1] = line;
        String[][] longer = new String[arr.length + 1][5];
        for (int i = 0; i < arr.length; i++)
            longer[i] = arr[i];
        longer[arr.length] = line;
        arr = longer;
    }

    public static String[] separate(String line) {
        return line.split("(,)", 4);
    }

    public static String formateDate(String date){//2016-12-18 03:21:51
        System.out.println(date.split("\s", 2)[0]);
        String[] formatedDate= date.split("\s", 2)[0].split("(-)");
        
        return formatedDate[2].concat("-").concat(formatedDate[1]).concat("-").concat(formatedDate[0]);
    }

    public static String[] arrayReverse(String[] arr) {
        String[] temp = arr.clone();
        int index = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            temp[index] = arr[i];
            index++;
        }
        return temp;
    }

    public static void writeFile(String fileName, String[][] arr)
            throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter file = new PrintWriter(fileName, "UTF-8");
        for (int i = 0; i < arr.length; i++) {
            file.println(
                    arr[i][0]
                            .concat(arr[i][1])
                            .concat(arr[i][2])
                            .concat(arr[i][3])
                            .concat(arr[i][4]));
        }
        file.close();
    }

    public static String[][] insertionSort(String[][] arr, int pos) {
        String[][] tempArr = arr.clone();
        String key;
        int j;
        for (int i = 1; i < tempArr.length; i++) {
            key = tempArr[i][pos];
            j = i - 1;
            while (j >= 0 && 0 < key.compareToIgnoreCase(tempArr[j][pos])) {
                tempArr[j + 1] = tempArr[j];
                j--;
            }
            tempArr[j + 1] = tempArr[i];
        }
        return tempArr;
    }

    private void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }

    private int partition(int[] arr, int left, int right) {
        int p = arr[left];
        int i = left + 1;
        int j = right;

        while (i <= j) {
            if (arr[i] <= p)
                i++;
            else if (arr[j] > p)
                j--;
            else
                swap(arr, i, j);
        }
        swap(arr, left, j);
        return j;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }
}
