package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Account;
import model.Calculation;
import model.ComboBoxCollections;
import model.History;

import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

public class Controller implements Initializable {
@FXML public ComboBox<String> dayComBox;
@FXML public ComboBox<String> monthComBox;
@FXML public ComboBox<String> yearComBox;
@FXML public ComboBox<String> categorySelectComBox;
@FXML public Label currentBalanceValue;
@FXML public TextField inputField;
@FXML public TextField categoryComment;
@FXML public TextArea historyArea;
    GregorianCalendar calendar = new GregorianCalendar();

    @FXML private void deposite(ActionEvent event) {
        Calculation.depositeToAccount(inputField.getText());
        currentBalanceValue.setText(Account.getBalance());
        History.setHistory(dayComBox.getValue()+"."+monthComBox.getValue()+"."+yearComBox.getValue()+" + "+inputField.getText()+" "+categorySelectComBox.getValue()+" "+History.commentFormatter(categoryComment.getText()));
        historyArea.setText(History.getHistory());
    }

    @FXML private void withdraw(ActionEvent event) {
        Calculation.withdrawToAccount(inputField.getText());
        currentBalanceValue.setText(Account.getBalance());
        History.setHistory(dayComBox.getValue()+"."+monthComBox.getValue()+"."+yearComBox.getValue()+" - "+inputField.getText()+" "+categorySelectComBox.getValue()+" "+History.commentFormatter(categoryComment.getText()));
        historyArea.setText(History.getHistory());
    }
    public void initialize(URL location, ResourceBundle resources) {
        dayComBox.setItems(ComboBoxCollections.setDayComboBox);
        dayComBox.setValue(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
        monthComBox.setItems(ComboBoxCollections.setMonthComBox);
        monthComBox.setValue(ComboBoxCollections.setMonthComBox.get(calendar.get(Calendar.MONTH)));
        yearComBox.setItems(ComboBoxCollections.setYearComBox);
        yearComBox.setValue(String.valueOf(calendar.get(Calendar.YEAR)));
        categorySelectComBox.setItems(ComboBoxCollections.setCategorySelectComBox);
        categorySelectComBox.setValue("Прочее");
        currentBalanceValue.setText(Account.getBalance());
        historyArea.setText(History.getHistory());
    }
}


