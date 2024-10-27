package woordenperlengte;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author tiwi
 */
public class SpreukZoeker {
    private Map<Integer, TreeSet<String>> woordenPerLengte = new HashMap<>();
    private Set<String> woorden = new TreeSet<>();
    public SpreukZoeker(String bestandsnaam) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(bestandsnaam));
        while (sc.hasNext()) {
            String woord = sc.next().toLowerCase();
            woorden.add(woord);
            if (woordenPerLengte.containsKey(woord.length())) {
                woordenPerLengte.get(woord.length()).add(woord);
            } else {
                TreeSet<String> eerstewoord = new TreeSet<>();
                eerstewoord.add(woord);
                woordenPerLengte.put(woord.length(), eerstewoord);
            }
        }
    }

    public void printSpreuk(int[] getallen) {
        for(Integer getal : getallen) {
            System.out.println(woordenPerLengte.get(getal).first());
        }
    }

}
