package it.saimao.pakpi.mmcalendar;

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

    public static String getPheeKin(MyanmarDate myanmarDate) {
        return "ၽီၵိၼ်" + wannPheeKin[(int) myanmarDate.getMonthDay() - 1];
    }

    /***************************** ဝၼ်းတႆးလီဢိၵ်ႇၸႃႉ ႁေႃးၸွမ်းမႄႈပီႈ ****************************/

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

    // ဝၼ်းႁၢမ်းဝၼ်းၵႅၼ်
    public static boolean isWannHarmWannKyan(LocalDate ld, MyanmarDate md) {
        boolean isWannHarm = false;
        int shanMonth = md.getShanMonth();
        int mePee = getMePeeInt(ld.toEpochDay());
        if ((shanMonth == 1 || shanMonth == 6 || shanMonth == 11) && getMePeeInt(ld.toEpochDay()) == 4) isWannHarm = true;
        else if ((shanMonth == 2 || shanMonth == 7 || shanMonth == 12) && mePee == 2) isWannHarm = true;
        else if ((shanMonth == 3 || shanMonth == 8) && mePee == 5) isWannHarm = true;
        else if ((shanMonth == 4 || shanMonth == 9) && mePee == 8) isWannHarm = true;
        else if ((shanMonth == 5 ||shanMonth == 10) && mePee == 6) isWannHarm = true;
        return isWannHarm;
    }

    /************** ဝၼ်းတႆးလီဢိၵ်ႇၸႃႉ ႁေႃးၸွမ်းလုၵ်ႈပီႈ ******************/

    // ၸူမ်တိၼ်သိူဝ် - ၵမ်ၵႂႃႇတိုၵ်ႉ
    public static boolean isJomTinSur(LocalDate ld, MyanmarDate md) {
        boolean isJomTinSur = false;
        int shanMonth = md.getShanMonth();        int lukPee = getLukPeeInt(ld.toEpochDay());

        if ((shanMonth == 1 || shanMonth == 5 || shanMonth == 9) && lukPee == 0)
            isJomTinSur = true;
        else if ((shanMonth == 2 || shanMonth == 6 || shanMonth == 10) && lukPee == 1)
            isJomTinSur = true;
        else if ((shanMonth == 3 || shanMonth == 7 || shanMonth == 11) && lukPee == 6)
            isJomTinSur = true;
        else if ((shanMonth == 4 || shanMonth == 8 || shanMonth == 12) && lukPee == 9)
            isJomTinSur = true;
        return isJomTinSur;
    }

    // ၵမ်သိုဝ်ႉၶၢႆဢမ်ႇလီ
    public static boolean isKamSiuKhai(LocalDate ld, MyanmarDate md) {
        boolean isKamSiuKhai = false;
        int shanMonth = md.getShanMonth();
        int lukPee = getLukPeeInt(ld.toEpochDay());
        if (shanMonth == 1 && lukPee == 2)
            isKamSiuKhai = true;
        else if (shanMonth == 2 && lukPee == 4)
            isKamSiuKhai = true;
        else if ((shanMonth == 3 || shanMonth == 12) && lukPee == 1)
            isKamSiuKhai = true;
        else if (shanMonth == 4 && lukPee == 3)
            isKamSiuKhai = true;
        else if (shanMonth == 5 && lukPee == 0)
            isKamSiuKhai = true;
        else if ((shanMonth == 6 || shanMonth == 9) && lukPee == 8)
            isKamSiuKhai = true;
        else if ((shanMonth == 7 || shanMonth == 8 || shanMonth == 10) && lukPee == 7)
            isKamSiuKhai = true;
        else if (shanMonth == 11 && lukPee == 6)
            isKamSiuKhai = true;
        return isKamSiuKhai;
    }

    // ၵမ်ယဵပ်ႉၶူဝ်းလဵင်းၼုင်ႈ
    public static boolean isKamYeipKho(LocalDate ld, MyanmarDate md) {
        boolean isKamYeipKho = false;
        int shanMonth = md.getShanMonth();
        int lukPee = getLukPeeInt(ld.toEpochDay());
        if (shanMonth == 1 && lukPee == 1)
            isKamYeipKho = true;
        else if ((shanMonth == 2 || shanMonth == 6 || shanMonth == 11) && lukPee == 3)
            isKamYeipKho = true;
        else if (shanMonth == 3 && lukPee == 8)
            isKamYeipKho = true;
        else if ((shanMonth == 4 || shanMonth == 10) && lukPee == 4)
            isKamYeipKho = true;
        else if ((shanMonth == 5 || shanMonth == 12) && lukPee == 2)
            isKamYeipKho = true;
        else if (shanMonth == 7 && lukPee == 7)
            isKamYeipKho = true;
        else if (shanMonth == 8 && lukPee == 6)
            isKamYeipKho = true;
        else if (shanMonth == 9 && lukPee == 5)
            isKamYeipKho = true;
        return isKamYeipKho;
    }

    // ဝၼ်းမူၺ်ႉ - ၵမ်ၵူပ်ႉၵူႈသွမ်ႉမိင်ႈ
    public static boolean isWannMwe(LocalDate ld, MyanmarDate md) {
        boolean isWannMwe = false;
        int shanMonth = md.getShanMonth();
        int lukPee = getLukPeeInt(ld.toEpochDay());
        if (shanMonth == 1 && lukPee == 2)
            isWannMwe = true;
        else if (shanMonth == 2 && lukPee == 4)
            isWannMwe = true;
        else if ((shanMonth == 3 || shanMonth == 6) && lukPee == 6)
            isWannMwe = true;
        else if ((shanMonth == 4 || shanMonth == 8) && lukPee == 8)
            isWannMwe = true;
        else if ((shanMonth == 5 || shanMonth == 11) && lukPee == 11)
            isWannMwe = true;
        else if ((shanMonth == 7 || shanMonth == 10) && lukPee == 3)
            isWannMwe = true;
        else if (shanMonth == 9 && lukPee == 5)
            isWannMwe = true;
        else if (shanMonth == 12 && lukPee == 0)
            isWannMwe = true;
        return isWannMwe;
    }


    // ၵမ်ၶဵၼ်ႇႁွၵ်ႇလၢပ်ႇ
    public static boolean isKamKhenHogLep(LocalDate ld, MyanmarDate md) {
        boolean isKamKhenHopLep = false;
        int shanMonth = md.getShanMonth();
        int lukPee = getLukPeeInt(ld.toEpochDay());
        if ((shanMonth == 1 || shanMonth == 5 || shanMonth == 9) && lukPee == 11)
            isKamKhenHopLep = true;
        else if ((shanMonth == 2 || shanMonth == 6 || shanMonth == 10) && lukPee == 2)
            isKamKhenHopLep = true;
        else if ((shanMonth == 3 || shanMonth == 7 || shanMonth == 11) && lukPee == 5)
            isKamKhenHopLep = true;
        else if ((shanMonth == 4 || shanMonth == 8 || shanMonth == 12) && lukPee == 8)
            isKamKhenHopLep = true;
        return isKamKhenHopLep;
    }

    // ၵမ်ဝၢၼ်ႇၵႃႈ
    public static boolean isKamWaanKaa(LocalDate ld, MyanmarDate md) {
        boolean isKamWaanKaa = false;
        int shanMonth = md.getShanMonth();
        int lukPee = getLukPeeInt(ld.toEpochDay());
        if ((shanMonth == 1 || shanMonth == 5 || shanMonth == 9) && lukPee == 3)
            isKamWaanKaa = true;
        else if ((shanMonth == 2 || shanMonth == 6 || shanMonth == 10) && lukPee == 6)
            isKamWaanKaa = true;
        else if ((shanMonth == 3 || shanMonth == 7 || shanMonth == 11) && lukPee == 9)
            isKamWaanKaa = true;
        else if ((shanMonth == 4 || shanMonth == 8 || shanMonth == 12) && lukPee == 0)
            isKamWaanKaa = true;
        return isKamWaanKaa;
    }

    // မူၺ်ႉၶွမ်ႉ
    public static boolean isMweKhom(LocalDate ld, MyanmarDate md) {
        boolean isMweKhom = false;
        int shanMonth = md.getShanMonth();        int lukPee = getLukPeeInt(ld.toEpochDay());

        if ((shanMonth == 1 || shanMonth == 5 || shanMonth == 9) && lukPee == 0)
            isMweKhom = true;
        else if ((shanMonth == 2 || shanMonth == 6 || shanMonth == 10) && lukPee == 1)
            isMweKhom = true;
        else if ((shanMonth == 3 || shanMonth == 7 || shanMonth == 11) && lukPee == 4)
            isMweKhom = true;
        else if ((shanMonth == 4 || shanMonth == 8 || shanMonth == 12) && lukPee == 3)
            isMweKhom = true;
        return isMweKhom;
    }

    // ၵမ်ဢဝ်ၽူဝ်မေး
    public static boolean KamAoPhoMay(LocalDate ld, MyanmarDate md) {
        boolean isKamAoPhoMay = false;
        int shanMonth = md.getShanMonth();
        int lukPee = getLukPeeInt(ld.toEpochDay());
        if ((shanMonth == 1 || shanMonth == 5 || shanMonth == 9) && lukPee == 5)
            isKamAoPhoMay = true;
        else if ((shanMonth == 2 || shanMonth == 6 || shanMonth == 10) && lukPee == 9)
            isKamAoPhoMay = true;
        else if ((shanMonth == 3 || shanMonth == 7 || shanMonth == 11) && lukPee == 0)
            isKamAoPhoMay = true;
        else if ((shanMonth == 4 || shanMonth == 8 || shanMonth == 12) && lukPee == 3)
            isKamAoPhoMay = true;
        return isKamAoPhoMay;
    }

    // ဝၼ်းလီႁဵတ်ႉႁႆႊၼႃး
    public static boolean isWannLeeHeitHaiNaa(LocalDate ld, MyanmarDate md) {
        boolean isWannLeeHeitHaiNaa = false;
        int shanMonth = md.getShanMonth();
        int lukPee = getLukPeeInt(ld.toEpochDay());
        if ((shanMonth == 1 || shanMonth == 5 || shanMonth == 9) && lukPee == 10)
            isWannLeeHeitHaiNaa = true;
        else if ((shanMonth == 2 || shanMonth == 6 || shanMonth == 10) && lukPee == 1)
            isWannLeeHeitHaiNaa = true;
        else if ((shanMonth == 3 || shanMonth == 7 || shanMonth == 11) && lukPee == 4)
            isWannLeeHeitHaiNaa = true;
        else if ((shanMonth == 4 || shanMonth == 8 || shanMonth == 12) && lukPee == 7)
            isWannLeeHeitHaiNaa = true;
        return isWannLeeHeitHaiNaa;
    }

    // ဢမ်ႇလီႁဵတ်ႉလွၵ်းႁႆႊၼႃး
    public static boolean isUmLeeHeitHaiNaa(LocalDate ld, MyanmarDate md) {
        boolean isUmLeeHeitHaiNaa = false;
        int shanMonth = md.getShanMonth();
        int lukPee = getLukPeeInt(ld.toEpochDay());
        if ((shanMonth == 1) && lukPee == 1) isUmLeeHeitHaiNaa = true;
        else if ((shanMonth == 2) && lukPee == 2) isUmLeeHeitHaiNaa = true;
        else if ((shanMonth == 3) && lukPee == 3) isUmLeeHeitHaiNaa = true;
        else if ((shanMonth == 4) && lukPee == 4) isUmLeeHeitHaiNaa = true;
        else if ((shanMonth == 5) && lukPee == 5) isUmLeeHeitHaiNaa = true;
        else if ((shanMonth == 6) && lukPee == 6) isUmLeeHeitHaiNaa = true;
        else if ((shanMonth == 7) && lukPee == 7) isUmLeeHeitHaiNaa = true;
        else if ((shanMonth == 8) && lukPee == 8) isUmLeeHeitHaiNaa = true;
        else if ((shanMonth == 9) && lukPee == 9) isUmLeeHeitHaiNaa = true;
        else if ((shanMonth == 10) && lukPee == 10) isUmLeeHeitHaiNaa = true;
        else if ((shanMonth == 11) && lukPee == 11) isUmLeeHeitHaiNaa = true;
        else if ((shanMonth == 12) && lukPee == 0) isUmLeeHeitHaiNaa = true;
        return isUmLeeHeitHaiNaa;
    }

    // မူၺ်ႉၶႃးလိူင် - ၵမ်ပူၵ်းသဝ်
    public static boolean isMweKharLurng(LocalDate ld, MyanmarDate md) {
        boolean isMweKharLurng = false;
        int shanMonth = md.getShanMonth();        int lukPee = getLukPeeInt(ld.toEpochDay());

        if ((shanMonth == 1) && lukPee == 2) isMweKharLurng = true;
        else if ((shanMonth == 2) && lukPee == 3) isMweKharLurng = true;
        else if ((shanMonth == 3) && lukPee == 4) isMweKharLurng = true;
        else if ((shanMonth == 4) && lukPee == 5) isMweKharLurng = true;
        else if ((shanMonth == 5) && lukPee == 6) isMweKharLurng = true;
        else if ((shanMonth == 6) && lukPee == 7) isMweKharLurng = true;
        else if ((shanMonth == 7) && lukPee == 8) isMweKharLurng = true;
        else if ((shanMonth == 8) && lukPee == 9) isMweKharLurng = true;
        else if ((shanMonth == 9) && lukPee == 10) isMweKharLurng = true;
        else if ((shanMonth == 10) && lukPee == 11) isMweKharLurng = true;
        else if ((shanMonth == 11) && lukPee == 0) isMweKharLurng = true;
        else if ((shanMonth == 12) && lukPee == 1) isMweKharLurng = true;
        return isMweKharLurng;
    }

    // မူၺ်ႉၶႃးလိူင် - ၵမ်ယူတ်းၶႃး
    public static boolean isMweKharLurng2(LocalDate ld, MyanmarDate md) {
        boolean isMweKharLurng = false;
        int shanMonth = md.getShanMonth();
        int lukPee = getLukPeeInt(ld.toEpochDay());
        if ((shanMonth == 1) && lukPee == 4) isMweKharLurng = true;
        else if ((shanMonth == 2) && lukPee == 5) isMweKharLurng = true;
        else if ((shanMonth == 3) && lukPee == 6) isMweKharLurng = true;
        else if ((shanMonth == 4) && lukPee == 7) isMweKharLurng = true;
        else if ((shanMonth == 5) && lukPee == 8) isMweKharLurng = true;
        else if ((shanMonth == 6) && lukPee == 9) isMweKharLurng = true;
        else if ((shanMonth == 7) && lukPee == 10) isMweKharLurng = true;
        else if ((shanMonth == 8) && lukPee == 11) isMweKharLurng = true;
        else if ((shanMonth == 9) && lukPee == 0) isMweKharLurng = true;
        else if ((shanMonth == 10) && lukPee == 1) isMweKharLurng = true;
        else if ((shanMonth == 11) && lukPee == 2) isMweKharLurng = true;
        else if ((shanMonth == 12) && lukPee == 3) isMweKharLurng = true;
        return isMweKharLurng;
    }
    
    // ၵမ်ၵၢႆႇၶူဝ်လႆ
    public static boolean isKamKaaiKhoLai(LocalDate ld, MyanmarDate md) {
        boolean isKamKaaiKhoLai = false;
        int shanMonth = md.getShanMonth();
        int lukPee = getLukPeeInt(ld.toEpochDay());
        if ((shanMonth == 1) && lukPee == 8) isKamKaaiKhoLai = true;
        else if ((shanMonth == 2) && lukPee == 9) isKamKaaiKhoLai = true;
        else if ((shanMonth == 3) && lukPee == 10) isKamKaaiKhoLai = true;
        else if ((shanMonth == 4) && lukPee == 11) isKamKaaiKhoLai = true;
        else if ((shanMonth == 5) && lukPee == 0) isKamKaaiKhoLai = true;
        else if ((shanMonth == 6) && lukPee == 1) isKamKaaiKhoLai = true;
        else if ((shanMonth == 7) && lukPee == 2) isKamKaaiKhoLai = true;
        else if ((shanMonth == 8) && lukPee == 3) isKamKaaiKhoLai = true;
        else if ((shanMonth == 9) && lukPee == 4) isKamKaaiKhoLai = true;
        else if ((shanMonth == 10) && lukPee == 5) isKamKaaiKhoLai = true;
        else if ((shanMonth == 11) && lukPee == 6) isKamKaaiKhoLai = true;
        else if ((shanMonth == 12) && lukPee == 7) isKamKaaiKhoLai = true;
        return isKamKaaiKhoLai;
    }

    // ႁိူဝ်ႇလႆ - ၵမ်ႁဵတ်းႁိူၼ်း
    public static boolean isHoeLai(LocalDate ld, MyanmarDate md) {
        boolean isHoeLai = false;
        int shanMonth = md.getShanMonth();
        int lukPee = getLukPeeInt(ld.toEpochDay());
        if ((shanMonth == 1) && lukPee == 7) isHoeLai = true;
        else if ((shanMonth == 2) && lukPee == 8) isHoeLai = true;
        else if ((shanMonth == 3) && lukPee == 9) isHoeLai = true;
        else if ((shanMonth == 4) && lukPee == 10) isHoeLai = true;
        else if ((shanMonth == 5) && lukPee == 11) isHoeLai = true;
        else if ((shanMonth == 6) && lukPee == 0) isHoeLai = true;
        else if ((shanMonth == 7) && lukPee == 1) isHoeLai = true;
        else if ((shanMonth == 8) && lukPee == 2) isHoeLai = true;
        else if ((shanMonth == 9) && lukPee == 3) isHoeLai = true;
        else if ((shanMonth == 10) && lukPee == 4) isHoeLai = true;
        else if ((shanMonth == 11) && lukPee == 5) isHoeLai = true;
        else if ((shanMonth == 12) && lukPee == 6) isHoeLai = true;
        return isHoeLai;
    }

    // ဝၼ်းႁဝ်ၶၢႆ - ၵမ်ႁပ်ႉၸိူဝ်ႉ
    public static boolean isWannHaoKhaai(LocalDate ld, MyanmarDate md) {
        boolean isWannHaoKhaai = false;
        int shanMonth = md.getShanMonth();
        int lukPee = getLukPeeInt(ld.toEpochDay());
        if ((shanMonth == 1) && lukPee == 0) isWannHaoKhaai = true;
        else if ((shanMonth == 2) && lukPee == 11) isWannHaoKhaai = true;
        else if ((shanMonth == 3) && lukPee == 10) isWannHaoKhaai = true;
        else if ((shanMonth == 4) && lukPee == 9) isWannHaoKhaai = true;
        else if ((shanMonth == 5) && lukPee == 8) isWannHaoKhaai = true;
        else if ((shanMonth == 6) && lukPee == 7) isWannHaoKhaai = true;
        else if ((shanMonth == 7) && lukPee == 6) isWannHaoKhaai = true;
        else if ((shanMonth == 8) && lukPee == 5) isWannHaoKhaai = true;
        else if ((shanMonth == 9) && lukPee == 4) isWannHaoKhaai = true;
        else if ((shanMonth == 10) && lukPee == 3) isWannHaoKhaai = true;
        else if ((shanMonth == 11) && lukPee == 2) isWannHaoKhaai = true;
        else if ((shanMonth == 12) && lukPee == 1) isWannHaoKhaai = true;
        return isWannHaoKhaai;
    }

    // ဝၼ်းႁဝ်တၢႆ - ၵမ်သိုဝ်ႉဝူဝ်းၵႂၢႆး
    public static boolean isWannHaoTaai(LocalDate ld, MyanmarDate md) {
        boolean isWannHaoTaai = false;
        int shanMonth = md.getShanMonth();
        int lukPee = getLukPeeInt(ld.toEpochDay());
        if ((shanMonth == 1) && lukPee == 1) isWannHaoTaai = true;
        else if ((shanMonth == 2) && lukPee == 0) isWannHaoTaai = true;
        else if ((shanMonth == 3) && lukPee == 11) isWannHaoTaai = true;
        else if ((shanMonth == 4) && lukPee == 10) isWannHaoTaai = true;
        else if ((shanMonth == 5) && lukPee == 9) isWannHaoTaai = true;
        else if ((shanMonth == 6) && lukPee == 8) isWannHaoTaai = true;
        else if ((shanMonth == 7) && lukPee == 7) isWannHaoTaai = true;
        else if ((shanMonth == 8) && lukPee == 6) isWannHaoTaai = true;
        else if ((shanMonth == 9) && lukPee == 5) isWannHaoTaai = true;
        else if ((shanMonth == 10) && lukPee == 4) isWannHaoTaai = true;
        else if ((shanMonth == 11) && lukPee == 3) isWannHaoTaai = true;
        else if ((shanMonth == 12) && lukPee == 2) isWannHaoTaai = true;
        return isWannHaoTaai;
    }

    // တုမ်မူၺ်ႉ - ၵမ်ၶူတ်ႉလိၼ်
    public static boolean isTumMway(LocalDate ld, MyanmarDate md) {
        boolean isTumMway = false;
        int shanMonth = md.getShanMonth();
        int lukPee = getLukPeeInt(ld.toEpochDay());
        if ((shanMonth == 1) && lukPee == 1) isTumMway = true;
        else if ((shanMonth == 2) && lukPee == 0) isTumMway = true;
        else if ((shanMonth == 3) && lukPee == 11) isTumMway = true;
        else if ((shanMonth == 4) && lukPee == 10) isTumMway = true;
        else if ((shanMonth == 5) && lukPee == 9) isTumMway = true;
        else if ((shanMonth == 6) && lukPee == 8) isTumMway = true;
        else if ((shanMonth == 7) && lukPee == 7) isTumMway = true;
        else if ((shanMonth == 8) && lukPee == 6) isTumMway = true;
        else if ((shanMonth == 9) && lukPee == 5) isTumMway = true;
        else if ((shanMonth == 10) && lukPee == 4) isTumMway = true;
        else if ((shanMonth == 11) && lukPee == 3) isTumMway = true;
        else if ((shanMonth == 12) && lukPee == 2) isTumMway = true;
        return isTumMway;
    }

    // မူၺ်ႉၵဝ်ႈၵွင်
    public static boolean isMweKaoKong(LocalDate ld, MyanmarDate md) {
        boolean isMweKaoKong = false;
        int shanMonth = md.getShanMonth();
        int lukPee = getLukPeeInt(ld.toEpochDay());
        if ((shanMonth == 1 || shanMonth == 5) && lukPee == 0) isMweKaoKong = true;
        else if ((shanMonth == 2 || shanMonth == 7) && lukPee == 11) isMweKaoKong = true;
        else if ((shanMonth == 3 || shanMonth == 12) && lukPee == 7) isMweKaoKong = true;
        else if ((shanMonth == 4 || shanMonth == 9 || shanMonth == 10) && lukPee == 2)
            isMweKaoKong = true;
        else if ((shanMonth == 6 || shanMonth == 8) && lukPee == 10) isMweKaoKong = true;
        else if ((shanMonth == 11) && lukPee == 6) isMweKaoKong = true;
        return isMweKaoKong;
    }



    // ဝၼ်းၵျၢမ်းလူင်
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
        if (isSayTang(ld, md)) sb.append("သေတင်ႈ").append("၊ ");
        if (isSayHip(ld, md)) sb.append("သေႁိပ်ႈ").append("၊ ");
        if (isSayJom(ld, md)) sb.append("သေၸွမ်း").append("၊ ");
        if (isSayYam(ld, md)) sb.append("သေယမ်").append("၊ ");
        if (isJomTinSur(ld, md)) sb.append("ၸူမ်တိၼ်သိူဝ်").append("၊ ");
        sb.append(getPheeKin(md)).append("၊ ");
        sb.append(getWannMwe(md)).append("၊ ");
        if (isMweKhom(ld, md)) sb.append("မူၺ်ႉၶွမ်ႈ").append("၊ ");
        if (isMweKharLurng(ld, md)) sb.append("မူၺ်ႉၶႃးလိူင်").append("၊ ");
        if (isMweKharLurng2(ld, md)) sb.append("မူၺ်ႉၶႃးလိူင်").append("၊ ");
        if (isMweKaoKong(ld, md)) sb.append("မူၺ်ႉၵဝ်ႈၵွင်").append("၊ ");
        if (ShanDate.isMweLone(md))
            sb.append("မူၺ်ႉလူင်").append("၊ ");

        if (!ShanDate.getWannTun(md).isEmpty())
            sb.append("ဝၼ်းထုၼ်း").append("၊ ");
        if (!ShanDate.getWannPyaat(md).isEmpty()) {
            sb.append("ဝၼ်းပျၢတ်ႈ").append("၊ ");
        }
        if (ShanDate.isWannJum(md)) {
            sb.append("ဝၼ်းၸူမ်").append("၊ ");
        }
        if (ShanDate.isWannPhoo(md)) {
            sb.append("ဝၼ်းၾူး").append("၊ ");
        }
        if (ShanDate.isWannNao(md)) {
            sb.append("ဝၼ်းၼဝ်ႈ").append("၊ ");
        }
        if (ShanDate.isWannHarmWannKyan(ld, md)) sb.append("ဝၼ်းႁၢမ်း").append("၊ ");
        if (ShanDate.isWannYut(md)) sb.append("ဝၼ်းယုတ်ႈ").append("၊ ");
        if (ShanDate.isWannKyamLone(md)) sb.append("ဝၼ်းၵျၢမ်းလူင်").append("၊ ");
        if (sb.toString().trim().endsWith("၊")){
            sb.replace(sb.length() - 2, sb.length(), "။");
        }

        sb.append("\n").append("ႁူဝ်ၼၵႃး ").append(ShanDate.getHoNagaa(md)).append("။\n");
        if (getMePeeInt(ld.toEpochDay()) == 2 || getMePeeInt(ld.toEpochDay()) == 7) sb.append("ဝၼ်းၵၢတ်ႇမိူင်း").append("၊ ");
        if (AstroConverter.convert(md).isSabbath()) sb.append(AstroConverter.convert(md).getSabbath()).append("၊ ");
        if (sb.toString().trim().endsWith("၊")){
            sb.replace(sb.length() - 2, sb.length(), "။");
        }

        return sb.toString();
    }

    // လၵ်းၼီႈပီႊမိူင်း ( ဢမ်ႇၸႂ်ပီႊၶေႇ )
    // 2109 - ၵတ်းသႂ်ႉ(ငူး)
    public static String getPeeMurng(int shanYear) {
        int year = shanYear - 3;
        int mePeeInt = year % 10; // မိင်ႈမႄႈပီႊ - ဢဝ်တူဝ်လိုၼ်း
        String mingMePee = getMePeeByInt(mePeeInt);
        int lukPeeInt = year % 12;
        String mingLukPee = getLukPeeByInt(lukPeeInt);
        return mingMePee + mingLukPee + "(မိင်ႈ" + lukPeeDef[--lukPeeInt] + ")";
    }

    // ပီႊထမ်း
    // 1996 - ၼူ
    // 1992 - လိင်း
    // 2001 - ငူး
    public static String getPeeHtam(int engYear) {
        int lukPeeRemainder = (engYear % 12) - 4;
        if (lukPeeRemainder < 0) lukPeeRemainder = 12 + lukPeeRemainder;
        int mePeeRemain = (engYear % 10) - 4;
        if (mePeeRemain < 0) mePeeRemain = 10 + mePeeRemain;
        String peeHtam = mePee[mePeeRemain] + lukPee[lukPeeRemainder] + "(မိင်ႈ" + lukPeeDef[lukPeeRemainder] + ")";
        return peeHtam;
    }

    private static String getLukPeeByInt(int lukPeeInt) {
        return lukPee[--lukPeeInt];
    }

    private static String getMePeeByInt(int mePeeInt) {
        return mePee[--mePeeInt];
    }

    public static int getHarakunConstant(int myanmarYear) {
        int a = myanmarYear - 798;
        int b = a * 292207;
        int c = b + 8759;
        int d = c / 800;
        int e = d + 1;
        return e;
    }

    // Only applicable for Burmese Year
    public static int getNewYearDayLukWann(int myanmarYear) {
        int a = getHarakunConstant(myanmarYear) + 1;
        int lukWannInt = a % 7;
        return lukWannInt;
    }


}
