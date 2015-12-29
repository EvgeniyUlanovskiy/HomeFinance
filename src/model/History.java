package model;

import java.io.File;
import java.io.FileNotFoundException;

public class History {

    public static void setHistory(String totalHistory) {
        try {
            FileWorker.update("history.res", totalHistory);
        } catch (FileNotFoundException e) {
            FileWorker.write("history.res", totalHistory);
        }
    }

    public static String getHistory() {
        String getHistoryView = null;
        try {
            getHistoryView = FileWorker.read("history.res");
        } catch (FileNotFoundException e) {
            File file = new File("history.res");
            try {
                file.createNewFile();
            } catch (java.io.IOException IOexc) {
            }
        }
        return getHistoryView;
    }

    public static String commentFormatter(String comment){
        if (comment==null) {
           comment="";
            return comment;
        } else {
        return comment;
        }}

    }

