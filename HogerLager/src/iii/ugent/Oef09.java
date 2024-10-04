package iii.ugent;

public class Oef09 {

    public static void main(String[] args) {
        Kaart kaart1 =  BoekKaarten.geefKaart();
        Kaart kaart2 = BoekKaarten.geefKaart();
        if(kaart1.isHogerDan(kaart2)) {
            System.out.println(kaart1 + " is hoger dan " + kaart2);
        } else if(kaart1.isLagerDan(kaart2)) {
            System.out.println(kaart1 + " is lager dan " + kaart2);
        } else {
            System.out.println(kaart2 + " is gelijk aan " + kaart1);
        }

    }

}
