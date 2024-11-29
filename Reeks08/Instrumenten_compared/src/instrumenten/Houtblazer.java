package instrumenten;

/**
 *
 * @author tiwi
 */
public class Houtblazer extends Blazer{
    
    public Houtblazer(String naam, int gewicht, String sleutel) {
        super(naam, gewicht, sleutel);
    }
    
    @Override
    public String toString(){
        return "Houtblazer " + super.toString();
    }
    
}
