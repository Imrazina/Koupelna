package cz.upce.fei.boop.clonebathroom;

import java.util.Objects;

public class Vana implements Cloneable{
    
    
//<editor-fold defaultstate="collapsed" desc="Instanční proměnný/atributy">
    private String NazevVany;
    private Rozmer rozmer; 
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Konstruktory">   
    @Override
    public Vana clone() throws CloneNotSupportedException {
        return (Vana) super.clone(); 
    }
    
    
    public Vana(String NazevVany, Rozmer rozmer) {
        if (NazevVany == null || rozmer == null) {
            throw new NullPointerException();
        }
        
        this.NazevVany = NazevVany;
        this.rozmer = rozmer;
    }
    
    public Vana(String NazevVany, double delka, double sirka, double vyska) {
        if (NazevVany == null) {
            throw new NullPointerException();
        }
        this.NazevVany = NazevVany;
        this.rozmer = new Rozmer(delka, sirka, vyska);
    }

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="toString">
  @Override
   public String toString() {
        return "Vana " + NazevVany + "{" + rozmer + ", reference=" + super.toString() + '}';
    }
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Metody get">
    public String getNazevVany() {
        return NazevVany;
    }

    public Rozmer getRozmer() {
        return rozmer;
    }
//</editor-fold>    

//<editor-fold defaultstate="collapsed" desc="Pouze metoda equals ">
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vana other = (Vana) obj;
        if (!Objects.equals(this.NazevVany, other.NazevVany)) {
            return false;
        }
        return Objects.equals(this.rozmer, other.rozmer);
    }
//</editor-fold>

}
