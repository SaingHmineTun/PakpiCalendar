package it.saimao.shancalendar.mmcalendar;

import java.util.ArrayList;
import java.util.List;

/**
 * Holiday Calculator
 *
 * @author <a href="mailto:chanmratekoko.dev@gmail.com">Chan Mrate Ko Ko</a>
 * @version 1.0
 */
public final class HolidayCalculator {

    /**
     * Don't let anyone instantiate this class.
     */
    private HolidayCalculator() {
    }

    /**
     * Eid
     */
    private static final int[] ghEid2 = new int[]{2456936, 2457290, 2457644, 2457998, 2458353};

    /**
     * Chinese New Year ref
     * http://www.mom.gov.sg/employment-practices/public-holidays ref
     * https://en.wikipedia.org/wiki/Chinese_New_Year
     */
    private static final int[] ghCNY = new int[]{2456689, 2456690, 2457073, 2457074, 2457427, 2457428, 2457782,
            2457783, 2458166, 2458167};

    private static final int[] ghDiwali = new int[]{2456599, 2456953, 2457337, 2457691, 2458045, 2458429};
    private static final int[] ghEid = new int[]{2456513, 2456867, 2457221, 2457576, 2457930, 2458285};

    /**
     * Check for English Holiday
     *
     * @param gy year
     * @param gm month [Jan=1, ... , Dec=12]
     * @param gd day [0-31]
     * @return Name of Holiday Strings List if exist
     */
    static List<String> englishHoliday(int gy, int gm, int gd) {

        List<String> holiday = new ArrayList<String>();

        if ((gy >= 2018) && (gm == 1) && (gd == 1)) {
            holiday.add("New Year Day");
        } else if ((gy >= 1948) && (gm == 1) && (gd == 4)) {
            holiday.add("Independence Day");
        } else if ((gy >= 1947) && (gm == 2) && (gd == 12)) {
            holiday.add("Union Day");
        } else if ((gy >= 1958) && (gm == 3) && (gd == 2)) {
            holiday.add("Peasants Day");
        } else if ((gy >= 1945) && (gm == 3) && (gd == 27)) {
            holiday.add("Resistance Day");
        } else if ((gy >= 1923) && (gm == 5) && (gd == 1)) {
            holiday.add("Labour Day");
        } else if ((gy >= 1947) && (gm == 7) && (gd == 19)) {
            holiday.add("Martyrs Day");
        } else if ((gm == 12) && (gd == 25)) {
            holiday.add("Christmas Day");
        } else if ((gy == 2017) && (gm == 12) && (gd == 30)) {
            holiday.add("Holiday");
        } else if ((gy >= 2017) && (gm == 12) && (gd == 31)) {
            holiday.add("Holiday");
        }

        return holiday;
    }

    static List<String> shanSpecialDays(MyanmarDate md) {
        List<String> shanSpecialDays = new ArrayList<>();
        int shanMonth = md.getShanMonth();
        if (shanMonth == 1 && md.getMonthDay() == 1) {
            shanSpecialDays.add("ဝၼ်းပီႊမႂ်ႇတႆး");
        } else if (shanMonth == 2 && md.getMoonPhrase() == 2 && md.getFortnightDayInt() == 14) {
            shanSpecialDays.add("ဝၼ်းလူႇၾႆးသုမ်လူဝ်");
        } else if (shanMonth == 3 && md.getMoonPhrase() == 1) {
            shanSpecialDays.add("ပွႆးလိူၼ်သၢမ်မူၼ်း");
        } else if (shanMonth == 3 && md.getMoonPhrase() == 2 && md.getFortnightDayInt() == 3) {
            shanSpecialDays.add("ဝၼ်းဢူဝ်ႈပဵမ်ႇသၢမ်လေႃး");
        } else if (shanMonth == 4 && md.getMoonPhrase() == 1) {
            shanSpecialDays.add("ပွႆးလိူၼ်သီႇမူၼ်း");
        } else if (shanMonth == 6 && md.getMoonPhrase() == 1) {
            shanSpecialDays.add("ဝၼ်းပုတ်ႉထၸဝ်ႈ");
        } else if (shanMonth == 8 && md.getMoonPhrase() == 1) {
            shanSpecialDays.add("ဝၼ်းထမ်ႇမၸၵ်ႉၵ (ၶဝ်ႈဝႃႇ)");
        } else if (shanMonth == 11 && md.getMoonPhrase() == 1) {
            shanSpecialDays.add("ဝၼ်းဢၽိထမ်ႇမႃႇ (ဢွၵ်ႇဝႃႇ)");
        } else if (shanMonth == 11 && md.getMoonPhrase() == 2 && md.getFortnightDayInt() == 8) {
            shanSpecialDays.add("ပွႆးသၢဝ်းသၢမ်");
        } else if (shanMonth == 12 && md.getMoonPhrase() == 1) {
            shanSpecialDays.add("ပွႆးၵႆႈတဵၼ်းႁဵင်");
        } else if (shanMonth == 12 && md.getMoonPhrase() == 3) {
            shanSpecialDays.add("ႁပ်ႉၸဵင်");
        }
        return shanSpecialDays;
    }

