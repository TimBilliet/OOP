public class Omzetter {

    private int aantalRijen;
    private int aantalKolommen;

    public Omzetter(int aantalRijen, int aantalKolommen) {
        this.aantalKolommen = aantalKolommen;
        this.aantalRijen = aantalRijen;
    }

    public int rij(int volgnr) {
        if (volgnr >= 0 && volgnr < aantalRijen * aantalKolommen) {
            return volgnr / aantalKolommen;
        } else {
            return -1;
        }
    }

    public int kolom(int volgnr) {
        if (volgnr >= 0 && volgnr < aantalRijen * aantalKolommen) {
            return volgnr - aantalKolommen * rij(volgnr);
        } else {
            return -1;
        }
    }

    public int volgnr(int rij, int kolom) {
        if(rij >= 0 && rij < aantalRijen && kolom >= 0 && kolom < aantalKolommen) {
            return rij * aantalKolommen + kolom;
        } else {
            return -1;
        }
    }
}
