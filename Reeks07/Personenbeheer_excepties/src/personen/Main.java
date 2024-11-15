package personen;

import java.io.FileNotFoundException;

/**
 * @author ...
 */
public class Main {

    public static void main(String[] args) {


        Personenlijst personen = new Personenlijst("personen.csv");
        System.out.println("Aantal personen en studenten: " + personen.getPersonen().size());
        System.out.println("Fouten: " + personen.getFoutmelding());


    }

}