    /**
     * Check for Myanmar Holiday
     *
     * @param myear     Myanmar Year
     * @param mmonth    Myanmar month [Tagu=1, ... , Tabaung=12]
     * @param monthDay  Myanmar Month day [0-30]
     * @param moonPhase Moon phase [0=waxing, 1=full moon, 2=waning, 3=new moon]
     * @return Name of Holiday Strings List if exist
     */
    static List<String> myanmarHoliday(double myear, int mmonth, int monthDay, int moonPhase) {

        List<String> holiday = new ArrayList<String>();

        if ((mmonth == 2) && (moonPhase == 1)) {
            holiday.add("Buddha Day");
        } // Vesak day
        else if ((mmonth == 4) && (moonPhase == 1)) {
            holiday.add("Start of Buddhist Lent");
        } // Warso day
        else if ((mmonth == 7) && (moonPhase == 1)) {
            holiday.add("End of Buddhist Lent");
        } else if ((myear >= 1379) && (mmonth == 7) && (monthDay == 14 || monthDay == 16)) {
            holiday.add("Holiday");
        } else if ((mmonth == 8) && (moonPhase == 1)) {
            holiday.add("Tazaungdaing");
        } else if ((myear >= 1379) && (mmonth == 8) && (monthDay == 14)) {
            holiday.add("Holiday");
        } else if ((myear >= 1282) && (mmonth == 8) && (monthDay == 25)) {
            holiday.add("National Day");
        } else if ((mmonth == 10) && (monthDay == 1)) {
            holiday.add("Karen New Year Day");
        } else if ((mmonth == 12) && (moonPhase == 1)) {
            holiday.add("Tabaung Pwe");
        }

        return holiday;
    }

    /**
     * @param jdn       Julian Day Number to check
     * @param myear     Myanmar year
     * @param monthType Myanmar month type [oo=0, hnaung=1
     * @return List of holiday String
     */
    public static List<String> thingyan(double jdn, double myear, int monthType) {

        // start of Thingyan
        int BGNTG = 1100;

        List<String> holiday = new ArrayList<String>();

        // double atat;
        double akn, atn;
        // start of third era
        int SE3 = 1312;

        double ja = Constants.SY * (myear + monthType) + Constants.MO;
        double jk;

        if (myear >= SE3) {
            jk = ja - 2.169918982;
        } else {
            jk = ja - 2.1675;
        }

        akn = Math.round(jk);
        atn = Math.round(ja);

        // if (jdn == (atn + 1))
        if (Math.abs(jdn - (atn + 1)) < 0.0000001) {
            holiday.add("Myanmar New Year Day");
        }

        if ((myear + monthType) >= BGNTG) {
            if (jdn == atn) {
                holiday.add("Thingyan Atat");
            } else if ((jdn > akn) && (jdn < atn)) {
                holiday.add("Thingyan Akyat");
            } else if (jdn == akn) {
                holiday.add("Thingyan Akya");
            } else if (jdn == (akn - 1)) {
                holiday.add("Thingyan Akyo");
            } else if (((myear + monthType) >= 1369) && ((myear + monthType) < 1379)
                    && ((jdn == (akn - 2)) || ((jdn >= (atn + 2)) && (jdn <= (akn + 7))))) {
                holiday.add("Holiday");
            }
        }

        return holiday;
    }

    /**
     * Other holidays (ohol) Diwali or Eid
     *
     * @param jd Julian day number
     * @return List of holiday String
     */
    public static List<String> otherHolidays(double jd) {

        List<String> holiday = new ArrayList<String>();

        if (BinarySearchUtil.search(jd, ghDiwali) >= 0) {
            holiday.add("Diwali");
        }
        if (BinarySearchUtil.search(jd, ghEid) >= 0) {
            holiday.add("Eid");
        }

        return holiday;
    }

