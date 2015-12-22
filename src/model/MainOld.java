package model;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;
import model.*;

public class MainOld {

        // Создаем основные компоненты интерфейса
    JFrame jfrm;
    JPanel IO_balance,historyPanel;
    JButton addOperation;
    JLabel currentBalanceTitle, currentBalanceValue, inputTitle, historyDayTitle, historyMonthTitle, historyYearTitle, categoryCommentTitle;
    JTextField inputField,categoryComment;
    JComboBox dayComBox,monthComBox,yearComBox,categorySelectComBox;
    JTextArea histotyView;
    JScrollPane hisrotyScroll;

        // Создаем промежуточную переменную для обновления данных баланса
    int balanceCount;

        // Добавляем экземпляры необходимых классов
    eHandler listener = new eHandler();
    GregorianCalendar gregorianCalendar = new GregorianCalendar();

        // Создаем конструктор
    MainOld() {

         // Создаем экземпляры Layout для расстановки компонентов внутри панели
        GridBagLayout grBaLa = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

            // Создаем основной фрейм и задаем ему параметры
        jfrm = new JFrame("HomeFinance");
        jfrm.setLayout(grBaLa);
        jfrm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfrm.setResizable(false);
        jfrm.setSize(500, 340);
        jfrm.setLocationRelativeTo(null);
         jfrm.setVisible(true);

         // Создаем панель с компонентами ввода/вывода данных и задаем ей параметры
        IO_balance = new JPanel();
        IO_balance.setLayout(grBaLa);
        IO_balance.setSize(230, 90);

            // Определяем компоненты используемые в данной панели
            currentBalanceTitle = new JLabel("Текущий баланс: ");
            currentBalanceValue = new JLabel(Engine.getBalance()+" руб."); // Здесь происходит считывание значение баланса из файла заданного в логикие приложения (класс Engine)
            inputTitle = new JLabel("Введите сумму:");
            inputField = new JTextField(10);
            addOperation = new JButton("Добавить/Отнять");

            // Расставляем компоненты и добавляем их в панель
            c.insets = new Insets(5, 5, 5, 5);
            c.gridx = 1;
            c.gridy = 0;
            grBaLa.setConstraints(currentBalanceTitle,c);
            IO_balance.add(currentBalanceTitle);
            c.gridx = 1;
            c.gridy = 1;
            c.gridwidth=2;
            c.gridheight=2;
            c.fill=GridBagConstraints.CENTER;
            grBaLa.setConstraints(currentBalanceValue,c);
            IO_balance.add(currentBalanceValue);
            c.gridwidth=1;
            c.gridheight=1;
            c.gridx = 1;
            c.gridy = 3;
            grBaLa.setConstraints(inputTitle,c);
            IO_balance.add(inputTitle);
            c.gridheight = 1;
            c.gridx = 1;
            c.gridy = 4;
            grBaLa.setConstraints(inputField,c);
            IO_balance.add(inputField);
            c.gridx = 1;
            c.gridy = 5;
            grBaLa.setConstraints(addOperation,c);
            IO_balance.add(addOperation);

            // Добавляем слушателя к кнопке
            addOperation.addActionListener(listener);

            // Создаем панель для формирования истории операций и задаем ей параметры
            historyPanel = new JPanel();
            historyPanel.setLayout(grBaLa);
            historyPanel.setSize(230, 90);

            // Создаем массивы для ComboBox'а
            String[] getDay = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
            String [] getMonth = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
            String  [] getYear = {"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"};
            String [] categorySelect = {"Продукты","Питание/проезд","Ипотека", "Интернет","Сотовая связь", "Прочие нужды"};

            // Создаем ComboBox'ы
            dayComBox = new JComboBox(getDay);
            monthComBox = new JComboBox(getMonth);
            yearComBox = new JComboBox(getYear);
            categorySelectComBox = new JComboBox(categorySelect);

            // Создаем лэйблы для ComboBox'ов
            historyDayTitle = new JLabel("День");
            historyMonthTitle = new JLabel("Месяц");
            historyYearTitle = new JLabel("Год");
            categoryCommentTitle = new JLabel("Примечание:");

            // Создаем текстовое поле для ввода комментариев к операции
            categoryComment = new JTextField(200);

            // Расставляем компоненты и добавляем их в панель
            c.gridwidth = 1;
            c.gridx = 1;
            c.gridy = 0;
            c.fill = GridBagConstraints.CENTER;
            grBaLa.setConstraints(historyDayTitle,c);
            historyPanel.add(historyDayTitle);
            c.gridx = 2;
            c.gridy = 0;
            grBaLa.setConstraints(historyMonthTitle,c);
            historyPanel.add(historyMonthTitle);
            c.gridx = 3;
            c.gridy = 0;
            grBaLa.setConstraints(historyYearTitle,c);
            historyPanel.add(historyYearTitle);
            c.gridx = 1;
            c.gridy = 1;
            grBaLa.setConstraints(dayComBox,c);
            dayComBox.setSelectedItem(getDay[gregorianCalendar.get(Calendar.DATE) - 1]);
            historyPanel.add(dayComBox);
            c.gridx = 2;
            c.gridy = 1;
            grBaLa.setConstraints(monthComBox,c);
            monthComBox.setSelectedItem(getMonth[gregorianCalendar.get(Calendar.MONTH)]);
            historyPanel.add(monthComBox);
            c.gridx = 3;
            c.gridy = 1;
            grBaLa.setConstraints(yearComBox,c);
            yearComBox.setSelectedItem(Year.now());
            historyPanel.add(yearComBox);
            c.gridwidth = 3;
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 1;
            c.gridy = 2;
            grBaLa.setConstraints(categorySelectComBox, c);
            categorySelectComBox.setSelectedItem(null);
            historyPanel.add(categorySelectComBox);
            c.gridx = 1;
            c.gridy = 3;
            grBaLa.setConstraints(categoryCommentTitle, c);
            historyPanel.add(categoryCommentTitle);
            c.gridx = 1;
            c.gridy = 4;
            grBaLa.setConstraints(categoryComment,c);
            historyPanel.add(categoryComment);

            // Создаем панель для отображения истории
            histotyView = new JTextArea(Engine.getHistory());
            hisrotyScroll = new JScrollPane(histotyView);

            // Добавляем панели
             c.fill = GridBagConstraints.CENTER;
            c.gridwidth = 1;
            c.gridx = 1;
            c.gridy = 0;
            grBaLa.setConstraints(IO_balance,c);
            jfrm.getContentPane().add(IO_balance);
            c.gridx = 1;
            c.gridy = 1;
            grBaLa.setConstraints(historyPanel, c);
            jfrm.getContentPane().add(historyPanel);
            c.gridx=2;
            c.gridy=0;
            c.gridheight=2;
            c.weightx = 1;
            c.fill=GridBagConstraints.BOTH;
            grBaLa.setConstraints(hisrotyScroll,c);
            jfrm.getContentPane().add(hisrotyScroll);
    }

