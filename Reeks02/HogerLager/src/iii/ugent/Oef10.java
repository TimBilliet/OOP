package iii.ugent;

import java.util.Scanner;

public class Oef10 {
    public static void main(String[] args) {

        Kaart huidigeKaart = BoekKaarten.geefKaart();
        System.out.println("De eerste kaart is " + huidigeKaart + " waarde: " + huidigeKaart.getWaarde());
        System.out.println("Hoger of lager?");
        Scanner scanner = new Scanner(System.in);
        Kaart nieuweKaart = BoekKaarten.geefKaart();
        boolean spelActief = true;

        while (spelActief) {
            String input = scanner.nextLine().trim().toLowerCase();
            while((!input.equals("hoger")) && (!input.equals("lager"))) {
                System.out.println("input was: " + input);
                System.out.println("Antwoord met 'hoger' of 'lager' aub");
                input = scanner.nextLine().trim().toLowerCase();
            }
            if (input.equals("hoger") && nieuweKaart.isHogerDan(huidigeKaart) || input.equals("lager") && nieuweKaart.isLagerDan(huidigeKaart)) {
                System.out.println("JUIST");
                System.out.println("De volgende kaart was " + nieuweKaart + " (waarde: " + nieuweKaart.getWaarde() + ")");
                System.out.println("Hoger of lager?");
                huidigeKaart = nieuweKaart;
                nieuweKaart = BoekKaarten.geefKaart();
            } else if (input.equals("lager") && nieuweKaart.isHogerDan(huidigeKaart) || input.equals("hoger") && nieuweKaart.isLagerDan(huidigeKaart)
                    || nieuweKaart.isGelijkAan(huidigeKaart)) {
                System.out.println("FOUT! Jammer, de volgende kaart was " + nieuweKaart);
                spelActief = false;
            }
        }

        /*
        while (spelActief && scanner.hasNext()) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("hoger") && nieuweKaart.isHogerDan(huidigeKaart) || input.equals("lager") && nieuweKaart.isLagerDan(huidigeKaart)) {
                System.out.println("JUIST");
                System.out.println("De volgende kaart was " + nieuweKaart + " (waarde: " + nieuweKaart.getWaarde() + ")");
                System.out.println("Hoger of lager?");
                huidigeKaart = nieuweKaart;
                nieuweKaart = BoekKaarten.geefKaart();
            } else if (input.equals("lager") && nieuweKaart.isHogerDan(huidigeKaart) || input.equals("hoger") && nieuweKaart.isLagerDan(huidigeKaart)
                    || (input.equals("lager") || input.equals("hoger")) && nieuweKaart.isGelijkAan(huidigeKaart)) {
                System.out.println("FOUT! Jammer, de volgende kaart was " + nieuweKaart);
                 spelActief = false;
            } else {
                System.out.println("Antwoord met 'hoger' of 'lager' aub");
            }
        }
         */
    }
}