    /**
     * Anniversary day
     *
     * @param jd           Julian Day Number,
     * @param calendarType calendar type [Optional argument: 0=english (default),
     *                     1=Gregorian, 2=Julian]
     * @return dependency: DoE(), j2w()
     */
    public static List<String> ecd(double jd, CalendarType calendarType) {
        // ct=ct||0;
        if (calendarType == null) {
            calendarType = CalendarType.ENGLISH;
        }

        List<String> holiday = new ArrayList<String>();

        WesternDate wd = WesternDateConverter.convert(jd, calendarType);
        double doe = DoE(wd.getYear());

        if ((wd.getYear() <= 2017) && (wd.getMonth() == 1) && (wd.getDay() == 1)) {
            holiday.add("New Year Day");
        } else if ((wd.getYear() > 1945) && wd.getMonth() == 2 && wd.getDay() == 7) {
            holiday.add("Shan National Day");
        } else if ((wd.getYear() >= 1915) && (wd.getMonth() == 2) && (wd.getDay() == 13)) {
            holiday.add("G. Aung San BD");
        } else if ((wd.getYear() >= 1969) && (wd.getMonth() == 2) && (wd.getDay() == 14)) {
            holiday.add("Valentines Day");
        } else if ((wd.getYear() >= 1970) && (wd.getMonth() == 4) && (wd.getDay() == 22)) {
            holiday.add("Earth Day");
        } else if ((wd.getYear() >= 1392) && (wd.getMonth() == 4) && (wd.getDay() == 1)) {
            holiday.add("April Fools Day");
        } else if ((wd.getYear() >= 1948) && (wd.getMonth() == 5) && (wd.getDay() == 8)) {
            holiday.add("Red Cross Day");
        } else if ((wd.getYear() >= 1994) && (wd.getMonth() == 10) && (wd.getDay() == 5)) {
            holiday.add("World Teachers Day");
        } else if ((wd.getYear() >= 1947) && (wd.getMonth() == 10) && (wd.getDay() == 24)) {
            holiday.add("United Nations Day");
        } else if ((wd.getYear() >= 1753) && (wd.getMonth() == 10) && (wd.getDay() == 31)) {
            holiday.add("Halloween");
        }

        if ((wd.getYear() >= 1876) && (jd == doe)) {
            holiday.add("Easter");
        } else if ((wd.getYear() >= 1876) && (jd == (doe - 2))) {
            holiday.add("Good Friday");
        } else if (BinarySearchUtil.search(jd, ghEid2) >= 0) {
            holiday.add("Eid");
        }
        if (BinarySearchUtil.search(jd, ghCNY) >= 0) {
            holiday.add("Chinese New Year");
        }

        return holiday;
    }

    /**
     * Date of Easter using "Meeus/Jones/Butcher" algorithm Reference: Peter
     * Duffett-Smith, Jonathan Zwart',
     * "Practical Astronomy with your Calculator or Spreadsheet," 4th Etd,
     * Cambridge university press, 2011. Page-4.
     *
     * @param year Western year
     * @return julian day number dependency: w2j()
     */
    private static double DoE(int year) {
        double a = year % 19;
        double b = Math.floor(year / 100);
        double c = year % 100;
        double d = Math.floor(b / 4);
        double e = b % 4;
        double f = Math.floor((b + 8) / 25);
        double g = Math.floor((b - f + 1) / 3);
        double h = (19 * a + b - d - g + 15) % 30;
        double i = Math.floor(c / 4);
        double k = c % 4;
        double l = (32 + 2 * e + 2 * i - h - k) % 7;
        double m = Math.floor((a + 11 * h + 22 * l) / 451);
        double q = h + l - 7 * m + 114;
        int day = (int) ((q % 31) + 1);
        int month = (int) Math.floor(q / 31);
        // this is for Gregorian
        return WesternDateKernel.w2j(year, month, day, 1, 0);
    }

