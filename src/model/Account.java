package model;

import java.io.FileNotFoundException;

public class Account {

    public static String getBalance() {
        String currentBalance = null;
        try {
            currentBalance = FileWorker.readBalance("balance.res");
        } catch (FileNotFoundException e) {
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
