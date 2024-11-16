package excepties;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author ...
 */
public class VerwerkerVanBestand {

    private File file;

    public VerwerkerVanBestand(String bestandsnaam) throws FileNotFoundException {
        this.file = new File(bestandsnaam);
        Scanner sc = new Scanner(this.file);
        // deze scanner werd alleen geinitialiseerd om een exceptie te triggeren
        // (Dit wordt hier in de constructor gedaan, omdat anders elke andere methode
        //  ook de FileNotFoundException moet opgooien - en dat wordt in het hoofdprogramma
        //  een rommeltje om dat allemaal op te vangen. Terwijl het eigenlijk niet nodig is;
        //  want als het bestand niet gevonden wordt, zal er ook geen object van de klasse
        //  VerwerkerVanBestand aangemaakt zijn!!)
        sc.close();
    }


    // zorg dat deze methode zeker geen FileNotFoundException meer gooit;
    // vang ze maar op in de methode!
    public int geefSom() throws GeenIntsExceptie {
        int som = 0;
        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNext()) {
                som += scanner.nextInt();
            }
        } catch (FileNotFoundException ignored) {
        } catch (InputMismatchException ex) {
            throw new GeenIntsExceptie();
        }
        return som;
    }


    // zelfde opmerking over FileNotFoundException
    public double geefGemiddelde() throws GeenDoublesExceptie {
        double gemiddelde = 0;
        int aantal = 0;
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                gemiddelde += sc.nextDouble();
                aantal++;
            }
        } catch (FileNotFoundException ignored) {

        } catch (InputMismatchException ex) {
            throw new GeenDoublesExceptie();
        }
        // to do
        gemiddelde /= aantal;
        return gemiddelde;
    }

    // zelfde opmerking over FileNotFoundException
    public String geefTekst() {
        StringBuilder tekst = new StringBuilder();
        try (Scanner sc = new Scanner(file)) {
            while(sc.hasNext()) {
                tekst.append(sc.next()).append(" ");
            }

        } catch (FileNotFoundException ignored) {
        }
        return String.valueOf(tekst);
    }
}
