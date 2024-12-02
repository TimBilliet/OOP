package groepen;

import java.util.Arrays;

/**
 * @author tiwi
 */
public class Balk extends Ruimtefiguur {

    private final int lengte;
    private final int breedte;
    private final int hoogte;

    public Balk(int l, int b, int h, String kleur) {
        super(kleur);
        // lengte, breedte en hoogte worden gesorteerd (lengte is allicht het grootst, daarna breedte, daarna hoogte)
        // anders kan het vergelijken (opgesplitst op lengte, breedte, hoogte) niet echt eerlijk gebeuren !
        // (voor de houtkenners onder jullie: er wordt dus geen rekening gehouden met de richting waarin de 
        //  nerven lopen, we definiëren de lengte als de langste afmeting en niet als de afmeting parallel aan de nerven)
        int[] afm = {l, b, h};
        Arrays.sort(afm);
        lengte = afm[2];  // grootste afmeting
        breedte = afm[1]; // 
        hoogte = afm[0];  // kleinste afmeting
    }

    @Override
    public double getVolume() {
        return lengte * breedte * hoogte;
    }

    @Override
    public int compareKey(Ruimtefiguur fig) {
        Balk andereBalk = (Balk) fig;
        if (lengte - andereBalk.lengte == 0) {
            if (breedte - andereBalk.breedte == 0) {
                return hoogte - andereBalk.hoogte;
            } else {
                return breedte - andereBalk.breedte;
            }
        } else {
            return lengte - andereBalk.lengte;
        }
    }

    @Override
    public int hashCode() {
        // één van de mogelijkheden
        return (kleur + lengte + " " + breedte + " " + hoogte).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Balk other = (Balk) obj;
        return lengte == other.lengte && breedte == other.breedte && hoogte == other.hoogte && kleur.equals(other.kleur);
    }

    // kan ook met StringBuilder
    @Override
    public String toString() {
        String s = super.toString();
        return s.substring(0, s.length() - 1) + "  l=" + lengte + "  b=" + breedte + "  h=" + hoogte + "]";
    }
}
