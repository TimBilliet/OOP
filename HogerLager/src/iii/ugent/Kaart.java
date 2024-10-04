package iii.ugent;

public class Kaart {

    private int waarde;
    private int kleur;

    /* de waarde van een kaart ligt tussen 1 en 13 (1 voor aas, 11-13 voor de prentjes)
     * de kleur van een kaart is
     *   1 (voor harten),
     *   2 (voor ruiten),
     *   3 (voor schoppen) of
     *   4 (voor klaveren)
     */
    public Kaart(int waarde, int kleur) {
        if (waarde < 1 || waarde > 13) {
            System.out.println("Als de gebruiker een object van de klasse Kaart aanmaakt, moet de waarde tussen 1 en 13 liggen!" );
            waarde = 1;
        }
        this.waarde = waarde;
        if (this.waarde == 1) {
            this.waarde = 14;    // intern bewaren we de aas als '14', zo zorgen we ervoor dat de aas de hoogste is!
        }
        this.kleur = kleur;
    }

    public boolean isHogerDan(Kaart ander) {
        return this.waarde > ander.waarde;
    }

    public boolean isLagerDan(Kaart ander) {
        return this.waarde < ander.waarde;
    }

    @Override
    public String toString() {
        String[] kleuren = {"harten", "ruiten", "schoppen", "klaveren"};
        String[] waarden = {"boer", "dame", "heer", "aas"};
        String resultaat = kleuren[kleur - 1] + " ";
        if (waarde <= 10) {
            resultaat += waarde;
        } else {
            resultaat += waarden[waarde - 11];
        }
        return resultaat;
    }
}
