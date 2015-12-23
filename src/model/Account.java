package model;

import java.io.File;
import java.io.FileNotFoundException;

public class Account {

    public static String getBalance() {
        String currentBalance = null;
        try {
            currentBalance = FileWorker.read("balance.res");
        } catch (FileNotFoundException e) {
            File file = new File("balance.res");
            try {
                FileWorker.write("balance.res", "0");
                currentBalance = "0";
            } catch (Exception exc) {
            }
        }
        return currentBalance;
    }

    public static void setBalnce(int newBalance) {
        String balance = String.valueOf(newBalance);
        FileWorker.write("balance.res", balance);
    }
}
