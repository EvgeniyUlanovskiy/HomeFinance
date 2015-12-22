package model;
import java.io.File;
import java.io.FileNotFoundException;
public class Engine {

    // Записываем новый баланс в файл

    public static void updateBalnce(int newBalance) {
        String balance = String.valueOf(newBalance);
        FileWorker.write("balance.devsw", balance);
    }

    // Читаем баланс из файла

    public static String getBalance() {
        String currentBalance = null;
        try {
            currentBalance = FileWorker.read("balance.devsw");

        } catch (FileNotFoundException e) {
            File file = new File("balance.devsw");
            try {
                file.createNewFile();
                currentBalance = "0";
                return currentBalance;
            }
          catch (java.io.IOException IOexc){

          }
        }
        return currentBalance;
    }

    // Записываем историю
    public static void updateHistory(String totalHistory) {
        try {
            FileWorker.update("history.devsw", totalHistory);
        } catch (FileNotFoundException e) {
            FileWorker.write("history.devsw", totalHistory);
        }
    }

    // Считываем историю
    public static String getHistory() {
        String getHistoryView = null;
        try {
            getHistoryView = FileWorker.read("history.devsw");
        } catch (FileNotFoundException e) {
            File file = new File("history.devsw");
            try {
                file.createNewFile();
            }
            catch (java.io.IOException IOexc){

            }
        }
        return getHistoryView;
    }
}
