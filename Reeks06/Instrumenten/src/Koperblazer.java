public class Koperblazer extends Blazer{




    public Koperblazer(String naam, int gewicht, String sleutel) {
        super(naam, gewicht, sleutel);
    }

    public String toString() {
        return getClass().getSimpleName() + " " + super.toString();
    }
}
