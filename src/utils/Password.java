package src.utils;

public class Password {

    private String[] classificationName = { "Muito Ruim", "Ruim", "Fraca", "Boa", "Muito Boa", "N/A" };
    public String classifyPassword(String pass, boolean verbose) {

        String veryCrap = "^([0-9]{1,4}|[a-z]{1,4}|[A-Z]{1,4}|[^A-Za-z0-9]{1,4})$";

        String crap = "^([0-9]{1,5}|[a-z]{1,5}|[A-Z]{1,5}|[^A-Za-z0-9]{1,5})$";

        String weak = "(?=^.{1,6}$)(((?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])^[A-Za-z0-9]+$)|((?=.*[A-Z])(?=.*[a-z])(?=.*[^A-Za-z0-9])^[^0-9]+$)|((?=.*[^A-Za-z0-9])(?=.*[0-9])^[^A-Za-z]+$))";

        String good = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9]).{1,7}$";

        String veryGood = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9]).{9,}$";

        String arr[] = { veryCrap, crap, weak, good, veryGood };

        int i = 0;
        for (; i < arr.length; i++) {
            if (pass.matches(arr[i]))
                break;
        }

        return verbose ? classificationName[i] : String.valueOf(i);
    }

}