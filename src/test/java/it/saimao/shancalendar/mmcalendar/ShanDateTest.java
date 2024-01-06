package it.saimao.shancalendar.mmcalendar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShanDateTest {

    @Test
    void getPeeMurng() {
        String peeMurng = ShanDate.getPeeMurng(2109);
        assertEquals("ၵတ်းသႂ်ႉ(ငူး)", peeMurng);
    }

    @Test
    void getPeeMurngKhe() {
        assertEquals("ၼူ", ShanDate.getPeeMurngKhe(1960));
        assertEquals("ၼူ", ShanDate.getPeeMurngKhe(1996));
        assertEquals("ငူး", ShanDate.getPeeMurngKhe(2001));
        assertEquals("လိင်း", ShanDate.getPeeMurngKhe(1992));
    }
}