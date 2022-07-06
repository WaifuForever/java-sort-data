package src;

import java.io.IOException;

import src.utils.Password;
import src.utils.AlgorithmsHandler;
import src.utils.CallableUtils;
import src.utils.CustomArray;
import src.utils.FileHandler;

public class App {
    private static Password p1 = new Password();

    private static FileHandler fh = new FileHandler();

    private static CallableUtils callableUtils = new CallableUtils();

    public static void main(String[] args) throws IOException {

        String[] filenames = { "passwords.csv", "passwords_classifier.csv", "filtered_passwords_classifier.csv",
                "passwords_formated_data.csv" };

        CustomArray<String> data = fh.read(filenames[0], 100);

        data.update(0, data.get(0) + ",classification");
        // generates passwords_classifier
        for (int i = 1; i < data.getSize(); i++) {
            String passTier = p1.classifyPassword(((String) data.get(i)).split(",", 4)[1], true);
            data.update(i, data.get(i) + "," + passTier);

        }
        fh.write(filenames[1], data, 0, false);
        fh.write(filenames[2], data, callableUtils.filterCallable, 4);

        fh.write(filenames[3], data, 0, true);

        AlgorithmsHandler.sortData(data);

    }

}
