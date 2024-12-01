package instrumenten;


import java.util.Comparator;
import java.util.Objects;

/**
 * @author tiwi
 */
public class Instrument implements Comparable<Instrument> {

    private String naam;
    private int gewicht;

    public Instrument(String naam, int gewicht) {
        this.naam = naam;
        this.gewicht = gewicht;
    }

    public String getNaam() {
        return naam;
    }

    public int getGewicht() {
        return gewicht;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument instr = (Instrument) o;
        return gewicht == instr.gewicht && instr.naam.equalsIgnoreCase(naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam.toLowerCase(), gewicht);
    }

    public int compareTo(Instrument instrument) {
        if(instrument.gewicht - gewicht != 0) {
            return instrument.gewicht - gewicht;
        } else {
            return naam.compareTo(instrument.getNaam());
        }
    }

    @Override
    public String toString() {
        return naam + "  (" + gewicht + " gram)";
    }

}
