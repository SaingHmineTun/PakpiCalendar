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
        assertEquals("ၼူ", ShanDate.getPeeHtam(1960));
        assertEquals("ၼူ", ShanDate.getPeeHtam(1996));
        assertEquals("ငူး", ShanDate.getPeeHtam(2001));
        assertEquals("လိင်း", ShanDate.getPeeHtam(1992));
    }
}