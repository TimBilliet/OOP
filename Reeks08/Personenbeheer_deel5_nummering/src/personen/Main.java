package personen;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiwi
 */
public class Main {

    public static void main(String[] args) {

        try {
            Personenlijst lijst = new Personenlijst("personen.csv");
            System.out.println("Ik vond " + lijst.getPersonen().size() + " verschillende personen.\n");

            //zoekenOpNamen(lijst);              // test van vorige opdrachten
            //zoekenOpHaarkleurEnStudies(lijst); // test van vorige opdrachten
            //zoekenOpHobbysEnDiplomas(lijst);   // test van vorige opdrachten
            
            zoekenOpVolgnummer(lijst);   // voor de nieuwe opdracht

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static void zoekenOpVolgnummer(Personenlijst lijst){
        System.out.println("\n");
        for(int i=900; i<1005; i++){
            System.out.println("Persoon met volgnr "+i+": "+lijst.persoonMetVolgnummer(i));
        }            
    }
    
    public static void zoekenOpNamen(Personenlijst lijst) {
        String[] voornamen = {"Serdar", "Benjamin", "Martha"};
        String[] namen = {"Mortier", "Hakizimali", "Debyser"};
        for (int i = 0; i < namen.length; i++) {
            System.out.println("Persoon met naam " + voornamen[i] + " " + namen[i] + ": " + lijst.persoonMetNaam(namen[i], voornamen[i]));
            System.out.println("Student met naam " + voornamen[i] + " " + namen[i] + ": " + lijst.studentMetNaam(namen[i], voornamen[i]) + "\n");
        }
    }

    public static void zoekenOpHaarkleurEnStudies(Personenlijst lijst) {
        String[] haarkleuren = {"peper en zout", "vuurtorenros", "pimpelpaars", "ravenzwart"};
        for (int i = 0; i < haarkleuren.length; i++) {
            System.out.println("Aantal niet-studenten met haarkleur " + haarkleuren[i] + ": " + lijst.personenVanKlasseMetHaarkleur("Persoon", haarkleuren[i]).size());
            System.out.println("Aantal      studenten met haarkleur " + haarkleuren[i] + ": " + lijst.personenVanKlasseMetHaarkleur("Student", haarkleuren[i]).size());
        }

        String[] studies = {"industrieel ingenieur", "bio-ingenieur", "geneeskunde", "rechten"};
        for (int i = 0; i < studies.length; i++) {
            System.out.println("Aantal studenten met studie " + studies[i] + ": " + lijst.studentenMetStudie(studies[i]).size());
        }
    }

    public static void zoekenOpHobbysEnDiplomas(Personenlijst lijst) {
        System.out.println("\nDe actiefste hobby-beoefenaar: " + lijst.persoonMetMeesteHobbys());
        System.out.println("\nDe actiefste diploma-verzamelaar: " + lijst.studentMetMeesteDiplomas());
    }
    
}
