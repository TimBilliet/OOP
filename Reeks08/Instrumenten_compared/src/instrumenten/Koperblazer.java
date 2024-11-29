package instrumenten;

/**
 *
 * @author tiwi
 */
public class Koperblazer extends Blazer {

    public Koperblazer(String naam, int gewicht, String sleutel) {
        super(naam, gewicht, sleutel);
    }

    @Override
    public String toString() {
        return "Koperblazer " + super.toString();
    }
}
