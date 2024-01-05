package it.saimao.shancalendar.mmcalendar;

public class ShanDate {

    public static final String[] mePee = {"ၵၢပ်ႇ", "လပ်း", "ႁၢႆး", "မိူင်း", "ပိုၵ်း", "ၵတ်း", "ၶုတ်း", "ႁုင်ႉ", "တဝ်ႇ", "ၵႃႇ"};
    public static final String[] lukPee = {"ၸႂ်ႉ", "ပဝ်ႉ", "ယီး", "မဝ်ႉ", "သီ", "သႂ်ႉ", "သီင", "မူတ်ႉ", "သၼ်", "ႁဝ်ႉ", "မဵတ်ႉ", "ၵႂ်ႉ"};

    public static String getLukPee(long epochDay) {
        return ShanDate.lukPee[(int) (epochDay + 5) % 12];
    }

    public static String getMePee(long epochDay) {
        return ShanDate.mePee[getWeekDays10Int(epochDay)];
    }

    public static int getWeekDays10Int(long epochDay) {
        return (int) ((epochDay + 7) % 10);
    }

    public static String getWannTai60(long epochDay) {
        return getMePee(epochDay) + getLukPee(epochDay);
    }

    public static boolean isWannTun(MyanmarDate md) {
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
        return isWannTun;
    }

    public static String getWannTun(MyanmarDate myanmarDate) {
        if (isWannPyaat(myanmarDate)) return "ဝၼ်းထုၼ်း";
        return "";
    }

    public static boolean isWannPyaat(MyanmarDate myanmarDate) {
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
        return isWannPyaat;
    }

    public static String getWannPyaat(MyanmarDate myanmarDate) {
        if (isWannPyaat(myanmarDate)) return "ဝၼ်းပျၢတ်ႈ";
        return "";
    }

    // ဝၼ်းၸူမ်
    public static boolean isWannJum(MyanmarDate md) {
        int shanMonth = md.getShanMonth();
        boolean isWannJum = false;
        if (shanMonth == 1 || shanMonth == 8) {
            if (md.getWeekDayInt() == 2) isWannJum = true;
        } else if (shanMonth == 2 || shanMonth == 9 || shanMonth == 11) {
            if (md.getWeekDayInt() == 3) isWannJum = true;
        } else if (shanMonth == 3 || shanMonth == 10) {
            if (md.getWeekDayInt() == 4) isWannJum = true;
        } else if (shanMonth == 4) {
            if (md.getWeekDayInt() == 5) isWannJum = true;
        } else if (shanMonth == 5 || shanMonth == 12) {
            if (md.getWeekDayInt() == 6) isWannJum = true;
        } else if (shanMonth == 6) {
            if (md.getWeekDayInt() == 0) isWannJum = true;
        } else if (shanMonth == 7) {
            if (md.getWeekDayInt() == 1) isWannJum = true;
        }
        return isWannJum;
    }

    public static String getWannJum(MyanmarDate md) {
        if (isWannJum(md)) return "ဝၼ်းၸူမ်";
        return "";
    }

    public static boolean isWannPhoo(MyanmarDate md) {
        int shanMonth = md.getShanMonth();
        boolean isWannPhoo = false;
        if (shanMonth == 1 || shanMonth == 8) {
            if (md.getWeekDayInt() == 6) isWannPhoo = true;
        } else if (shanMonth == 2) {
            if (md.getWeekDayInt() == 0) isWannPhoo = true;
        } else if (shanMonth == 3) {
            if (md.getWeekDayInt() == 1) isWannPhoo = true;
        } else if (shanMonth == 4 || shanMonth == 9) {
            if (md.getWeekDayInt() == 2) isWannPhoo = true;
        } else if (shanMonth == 5 || shanMonth == 10) {
            if (md.getWeekDayInt() == 3) isWannPhoo = true;
        } else if (shanMonth == 6 || shanMonth == 11) {
            if (md.getWeekDayInt() == 4) isWannPhoo = true;
        } else if (shanMonth == 7 || shanMonth == 12) {
            if (md.getWeekDayInt() == 1) isWannPhoo = true;
        }
        return isWannPhoo;
    }

    public static String getWannPhoo(MyanmarDate md) {
        if (isWannPhoo(md)) return "ဝၼ်းၽူး";
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

    private static final String[] wannMwe = {
            "ႁိူၼ်း", "ၼႃး", "မေႃႈႁႆ", "လိၼ်", "ၼမ်ႉ", "ၵဵင်း", "ၶုၼ်", "ထဝ်ႈၵႄႇ", "မႆႉ", "လုၵ်ႈဢွၼ်ႇ",
            "မၢဝ်ႇသၢဝ်", "ရႁၢၼ်း", "ၵႃႈ", "သင်ႇၶႃႇ", "ၽီ", "ၶႅၵ်ႇ", "ထဝ်ႈၵႄႇ", "လိၼ်", "မေႃႈႁႆ", "မႆႉ",
            "မၢဝ်ႇသၢဝ်", "တဝ်ႊၾႆး", "ႁိူၼ်း", "ရႁၢၼ်း", "ၼမ်ႉ", "ၶဝ်ႈ", "တူဝ်သီႇတိၼ်", "တၢင်း", "ၶုၼ်", "ၶႃႈၵူၼ်း"
    };

    private static final String[] wannPheeKin = {
            "ၽီ", "ၵူၼ်း", "ၵႆႇ", "မႃ", "မႃႉ", "မူ", "ဝူဝ်း", "ၵႂၢႆး", "ၽီ", "ၵူၼ်း",
            "ၵႆႇ", "ပဵတ်း", "မူ", "မႃ", "ဝူဝ်း", "ၽီ", "ၵူၼ်း", "ၵႆႇ", "မႃ", "မႃႉ",
            "မူ", "ဝူဝ်း", "ၵႂၢႆး", "ၽီ", "ၵူၼ်း", "ၵႆႇ", "ပဵတ်း", "မူ", "မႃ", "ဝူဝ်း"
    };

    public static String getWannMwe(MyanmarDate myanmarDate) {
        return "မူၺ်ႉ" + wannMwe[(int) myanmarDate.getMonthDay() - 1];

    }

    public static String getWannPheeKin(MyanmarDate myanmarDate) {
        return "ၽီၵိၼ်" + wannPheeKin[(int) myanmarDate.getMonthDay() - 1];
    }

}
