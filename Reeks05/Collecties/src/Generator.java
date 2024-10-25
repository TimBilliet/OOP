import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Generator {

    private int ondergrens;
    private int bovengrens;


    public Generator(int ondergrens, int bovengrens) {
        if (ondergrens >= bovengrens) {
            throw new IllegalArgumentException("Ondergrens moet lager zijn dan bovengrens");
        } else {
            this.ondergrens = ondergrens;
            this.bovengrens = bovengrens;
        }
    }

    public Set<Integer> geefVerschillendeGetallen(int aantal) {
        if (aantal >= bovengrens - ondergrens) {
            throw new IllegalArgumentException("Onmogelijk om " + aantal + " verschillende getallen te generenen tussen " + bovengrens + " en " + ondergrens);
        } else {
            Set<Integer> getallen = new HashSet<>();
            while (getallen.size() < aantal) {
                int randomgetal = (int) (ondergrens + Math.random() * (bovengrens - ondergrens + 1));
                getallen.add(randomgetal);
            }
            return getallen;
        }
    }

    public Set<Integer> geefVerschillendeGetallenInVolgorde(int aantal) {
        if (aantal >= bovengrens - ondergrens) {
            throw new IllegalArgumentException("Onmogelijk om " + aantal + " verschillende getallen te generenen tussen " + bovengrens + " en " + ondergrens);
        } else {
            Set<Integer> getallenInVolgore = new TreeSet<>();
            while (getallenInVolgore.size() < aantal) {
                int randomgetal = (int) (ondergrens + Math.random() * (bovengrens - ondergrens + 1));
                getallenInVolgore.add(randomgetal);
            }
            return getallenInVolgore;
        }
    }
}
