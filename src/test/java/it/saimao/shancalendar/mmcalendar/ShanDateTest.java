package it.saimao.shancalendar.mmcalendar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShanDateTest {

    @Test
    void testPeeMurng() {
        assertEquals("ၵတ်းသႂ်ႉ(ငူး)", ShanDate.getPeeMurng(2109));
        assertEquals("ပိုၵ်းယီး(သိူဝ်)", ShanDate.getPeeMurng(2118));
    }

    @Test
    void testPeeHtam() {
        assertEquals("ၶုတ်းၸႂ်ႉ(ၼူ)", ShanDate.getPeeHtam(1960));
        assertEquals("ႁၢႆးၸႂ်ႉ(ၼူ)", ShanDate.getPeeHtam(1996));
        assertEquals("ႁုင်ႉသႂ်ႉ(ငူး)", ShanDate.getPeeHtam(2001));
        assertEquals("တဝ်ႇသၼ်(လိင်း)", ShanDate.getPeeHtam(1992));
        assertEquals("ၵၢပ်ႇသီ(ငိူၵ်ႈ)", ShanDate.getPeeHtam(2024));
    }
}