        // Создаем слушателя
    public class eHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {

                // Пишем логику слушателя для единственной кнопки
            if (e.getSource() == addOperation) {
                if (inputField.getText().length() <= 6) // if-else конструкцией ограничим максимальное количество цифр в числе
                {
                    try {
                        int i = Integer.parseInt(inputField.getText());
                        balanceCount += i;
                        Engine.updateBalnce(balanceCount);                             // Записываем новый баланс в файл
                        currentBalanceValue.setText(String.valueOf(balanceCount));  // Отправляем новое значение баланса для отображения в интерфейсе

                        // Добавляем запись в историю

                        String dateToHistory = dayComBox.getSelectedItem().toString() + "/" + monthComBox.getSelectedItem().toString() + "/" + yearComBox.getSelectedItem().toString();
                        String moneyToHistory = inputField.getText().toString() + " RUB";
                        String categoryToHistory = String.valueOf(categorySelectComBox.getSelectedItem());
                        String commentToHistory = categoryComment.getText().toString();
                        if (categorySelectComBox.getSelectedItem() == null) {
                            categoryToHistory = "н/д";
                        }
                        String totalHistory = dateToHistory + " " + moneyToHistory + " " + categoryToHistory + " " + commentToHistory;
                        Engine.updateHistory(totalHistory);

                    } catch (NumberFormatException exc) {
                        JOptionPane.showMessageDialog(null, "Необходимо ввести целое число!" + '\n' + "Ошибка: " + exc, "Ошибка ввода", 0);
                    }




                            // Обновляем отображаемую историю
                         histotyView.setText(Engine.getHistory());

                            // Очищаем все вводимые параметры
                         categorySelectComBox.setSelectedItem(null);
                         inputField.setText(null);
                         categoryComment.setText(null);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Вы ввели слишком большое число!");
                }
            }

        }
    }
    // Создаем главную функцию для запуска приложения в потоке событий
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new MainOld();

            }
        });

    }
}