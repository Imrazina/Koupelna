package cz.upce.fei.boop.clonebathroom.melce;

import cz.upce.fei.boop.clonebathroom.MojeException;
import cz.upce.fei.boop.clonebathroom.Rozmer;
import cz.upce.fei.boop.clonebathroom.Vana;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;

public class KoupelnaMelceTest {

    @Test
    public void test01Constructor() throws CloneNotSupportedException {
        Vana vana = new Vana("Ravak", new Rozmer(2.0, 1.2, 0.5));
        Rozmer rozmerKoupelny = new Rozmer(4, 5, 3);
        KoupelnaMelce koupelna = new KoupelnaMelce("K1", rozmerKoupelny, vana);
        KoupelnaMelce klonKoupelny = koupelna.clone();
        Vana result = klonKoupelny.getVana();
        assertEquals(vana, result);
    }

    @Test
    public void test02Constructor() {
        Vana vana = new Vana("Ravak", new Rozmer(2.5, 1.2, 0.5));
        KoupelnaMelce koupelna = new KoupelnaMelce("K1", 3, 2, 3, vana);
        Rozmer expResult = new Rozmer(3, 2, 3);
        Rozmer result = koupelna.getRozmer();
        assertEquals(expResult, result);
    }

    @Test(expected = NullPointerException.class)
    public void test03Constructor() {
        KoupelnaMelce koupelna = new KoupelnaMelce("K1", 3, 2, 3, null);
        fail("Nevystavila se výjimka NullPointerException z důvodu null ve parametru na vanu koupelny");
    }

    @Test(expected = NullPointerException.class)
    public void test04Constructor() {
        Vana vana = new Vana("Ravak", new Rozmer(2.5, 1.2, 0.5));
        KoupelnaMelce koupelna = new KoupelnaMelce("K1", null, vana);
        fail("Nevystavila se výjimka NullPointerException z důvodu null v rozměru koupelny");
    }

    @Test(expected = NullPointerException.class)
    public void test05Constructor() {
        Vana vana = new Vana("Ravak", new Rozmer(2.5, 1.2, 0.5));
        KoupelnaMelce koupelna = new KoupelnaMelce(null, new Rozmer(1, 1, 1), vana);
        fail("Nevystavila se výjimka NullPointerException z důvodu null ve jménu koupelny");
    }
    
    @Test(expected = MojeException.class)
    public void test06Constructor() {
        Vana vana = new Vana("Ravak", new Rozmer(2.5, 1.2, 0.5));
        KoupelnaMelce koupelna = new KoupelnaMelce("", new Rozmer(3, 4, 3), vana);
        fail("Nevystavila se výjimka MojeException");
    }

    @Test
    public void test07GetNazev() {
            Vana vana = new Vana("Ravak", new Rozmer(2.5, 1.2, 0.5));
            KoupelnaMelce koupelna = new KoupelnaMelce("Koupelna", new Rozmer(3, 4, 3), vana);
            assertEquals("Koupelna", koupelna.getNazev());
    }

}
