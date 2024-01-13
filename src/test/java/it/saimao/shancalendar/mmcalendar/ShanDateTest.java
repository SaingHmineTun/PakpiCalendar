package it.saimao.shancalendar.mmcalendar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShanDateTest {

    @Test
    void testPeeMurng() {
        assertEquals("ၵတ်းသႂ်ႉ(မိင်ႈငူး)", ShanDate.getPeeMurng(2109));
        assertEquals("ပိုၵ်းယီး(မိင်ႈသိူဝ်)", ShanDate.getPeeMurng(2118));
    }

    @Test
    void testPeeHtam() {
        assertEquals("ၶုတ်းၸႂ်ႉ(မိင်ႈၼူ)", ShanDate.getPeeHtam(1960));
        assertEquals("ႁၢႆးၸႂ်ႉ(မိင်ႈၼူ)", ShanDate.getPeeHtam(1996));
        assertEquals("ႁုင်ႉသႂ်ႉ(မိင်ႈငူး)", ShanDate.getPeeHtam(2001));
        assertEquals("တဝ်ႇသၼ်(မိင်ႈလိင်း)", ShanDate.getPeeHtam(1992));
        assertEquals("ၵၢပ်ႇသီ(မိင်ႈငိူၵ်ႈ)", ShanDate.getPeeHtam(2024));
    }
}