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


    // lees het bestand in:
    // op de eerste lijn staat de signaallengte
    // op de tweede lijn staat het aantal 1-bits dat nog volgt
    // daarna volgen de posities (volgnummers) van de 1-bits

    public Tekening(String bestandsnaam) throws FileNotFoundException {
        // vul aan



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
        while(signaalLengte % deler != 0){
            deler ++;
        }
        kleinsteDim = deler;
        grootsteDim = signaalLengte / deler;
    }

    // de volgnummers bepalen welke elementen uit de matrix zwart worden
    // gekleurd (op true worden gezet)
    private boolean[][] matrix(int m, int n) {
        boolean[][] matrix = {{}}; // vervang deze regel
        // vul aan

        return matrix;
    }

    // print de juiste tekening
    public void print(boolean landscape) {
        // vul aan
    }

}
