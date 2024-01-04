package it.saimao.shancalendar.mmcalendar;

public class ShanDate {

    public static final String[] weekDays10 = {"ၵၢပ်ႇ", "လပ်း", "ႁၢႆး", "မိူင်း", "ပိုၵ်း", "ၵတ်း", "ၶုတ်း", "ႁုင်ႉ", "တဝ်ႇ", "ၵႃႇ"};
    public static final String[] weekDays12 = {"ၸႂ်ႉ", "ပဝ်ႉ", "ယီး", "မဝ်ႉ", "သီ", "သႂ်ႉ", "သီင", "မူတ်ႉ", "သၼ်", "ႁဝ်ႉ", "မဵတ်ႉ", "ၵႂ်ႉ"};

    public static String getWeekDays12(long epochDay) {
        return ShanDate.weekDays12[(int) (epochDay + 5) % 12];
    }

    public static String getWeekDays10(long epochDay) {
        return ShanDate.weekDays10[(int) ((epochDay + 7) % 10)];
    }

    public static String getWannTai(long epochDay) {
        return getWeekDays10(epochDay) + getWeekDays12(epochDay);
    }

    public static String getWannTun(MyanmarDate md) {
        boolean isWannTun = false;
        int shanMonth = md.getShanMonth();
        if (shanMonth == 5 || shanMonth == 1) {
            if (md.getWeekDayInt() == 2 || md.getWeekDayInt() == 6) {
                isWannTun = true;
            }
        } else if (shanMonth == 6 || shanMonth == 2 || shanMonth == 10) {
            if (md.getWeekDayInt() == 5 || md.getWeekDayInt() == 0) {
                isWannTun = true;
            }
        } else if (shanMonth == 7 || shanMonth == 3 || shanMonth == 11) {
            if (md.getWeekDayInt() == 3 || md.getWeekDayInt() == 5) {
                isWannTun = true;
            }
        } else if (shanMonth == 8 || shanMonth == 4) {
            // လိူၼ်ပႅတ်ႇ
            if (md.getWeekDayInt() == 1 || md.getWeekDayInt() == 4) {
                isWannTun = true;
            }
        } else if (shanMonth == 9 || md.mmonth == 12) {
            // လိူၼ်ၵဝ်ႈ & လိူၼ်သိပ်းသွင်
            if (md.getWeekDayInt() == 4 || md.getWeekDayInt() == 6) {
                isWannTun = true;
            }
        }
        if (isWannTun) return "ဝၼ်းထုၼ်း";
        return "";
    }

    public static String getWannPyaat(MyanmarDate myanmarDate) {
        boolean isWannPyaat = false;
        int shanMonth = myanmarDate.getShanMonth();
        if (shanMonth == 6 || shanMonth == 10 || shanMonth == 2) {
            if (myanmarDate.getWeekDayInt() == 4 || myanmarDate.getWeekDayInt() == 6)
                isWannPyaat = true;
        } else if (shanMonth == 1 || shanMonth == 5 || shanMonth == 9) {
            if (myanmarDate.getWeekDayInt() == 5 || myanmarDate.getWeekDayInt() == 0)
                isWannPyaat = true;
        } else if (shanMonth == 3 || shanMonth == 7 || shanMonth == 11) {
            if (myanmarDate.getWeekDayInt() == 1 || myanmarDate.getWeekDayInt() == 2)
                isWannPyaat = true;
        } else if (shanMonth == 4 || shanMonth == 8 || shanMonth == 12) {
            if (myanmarDate.getWeekDayInt() == 3 || myanmarDate.getWeekDayInt() == 7)
                isWannPyaat = true;
        }
        if (isWannPyaat) return "ဝၼ်းပျၢတ်ႈ";
        return "";
    }

    public static String getHoNagaa(MyanmarDate myanmarDate) {
        int shanMonth = myanmarDate.getShanMonth();
        if (shanMonth >= 1 && shanMonth <= 3) return "ဝၢႆႇ တၢင်းၸၢၼ်း";
        if (shanMonth >= 4 && shanMonth <= 6) return "ဝၢႆႇ တၢင်းတူၵ်း";
        if (shanMonth >= 7 && shanMonth <= 9) return "ဝၢႆႇ တၢင်းႁွင်ႇ";
        if (shanMonth >= 10 && shanMonth <= 12) return "ဝၢႆႇ တၢင်းဢွၵ်ႇ";
        return "";
    }

}
