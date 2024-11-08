public class Houtblazer extends Blazer {

    public Houtblazer(String naam, int gewicht, String sleutel) {
        super(naam, gewicht, sleutel);
    }

    public String toString() {
        return getClass().getSimpleName() + " " + super.toString();
    }
}
