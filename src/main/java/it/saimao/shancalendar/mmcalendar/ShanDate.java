package it.saimao.shancalendar.mmcalendar;

import java.time.LocalDate;

public class ShanDate {

    public static final String[] mePee = {"ၵၢပ်ႇ", "လပ်း", "ႁၢႆး", "မိူင်း", "ပိုၵ်း", "ၵတ်း", "ၶုတ်း", "ႁုင်ႉ", "တဝ်ႇ", "ၵႃႇ"};
    public static final String[] lukPee = {"ၸႂ်ႉ", "ပဝ်ႉ", "ယီး", "မဝ်ႉ", "သီ", "သႂ်ႉ", "သီင", "မူတ်ႉ", "သၼ်", "ႁဝ်ႉ", "မဵတ်ႉ", "ၵႂ်ႉ"};

    public static final String[] lukPeeDef = {"ၼူ", "ၵႂၢႆး", "သိူဝ်", "ပၢင်တၢႆး", "ငိူၵ်ႈ", "ငူး", "မႃႉ", "ပႄႉ", "လိင်း", "ၵႆႇ", "မႃ", "မူ"};

    public static String getLukPee(long epochDay) {
        return ShanDate.lukPee[getLukPeeInt(epochDay)];
    }

    public static String getMePee(long epochDay) {
        return ShanDate.mePee[getMePeeInt(epochDay)];
    }

    public static int getMePeeInt(long epochDay) {
        return (int) ((epochDay + 7) % 10);
    }

