package boggledeel1;

import java.util.Random;

/**
 *
 * @author ...
 */
public class Dobbelsteen {
        
    private char[] letters;
    private char waarde;


    public Dobbelsteen(String woord) {
        letters = new char[woord.length()];
        for(int i = 0; i < woord.length(); i++) {
            letters[i] = woord.charAt(i);
        }
    }

    public void dobbel() {
        int random = (int) (Math.random() * letters.length);
        waarde = letters[random];
        System.out.println("waarde: " + waarde);
    }

    public char getWaarde() {
        return waarde;
    }
}
