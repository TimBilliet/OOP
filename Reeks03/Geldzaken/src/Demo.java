import java.io.FileNotFoundException;

public class Demo {

    public static void main(String[] args) throws FileNotFoundException {

        new Bestandslezer("personenMetGeld.csv");
        
        Persoon moeder = new Persoon("Verdonckt", "Els");
        Persoon zoon = new Persoon("Janssens", "Jan");
        Persoon dochter = new Persoon("Janssens", "Janne");
        moeder.zetOpRekening(5000, true);
        moeder.zetOpRekening(1000, false);

        System.out.println(moeder);
        System.out.println(zoon);
        System.out.println(dochter);
        moeder.geefZakgeldAan(zoon, 70);
        moeder.geefZakgeldAan(dochter, 5.5);
        moeder.geefSpaarcentAan(zoon, 30);
        moeder.geefSpaarcentAan(dochter, 30);
        moeder.versluisNaarSpaar(moeder.getSaldoZicht()-600);

        System.out.println(moeder);
        System.out.println(zoon);
        System.out.println(dochter);


    }
}