    public static int getLukPeeInt(long epochDay) {
        return (int) (epochDay + 5) % 12;
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
        if (isWannTun(myanmarDate)) return "ဝၼ်းထုၼ်း";
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


    public static boolean isMweLone(MyanmarDate md) {
        int x = md.getFortnightDayInt();
        int y = md.getWeekDayInt() == 0 ? 7 : md.getWeekDayInt();
        return x + y == 13;
    }

    public static String getMweLone(MyanmarDate md) {
        if (isMweLone(md)) return "မူၺ်ႉလူင်";
        return "";
    }

    public static boolean isWannNao(MyanmarDate md) {
        boolean isWannNao = false;
        if (md.getFortnightDayInt() == 1 && md.getWeekDayInt() == 1) isWannNao = true;
        if (md.getFortnightDayInt() == 4 && md.getWeekDayInt() == 2) isWannNao = true;
        if (md.getFortnightDayInt() == 6 && md.getWeekDayInt() == 3) isWannNao = true;
        if (md.getFortnightDayInt() == 9 && md.getWeekDayInt() == 4) isWannNao = true;
        if (md.getFortnightDayInt() == 8 && md.getWeekDayInt() == 5) isWannNao = true;
        if (md.getFortnightDayInt() == 7 && md.getWeekDayInt() == 6) isWannNao = true;
        if (md.getFortnightDayInt() == 8 && md.getWeekDayInt() == 0) isWannNao = true;
        // TODO - Can have error in calculating Wann Nao!
        return isWannNao;
    }

    public static String getWannNao(MyanmarDate md) {
        if (isWannNao(md)) return "ဝၼ်းၼဝ်ႈ";
        return "";
    }

    public static String getHoNagaa(MyanmarDate myanmarDate) {
        int shanMonth = myanmarDate.getShanMonth();
        if (shanMonth >= 1 && shanMonth <= 3) return "ဝၢႆႇတၢင်းၸၢၼ်း";
        if (shanMonth >= 4 && shanMonth <= 6) return "ဝၢႆႇတၢင်းတူၵ်း";
        if (shanMonth >= 7 && shanMonth <= 9) return "ဝၢႆႇတၢင်းႁွင်ႇ";
        if (shanMonth >= 10 && shanMonth <= 12) return "ဝၢႆႇတၢင်းဢွၵ်ႇ";
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

    // သေတင်ႈ
    public static boolean isSayTang(LocalDate ld, MyanmarDate md) {
        boolean isSayTang = false;
        int shanMonth = md.getShanMonth();
        if ((shanMonth == 1 || shanMonth == 7) && getMePeeInt(ld.toEpochDay()) == 2) isSayTang = true;
        else if ((shanMonth == 2 || shanMonth == 5 || shanMonth == 11 || shanMonth == 8) && getMePeeInt(ld.toEpochDay()) == 3)
            isSayTang = true;
        else if ((shanMonth == 3 || shanMonth == 6 || shanMonth == 12 || shanMonth == 9) && getMePeeInt(ld.toEpochDay()) == 7)
            isSayTang = true;
        else if ((shanMonth == 4 || shanMonth == 10) && getMePeeInt(ld.toEpochDay()) == 4) isSayTang = true;
        return isSayTang;
    }

    // သေႁိပ်ႈ
    public static boolean isSayHip(LocalDate ld, MyanmarDate md) {
        boolean isSayHip = false;
        int shanMonth = md.getShanMonth();
        if ((shanMonth == 1 || shanMonth == 7) && getMePeeInt(ld.toEpochDay()) == 3) isSayHip = true;
        else if ((shanMonth == 2 || shanMonth == 5 || shanMonth == 8 || shanMonth == 11) && getMePeeInt(ld.toEpochDay()) == 4)
            isSayHip = true;
        else if ((shanMonth == 3 || shanMonth == 6 || shanMonth == 9 || shanMonth == 12) && getMePeeInt(ld.toEpochDay()) == 8)
            isSayHip = true;
        else if ((shanMonth == 4 || shanMonth == 10) && getMePeeInt(ld.toEpochDay()) == 5) isSayHip = true;
        return isSayHip;
    }

    // သေၸွမ်း
    public static boolean isSayJom(LocalDate ld, MyanmarDate md) {
        boolean isSayJom = false;
        int shanMonth = md.getShanMonth();
        if ((shanMonth == 1 || shanMonth == 7) && getMePeeInt(ld.toEpochDay()) == 4) isSayJom = true;
        else if ((shanMonth == 2 || shanMonth == 5 || shanMonth == 11 || shanMonth == 8) && getMePeeInt(ld.toEpochDay()) == 5)
            isSayJom = true;
        else if ((shanMonth == 3 || shanMonth == 6 || shanMonth == 12 || shanMonth == 9) && getMePeeInt(ld.toEpochDay()) == 9)
            isSayJom = true;
        else if ((shanMonth == 4 || shanMonth == 10) && getMePeeInt(ld.toEpochDay()) == 6) isSayJom = true;
        return isSayJom;
    }

    // သေယမ်
    public static boolean isSayYam(LocalDate ld, MyanmarDate md) {
        boolean isSayYam = false;
        int shanMonth = md.getShanMonth();
        if ((shanMonth == 1 || shanMonth == 7) && getMePeeInt(ld.toEpochDay()) == 7) isSayYam = true;
        else if ((shanMonth == 2 || shanMonth == 5 || shanMonth == 11 || shanMonth == 8) && getMePeeInt(ld.toEpochDay()) == 8)
            isSayYam = true;
        else if ((shanMonth == 3 || shanMonth == 6 || shanMonth == 12 || shanMonth == 9) && getMePeeInt(ld.toEpochDay()) == 4)
            isSayYam = true;
        else if ((shanMonth == 4 || shanMonth == 10) && getMePeeInt(ld.toEpochDay()) == 9) isSayYam = true;
        return isSayYam;
    }

    // ၸူမ်တိၼ်သိူဝ်
    public static boolean isJomTinSur(LocalDate ld, MyanmarDate md) {
        boolean isJomTinSur = false;
        int shanMonth = md.getShanMonth();
        if ((shanMonth == 1 || shanMonth == 5 || shanMonth == 9) && getLukPeeInt(ld.toEpochDay()) == 0)
            isJomTinSur = true;
        else if ((shanMonth == 2 || shanMonth == 6 || shanMonth == 10) && getLukPeeInt(ld.toEpochDay()) == 1)
            isJomTinSur = true;
        else if ((shanMonth == 3 || shanMonth == 7 || shanMonth == 11) && getLukPeeInt(ld.toEpochDay()) == 6)
            isJomTinSur = true;
        else if ((shanMonth == 4 || shanMonth == 8 || shanMonth == 12) && getLukPeeInt(ld.toEpochDay()) == 9)
            isJomTinSur = true;
        return isJomTinSur;
    }

    // မူၺ်ႉၶွမ်ႉ
    public static boolean isMweKhom(LocalDate ld, MyanmarDate md) {
        boolean isMweKhom = false;
        int shanMonth = md.getShanMonth();
        if ((shanMonth == 1 || shanMonth == 5 || shanMonth == 9) && getLukPeeInt(ld.toEpochDay()) == 0)
            isMweKhom = true;
        else if ((shanMonth == 2 || shanMonth == 6 || shanMonth == 10) && getLukPeeInt(ld.toEpochDay()) == 1)
            isMweKhom = true;
        else if ((shanMonth == 3 || shanMonth == 7 || shanMonth == 11) && getLukPeeInt(ld.toEpochDay()) == 4)
            isMweKhom = true;
        else if ((shanMonth == 4 || shanMonth == 8 || shanMonth == 12) && getLukPeeInt(ld.toEpochDay()) == 3)
            isMweKhom = true;
        return isMweKhom;
    }

    // မူၺ်ႉၶႃးလိူင် - ၵမ်ပူၵ်းသဝ်
    public static boolean isMweKharLurng(LocalDate ld, MyanmarDate md) {
        boolean isMweKharLurng = false;
        int shanMonth = md.getShanMonth();
        if ((shanMonth == 1) && getLukPeeInt(ld.toEpochDay()) == 2) isMweKharLurng = true;
        else if ((shanMonth == 2) && getLukPeeInt(ld.toEpochDay()) == 3) isMweKharLurng = true;
        else if ((shanMonth == 3) && getLukPeeInt(ld.toEpochDay()) == 4) isMweKharLurng = true;
        else if ((shanMonth == 4) && getLukPeeInt(ld.toEpochDay()) == 5) isMweKharLurng = true;
        else if ((shanMonth == 5) && getLukPeeInt(ld.toEpochDay()) == 6) isMweKharLurng = true;
        else if ((shanMonth == 6) && getLukPeeInt(ld.toEpochDay()) == 7) isMweKharLurng = true;
        else if ((shanMonth == 7) && getLukPeeInt(ld.toEpochDay()) == 8) isMweKharLurng = true;
        else if ((shanMonth == 8) && getLukPeeInt(ld.toEpochDay()) == 9) isMweKharLurng = true;
        else if ((shanMonth == 9) && getLukPeeInt(ld.toEpochDay()) == 10) isMweKharLurng = true;
        else if ((shanMonth == 10) && getLukPeeInt(ld.toEpochDay()) == 11) isMweKharLurng = true;
        else if ((shanMonth == 11) && getLukPeeInt(ld.toEpochDay()) == 0) isMweKharLurng = true;
        else if ((shanMonth == 12) && getLukPeeInt(ld.toEpochDay()) == 1) isMweKharLurng = true;
        return isMweKharLurng;
    }

    // မူၺ်ႉၶႃးလိူင် - ၵမ်ယူတ်းၶႃး
    public static boolean isMweKharLurng2(LocalDate ld, MyanmarDate md) {
        boolean isMweKharLurng = false;
        int shanMonth = md.getShanMonth();
        if ((shanMonth == 1) && getLukPeeInt(ld.toEpochDay()) == 4) isMweKharLurng = true;
        else if ((shanMonth == 2) && getLukPeeInt(ld.toEpochDay()) == 5) isMweKharLurng = true;
        else if ((shanMonth == 3) && getLukPeeInt(ld.toEpochDay()) == 6) isMweKharLurng = true;
        else if ((shanMonth == 4) && getLukPeeInt(ld.toEpochDay()) == 7) isMweKharLurng = true;
        else if ((shanMonth == 5) && getLukPeeInt(ld.toEpochDay()) == 8) isMweKharLurng = true;
        else if ((shanMonth == 6) && getLukPeeInt(ld.toEpochDay()) == 9) isMweKharLurng = true;
        else if ((shanMonth == 7) && getLukPeeInt(ld.toEpochDay()) == 10) isMweKharLurng = true;
        else if ((shanMonth == 8) && getLukPeeInt(ld.toEpochDay()) == 11) isMweKharLurng = true;
        else if ((shanMonth == 9) && getLukPeeInt(ld.toEpochDay()) == 0) isMweKharLurng = true;
        else if ((shanMonth == 10) && getLukPeeInt(ld.toEpochDay()) == 1) isMweKharLurng = true;
        else if ((shanMonth == 11) && getLukPeeInt(ld.toEpochDay()) == 2) isMweKharLurng = true;
        else if ((shanMonth == 12) && getLukPeeInt(ld.toEpochDay()) == 3) isMweKharLurng = true;
        return isMweKharLurng;
    }

    // မူၺ်ႉၵဝ်ႈၵွင်
    public static boolean isMweKaoKong(LocalDate ld, MyanmarDate md) {
        boolean isMweKaoKong = false;
        int shanMonth = md.getShanMonth();
        if ((shanMonth == 1 || shanMonth == 5) && getLukPeeInt(ld.toEpochDay()) == 0) isMweKaoKong = true;
        else if ((shanMonth == 2 || shanMonth == 7) && getLukPeeInt(ld.toEpochDay()) == 11) isMweKaoKong = true;
        else if ((shanMonth == 3 || shanMonth == 12) && getLukPeeInt(ld.toEpochDay()) == 7) isMweKaoKong = true;
        else if ((shanMonth == 4 || shanMonth == 9 || shanMonth == 10) && getLukPeeInt(ld.toEpochDay()) == 2)
            isMweKaoKong = true;
        else if ((shanMonth == 6 || shanMonth == 8) && getLukPeeInt(ld.toEpochDay()) == 10) isMweKaoKong = true;
        else if ((shanMonth == 11) && getLukPeeInt(ld.toEpochDay()) == 6) isMweKaoKong = true;
        return isMweKaoKong;
    }

    public static boolean isWannKyamLone(MyanmarDate md) {
        boolean isWannKyamLone = false;
        int shanMonth = md.getShanMonth();
        int day = md.getFortnightDayInt();
        if ((shanMonth == 2 || shanMonth == 3) && day == 4) isWannKyamLone = true;
        if ((shanMonth == 4 || shanMonth == 5) && day == 5) isWannKyamLone = true;
        if ((shanMonth == 6 || shanMonth == 7) && day == 6) isWannKyamLone = true;
        if ((shanMonth == 8 || shanMonth == 9) && day == 1) isWannKyamLone = true;
        if ((shanMonth == 10 || shanMonth == 11) && day == 2) isWannKyamLone = true;
        if ((shanMonth == 12 || shanMonth == 1) && day == 9) isWannKyamLone = true;
        return isWannKyamLone;
    }

    // ဝၼ်းယုတ်ႈ
    public static boolean isWannYut(MyanmarDate md) {
        boolean isWannYut = false;
        int shanMonth = md.getShanMonth();
        int day = md.getFortnightDayInt();
        if ((shanMonth == 5 || shanMonth == 8) && day == 6) isWannYut = true;
        if ((shanMonth == 6 || shanMonth == 3) && day == 4) isWannYut = true;
        if ((shanMonth == 7 || shanMonth == 10) && day == 8) isWannYut = true;
        if ((shanMonth == 9 || shanMonth == 12) && day == 10) isWannYut = true;
        if ((shanMonth == 2 || shanMonth == 11) && day == 12) isWannYut = true;
        if ((shanMonth == 1 || shanMonth == 4) && day == 2) isWannYut = true;
        return isWannYut;
    }

    public static String toString(LocalDate ld, MyanmarDate md) {
        StringBuilder sb = new StringBuilder();
        if (isSayTang(ld, md)) sb.append(" ၊ ").append("သေတင်ႈ");
        if (isSayHip(ld, md)) sb.append(" ၊ ").append("သေႁိပ်ႈ");
        if (isSayJom(ld, md)) sb.append(" ၊ ").append("သေၸွမ်း");
        if (isSayYam(ld, md)) sb.append(" ၊ ").append("သေယမ်");

        if (isJomTinSur(ld, md)) sb.append(" ၊ ").append("ၸူမ်တိၼ်သိူဝ်");
        if (isMweKhom(ld, md)) sb.append(" ၊ ").append("မူၺ်ႉၶွမ်ႈ");
        if (isMweKharLurng(ld, md)) sb.append(" ၊ ").append("မူၺ်ႉၶႃႈလိူင် - ၵမ်ပူၵ်းသဝ်");
        if (isMweKharLurng2(ld, md)) sb.append(" ၊ ").append("မူၺ်ႉၶႃႈလိူင် - ၵမ်ယူတ်းၶႃး");
        if (isMweKaoKong(ld, md)) sb.append(" ၊ ").append("မူၺ်ႉၵဝ်ႈၵွင်");
        if (ShanDate.isMweLone(md)) {
            sb.append(" ၊ ").append("မူၺ်ႉလူင်");
        }
        if (!ShanDate.getWannTun(md).isEmpty()) {
            sb.append(" ၊ ဝၼ်းထုၼ်း");
        }
        if (!ShanDate.getWannPyaat(md).isEmpty()) {
            sb.append(" ၊ ဝၼ်းပျၢတ်ႈ");
        }
        if (ShanDate.isWannJum(md)) {
            sb.append(" ၊ ").append("ဝၼ်းၸူမ်");
        }
        if (ShanDate.isWannPhoo(md)) {
            sb.append(" ၊ ").append("ဝၼ်းၾူး");
        }
        if (ShanDate.isWannNao(md)) {
            sb.append(" ၊ ").append("ဝၼ်းၼဝ်ႈ");
        }
        if (ShanDate.isWannYut(md)) sb.append(" ၊ ").append("ဝၼ်းယုတ်ႈ");
        if (ShanDate.isWannKyamLone(md)) sb.append(" ၊ ").append("ဝၼ်းၵျၢမ်းလူင်");
        sb.append(" ၊ ႁူဝ်ၼၵႃး ").append(ShanDate.getHoNagaa(md));

        return sb.toString();
    }

    // လၵ်းၼီႈပီႊမိူင်း ( ဢမ်ႇၸႂ်ပီႊၶေႇ )
    public static String getPeeMurng(int shanYear) {
        int year = shanYear - 3;
        int mePeeInt = year % 10; // မိင်ႈမႄႈပီႊ - ဢဝ်တူဝ်လိုၼ်း
        String mingMePee = getMePeeByInt(mePeeInt);
        int lukPeeInt = year % 12;
        String mingLukPee = getLukPeeByInt(lukPeeInt);
        return mingMePee + mingLukPee + "(" + lukPeeDef[--lukPeeInt] + ")";
    }

    public static String getPeeMurngKhe(int engYear) {
        int remainder = (engYear % 12) - 4;
        if (remainder < 0) remainder = 12 + remainder;
        return lukPeeDef[remainder];
    }

    private static String getLukPeeByInt(int lukPeeInt) {
        return lukPee[--lukPeeInt];
    }

    private static String getMePeeByInt(int mePeeInt) {
        return mePee[--mePeeInt];
    }


}
