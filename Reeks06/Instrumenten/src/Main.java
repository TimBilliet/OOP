import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
        //deel0();
        //deel1();
        //deel2();
        deel3();
        //deel4();
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

    public static void deel1() throws FileNotFoundException {
        System.out.println("\nDEEL 1");
        Instrumenten instrumenten = new Instrumenten("instrumenten.txt");
        int aantalSnaar = instrumenten.aantalVanKlasse("Snaarinstrument");
        int aantalHout = instrumenten.aantalVanKlasse("Houtblazer");
        int aantalKoper = instrumenten.aantalVanKlasse("Koperblazer");
        System.out.println("Er werden " + aantalSnaar + " snaarinstrumenten geteld;");
        System.out.println("er werden " + aantalHout + " houtblazers geteld;");
        System.out.println("er werden " + aantalKoper + " koperblazers geteld.");
        if (aantalSnaar == 4 && aantalHout == 3 && aantalKoper == 4) {
            System.out.println("test passed");
        } else {
            System.out.println("ERROR aantallen zijn niet juist!");
        }
    }

    public static void deel2() throws FileNotFoundException {
        System.out.println("\nDEEL 2");
        Instrumenten instrumenten = new Instrumenten("instrumenten.txt");
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
//
    public static void deel3() throws FileNotFoundException {
        System.out.println("\nDEEL 3");
        Instrumenten instrumenten = new Instrumenten("instrumenten.txt");
        System.out.println("De blaasinstrumenten in ut: ");
        for (Blazer b : instrumenten.blazersInSleutel("ut")) {
            System.out.println("" + b);
        }
        if (instrumenten.blazersInSleutel("ut").size() == 3) {
            System.out.println("test passed");
        } else {
            System.out.println("ERROR fout bij bepalen van blazers in sleutel ut");
        }
    }
//
//    public static void deel4() throws FileNotFoundException, ClassNotFoundException {
//        System.out.println("\nDEEL 4");
//        Instrumenten instrumenten = new Instrumenten("instrumenten.txt");
//        int totaalInstrument = instrumenten.aantalVanKlasseOfAfgeleidVanKlasse("Instrument");
//        int totaalSnaar = instrumenten.aantalVanKlasseOfAfgeleidVanKlasse("Snaarinstrument");
//        int totaalBlazer = instrumenten.aantalVanKlasseOfAfgeleidVanKlasse("Blazer");
//        System.out.println("Er werden in totaal " + totaalInstrument + " instrumenten geteld;");
//        System.out.println("Er werden in totaal " + totaalSnaar + " snaarinstrumenten geteld;");
//        System.out.println("Er werden in totaal " + totaalBlazer + " blazers geteld.");
//        if (totaalInstrument == 13 && totaalSnaar == 4 && totaalBlazer == 7) {
//            System.out.println("test passed");
//        } else {
//            System.out.println("ERROR aantallen zijn niet juist!");
//        }
//    }
}