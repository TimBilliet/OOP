package iii.ugent;

import java.util.Random;

public class BoekKaarten {

    private static Random random = new Random();

    public static Kaart geefKaart() {
        return new Kaart(1 + random.nextInt(13),
                1 + random.nextInt(4));
    }

}
