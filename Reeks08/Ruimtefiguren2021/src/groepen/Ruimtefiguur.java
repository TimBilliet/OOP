package groepen;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author tiwi
 */
public abstract class Ruimtefiguur implements Comparable<Ruimtefiguur> {

    protected String kleur;

    public Ruimtefiguur(String kleur) {
        this.kleur = kleur;
    }

    public String getKleur() {
        return kleur;
    }

    public abstract double getVolume();

    public abstract int compareKey(Ruimtefiguur fig);

    @Override
    public String toString() {
        // De regel code hieronder kan je niet vinden in de slides of de theorie.
        // Als je met een probleem geconfronteerd wordt (hier: je wil een decimale punt ipv decimale komma),
        // dan ga je zoeken op het net. En dan kom je (mits wat tijdsinvestering) wel op een antwoord.
        // Dus niet vanbuiten te leren voor een test of examen; dat doen wij ook niet.
        // Voor dit specifieke probleempje gebruikten we de zoektermen
        // "java how to change decimal comma in point"  ; of
        // "how to change decimal point in comma in string java"
        // en vonden we een bruikbaar antwoord op 
        // https://stackoverflow.com/questions/5236056/force-point-as-decimal-separator-in-java
        String vol = String.format(Locale.ROOT, "%.2f", getVolume());
        return this.getClass().getName().substring(8) + " [" + getKleur() + "  vol=" + vol + "]";
    }

    @Override
    public int compareTo(Ruimtefiguur that) {
        if(this.kleur.compareTo(that.kleur)!= 0) {
            return this.kleur.compareTo(that.kleur);
        } else if(this.getClass().getSimpleName().compareTo(that.getClass().getSimpleName()) != 0) {
            return this.getClass().getSimpleName().compareTo(that.getClass().getSimpleName());
        } else {
            return this.compareKey(that);
        }
    }
}
