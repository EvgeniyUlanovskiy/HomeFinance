package controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


@FXML private ComboBox<String> dayComBox;
    ObservableList<String> setDayComboBox = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");

@FXML private ComboBox<String> monthComBox;
    ObservableList<String> setMonthComBox = FXCollections.observableArrayList(
            "январь",
            "февраль",
            "март",
            "апрель",
            "май",
            "июнь",
            "июль",
            "сентябрь",
            "октябрь",
            "ноябрь",
            "декабрь"
   );
@FXML private ComboBox<String> yearComBox;
    ObservableList<String> setYearComBox = FXCollections.observableArrayList(
            "2016",
            "2017",
            "2018",
            "2019",
            "2020");

@FXML private Label currentBalanceValue;

    public void initialize(URL location, ResourceBundle resources) {
        dayComBox.setItems(setDayComboBox);
        monthComBox.setItems(setMonthComBox);
        yearComBox.setItems(setYearComBox);
        currentBalanceValue.setText("1365");
    }
}


