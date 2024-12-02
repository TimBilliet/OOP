package groepen;

/**
 * @author tiwi
 */
public class Cilinder extends Ruimtefiguur {

    private final int straal;
    private final int hoogte;

    public Cilinder(int straal, int hoogte, String kleur) {
        super(kleur);
        this.straal = straal;
        this.hoogte = hoogte;
    }

    @Override
    public double getVolume() {
        return Math.PI * straal * straal * hoogte;
    }

    @Override
    public int compareKey(Ruimtefiguur fig) {
        Cilinder andereCil = (Cilinder) fig;
        if (hoogte - andereCil.hoogte == 0) {
            return straal - andereCil.straal;
        } else {
            return hoogte - andereCil.hoogte;
        }
    }

    @Override
    public int hashCode() {
        return (kleur + straal + " " + hoogte).hashCode();
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
        Cilinder other = (Cilinder) obj;
        return straal == other.straal && hoogte == other.hoogte && kleur.equals(other.kleur);
    }

    // kan ook met StringBuilder
    @Override
    public String toString() {
        String s = super.toString();
        return s.substring(0, s.length() - 1) + "  r=" + straal + "  h=" + hoogte + "]";
    }

}
