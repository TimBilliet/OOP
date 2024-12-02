package groepen;

import java.util.Comparator;

public class GrootteComparator implements Comparator<Ruimtefiguur> {
    @Override
    public int compare(Ruimtefiguur fig1, Ruimtefiguur fig2) {
        //System.out.println("fig1: " + fig1 + ", fix2: " + fig2);
        if(Math.abs(fig1.getVolume() - fig2.getVolume()) < 0.0001) {

            return fig1.compareTo(fig2);

        } else {
            return (int) (fig1.getVolume() - fig2.getVolume());
        }

       // return (int) (fig1.getVolume() - fig2.getVolume());
    }
}
