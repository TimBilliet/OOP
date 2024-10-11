import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bestandslezer {

    private Persoon rijkstePersoon;

    public Bestandslezer(String bestandsnaam) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(bestandsnaam));
        rijkstePersoon = new Persoon("", "");

        while (sc.hasNext()) {
            String[] persoonInfo = sc.nextLine().split(";");
            String[] naam = persoonInfo[0].split(",");
            Persoon persoon = new Persoon(naam[0], naam[1]);
            persoon.zetOpRekening(Double.parseDouble(persoonInfo[1]), false);
            persoon.zetOpRekening(Double.parseDouble(persoonInfo[2]), true);
            if( persoon.getvermogen() > rijkstePersoon.getvermogen()) {
                rijkstePersoon = persoon;
            }
        }
        System.out.println("Rijkste persoon: " + rijkstePersoon);
    }

    public Persoon getRijkstePersoon() {
        return rijkstePersoon;
    }
}
