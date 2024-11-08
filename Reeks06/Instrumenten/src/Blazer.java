public class Blazer extends Instrument {

    private String sleutel;

    public Blazer(String naam, int gewicht, String sleutel) {
        super(naam, gewicht);
        this.sleutel = sleutel;
    }

    public String getSleutel() {

        return sleutel;
    }

    public String toString() {
        return super.toString() + " in " + sleutel;
    }
}
