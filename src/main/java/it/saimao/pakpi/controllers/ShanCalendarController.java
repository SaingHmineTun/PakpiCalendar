package it.saimao.pakpi.controllers;

import it.saimao.pakpi.mmcalendar.*;
import it.saimao.pakpi.utils.Perc;
import it.saimao.pakpi.utils.ShanDate;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

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
    private Label lbYear, lbBuddhistYear, lbDetail, lbHoliday;

    @FXML
    private Label lbDesc;

    @FXML
    private Button btPrev, btNext, btSearch;

    @FXML
    private DatePicker dpSelected;
    @FXML
    private VBox rightBox;
    private LocalDate selectedDate, dpDate;
    private MyanmarDate selectedMyanmarDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Config.initDefault(
                new Config.Builder()
                        .setCalendarType(CalendarType.ENGLISH)
                        .setLanguage(Language.TAI)
                        .build());

        btNext.setOnAction(event -> gotoNextMonth());
        btPrev.setOnAction(event -> gotoPrevMonth());


        adjustSize();
        customizeDatePicker();
        createCalendarHeader();
        createCalendar();
    }

    private void adjustSize() {
        rightBox.setPrefWidth(Perc.getDynamicPixel(300));
    }

    private void customizeDatePicker() {

        dpSelected.setOnHidden(event -> {
            gotoSelectedDate();
        });

        btSearch.setOnAction(event -> {
            gotoSelectedDate();
        });

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dpSelected.setConverter(new StringConverter<>() {
            @Override
            public String toString(LocalDate object) {
                if (object != null)
                    return formatter.format(object);
                else
                    return "";
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty())
                    return LocalDate.parse(string, formatter);
                return null;
            }
        });
        selectedDate = LocalDate.now();
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
        ShanDate shanDate = new ShanDate(selectedMyanmarDate);
        dpSelected.setValue(selectedDate);
        lbDetail.setText(
                getFirstDayOfMonth().getMonth() + " - " + getFirstDayOfMonth().plusMonths(1).getMonth()
        );
        lbMonth.setText(ShanDate.translate(selectedMyanmarDate.getMonthName(Language.ENGLISH)));
        lbBuddhistYear.setText(
                "ပီႊတႆး - " + shanDate.getShanYear() + " ၼီႈ" +
                        "\nပီႊမိူင်း - " + ShanDate.getPeeMurng(shanDate.getShanYearValue()) +
                        "\nပီႊထမ်း - " + ShanDate.getPeeHtam(selectedDate.getYear())
        );
        lbYear.setText(ShanDate.translate("Sasana Year") + " - " + selectedMyanmarDate.getBuddhistEra() + "\n" +
                ShanDate.translate("Myanmar Year") + " - " + selectedMyanmarDate.getYear() + "\n" +
                ShanDate.translate("English Year") + " - " + selectedDate.getYear());
        var description = description();
        var holidays = ShanDate.getHolidays(selectedMyanmarDate);
        String holiday = "";
        if (!holidays.isEmpty()) {
            holiday = holidays.stream()
                    .map(n -> {
                        var str = ShanDate.translate(n);
                        return str == null ? n : str;
                    })
                    .collect(Collectors.joining(","));
        }

        if (!holiday.isEmpty()) {
            lbHoliday.setText(holiday);
            lbHoliday.setVisible(true);
            lbHoliday.setManaged(true);
        } else {
            lbHoliday.setVisible(false);
            lbHoliday.setManaged(false);
        }
        lbDesc.setText(description);


    }

    private String description() {
        StringBuilder sb = new StringBuilder();
        sb.append(ShanDate.translate(selectedMyanmarDate.getMonthName(Language.ENGLISH))).append(" ");
        if (selectedMyanmarDate.getMoonPhaseValue() == 1 || selectedMyanmarDate.getMoonPhaseValue() == 3) {
            sb.append(selectedMyanmarDate.getMoonPhase()).append("၊ ");
        } else {
            sb.append(selectedMyanmarDate.getMoonPhase()).append(" ");
            sb.append(selectedMyanmarDate.getFortnightDay()).append(" ");
            sb.append(selectedMyanmarDate.getMoonPhaseValue() == 0 ? " ဝၼ်း" : "").append(selectedMyanmarDate.getMoonPhaseValue() == 2 ? " ၶမ်ႈ" : "").append("၊ ");

        }
        sb.append("ဝၼ်း").append(ShanDate.getWannTai60(selectedDate.toEpochDay())).append("၊ ");
        sb.append("ဝၼ်း").append(selectedMyanmarDate.getWeekDay()).append("။\n");
        sb.append(ShanDate.toString(selectedDate, selectedMyanmarDate));
        return sb.toString();
    }


    private void createCalendar() {

        resetCalendarView();

        LocalDate firstDayOfMonth = getFirstDayOfMonth();
        MyanmarDate firstDayOfMonthMM = MyanmarDate.of(firstDayOfMonth);
        int monthLength = firstDayOfMonthMM.lengthOfMonth();
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
                    MyanmarDate md = MyanmarDate.of(ld);

                    HBox hb = (HBox) vBox.getChildren().get(0);
                    // English Day - ဝၼ်းဢၢင်းၵိတ်ႈ
                    Label engDay = (Label) hb.getChildren().get(1);
                    engDay.setText(String.valueOf(ld.getDayOfMonth()));
                    // Luk Wann - လုၵ်ႈဝၼ်း ( ၸၼ်, ဢင်းၵၢၼ်း )
                    Label lukWann = (Label) hb.getChildren().get(0);
                    lukWann.setText(md.getWeekDay());
                    // Shan Day - ဝၼ်းတႆး
                    Label shanDay = (Label) vBox.getChildren().get(1);
                    shanDay.setText(LanguageTranslator.translate(md.getDayOfMonth(), Language.TAI));
                    // Wann Luk Pee - ဝၼ်းလုၵ်ႈပီႊ (ၸႂ်ႉ၊ ပဝ်ႉ၊ ယီး)
                    Label wannLukPee = (Label) vBox.getChildren().get(2);
                    wannLukPee.setText(ShanDate.getLukPee(ld.toEpochDay()));
                    vBox.setUserData(ld);
                    vBox.setOnMouseClicked(this::selectDate);

                    // Decorate Cell : Selecting cell
                    if (ld.isEqual(LocalDate.now())) {
                        if (dpDate == null)
                            selectDate(vBox);
                        else
                            vBox.setStyle("-fx-background-color: #28a74555");
                    } else if (dpDate != null && ld.isEqual(dpDate)) {
                        selectDate(vBox);
                    } else if (ld.isEqual(firstDayOfMonth)) {
                        selectDate(vBox);
                    } else if (ShanDate.getMePeeInt(ld.toEpochDay()) % 5 == 0) {
                        vBox.setStyle(
                                "-fx-background-color: #420C0955; " +
                                        "-fx-border-color: #420C09;" +
                                        "-fx-border-width: 1px;"
                        );
                    } else {
                        vBox.setStyle("-fx-background-color: white");
                    }

                    // Decorate cell label
                    if (md.getMoonPhaseValue() == 1) {
                        // full moon
//                        shanDay.setTextFill(Color.rgb(255, 255, 29));
                        vBox.setId("full-moon");
                    } else if (md.getMoonPhaseValue() == 3) {
                        // new moon
                        shanDay.setTextFill(Color.WHITE);
                        vBox.setId("new-moon");
                    } else {
                        // normal day
                        vBox.setId("");
                    }

                    // Decorate English Date Label
                    if (ShanDate.isHoliday(md)/* || ld.getDayOfWeek() == DayOfWeek.SATURDAY || ld.getDayOfWeek() == DayOfWeek.SUNDAY*/) {
                        shanDay.setTextFill(Color.valueOf("#630C09"));
                    } else {
                        shanDay.setTextFill(Color.valueOf("#1E3A57"));
                    }

                }

                totalMonthDay++;
            }

        }
        dpDate = null;
    }

    VBox prevSelectedDate = null;

    private void selectDate(MouseEvent event) {
        VBox vb = (VBox) event.getSource();
        selectDate(vb);
    }

    private void selectDate(VBox vb) {
        selectedDate = (LocalDate) vb.getUserData();
        selectedMyanmarDate = MyanmarDate.of(selectedDate);
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

    private void resetCalendarView() {
        row1.getChildren().forEach(node -> {
            if (!node.isVisible()) node.setVisible(true);
        });
        row2.getChildren().forEach(node -> {
            if (!node.isVisible()) node.setVisible(true);
        });
        row3.getChildren().forEach(node -> {
            if (!node.isVisible()) node.setVisible(true);
        });
        row4.getChildren().forEach(node -> {
            if (!node.isVisible()) node.setVisible(true);
        });
    }


    private void gotoPrevMonth() {
        selectedDate = selectedDate.minusDays(selectedMyanmarDate.getDayOfMonth());
        createCalendar();
    }

    private void gotoNextMonth() {
        if (selectedDate.equals(LocalDate.now())) {
            selectedDate = selectedDate.plusDays(selectedMyanmarDate.lengthOfMonth() - selectedMyanmarDate.getDayOfMonth()).plusDays(1);
        } else {
            selectedDate = selectedDate.plusDays(selectedMyanmarDate.lengthOfMonth() - selectedMyanmarDate.getDayOfMonth() + 1);
        }
        createCalendar();
    }


    private void gotoSelectedDate() {
        System.out.println("Go to selected date");
        System.out.println(dpSelected.getValue().isEqual(selectedDate));
        if (!dpSelected.getValue().isEqual(selectedDate)) {
            selectedDate = dpSelected.getValue();
            dpDate = selectedDate;
            createCalendar();
        }
    }

    public LocalDate getFirstDayOfMonth() {
        MyanmarDate myanmarDate = MyanmarDate.of(selectedDate);

        return selectedDate.minusDays(myanmarDate.getDayOfMonth() - 1);
    }
}