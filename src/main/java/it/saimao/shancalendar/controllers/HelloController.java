package it.saimao.shancalendar.controllers;

import it.saimao.shancalendar.mmcalendar.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private HBox row0;

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
    private Label lbYear, lbDetail, lbDesc;

    @FXML
    private Button btPrev, btNext;
    LocalDate currentDate, selectedDate;
    MyanmarDate selectedMyanmarDate;


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

        createCalendarHeader();
        createCalendar();

    }

    private void createCalendarHeader() {
        for (int i = 0; i < 10; i ++) {
            Button btHeader = (Button) row0.getChildren().get(i);
            btHeader.setText(ShanDate.mePee[i]);
        }
    }

    private int monthLength;

    private void setDateDetail() {
        selectedMyanmarDate = MyanmarDateConverter.convert(selectedDate.getYear(), selectedDate.getMonthValue(), selectedDate.getDayOfMonth());
        lbDetail.setText(
                selectedDate.toString() + "\n" +
                        getFirstDayOfMonth().getMonth() + " - " + getFirstDayOfMonth().plusMonths(1).getMonth()
        );
        lbMonth.setText(selectedMyanmarDate.getShanMonth() + "");
        lbYear.setText("ပီႊတႆး - " + selectedMyanmarDate.getShanYear() + " ၼီႈ\nသႃႇသၼႃႇ - " + selectedMyanmarDate.getBuddhistEra() + " ဝႃႇ");
        monthLength = selectedMyanmarDate.getMonthLength();
        lbDesc.setText(
                selectedMyanmarDate.format("S s k ၊ B y k ၊ M p f r nE") + "\n" +
//                        AstroConverter.convert(myanmarDate).toString() + "\n" +
                        "ဝၼ်းတႆး - " + ShanDate.getWannTai60(selectedDate.toEpochDay()) +
                        " ၊ " + ShanDate.getWannMwe(selectedMyanmarDate) +
                        " ၊ " + ShanDate.getWannPheeKin(selectedMyanmarDate) +
                        ShanDate.toString(selectedDate, selectedMyanmarDate)
        );


    }


    private void createCalendar() {

        clearCalendarView();
        selectedDate = getFirstDayOfMonth();
        setDateDetail();

        int dayToHide = ShanDate.getMePeeInt(selectedDate.toEpochDay());


        int totalMonthDay = 0;

        for (int i = 0; i < 40; i++) {

            // Invisible cells that won't be used
            if (i < dayToHide) {
                row1.getChildren().get(i).setVisible(false);
            } else {
                int index = i % 10;
                VBox vBox;
                if (i / 10 == 0) {
                    // row 1
                    vBox = (VBox) row1.getChildren().get(index);
                } else if (i / 10 == 1) {
                    // row 2
                    vBox = (VBox) row2.getChildren().get(index);
                } else if (i / 10 == 2) {
                    // row 3
                    vBox = (VBox) row3.getChildren().get(index);
                } else {
                    // row 4
                    vBox = (VBox) row4.getChildren().get(index);
                }

                if (totalMonthDay >= monthLength) {
                    vBox.setVisible(false);
                }

                if (vBox.isVisible()) {
                    // Set Date Cell label
                    LocalDate ld = getFirstDayOfMonth().plusDays(totalMonthDay);
                    MyanmarDate md = MyanmarDateConverter.convert(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());

                    HBox hb = (HBox) vBox.getChildren().get(0);
                    Label engDay = (Label) hb.getChildren().get(1);
                    Label lukWann = (Label) hb.getChildren().get(0);
                    lukWann.setText(md.getWeekDay());
                    engDay.setText(String.valueOf(ld.getDayOfMonth()));
                    Label shanDay = (Label) vBox.getChildren().get(1);
                    shanDay.setText(md.getMonthDay() + "");
                    Label week12Day = (Label) vBox.getChildren().get(2);
                    week12Day.setText(ShanDate.getLukPee(ld.toEpochDay()));
                    vBox.setUserData(ld);
                    vBox.setOnMouseClicked(this::clickDate);

                    // Decoration
                    if (ld.isEqual(LocalDate.now())) {
                        selectedDate = LocalDate.now();
                        selectDate(vBox);
                    } else if (ld.isEqual(selectedDate)) {
                        selectDate(vBox);
                    }
                    setDateDecoration(vBox);

                }

                totalMonthDay++;
            }

        }
    }

    VBox preSelectedDate = null;

    private void clickDate(MouseEvent event) {
        VBox vb = (VBox) event.getSource();
        selectDate(vb);
    }

    private void selectDate(VBox vb) {
        if (preSelectedDate != null) {
            preSelectedDate.setStyle("-fx-background-color: white;");
        }
        selectedDate = (LocalDate) vb.getUserData();
        vb.setStyle("-fx-background-color: cyan;");
        preSelectedDate = vb;
        setDateDetail();
        setDateDecoration(vb);

    }

    private void setDateDecoration(VBox vb) {

        LocalDate ld = (LocalDate) vb.getUserData();
        MyanmarDate md = MyanmarDateConverter.convert(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
        Label shanDay = (Label) vb.getChildren().get(1);
        if (md.getMoonPhraseInt() == 1) {
            shanDay.setTextFill(Color.valueOf("#ffdf00"));
        } else if (md.getMoonPhraseInt() == 3) {
            // new moon
            shanDay.setTextFill(Color.valueOf("#555"));
        } else {
            // normal day
            shanDay.setTextFill(Color.valueOf("#007bff"));
        }
    }

    private void clearCalendarView() {
        row1.getChildren().forEach(node -> node.setVisible(true));
        row2.getChildren().forEach(node -> node.setVisible(true));
        row3.getChildren().forEach(node -> node.setVisible(true));
        row4.getChildren().forEach(node -> node.setVisible(true));
    }


    private void gotoPrevMonth() {
        selectedDate = selectedDate.minusDays(selectedMyanmarDate.getMonthLength());
        createCalendar();
    }

    private void gotoNextMonth() {
        System.out.println("Before : " + selectedDate);
        selectedDate = selectedDate.plusDays(selectedMyanmarDate.getMonthLength());
        System.out.println("After : " + selectedDate);
        createCalendar();
    }


    public LocalDate getFirstDayOfMonth() {
        MyanmarDate myanmarDate = MyanmarDateConverter.convert(selectedDate.getYear(), selectedDate.getMonthValue(), selectedDate.getDayOfMonth());
        return selectedDate.minusDays(myanmarDate.getMonthDay() - 1);
    }

}