package cz.upce.fei.boop.clonebathroom.hluboce;

import cz.upce.fei.boop.clonebathroom.MojeException;
import cz.upce.fei.boop.clonebathroom.Rozmer;
import cz.upce.fei.boop.clonebathroom.Vana;


public class KoupelnaHluboce implements Cloneable {

//<editor-fold defaultstate="collapsed" desc="instanční proměnný/atributy">
    private String nazevKoupelny;
    private Rozmer rozmer;
    private Vana vana;  
//</editor-fold>


//<editor-fold defaultstate="collapsed" desc="konstruktory">
    public KoupelnaHluboce(String nazevKoupelny, Rozmer rozmer, Vana vana) {
        if (rozmer == null || nazevKoupelny == null) {
            throw new NullPointerException();
        }
        if("".equals(nazevKoupelny)) {
            throw new MojeException("");
        }
        this.nazevKoupelny = nazevKoupelny;
        this.rozmer = rozmer;
        this.vana = vana;
    }
        
    public KoupelnaHluboce(String nazevKoupelny, double delka, double sirka, double vyska, Vana vana) {
        if (vana == null) {
            throw new NullPointerException();
        }
        this.nazevKoupelny = nazevKoupelny;
        this.rozmer = new Rozmer(delka, sirka, vyska);
        this.vana = vana;
    }
//</editor-fold>


//<editor-fold defaultstate="collapsed" desc="metoda klonovani">
    @Override
    public KoupelnaHluboce clone() throws CloneNotSupportedException {
        KoupelnaHluboce koupelna = (KoupelnaHluboce) super.clone();
        koupelna.vana = (Vana) vana.clone();
        return koupelna;
        
    }
//</editor-fold>
    

//<editor-fold defaultstate="collapsed" desc="metoda toString">
    @Override
    public String toString() {
        return "KoupelnaHluboce{" + "nazevKoupelny=" + nazevKoupelny + ", rozmer=" + rozmer + ", vana=" + vana + '}';
    }
//</editor-fold>

 
//<editor-fold defaultstate="collapsed" desc="metody get">
   public String getNazev() {
        return nazevKoupelny;
    }

    public Rozmer getRozmer() {
        return rozmer;
    }

    public Vana getVana() {
        return vana;
    } 
//</editor-fold>

}
