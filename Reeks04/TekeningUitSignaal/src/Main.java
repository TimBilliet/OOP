import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        try {
            Tekening tekening = new Tekening("one_bits.txt");
            tekening.print(true);  // landscapemodus
            tekening.print(false); // portretmodus
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}