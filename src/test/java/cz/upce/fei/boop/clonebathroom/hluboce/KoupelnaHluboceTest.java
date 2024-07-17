package cz.upce.fei.boop.clonebathroom.hluboce;

import cz.upce.fei.boop.clonebathroom.MojeException;
import cz.upce.fei.boop.clonebathroom.Rozmer;
import cz.upce.fei.boop.clonebathroom.Vana;
import static org.junit.Assert.*;
import org.junit.Test;


public class KoupelnaHluboceTest {

    @Test
    public void test01Constructor() throws CloneNotSupportedException {
        Vana vana = new Vana("Ravak", new Rozmer(2.0, 1.2, 0.5));
        Rozmer rozmerKoupelny = new Rozmer(4, 5, 3);
        KoupelnaHluboce koupelna = new KoupelnaHluboce("K1", rozmerKoupelny, vana);
        KoupelnaHluboce klonKoupelny = koupelna.clone();
        Vana result = klonKoupelny.getVana();
        assertFalse(vana == result);
    }


    @Test
    public void test02Constructor() throws CloneNotSupportedException {
        Vana vana = new Vana("Ravak", new Rozmer(2.0, 1.2, 0.5));
        Rozmer rozmerKoupelny = new Rozmer(4, 5, 3);
        KoupelnaHluboce koupelna = new KoupelnaHluboce("K1", rozmerKoupelny, vana);
        KoupelnaHluboce klonKoupelny = koupelna.clone();
        Vana result = klonKoupelny.getVana();
        assertEquals(vana, result);
    }


    @Test
    public void testConstructor00b() {
        Vana vana = new Vana("Ravak", new Rozmer(2.5, 1.2, 0.5));
        KoupelnaHluboce koupelna = new KoupelnaHluboce("K1", 3, 2, 3, vana);
        Rozmer expResult = new Rozmer(3, 2, 3);
        Rozmer result = koupelna.getRozmer();
        assertEquals(expResult, result);
    }


    @Test(expected = NullPointerException.class)
    public void testConstructor01b() {
        KoupelnaHluboce koupelna = new KoupelnaHluboce("K1", 3, 2, 3, null);
        fail("Nevystavila se výjimka NullPointerException z důvodu null ve parametru na vanu koupelny");

    }

 
    @Test(expected = NullPointerException.class)
    public void testConstructor02() {
        Vana vana = new Vana("Ravak", new Rozmer(2.5, 1.2, 0.5));
        KoupelnaHluboce koupelna = new KoupelnaHluboce("K1", null, vana);
        fail("Nevystavila se výjimka NullPointerException z důvodu null v rozměru koupelny");
    }


    @Test(expected = NullPointerException.class)
    public void testConstructor04() {
        Vana vana = new Vana("Ravak", new Rozmer(2.5, 1.2, 0.5));
        KoupelnaHluboce koupelna = new KoupelnaHluboce(null, new Rozmer(1, 1, 1), vana);
        fail("Nevystavila se výjimka NullPointerException z důvodu null ve jménu koupelny");
    }


    @Test(expected = MojeException.class)
    public void testConstructor05() {
        Vana vana = new Vana("Ravak", new Rozmer(2.5, 1.2, 0.5));
        KoupelnaHluboce koupelna = new KoupelnaHluboce("", new Rozmer(3, 4, 3), vana);
        fail("Nevystavila se výjimka MojeException");
    }

    @Test
    public void test07GetNazev() {
        Vana vana = new Vana("Ravak", new Rozmer(2.5, 1.2, 0.5));
        KoupelnaHluboce koupelna = new KoupelnaHluboce("Koupelna", new Rozmer(3, 4, 3), vana);
        assertEquals("Koupelna", koupelna.getNazev());
    }

}
