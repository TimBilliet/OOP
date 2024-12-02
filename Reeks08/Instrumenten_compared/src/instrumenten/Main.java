package instrumenten;

import java.io.FileNotFoundException;
import java.util.Set;

/**
 *
 * @author tiwi
 */
public class Main {

    public static InstrumentDAO instrumenten;

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
        instrumenten = new InstrumentDAO("instrumenten.txt");
//        deel0();
//        deel1();
//        deel2();
//        deel3();
//        deel4();
//        deel5();
//         deel6();
         deel7();
    }

    public static void deel0() {
        System.out.println("DEEL 0");
        Instrument a = new Instrument("buffetpiano", 180000);
        Snaarinstrument b = new Snaarinstrument("viool", 450);
        Koperblazer c = new Koperblazer("trompet", 1000, "bes");
        if (a.toString().startsWith("buffetpiano") && a.toString().contains("180000")) {
            System.out.println("test passed");
        } else {
            System.out.println("ERROR foutje bij Instrument buffetpiano");
        }
        if (b.toString().startsWith("Snaarinstrument") && c.toString().startsWith("Koperblazer")) {
            System.out.println("test passed");
        } else {
            System.out.println("ERROR foutje bij Snaarinstrument en/of Koperblazer");
        }
    }

    public static void deel1() {
        System.out.println("\nDEEL 1");
        int aantalSnaar = instrumenten.aantalVanKlasse("Snaarinstrument");
        int aantalHout = instrumenten.aantalVanKlasse("Houtblazer");
        int aantalKoper = instrumenten.aantalVanKlasse("Koperblazer");
        System.out.println("Er werden " + aantalSnaar + " snaarinstrumenten geteld;");
        System.out.println("er werden " + aantalHout + " houtblazers geteld;");
        System.out.println("er werden " + aantalKoper + " koperblazers geteld.");
        if (aantalSnaar == 4 && aantalHout == 3 && aantalKoper == 5) {
            System.out.println("test passed");
        } else {
            System.out.println("ERROR aantallen zijn niet juist!");
        }
    }

    public static void deel2() {
        System.out.println("\nDEEL 2");
        System.out.println("Het zwaarste snaarinstrument: " + instrumenten.zwaarste("Snaarinstrument"));
        System.out.println("De zwaarste houtblazer: " + instrumenten.zwaarste("Houtblazer"));
        System.out.println("De zwaarste blazer: " + instrumenten.zwaarste("Blazer"));
        if (instrumenten.zwaarste("Snaarinstrument").getGewicht() == 11000 && instrumenten.zwaarste("Houtblazer").getGewicht() == 3000
                && instrumenten.zwaarste("Blazer") == null) {
            System.out.println("test passed");
        } else {
            System.out.println("ERROR foutje bij bepalen van zwaarste instrumenten");
        }
    }

    public static void deel3() {
        System.out.println("\nDEEL 3");
        System.out.println("De blaasinstrumenten in ut: ");
        for (Blazer b : instrumenten.blazersInSleutel("ut")) {
            System.out.println("" + b);
        }
        if (instrumenten.blazersInSleutel("ut").size() == 4) {
            System.out.println("test passed");
        } else {
            System.out.println("ERROR fout bij bepalen van blazers in sleutel ut");
        }
    }

    public static void deel4() throws ClassNotFoundException {
        System.out.println("\nDEEL 4");
        int totaalInstrument = instrumenten.aantalVanKlasseOfAfgeleidVanKlasse("Instrument");
        int totaalSnaar = instrumenten.aantalVanKlasseOfAfgeleidVanKlasse("Snaarinstrument");
        int totaalBlazer = instrumenten.aantalVanKlasseOfAfgeleidVanKlasse("Blazer");
        System.out.println("Er werden in totaal " + totaalInstrument + " instrumenten geteld;");
        System.out.println("Er werden in totaal " + totaalSnaar + " snaarinstrumenten geteld;");
        System.out.println("Er werden in totaal " + totaalBlazer + " blazers geteld.");
        if (totaalInstrument == 14 && totaalSnaar == 4 && totaalBlazer == 8) {
            System.out.println("test passed");
        } else {
            System.out.println("ERROR aantallen zijn niet juist!");
        }
    }

    private static void testSorteren(Set<Instrument> set, String verwachteUitkomst, String manier) {
        System.out.println(set);
        if (verwachteUitkomst.equalsIgnoreCase(set.toString())) {
            System.out.println("test passed");
        } else {
            System.out.println("ERROR sorteren op " + manier + " ergens misgelopen!");
        }
    }

    public static void deel5() {
        System.out.println("\nDEEL 5");
        String verwachteUitkomst = "[vleugelpiano  (400000 gram), buffetpiano  (180000 gram), Snaarinstrument contrabas  (11000 gram), Snaarinstrument cello  (3000 gram), Houtblazer fagot  (3000 gram) in ut, Koperblazer hoorn  (2800 gram) in fa, Koperblazer trombone  (1200 gram) in bes, Snaarinstrument altviool  (1000 gram), Koperblazer trompet  (1000 gram) in bes, Houtblazer klarinet  (780 gram) in la, Houtblazer hobo  (650 gram) in ut, Koperblazer dwarsfluit  (500 gram) in ut, Koperblazer dwarsfluit  (450 gram) in ut, Snaarinstrument viool  (450 gram)]";
        testSorteren(instrumenten.gesorteerdOpGewicht(), verwachteUitkomst, "gewicht");
    }

    public static void deel6() {
        System.out.println("\nDEEL 6");
        String verwachteUitkomst = "[Snaarinstrument altviool  (1000 gram), buffetpiano  (180000 gram), Snaarinstrument cello  (3000 gram), Snaarinstrument contrabas  (11000 gram), Koperblazer dwarsfluit  (500 gram) in ut, Koperblazer dwarsfluit  (450 gram) in ut, Houtblazer fagot  (3000 gram) in ut, Houtblazer hobo  (650 gram) in ut, Koperblazer hoorn  (2800 gram) in fa, Houtblazer klarinet  (780 gram) in la, Koperblazer trombone  (1200 gram) in bes, Koperblazer trompet  (1000 gram) in bes, Snaarinstrument viool  (450 gram), vleugelpiano  (400000 gram)]";
        testSorteren(instrumenten.gesorteerdOpNaam(), verwachteUitkomst, "naam");
    }

    public static void deel7() {
        System.out.println("\nDEEL 7");
        String verwachteUitkomst = "[Houtblazer fagot  (3000 gram) in ut, Houtblazer klarinet  (780 gram) in la, Houtblazer hobo  (650 gram) in ut, vleugelpiano  (400000 gram), buffetpiano  (180000 gram), Koperblazer hoorn  (2800 gram) in fa, Koperblazer trombone  (1200 gram) in bes, Koperblazer trompet  (1000 gram) in bes, Koperblazer dwarsfluit  (500 gram) in ut, Koperblazer dwarsfluit  (450 gram) in ut, Snaarinstrument contrabas  (11000 gram), Snaarinstrument cello  (3000 gram), Snaarinstrument altviool  (1000 gram), Snaarinstrument viool  (450 gram)]";
        testSorteren(instrumenten.gesorteerdOpSoort(), verwachteUitkomst, "soort");
    }

}