    /**
     * Myanmar Anniversary day
     *
     * @param myear     Myanmar year
     * @param mmonth    Myanmar month [Tagu=1, ... , Tabaung=12]
     * @param monthDay  Month day [1 to 30]
     * @param moonPhase Moon phase [0=waxing, 1=full moon, 2=waning, 3=new moon]
     * @return List of holiday String
     */
    public static List<String> mcd(double myear, int mmonth, int monthDay, int moonPhase) {

        List<String> holiday = new ArrayList<String>();

        if ((myear >= 1309) && (mmonth == 11) && (monthDay == 16)) {
            holiday.add("Mon National Day");
        } // the ancient founding of Hanthawady
        else if ((mmonth == 9) && (monthDay == 1)) {
            holiday.add("Shan New Year Day");
            if (myear >= 1306) {
                holiday.add("Authors Day");
            }
        } // Nadaw waxing moon 1
        else if ((mmonth == 3) && (moonPhase == 1)) {
            holiday.add("Mahathamaya Day");
        } // Nayon full moon
        else if ((mmonth == 6) && (moonPhase == 1)) {
            holiday.add("Garudhamma Day");
        } // Tawthalin full moon
        else if ((myear >= 1356) && (mmonth == 10) && (moonPhase == 1)) {
            holiday.add("Mothers Day");
        } // Pyatho full moon
        else if ((myear >= 1370) && (mmonth == 12) && (moonPhase == 1)) {
            holiday.add("Fathers Day");
        } // Tabaung full moon
        else if ((mmonth == 5) && (moonPhase == 1)) {
            holiday.add("Metta Day");
            // if(my>=1324) {hs[h++]="Mon Revolution Day";}//Mon Revolution day
        } // Waguang full moon
        else if ((mmonth == 5) && (monthDay == 10)) {
            holiday.add("Taungpyone Pwe");
        } // Taung Pyone Pwe
        else if ((mmonth == 5) && (monthDay == 23)) {
            holiday.add("Yadanagu Pwe");
        } // Yadanagu Pwe

        // else if((my>=1119) && (mm==2) && (md==23))
        // {hs[h++]="Mon Fallen Day";}
        // else if((mm==12) && (md==12)) {hs[h++]="Mon Women Day";}

        return holiday;
    }


    /**
     * @param myanmarDate MyanmarDate
     * @return List of holiday String
     */
    public static List<String> getHoliday(MyanmarDate myanmarDate) {
        return getHoliday(myanmarDate, Config.get().getCalendarType());
    }


    /**
     * @param myanmarDate  MyanmarDate
     * @param calendarType CalendarType
     * @return List of holiday String
     */
    public static List<String> getHoliday(MyanmarDate myanmarDate, CalendarType calendarType) {

        WesternDate westernDate = WesternDateConverter.convert(myanmarDate.jd, calendarType);
        // Office Off
        List<String> hde = englishHoliday(westernDate.getYear(), westernDate.getMonth(), westernDate.getDay());
        List<String> hdm = myanmarHoliday(myanmarDate.myear, myanmarDate.mmonth, myanmarDate.monthDay,
                myanmarDate.moonPhase);
        List<String> ssd = shanSpecialDays(myanmarDate);
        List<String> hdt = thingyan(myanmarDate.jd, myanmarDate.myear, myanmarDate.monthType);
        List<String> hdo = otherHolidays(myanmarDate.jd); // Diwali Eid

        List<String> holiday = new ArrayList<String>();

        holiday.addAll(hde);
        holiday.addAll(hdm);
        holiday.addAll(ssd);
        holiday.addAll(hdt);
        holiday.addAll(hdo);

        return holiday;
    }

    /**
     * @param myanmarDate MyanmarDate object
     * @return boolean
     */
    public static boolean isHoliday(MyanmarDate myanmarDate) {
        return getHoliday(myanmarDate).size() > 0 ? true : false;
    }

    /**
     * @param holidayList List Of Holiday
     * @return boolean
     */
    public static boolean isHoliday(List<String> holidayList) {
        return holidayList.size() > 0 ? true : false;
    }

    /**
     * @param myanmarDate MyanmarDate Object
     * @return List of holiday String
     */
    public static List<String> getAnniversary(MyanmarDate myanmarDate) {
        return getAnniversary(myanmarDate, Config.get().getCalendarType());
    }

    /**
     * @param myanmarDate  MyanmarDate
     * @param calendarType CalendarType
     * @return List of holiday String
     */
    public static List<String> getAnniversary(MyanmarDate myanmarDate, CalendarType calendarType) {
        List<String> ecd = ecd(myanmarDate.jd, calendarType); // anniversary day
        List<String> mcd = mcd(myanmarDate.myear, myanmarDate.mmonth, myanmarDate.monthDay, myanmarDate.moonPhase);

        List<String> holiday = new ArrayList<String>();

        holiday.addAll(ecd);
        holiday.addAll(mcd);

        return holiday;
    }

    public static String toString(MyanmarDate selectedMyanmarDate) {
        StringBuilder sb = new StringBuilder();
        for (String holiday : getHoliday(selectedMyanmarDate)) {
            String value = LanguageCatalog.getInstance().translate(holiday);
            // Do not want to make Shan special days localized
            if (value == null) value = holiday;
            sb.append(value).append("၊ ");

        }
        for (String holiday : getAnniversary(selectedMyanmarDate)) {
            String value = LanguageCatalog.getInstance().translate(holiday);
            // Do not want to make Shan special days localized
            if (value == null) value = holiday;
            sb.append(value).append("၊ ");

        }
        if (sb.toString().trim().endsWith("၊")) {
            sb.replace(sb.length() - 2, sb.length(), "။\n");
        }
        return sb.toString();
    }
}
