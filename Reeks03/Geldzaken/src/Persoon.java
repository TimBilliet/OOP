public class Persoon {

    private String achternaam;
    private String voornaam;
    private Rekening zichtrekening;
    private Rekening spaarrekening;

    public Persoon(String achternaam, String voornaam) {
        this.achternaam = achternaam.trim();
        this.voornaam = voornaam.trim();
        zichtrekening = new Rekening(0);
        spaarrekening = new Rekening(0);
    }

    public double getSaldoZicht() {
        return zichtrekening.getSaldo();
    }

    public double getvermogen() {
        return zichtrekening.getSaldo() + spaarrekening.getSaldo();
    }

    public void versluisNaarSpaar(double bedrag) {
        if (bedrag > 0) {
            zichtrekening.haalAf(bedrag);
            spaarrekening.stort(bedrag);
        }
    }

    public void zetOpRekening(double bedrag, boolean opSpaar) {
        if(opSpaar) {
            spaarrekening.stort(bedrag);
        } else {
            zichtrekening.stort(bedrag);
        }
    }
    public void geefZakgeldAan(Persoon anderePersoon, double bedrag) {
        if (bedrag > 0) {
            zichtrekening.schrijfOverNaar(anderePersoon.zichtrekening, bedrag);
            //zichtrekening.haalAf(bedrag);
            //anderePersoon.zichtrekening.stort(bedrag);
            //anderePersoon.zetOpRekening(bedrag, false);
        }
    }
    public void geefSpaarcentAan(Persoon anderePersoon, double bedrag) {
        if (bedrag > 0) {
            zichtrekening.schrijfOverNaar(anderePersoon.spaarrekening, bedrag);
            zichtrekening.haalAf(bedrag);
            //anderePersoon.spaarrekening.stort(bedrag);
            //anderePersoon.zetOpRekening(bedrag, true);
        }
    }
    @Override
    public String toString() {
        return voornaam + " " + achternaam + " (zicht " + zichtrekening + ", spaar " + spaarrekening + ")";
    }
}