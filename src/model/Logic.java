package model;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Logic {

    public static void setUI() {
        ObservableList<String> daysComBox = FXCollections.observableArrayList();
        int n = 1;
        for (int i=0;i<31;){
           String  Strn = String.valueOf(n);
        daysComBox.add(i,Strn);
            i++;
    }
    }}