package instrumenten;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InstrumentDAO {

    // verander List in Set
    //private List<Instrument> instrumenten;
    private Set<Instrument> instrumenten;

    public InstrumentDAO(String bestandsnaam) throws FileNotFoundException {

        // verander ArrayList in HashSet
        instrumenten = new HashSet<>();
        try (Scanner sc = new Scanner(new File(bestandsnaam))) {
            while (sc.hasNext()) {
                Scanner sc2 = new Scanner(sc.nextLine());
                sc2.useDelimiter(";");
                String soort = sc2.next();
                Instrument instrument = null;
                if (soort.equals("INSTR")) {
                    instrument = new Instrument(sc2.next(), sc2.nextInt());
                } else if (soort.equals("SNAAR")) {
                    instrument = new Snaarinstrument(sc2.next(), sc2.nextInt());
                } else if (soort.equals("HOUT")) {
                    instrument = new Houtblazer(sc2.next(), sc2.nextInt(), sc2.next());
                } else if (soort.equals("KOPER")) {
                    instrument = new Koperblazer(sc2.next(), sc2.nextInt(), sc2.next());
                }
                instrumenten.add(instrument);
                sc2.close();
            }
        }
    }


    public int aantalVanKlasse(String soort) {
        int aant = 0;
        for (Instrument instr : instrumenten) {
            if (instr.getClass().getSimpleName().equalsIgnoreCase(soort)) {
                aant++;
            }
        }
        return aant;
    }


    public Instrument zwaarste(String soort) {
        int gewicht = 0;
        Instrument voorlopigZwaarste = null;
        for (Instrument instr : instrumenten) {
            if (instr.getClass().getSimpleName().equalsIgnoreCase(soort)) {
                if (instr.getGewicht() > gewicht) {
                    gewicht = instr.getGewicht();
                    voorlopigZwaarste = instr;
                }
            }
        }
        return voorlopigZwaarste;
    }

    public List<Blazer> blazersInSleutel(String sleutel) {
        List<Blazer> list = new ArrayList<>();
        for (Instrument instr : instrumenten) {
            if (instr instanceof Blazer && ((Blazer) instr).getSleutel().equalsIgnoreCase(sleutel)) {
                list.add((Blazer) instr);
            }
        }
        return list;
    }

    // to do
    public Set<Instrument> gesorteerdOpGewicht() {
        Instrument instr1 = null;
        Instrument instr2=null;
        int toegekend = 0;
        Set<Instrument> testset = new TreeSet<>();
        for(Instrument instr: instrumenten) {
            //System.out.println(instr);
            if(instr.getGewicht() == 1000 && toegekend == 0) {
                instr1 = instr;
                toegekend++;
            } else if(instr.getGewicht() == 1000 && toegekend == 1) {
                instr2 = instr;
                toegekend++;
            }
        }
        System.out.println(instr1.compareTo(instr2));
        testset.add(instr1);
        testset.add(instr2);
        System.out.println(instr1);
        System.out.println(instr2);
        System.out.println(testset);
        return new TreeSet<>(instrumenten); // pas aan
    }

    // to do
    public Set<Instrument> gesorteerdOpNaam() {
        return null; // pas aan
    }

    // to do
    public Set<Instrument> gesorteerdOpSoort() {
        return null; // pas aan
    }

    /*
    https://stackoverflow.com/questions/2590640/why-cant-a-class-variable-be-passed-to-instanceof
    The operator 'instanceof' can be used only with explicit class names (stated at compile time). 
    In order to do a runtime check, you should use the method 'isInstance(objectToCheck)' of the 
    class 'Class'.
    */
    public int aantalVanKlasseOfAfgeleidVanKlasse(String soort) throws ClassNotFoundException {
        Class klasse = Class.forName("instrumenten." + soort);
        int aant = 0;
        for (Instrument instr : instrumenten) {
            if (klasse.isInstance(instr)) {
                aant++;
            }
        }
        return aant;
    }

}
