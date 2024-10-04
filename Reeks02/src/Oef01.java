import java.util.Random;

public class Oef01 {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 1; i <= 50; i++) {
            int randomGetal = random.nextInt(11) + 10;
            System.out.println("Random getal " + i + ": " + randomGetal);

        }
    }
}