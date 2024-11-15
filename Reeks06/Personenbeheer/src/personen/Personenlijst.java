package personen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ...
 */
public class Personenlijst {

    // hier werd niet voor een set gekozen, omdat de reeds bestaande persoon
    // makkelijk opgevraagd moet kunnen worden (dat kan met een iterator voor een set - komt later aan bod)
    private List<Persoon> personen;

    private int count = 0;
    public Personenlijst(String bestandsnaam) throws FileNotFoundException {
        personen = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(bestandsnaam))) {
            while (sc.hasNext()) {
                String lijn = sc.nextLine();
                Scanner scLijn = new Scanner(lijn);
                scLijn.useDelimiter("/");
                String soort = scLijn.next();  // hebben we niet nodig op dit moment
                //Persoon persoon = new Persoon(scLijn.next(), scLijn.next());
                Persoon persoon = null;

                try {
                    persoon = (Persoon) Class.forName("personen." + soort).getConstructor(String.class, String.class).newInstance(scLijn.next(), scLijn.next());
                } catch (Exception ex ) {
                    System.out.println("Maken van object gefaald: " + ex);
                } 
                if (personen.contains(persoon)) {
                    Persoon teBewerkenPersoon = personen.get(personen.indexOf(persoon));
                    while (scLijn.hasNext()) {
                        teBewerkenPersoon.voegInformatieToe(scLijn.next());
                    }
                } else {
                    while (scLijn.hasNext()) {
                        persoon.voegInformatieToe(scLijn.next());
                    }
                    personen.add(persoon);
                }
                scLijn.close();
            }
        }
    }

    public List<Persoon> getPersonen() {
        return personen;
    }

}
