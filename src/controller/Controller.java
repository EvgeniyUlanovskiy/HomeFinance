package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Account;
import model.Calculation;
import model.ComboBoxCollections;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

@FXML private ComboBox<String> dayComBox;
@FXML private ComboBox<String> monthComBox;
@FXML private ComboBox<String> yearComBox;
    @FXML
    private ComboBox<String> categorySelectComBox;
@FXML private Label currentBalanceValue;
    @FXML
    public TextField inputField;

    @FXML
    private void deposite(ActionEvent event) {
        Calculation.depositeToAccount(inputField.getText());
        currentBalanceValue.setText(Account.getBalance());
    }

    @FXML
    private void withdraw(ActionEvent event) {
        Calculation.withdrawToAccount(inputField.getText());
        currentBalanceValue.setText(Account.getBalance());
    }
    public void initialize(URL location, ResourceBundle resources) {
        dayComBox.setItems(ComboBoxCollections.setDayComboBox);
        monthComBox.setItems(ComboBoxCollections.setMonthComBox);
        yearComBox.setItems(ComboBoxCollections.setYearComBox);
        categorySelectComBox.setItems(ComboBoxCollections.setCategorySelectComBox);
        currentBalanceValue.setText(Account.getBalance());
    }
}


