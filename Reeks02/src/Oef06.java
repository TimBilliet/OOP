import java.util.Scanner;

public class Oef06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Geef een woord in zonder spaties en van minimum lengte 8: " );

        while (sc.next().length() < 8) {
            System.out.println("opnieuw graag" );
        }
        System.out.println("dank!");

    }
}
