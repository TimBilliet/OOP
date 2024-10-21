package adressen;

public class Adres {
    private String straat;
    private int huisnummer;
    private int postcode;
    private String woonplaats;
    private String bus;

    public Adres(int postcode, String woonplaats, String straat, int huisnummer) {
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.woonplaats = woonplaats;
        //this.bus = null;
    }
    public Adres(int postcode, String woonplaats, String straat, int huisnummer, String bus) {
        this(postcode, woonplaats, straat, huisnummer);
        this.bus = bus;
    }

    public String getGemeente() {
        return woonplaats;
    }

    public String getStraat() {
        return straat;
    }

    public int getPostcode() {
        return postcode;
    }

    @Override
    public String toString() {
        return  straat + " " + huisnummer + (bus == null ? "": (" bus " + bus)) + "\n" +
               postcode + " " + woonplaats;
    }

}