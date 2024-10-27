package groepsindeling;

/**
 *
 * @author tiwi
 */
public class Persoon {
    
    private String naam;
    private int ervaring;

    public Persoon(String naam, int ervaring) {
        this.naam = naam;
        this.ervaring = ervaring;
    }
    
    public String getNaam() {
        return naam;
    }

    public int getErvaring() {
        return ervaring;
    }

    @Override
    public String toString() {
        return " (" + ervaring + ')' + naam ;
    }
    
    
}
