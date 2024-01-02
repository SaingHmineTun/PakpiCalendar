package it.saimao.shancalendar.controllers;

import it.saimao.shancalendar.mmcalendar.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class HelloController implements Initializable {

    @FXML
    private HBox row1;

    @FXML
    private HBox row2;

    @FXML
    private HBox row3;

    @FXML
    private HBox row4;

    @FXML
    private Button lbMonth;

    @FXML
    private Label lbYear, lbDetail;

    @FXML
    private Button btPrev, btNext;
    LocalDate currentDate, selectedDate;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btNext.setOnAction(event -> gotoNextMonth());
        btPrev.setOnAction(event -> gotoPrevMonth());

        Config.initDefault(
                new Config.Builder()
                        .setCalendarType(CalendarType.ENGLISH)
                        .setLanguage(Language.SHAN)
                        .build());

        currentDate = LocalDate.now();
        selectedDate = currentDate;

        createCalendar();






    }

    private int monthLength;

    private void setDateDetail() {
        MyanmarDate myanmarDate = MyanmarDateConverter.convert(selectedDate.getYear(), selectedDate.getMonthValue(), selectedDate.getDayOfMonth());
        lbDetail.setText(
                selectedDate.toString() + "\n" +
                myanmarDate.format("S s k ၊ B y k ၊ M p f r ၊ nE ။")
        );
        lbMonth.setText(myanmarDate.getMonthName());
        lbYear.setText(myanmarDate.getShanYear());
        System.out.println(myanmarDate.getMonthDay());
        monthLength = myanmarDate.getMonthLength();
    }

    private void createCalendar() {

        clearCalendarView();

//        MyanmarDate myanmarDate = MyanmarDateConverter.convert(currentDate.getYear(), currentDate.getMonthValue(), currentDate.getDayOfMonth());
//        lbMonth.setText(myanmarDate.format("S s k ၊ B y k ၊ M p f r ၊ nE ။"));
//        lbYear.setText(myanmarDate.getShanYear());
//        System.out.println(myanmarDate.getMonthDay());

        selectedDate = getFirstDayOfMonth();
        setDateDetail();

        long dayCounts = ChronoUnit.DAYS.between(LocalDate.of(1996, 1, 1), selectedDate);
        int wannWhat = (int) (dayCounts % 10);
        System.out.println(wannWhat);

        for (int i = 0; i < wannWhat; i ++) {
            row1.getChildren().get(i).setVisible(false);
        }

        int totalMonthDay = 0;

        for (int i = wannWhat; i < 40; i ++) {
            int index = i % 10;
            LocalDate ld = null;
            Button bt = null;
            if (i / 10 == 0) {
                // row 1
                bt = (Button) row1.getChildren().get(index);
                ld = getFirstDayOfMonth().plusDays(totalMonthDay);
                MyanmarDate md = MyanmarDateConverter.convert(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
                bt.setText(md.getMonthDay() + "");
            } else if (i / 10 == 1) {
                // row 2
                if (totalMonthDay < monthLength) {
                    bt = (Button) row2.getChildren().get(index);
                    ld = getFirstDayOfMonth().plusDays(totalMonthDay);
                    MyanmarDate md = MyanmarDateConverter.convert(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
                    bt.setText(md.getMonthDay() + "");
                }
            } else if ( i / 10 == 2) {
                // row 3
                if (totalMonthDay < monthLength) {
                    bt = (Button) row3.getChildren().get(index);
                    ld = getFirstDayOfMonth().plusDays(totalMonthDay);
                    MyanmarDate md = MyanmarDateConverter.convert(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
                    bt.setText(md.getMonthDay() + "");
                }
            } else {
                bt = (Button) row4.getChildren().get(index);
                if (totalMonthDay < monthLength) {
                    ld = getFirstDayOfMonth().plusDays(totalMonthDay);
                    MyanmarDate md = MyanmarDateConverter.convert(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
                    bt.setText(md.getMonthDay() + "");
                } else {
                    bt.setVisible(false);
                }
            }

            totalMonthDay ++;
            // Decorate today's date
            if (bt != null) {
                 bt.setUserData(ld);
                 bt.setOnAction(this::clickDate);
            }
            if (ld != null && ld.isEqual(LocalDate.now())) {
                bt.setStyle("-fx-background-color: #d4a808;");
                selectedDate = LocalDate.now();
                setDateDetail();
            } else {
                bt.setStyle("-fx-background-color: white;");
            }

        }
    }

    Button preSelectedDate = null;
    private void clickDate(ActionEvent event) {
        Button btn = (Button) event.getSource();
        if (preSelectedDate != null) {
            preSelectedDate.setStyle("-fx-background-color: white;");
            LocalDate prevDate = (LocalDate) preSelectedDate.getUserData();
            if (prevDate != null && prevDate.isEqual(LocalDate.now())) {
                preSelectedDate.setStyle("-fx-background-color: #d4a808;");
            }
        }
        selectedDate = (LocalDate) btn.getUserData();
        btn.setStyle("-fx-background-color: cyan;");
        preSelectedDate = btn;
        setDateDetail();
    }

    private void clearCalendarView() {
        row1.getChildren().forEach(node -> node.setVisible(true));
        row2.getChildren().forEach(node -> node.setVisible(true));
        row3.getChildren().forEach(node -> node.setVisible(true));
        row4.getChildren().forEach(node -> node.setVisible(true));
    }


    private void gotoPrevMonth() {
        currentDate = currentDate.minusMonths(1);
        selectedDate = currentDate;
        createCalendar();
    }

    private void gotoNextMonth() {
        currentDate = currentDate.plusMonths(1);
        selectedDate = currentDate;
        createCalendar();
    }


    public LocalDate getFirstDayOfMonth() {
        MyanmarDate myanmarDate = MyanmarDateConverter.convert(currentDate.getYear(), currentDate.getMonthValue(), currentDate.getDayOfMonth());
        LocalDate localDate = currentDate.minusDays(myanmarDate.getMonthDay()).plusDays(currentDate.getDayOfMonth());
        return localDate;
    }

}