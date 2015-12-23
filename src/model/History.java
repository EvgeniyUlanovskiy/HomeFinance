package model;

import java.io.File;
import java.io.FileNotFoundException;

public class History {

    public static void setHistory(String totalHistory) {
        try {
            FileWorker.update("history.devsw", totalHistory);
        } catch (FileNotFoundException e) {
            FileWorker.write("history.devsw", totalHistory);
        }
    }

    public static String getHistory() {
        String getHistoryView = null;
        try {
            getHistoryView = FileWorker.read("history.devsw");
        } catch (FileNotFoundException e) {
            File file = new File("history.devsw");
            try {
                file.createNewFile();
            } catch (java.io.IOException IOexc) {
            }
        }
        return getHistoryView;
    }
}
