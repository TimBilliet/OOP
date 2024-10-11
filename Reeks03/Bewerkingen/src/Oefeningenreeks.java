import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Oefeningenreeks {
    private int aantalOefeningen;
    private int aantalJuisteAntwoorden;

    public Oefeningenreeks(String bestandsnaam) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(bestandsnaam));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if(input.isEmpty()){
                continue;
            }
            geefOefeningAanGebruiker(new Bewerking(input));
            aantalOefeningen++;
        }
        System.out.println(this);
    }

    public void geefOefeningAanGebruiker(Bewerking bewerking) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(bewerking);
        String input = scanner.nextLine().trim();
        if (Integer.parseInt(input) == bewerking.oplossing()) {
            System.out.println(":)");
            aantalJuisteAntwoorden++;
        } else {
            System.out.println(":(");
        }
    }

    @Override
    public String toString() {
        String feedback = "U heeft " + aantalJuisteAntwoorden + " van de " + aantalOefeningen + " oefeningen juist opgelost.";

        if (aantalJuisteAntwoorden <= aantalOefeningen / 2) {
            feedback += " Niet opgeven, blijven oefenen!!";
        }

        return feedback;
    }
}
