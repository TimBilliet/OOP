package woordenperlengte;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author tiwi
 */
public class SpreukZoeker {
    private Map<Integer, String> woorden = new TreeMap<>();

    public SpreukZoeker(String bestandsnaam) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(bestandsnaam));
        while(sc.hasNext()) {
            String woord = sc.next().toLowerCase();
            if(woorden.containsKey(woord.length())) {
                if(woorden.get(woord.length()).compareTo(woord) > 0) {
                    woorden.put(woord.length(), woord);
                }
            } else {
                woorden.put(woord.length(), woord);
            }
        }
    }
    public void printSpreuk(int[] getallen) {
        for(Integer getal : getallen) {
            System.out.print(woorden.get(getal) + " ");
        }
    }



}
