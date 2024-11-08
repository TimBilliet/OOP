public class Snaarinstrument extends Instrument{
    public Snaarinstrument(String naam, int gewicht) {
        super(naam, gewicht);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + super.toString();
    }
}
