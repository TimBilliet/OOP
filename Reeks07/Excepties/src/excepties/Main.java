package excepties;


import java.io.FileNotFoundException;

/**
 * @author ...
 */
public class Main {

    public static void main(String[] args) {
//        oefening1();
        oefening2(args);
    }

    public static void oefening1() {
        TellerVanBestandsinhoud teller = new TellerVanBestandsinhoud("tel.txt");
        System.out.println("aantal ints is " + teller.getAantalInt());
        System.out.println("aantal doubles is " + teller.getAantalDouble());
        System.out.println("aantal strings is " + teller.getAantalString());
    }
    //in het bestand d.txt worden punten gebruikt in plaats van kommas dus worden de getallen niet als doubles maar als tekst behandeld
    public static void oefening2(String[] args) {
        VerwerkerVanBestand verwerker = null;
        for (String arg : args) {
            try {
                verwerker = new VerwerkerVanBestand(arg);
                System.out.println("De som in het bestand " + arg + " is " + verwerker.geefSom());
            } catch (FileNotFoundException ex) {
                System.out.println("Bestand " + arg + " niet gevonden");
            } catch (GeenIntsExceptie ex) {
                try {
                    System.out.println(verwerker.geefGemiddelde());

                } catch (GeenDoublesExceptie e) {
                    System.out.println("De tekst in bestand " + arg + " is ");
                    System.out.println(verwerker.geefTekst());
                }
            }
        }
    }
}
