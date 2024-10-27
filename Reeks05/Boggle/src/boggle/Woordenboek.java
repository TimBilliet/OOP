package boggle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Woordenboek {
    private Set<String> woorden = new HashSet<>();
    private Map<Integer, Integer> scores = new HashMap<>();


    public Woordenboek(String bestandsnaam) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(bestandsnaam));
        while(sc.hasNext()) {
            woorden.add(sc.next().toLowerCase());
        }
        scores.put(1, 0);
        scores.put(2, 0);
        scores.put(3, 1);
        scores.put(4, 1);
        scores.put(5, 2);
        scores.put(6, 3);
        scores.put(7, 5);
    }

    public int puntVanWoord(String woord) {
        if(!woorden.contains(woord)) {

            return 0;
        } else {
            if(woord.length() < 8) {
                return scores.get(woord.length());
            } else {
                return 11;
            }
        }
    }
}
