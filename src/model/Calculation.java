package model;

public class Calculation {

    public static void depositeToAccount(String inputNumber) {
        String currentBalanceValue = Account.getBalance();
        try {
            int i = Integer.parseInt(inputNumber);
            int newBalance = Integer.parseInt(currentBalanceValue) + i;
            Account.setBalnce(newBalance);
        } catch (Exception e) {
        }
    }

    public static void withdrawToAccount(String inputNumber) {
        String currentBalanceValue = Account.getBalance();
        try {
            int i = Integer.parseInt(inputNumber);
            int newBalance = Integer.parseInt(currentBalanceValue) - i;
            Account.setBalnce(newBalance);
        } catch (Exception e) {
        }
    }
}