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
        //zesde opdracht
        String[] voornamen = {"Serdar","Benjamin","Martha"};
        String[] namen = {"Mortier","Hakizimali","Debyser"};

        for(int i=0; i<namen.length; i++){
            System.out.println("Persoon met naam "+voornamen[i]+" "+namen[i]+": "+lijst.nietStudentMetNaam(namen[i],voornamen[i]));
            System.out.println("Student met naam "+voornamen[i]+" "+namen[i]+": "+lijst.studentMetNaam(namen[i],voornamen[i])+"\n");
        }
//        zevende opdracht
        String[] haarkleuren = {"peper en zout", "vuurtorenros", "pimpelpaars", "ravenzwart"};
        for (int i = 0; i < haarkleuren.length; i++) {
            System.out.println("Aantal niet-studenten met haarkleur " + haarkleuren[i] + ": " + lijst.personenVanKlasseMetHaarkleur("Persoon",haarkleuren[i]).size());
            System.out.println("Aantal      studenten met haarkleur " + haarkleuren[i] + ": " + lijst.personenVanKlasseMetHaarkleur("Student",haarkleuren[i]).size());
        }

        String[] studies = {"industrieel ingenieur","bio-ingenieur","geneeskunde","rechten"};
        for (int i = 0; i < studies.length; i++) {
            System.out.println("Aantal studenten met studie " + studies[i] + ": " + lijst.studentenMetStudie(studies[i]).size());
        }
        //achtste opdracht
        System.out.println(lijst.persoonMetMeesteHobbys());
        System.out.println(lijst.studentMetMeesteDiplomas());
    }
}
