import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Oef08 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("zoekmij.txt"));
        StringBuilder out = new StringBuilder();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] woorden = line.split(" ");
            String woord = woorden[Integer.parseInt(woorden[0])];
            out.append(woord).append(" ");
        }
        System.out.println(out);
    }
}
