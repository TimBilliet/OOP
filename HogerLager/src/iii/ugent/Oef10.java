package iii.ugent;

import java.util.Scanner;

public class Oef10 {
    public static void main(String[] args) {
        Kaart kaart1 = BoekKaarten.geefKaart();
        System.out.println("De eerste kaart is " + BoekKaarten.geefKaart());
        System.out.println("Hoger of lager?" );
        Scanner scanner = new Scanner(System.in);
        Kaart nieuw = BoekKaarten.geefKaart();
        while (scanner.hasNext()) {

            String input = scanner.nextLine();
            System.out.println(input);
            if (input.equals("hoger" ) && nieuw.isHogerDan(kaart1)) {
                nieuw = BoekKaarten.geefKaart();
                System.out.println("JUIST");
                break;
            } else if (input.equals("lager" ) && nieuw.isLagerDan(kaart1)) {
                nieuw = BoekKaarten.geefKaart();
                System.out.println("JUIST");
            } else if() {

            } else {
                System.out.println("Antwoord met 'hoger' of 'lager' aub" );
            }

        }
    }
}
