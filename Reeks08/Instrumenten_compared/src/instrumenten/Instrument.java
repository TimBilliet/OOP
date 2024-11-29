package instrumenten;


/**
 *
 * @author tiwi
 */
public class Instrument {

    private String naam;
    private int gewicht;

    public Instrument(String naam, int gewicht) {
        this.naam = naam;
        this.gewicht = gewicht;
    }
    
    public String getNaam(){
        return naam;
    }

    public int getGewicht() {
        return gewicht;
    }

    @Override
    public String toString() {
        return naam + "  (" + gewicht + " gram)";
    }

}
