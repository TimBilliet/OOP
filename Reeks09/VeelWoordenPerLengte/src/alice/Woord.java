package alice;

/**
 *
 * @author ...
 */
public class Woord implements Comparable<Woord>{

    private String tekst;
    private int waarde;

    public Woord(String tekst, int waarde) {
        this.tekst = tekst;
        this.waarde = waarde;
    }

    public String getTekst() {
        return tekst;
    }

    @Override
    public int compareTo(Woord that) {
        return this.waarde - that.waarde;
    }
}
