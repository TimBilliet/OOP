package boggledeel1;

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
        waarde = letters[0];
    }

    public void dobbel() {
        int random = (int) (Math.random() * letters.length);
        waarde = letters[random];
    }

    public char getWaarde() {

        return waarde;
    }
}
