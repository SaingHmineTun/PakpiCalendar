package it.saimao.shancalendar.mmcalendar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShanDateTest {

    @Test
    void getPeeMurng() {
        String peeMurng = ShanDate.getPeeMurng(2109);
        assertEquals("ၵတ်းသႂ်ႉ(ငူး)", peeMurng);
    }
}