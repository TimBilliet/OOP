package personen;

import java.io.FileNotFoundException;

/**
 *
 * @author ...
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        Personenlijst lijst = new Personenlijst("personenKORT.csv");
        Personenlijst lijst = new Personenlijst("personen.csv");  // voor het lange bestand
        System.out.println("Ik vond " + lijst.getPersonen().size() + " verschillende personen.");
        for (Persoon p : lijst.getPersonen()) {  // zet dit uit bij lang bestand!
//            System.out.println(p);
        }
    }
}
