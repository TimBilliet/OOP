import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Instrumenten {

    private List<Instrument> instrumentenLijst;

    //Obj obj = (Obj) Class.forname(klassenaam).getConstructor(String.class,int.class).newInstance("test", 40);
    public Instrumenten(String bestandsnaam) {
        try (Scanner sc = new Scanner(new File(bestandsnaam))) {
            instrumentenLijst = new ArrayList<>();
            while (sc.hasNext()) {
                String lijn = sc.nextLine();

                String stukjes[] = lijn.split(";");





                switch (stukjes[0]) {
                    case "KOPER":
                        instrumentenLijst.add(new Koperblazer(stukjes[1], Integer.parseInt(stukjes[2]), stukjes[3]));
                        break;
                    case "HOUT":
                        instrumentenLijst.add(new Houtblazer(stukjes[1], Integer.parseInt(stukjes[2]), stukjes[3]));
                        break;
                    case "SNAAR":
                        instrumentenLijst.add(new Snaarinstrument(stukjes[1], Integer.parseInt(stukjes[2])));
                        break;
                    case "INSTR":
                        instrumentenLijst.add(new Instrument(stukjes[1], Integer.parseInt(stukjes[2])));
                        break;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Bestand \"" + bestandsnaam + "\" niet gevonden");
        }


    }

    public int aantalVanKlasse(String naam) {
        int teller = 0;
        try {
            for (Instrument instr : instrumentenLijst) {
                if (instr.getClass() == Class.forName(naam)) {
                    teller++;
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        return teller;
    }

    public Instrument zwaarste(String naam) {
        Instrument zwaarsteInstrument = instrumentenLijst.get(0);
        try {
            if (Class.forName(naam).equals(Blazer.class)) {
                return null;
            }
            for (Instrument instr : instrumentenLijst) {
                //== is hetzelfde als equals bij Class, de equals methode wordt niet overschreven omdat Class final is, isEquals wordt geërfd van de Object klasse
                if (instr.getClass() == Class.forName(naam) && instr.getGewicht() > zwaarsteInstrument.getGewicht()) {

                    zwaarsteInstrument = instr;
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return zwaarsteInstrument;
    }

    public List<Blazer> blazersInSleutel(String sleutel) {
        List<Blazer> blazerMetSleutelLijst = new ArrayList<>();
        for(Instrument instr : instrumentenLijst) {
            //if(instr instanceof Blazer && ((Blazer)instr).getSleutel().equals(sleutel)) {
            if(instr instanceof Blazer blazer && blazer.getSleutel().equals(sleutel)) {
                if(blazer instanceof Houtblazer houtblazer) {
                    blazerMetSleutelLijst.add(houtblazer);
                } else if(blazer instanceof Koperblazer koperblazer){
                    blazerMetSleutelLijst.add(koperblazer);
                }
                //moeten subklasse objecten zijn, koperblazern en houtblazer
            }
        }
        return blazerMetSleutelLijst;
    }
}
