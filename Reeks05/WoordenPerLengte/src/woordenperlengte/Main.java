package woordenperlengte;

import java.io.FileNotFoundException;

/**
 *
 * @author tiwi
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        int[] getallen = {9,5,10,3,2,11};
        SpreukZoeker zoeker = new SpreukZoeker("zoekSpreuk.txt");
        zoeker.printSpreuk(getallen);
    }
    
}
