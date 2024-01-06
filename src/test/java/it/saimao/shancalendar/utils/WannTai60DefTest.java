package it.saimao.shancalendar.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WannTai60DefTest {

    WannTai60Def wannTai60Def;
    @BeforeEach
    void init() {
        wannTai60Def = new WannTai60Def();
    }
    @Test
    void testGetWannTai60DefByName() {
        String result = wannTai60Def.getDictByName("မိူင်းသႂ်ႉ");
        assertEquals(result, "ယႃႇပေဢဵၼ်ႈၽႃႉမိတ်ႈ");
    }

    @Test
    void testGetWannTai60DefByName_Error() {
        String result = wannTai60Def.getDictByName("မိူင်းသႂ်ႉ");
        assertNotEquals(result, "ယႃႇပေဢဵၼ်ႈၽႃႉမိတ်ႉ");
    }

    @Test
    void testGetWannTai60DefByNumber() {
        String result = wannTai60Def.getDefByNumber(54);
        assertEquals(result, "ယႃႇပေဢဵၼ်ႈၽႃႉမိတ်ႈ");
    }

}