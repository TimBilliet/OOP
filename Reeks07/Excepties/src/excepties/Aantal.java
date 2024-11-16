package excepties;

/**
 * @author tiwi
 */
public class Aantal {
    private int aantalInt;
    private int aantalDouble;
    private int aantalString;

    public Aantal() {
        // alles staat bij aanvang op 0
    }

    public void verhoogInt() {
        aantalInt++;
    }

    public void verhoogDouble() {
        aantalDouble++;
    }

    public void verhoogString() {
        aantalString++;
    }

    public int getAantalInt() {
        return aantalInt;
    }

    public int getAantalDouble() {
        return aantalDouble;
    }

    public int getAantalString() {
        return aantalString;
    }
}
