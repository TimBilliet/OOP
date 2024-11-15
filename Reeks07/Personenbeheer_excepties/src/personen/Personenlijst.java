package personen;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ...
 */
public class Personenlijst {

    private List<Persoon> personen;

    private String foutmelding = "";
    private int lijnCounter;

    public Personenlijst(String bestandsnaam) {
        personen = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(bestandsnaam))) {
            while (sc.hasNext()) {
                String lijn = sc.nextLine();
                lijnCounter++;
                Scanner scLijn = new Scanner(lijn);
                scLijn.useDelimiter("/");
                String soort = scLijn.next();

                try {
                    Persoon persoon = (Persoon) Class.forName("personen."
                            + soort).getConstructor(String.class, String.class).newInstance(scLijn.next(), scLijn.next());
                    if (personen.contains(persoon)) {
                        int locatie = personen.indexOf(persoon);
                        persoon = personen.get(locatie);
                    } else {
                        personen.add(persoon);
                    }
                    while (scLijn.hasNext()) {
                        persoon.voegInformatieToe(scLijn.next());
                    }
                } catch (Exception ex) {
                    foutmelding += "\nRegel " + lijnCounter + " werd niet opgenomen in het verslag: " + soort;
                } finally {
                    scLijn.close();
                }
            }
        } catch (FileNotFoundException ex) {
            foutmelding += "\nFout bij het inlezen van bestand";
        }
    }

    public List<Persoon> getPersonen() {
        return personen;
    }

    public String getFoutmelding() {
        return foutmelding;
    }

}
