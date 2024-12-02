package groepen;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author tiwi
 */
public class Main {

    public static void main(String[] args) {
        vraag1();
//        vraag2();
    }

    public static void vraag1() {
        DAOFigurenDummy dummy = new DAOFigurenDummy();

        System.out.println("Dit zijn alle figuren:\n");
        for (Ruimtefiguur f : dummy.getFiguren()) {
            System.out.println("" + f);
        }

        System.out.println("\nVRAAG 1");
        controleerAantallen("aantal verschillende figuren  ", dummy.getFiguren().size(), 17);
        controleerAantallen("aantal verschillende balken   ", dummy.getBalken().size(), 9);
        controleerAantallen("aantal verschillende cilinders", dummy.getCilinders().size(), 6);
    }

    public static void vraag2() {

        DAOFigurenDummy dummy = new DAOFigurenDummy();
        System.out.println("\nVRAAG 2 FUNCTIE 'MAX'");        
        
        controleerFiguur("'Grootste' (eerst gesorteerd) van figuren   [rood]", max(dummy.getFiguren(), "rood"), "Cilinder [rood  vol=14137.17  r=30  h=5]");
        controleerFiguur("'Grootste' (eerst gesorteerd) van balken    [rood]", max(dummy.getBalken(), "rood"), "Balk [rood  vol=240.00  l=20  b=4  h=3]");
        controleerFiguur("'Grootste' (eerst gesorteerd) van cilinders [rood]", max(dummy.getCilinders(), "rood"), "Cilinder [rood  vol=14137.17  r=30  h=5]");
        controleerFiguur("'Grootste' (eerst gesorteerd) van figuren   [geel]", max(dummy.getFiguren(), "geel"), "Cilinder [geel  vol=2513.27  r=10  h=8]");
        controleerFiguur("'Grootste' (eerst gesorteerd) van balken    [geel]", max(dummy.getBalken(), "geel"), "Balk [geel  vol=240.00  l=20  b=4  h=3]");
        controleerFiguur("'Grootste' (eerst gesorteerd) van cilinders [geel]", max(dummy.getCilinders(), "geel"), "Cilinder [geel  vol=2513.27  r=10  h=8]");
        controleerFiguur("'Grootste' (eerst gesorteerd) van figuren   [blauw]", max(dummy.getFiguren(), "blauw"), "Cilinder [blauw  vol=141.37  r=3  h=5]");
        controleerFiguur("'Grootste' (eerst gesorteerd) van balken    [blauw]", max(dummy.getBalken(), "blauw"), "Balk [blauw  vol=24000.00  l=400  b=20  h=3]");
        controleerFiguur("'Grootste' (eerst gesorteerd) van cilinders [blauw]", max(dummy.getCilinders(), "blauw"), "Cilinder [blauw  vol=141.37  r=3  h=5]");

    }

    private static void controleerTekst(String info, String berekend, String verwacht) {
        if (berekend.equals(verwacht)) {
            System.out.println("test passed [" + info + "]");
        } else {
            System.out.println("TEST FAILED [" + info + "], verwacht: " + verwacht + ", gekregen: " + berekend);
        }
    }

    private static void controleerAantallen(String info, int berekend, int verwacht) {
        controleerTekst(info, "" + berekend, "" + verwacht);
    }

    private static void controleerFiguur(String info, Ruimtefiguur figuur, String verwachteTekst) {
        controleerTekst(info, figuur.toString(), verwachteTekst);
    }

    private static Ruimtefiguur max(Collection<? extends Ruimtefiguur> collection, String kleur) {
        return collection.stream().filter(f -> f.getKleur().equals(kleur)).max(new GrootteComparator()).get();
    }

}
