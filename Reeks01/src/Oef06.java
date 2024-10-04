import java.util.Random;

public class Oef06 {
    public static void main(String[] args) {
        System.out.println();
        for (int i = 1; i < 30; i++) {
            //                min + (int)((max - min + 1) * Math.random())
            int randomGetal = 10 + (int)( (20 - 10 + 1)* Math.random());

            System.out.println("Random getal " + i + ": " + randomGetal);
        }

    }
}
