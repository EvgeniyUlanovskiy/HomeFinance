package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ComboBoxCollections {

    public static ObservableList<String> setDayComboBox = FXCollections.observableArrayList(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "21",
            "22",
            "23",
            "24",
            "25",
            "26",
            "27",
            "28",
            "29",
            "30",
            "31"
    );

    public static ObservableList<String> setMonthComBox = FXCollections.observableArrayList(
            "января",
            "февраля",
            "марта",
            "апреля",
            "мая",
            "июня",
            "июля",
            "августа",
            "сентября",
            "октября",
            "ноября",
            "декабря"
    );

    public static ObservableList<String> setYearComBox = FXCollections.observableArrayList(
            "2016",
            "2017",
            "2018",
            "2019",
            "2020",
            "2021",
            "2022",
            "2023",
            "2024",
            "2025",
            "2026"
    );

    public static ObservableList<String> setCategorySelectComBox = FXCollections.observableArrayList(
            "Продукты",
            "Питание/проезд",
            "Памперсы/детское питание",
            "Ипотека",
            "Зарплата",
            "Прочее"
    );

}
