import java.util.Scanner;

public class Oef03 {
    public static void main(String[] args) {
        String naam = "Van d'Hievel, Gert-Jan";
        //String naam = " Van den Breen , Wim ";
        //String naam = " Naessens , Helga ";
        StringBuilder emailadres = new StringBuilder();
        Scanner sc = new Scanner(naam.toLowerCase().replaceAll("[\\s-']+", "")).useDelimiter(",");

        String achternaam = sc.next();
        String voornaam = sc.next();
        sc.close();

        emailadres.append(voornaam);
        emailadres.append(".");
        emailadres.append(achternaam);

        emailadres.append("@ugent.be");
        System.out.println("E-mailadres: " + emailadres);

    }
}
