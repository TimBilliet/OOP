import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Kerstwensdecode kerstwensdecode = new Kerstwensdecode("input.txt", "decode.txt");
            Scanner sc = new Scanner(System.in);
            for(String stuk : kerstwensdecode){
                if (stuk.contains("*")) {
                    System.out.print(stuk.replace("*", ""));
                    sc.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}