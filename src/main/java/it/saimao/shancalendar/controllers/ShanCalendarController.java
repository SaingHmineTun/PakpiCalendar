package it.saimao.shancalendar.controllers;

import it.saimao.shancalendar.mmcalendar.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ShanCalendarController implements Initializable {

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
    private Label lbYear, lbBuddhistYear, lbDetail, lbDesc;

    @FXML
    private Button btPrev, btNext;

    @FXML
    private DatePicker dpSelected;
    LocalDate selectedDate, dpDate;
    MyanmarDate selectedMyanmarDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Config.initDefault(
                new Config.Builder()
                        .setCalendarType(CalendarType.ENGLISH)
                        .setLanguage(Language.SHAN)
                        .build());

        btNext.setOnAction(event -> gotoNextMonth());
        btPrev.setOnAction(event -> gotoPrevMonth());

        dpSelected.setOnHidden(event -> gotoSelectedDate());
        selectedDate = LocalDate.now();

        createCalendarHeader();
        createCalendar();
    }

    private void createCalendarHeader() {
        for (int i = 0; i < 10; i++) {
            Button btHeader = (Button) row0.getChildren().get(i);
            btHeader.setText(ShanDate.mePee[i]);
            if (i % 5 == 0) {
                btHeader.setStyle("-fx-background-color: #420C09;");
            }
        }
    }

    private void setDateDetail() {
        dpSelected.setValue(selectedDate);
        lbDetail.setText(
                getFirstDayOfMonth().getMonth() + " - " + getFirstDayOfMonth().plusMonths(1).getMonth()
        );
        lbMonth.setText(selectedMyanmarDate.getMonthName());
        lbBuddhistYear.setText(
                "ပီႊတႆး - " + selectedMyanmarDate.getShanYear() + " ၼီႈ" +
                        "\nပီႊမိူင်း - " + ShanDate.getPeeMurng(selectedMyanmarDate.getShanYearInt()) +
                        "\nပီႊထမ်း - " + ShanDate.getPeeHtam(selectedDate.getYear())
        );
        lbYear.setText("ပီႊသႃႇသၼႃႇ - " + selectedMyanmarDate.getBuddhistEra() + "\n" +
                "ပီႊၵေႃးၸႃႇ - " + selectedMyanmarDate.getYear() + "\n" +
                "ပီႊၶရိတ်ႉ - " + selectedDate.getYear());
        lbDesc.setText(description());


    }

    private String description() {
        StringBuilder sb = new StringBuilder();
        sb.append(HolidayCalculator.toString(selectedMyanmarDate));
        sb.append(selectedMyanmarDate.getMonthName()).append(" ");
        sb.append(selectedMyanmarDate.getMoonPhase()).append(" ");
        sb.append(selectedMyanmarDate.getFortnightDay()).append(" ");
        sb.append(selectedMyanmarDate.getMoonPhraseInt() == 0 ? " ဝၼ်း" : "").append(selectedMyanmarDate.getMoonPhraseInt() == 2 ? " ၶမ်ႈ" : "").append("၊ ");
        sb.append("ဝၼ်း").append(ShanDate.getWannTai60(selectedDate.toEpochDay())).append("၊ ");
        sb.append("ဝၼ်း").append(selectedMyanmarDate.getWeekDay()).append("။\n");
        sb.append(ShanDate.toString(selectedDate, selectedMyanmarDate));
        return sb.toString();
    }


    private void createCalendar() {

        clearCalendarView();

        LocalDate firstDayOfMonth = getFirstDayOfMonth();
        MyanmarDate firstDayOfMonthMM = MyanmarDateConverter.convert(firstDayOfMonth.getYear(), firstDayOfMonth.getMonthValue(), firstDayOfMonth.getDayOfMonth());
        int monthLength = firstDayOfMonthMM.getMonthLength();
        int dayToHide = ShanDate.getMePeeInt(firstDayOfMonth.toEpochDay());
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
                    // Set Date Cell Data
                    LocalDate ld = firstDayOfMonth.plusDays(totalMonthDay);
                    MyanmarDate md = MyanmarDateConverter.convert(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());

                    HBox hb = (HBox) vBox.getChildren().get(0);
                    // English Day - ဝၼ်းဢၢင်းၵိတ်ႈ
                    Label engDay = (Label) hb.getChildren().get(1);
                    engDay.setText(String.valueOf(ld.getDayOfMonth()));
                    // Luk Wann - လုၵ်ႈဝၼ်း ( ၸၼ်, ဢင်းၵၢၼ်း )
                    Label lukWann = (Label) hb.getChildren().get(0);
                    lukWann.setText(md.getWeekDay());
                    // Shan Day - ဝၼ်းတႆး
                    Label shanDay = (Label) vBox.getChildren().get(1);
                    shanDay.setText(md.getMonthDay(LanguageCatalog.getInstance()));
                    // Wann Luk Pee - ဝၼ်းလုၵ်ႈပီႊ (ၸႂ်ႉ၊ ပဝ်ႉ၊ ယီး)
                    Label wannLukPee = (Label) vBox.getChildren().get(2);
                    wannLukPee.setText(ShanDate.getLukPee(ld.toEpochDay()));
                    vBox.setUserData(ld);
                    vBox.setOnMouseClicked(this::selectDate);

                    // Decorate Cell : Selecting cell
                    if (ld.isEqual(LocalDate.now())) {
                        selectDate(vBox);
                    } else if (dpDate != null && ld.isEqual(dpDate)) {
                        selectDate(vBox);
                        dpDate = null;
                    } else if (ld.isEqual(firstDayOfMonth)) {
                        selectDate(vBox);
                    } else if (ShanDate.getMePeeInt(ld.toEpochDay()) % 5 == 0) {
                        vBox.setStyle(
                                "-fx-background-color: #420C0955; " +
                                        "-fx-border-color: #420C09;" +
                                        "-fx-border-width: 1px;"
                        );
//                        shanDay.setTextFill(Color.valueOf("#420C09"));
                    } else {
                        vBox.setStyle("-fx-background-color: white");
                    }

                    // Decorate cell label
                    if (md.getMoonPhraseInt() == 1) {
                        // full moon
//                        shanDay.setTextFill(Color.rgb(255, 255, 29));
                        vBox.setId("full-moon");
                    } else if (md.getMoonPhraseInt() == 3) {
                        // new moon
                        shanDay.setTextFill(Color.WHITE);
                        vBox.setId("new-moon");
                    } else {
                        // normal day
                        shanDay.setTextFill(Color.valueOf("#1E3A57"));
                        vBox.setId("");
                    }
                }

                totalMonthDay++;
            }

        }
    }

    VBox prevSelectedDate = null;

    private void selectDate(MouseEvent event) {
        VBox vb = (VBox) event.getSource();
        selectDate(vb);
    }

    private void selectDate(VBox vb) {
        selectedDate = (LocalDate) vb.getUserData();
        selectedMyanmarDate = MyanmarDateConverter.convert(selectedDate.getYear(), selectedDate.getMonthValue(), selectedDate.getDayOfMonth());
        setSelectedCellBackground(vb);
        setDateDetail();

    }

    private void setSelectedCellBackground(VBox vb) {
        /*
        If already had other cells selected,
        de-select it.
         */
        if (prevSelectedDate != null) {
            LocalDate localDate = (LocalDate) prevSelectedDate.getUserData();
            if (localDate.isEqual(LocalDate.now()))
                prevSelectedDate.setStyle("-fx-background-color: #28a74555");
            else if (ShanDate.getMePeeInt(localDate.toEpochDay()) % 5 == 0) {
                prevSelectedDate.setStyle("-fx-background-color: #420C0955;");
            } else
                prevSelectedDate.setStyle("-fx-background-color: white");
        }
        vb.setStyle("-fx-background-color: #1E3A5755;");
        prevSelectedDate = vb;
    }

    private void clearCalendarView() {
        row1.getChildren().forEach(node -> node.setVisible(true));
        row2.getChildren().forEach(node -> node.setVisible(true));
        row3.getChildren().forEach(node -> node.setVisible(true));
        row4.getChildren().forEach(node -> node.setVisible(true));
    }


    private void gotoPrevMonth() {
        selectedDate = selectedDate.minusDays(selectedMyanmarDate.getMonthDay());
        createCalendar();
    }

    private void gotoNextMonth() {
        if (selectedDate.equals(LocalDate.now())) {
            selectedDate = selectedDate.plusDays(selectedMyanmarDate.getMonthLength() - selectedMyanmarDate.getMonthDay()).plusDays(1);
        } else {
            selectedDate = selectedDate.plusDays(selectedMyanmarDate.getMonthLength());
        }
        createCalendar();
    }


    private void gotoSelectedDate() {
        if (!dpSelected.getValue().isEqual(selectedDate)) {
            selectedDate = dpSelected.getValue();
            dpDate = selectedDate;
            createCalendar();
        }
    }

    public LocalDate getFirstDayOfMonth() {
        MyanmarDate myanmarDate = MyanmarDateConverter.convert(selectedDate.getYear(), selectedDate.getMonthValue(), selectedDate.getDayOfMonth());
        return selectedDate.minusDays(myanmarDate.getMonthDay() - 1);
    }
}