import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tekening {

    private int signaalLengte;
    private int[] volgnrs;
    private int kleinsteDim;
    private int grootsteDim;

    private boolean[][] isZwart_portret;
    private boolean[][] isZwart_landscape;

    private int aantalBits;
    // lees het bestand in:
    // op de eerste lijn staat de signaallengte
    // op de tweede lijn staat het aantal 1-bits dat nog volgt
    // daarna volgen de posities (volgnummers) van de 1-bits

    public Tekening(String bestandsnaam) throws FileNotFoundException {
        // vul aan
        Scanner scanner = new Scanner(new File(bestandsnaam));
        signaalLengte = scanner.nextInt();
        aantalBits = scanner.nextInt();
        System.out.println(signaalLengte + " en " + aantalBits);
        volgnrs = new int[aantalBits];
        for (int i = 0; i < aantalBits; i++) {
            volgnrs[i] = scanner.nextInt();
        }

        for (Integer i : volgnrs) {
            // System.out.println(i);
        }

        // LAAT DIT ONDERAAN STAAN:
        // deze hulpmethode zal de twee dimensies bepalen (kleinsteDim en grootsteDim)
        bepaalDimensie();

        // de beide boolean-matrices worden ingevuld (true = 1-bit = zwart)
        isZwart_portret = matrix(grootsteDim, kleinsteDim);
        isZwart_landscape = matrix(kleinsteDim, grootsteDim);
    }

    // gegeven
    private void bepaalDimensie() {
        int deler = 2;
        while (signaalLengte % deler != 0) {
            deler++;
        }
        kleinsteDim = deler;
        grootsteDim = signaalLengte / deler;
        System.out.println("kleinsteDim = " + kleinsteDim + " en grootsteDim = " + grootsteDim);
    }

    // de volgnummers bepalen welke elementen uit de matrix zwart worden
    // gekleurd (op true worden gezet)
    private boolean[][] matrix(int m, int n) {
        boolean[][] matrix = new boolean[n][m]; // vervang deze regel
        Omzetter omzetter = new Omzetter(n, m);
        for (int i = 0; i < aantalBits; i++) {
            int rij = omzetter.rij(volgnrs[i]);
            int kolom = omzetter.kolom(volgnrs[i]);
            matrix[rij][kolom] = true;
        }
        //for(int i = 0; i < m; i++) {//rij
        //   for(int j = 0; j < n; j++) {//kolom


        // }
        //  }
        return matrix;
    }

    // print de juiste tekening
    public void print(boolean landscape) {
        // vul aan
        if (landscape) {
            for (int i = 0; i < kleinsteDim; i++) {
                for (int j = 0; j < grootsteDim; j++) {
                    System.out.print(isZwart_landscape[i][j] ? "XX" : "  ");
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < kleinsteDim; i++) {
                for (int j = 0; j < grootsteDim; j++) {
                    System.out.print(isZwart_portret[j][i] ? "XX" : "  ");
                }
                System.out.println();
            }
        }
    }

}
