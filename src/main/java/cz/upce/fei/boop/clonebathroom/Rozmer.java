package cz.upce.fei.boop.clonebathroom;

import java.util.Locale;

public class Rozmer {
    
    public static double DIMENZE_MAX = 100.0;
    public static double DIMENZE_MIN = 0.1;

    private final double delka;
    private final double sirka;
    private final double vyska;

    public Rozmer(final double delka, final double sirka, final double vyska) {
        if (!kontrolaDimenze(delka) || !kontrolaDimenze(sirka) || !kontrolaDimenze(vyska)) {
            throw new MojeException("Invalid dimension value.");
    }
        this.delka = Math.round(delka * 100.0);
        this.sirka = Math.round(sirka * 100.0);
        this.vyska = Math.round(vyska * 100.0);
    }

    public double getDelka() {
        return delka/100;
    }

    public double getSirka() {
        return sirka/100;
    }

    public double getVyska() {
        return vyska/100;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "Rozmer{delka=%5.2f,sirka=%5.2f,vyska=%5.2f}", getDelka(), getSirka(), getVyska());
    }
    
    @Override
    public int hashCode() {
    int hash = 5;
    hash = 73 * hash + Double.hashCode(this.delka);
    hash = 73 * hash + Double.hashCode(this.sirka);
    hash = 73 * hash + Double.hashCode(this.vyska);
    return hash;
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
        final Rozmer other = (Rozmer) obj;
        if (this.delka != other.delka) {
            return false;
        }
        if (this.sirka != other.sirka) {
            return false;
        }
        return this.vyska == other.vyska;
    }

    public static boolean kontrolaDimenze(double dimenze) {
        return check(dimenze);
    }

    private static boolean check(double dimenze) {
      return dimenze >= DIMENZE_MIN && dimenze <= DIMENZE_MAX;
    }

    
}
