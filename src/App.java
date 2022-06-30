package src;
import java.io.IOException;
import src.utils.Password;
import src.utils.ArrayHandler;
import src.utils.CustomArray;
import src.utils.FileHandler;

public class App {
    private static Password p1 = new Password();

    private static FileHandler fh = new FileHandler();

    public static void main(String[] args) throws IOException {

        String[] filenames = { "passwords.csv", "passwords_classifier.csv",
                "passwords_formated_data.csv" };

        CustomArray<String> data = fh.read(filenames[0], 200);

        data.update(0, data.get(0) + ",classification");

        for (int i = 1; i < data.getSize(); i++) {
            String passTier = p1.classifyPassword(((String) data.get(i)).split(",", 4)[1], true);
            data.update(i, data.get(i) + "," + passTier);

        }
        fh.write(filenames[1], data);

        for (int i = 1; i < data.getSize(); i++) {
            String[] line = ((String) data.get(i)).split(",", 5);
            line[3] = formateDate(line[3]);
            data.update(i, ArrayHandler.concatArray(line));

        }
        fh.write(filenames[2], data);

        System.out.println(data.getSize());
        for (int i = 0; i < data.getSize(); i++) {
            System.out.println(data.get(i));
        }

    }

    public static String formateDate(String date) {// 2016-12-18 03:21:51
        // System.out.println(date.split(" ", 2)[0]);
        String[] temp = date.split(" ", 2)[0].split("-");
        return ArrayHandler.concatArray(ArrayHandler.reverseArray(temp), "/");

    }

}
