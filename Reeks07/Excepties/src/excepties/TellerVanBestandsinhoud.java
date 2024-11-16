package excepties;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author ...
 */
public class TellerVanBestandsinhoud {

    private String bestandsnaam;
    private Aantal aantal;

    public TellerVanBestandsinhoud(String bestandsnaam) {
        this.bestandsnaam = bestandsnaam;
        aantal = null;   // voorlopig nog niets gaan tellen; 
        // enkel als er een vraag gesteld wordt naar aantallen
    }


    // Gebruik de onderstaande hulpmethode om slechts één keer het bestand te doorlopen,
    // en niet telkens er naar het aantal (ints, doubles, strings) gevraagd wordt.
    // Met andere woorden: lees hier het bestand en initialiseer hier de
    // instantievariabele 'aantal'.
    private void telPerSoort() {
        try(Scanner sc = new Scanner(new File(bestandsnaam))) {
            aantal = new Aantal();
            while (sc.hasNext()) {
                String lijn = sc.next();
                if(isInt(lijn)) {
                    aantal.verhoogInt();
                } else if(isDouble(lijn)) {
                    aantal.verhoogDouble();
                } else {
                    aantal.verhoogString();
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Bestand niet gevonden");
        }
    }

    private boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    // enkel indien het aantal nog niet goed geïnitaliseerd is, 
    // mag je het initialiseren.
    public int getAantalInt() {
        if(aantal == null) {
           // aantal = new Aantal();
            telPerSoort();
        }
        return aantal.getAantalInt();
    }

    // zelfde opmerking over initialisatie van aantal
    public int getAantalDouble() {
        if(aantal == null) {
            telPerSoort();
        }
        return aantal.getAantalDouble();
    }

    // zelfde opmerking over initialisatie van aantal
    public int getAantalString() {
        if(aantal == null) {
            telPerSoort();
        }
        return aantal.getAantalString();
    }


}
