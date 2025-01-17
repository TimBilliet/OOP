package iteratoren;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author ...
 */
public class Woordenboek {

    private Set<String> alfabetisch;
    private List<String> inleesvolgorde;
    private Set<String> hashed;

    public Woordenboek(String bestandsnaam) throws FileNotFoundException {
        alfabetisch = new TreeSet<>();
        inleesvolgorde = new ArrayList<>();
        hashed = new HashSet<>();
        Scanner sc = new Scanner(new File(bestandsnaam));
        while (sc.hasNext()) {
            String woord = sc.next();
            alfabetisch.add(woord);
            inleesvolgorde.add(woord);
            hashed.add(woord);
        }
    }

    public void verwijderWoord(String woord) {
        verwijderWoord(woord, alfabetisch);
        verwijderWoord(woord, inleesvolgorde);
        verwijderWoord(woord, hashed);
    }

    // declareer en implementeer 'verwijderWoord(... , ...)'
    public void verwijderWoord(String woord, Collection<String> col) {
        col.remove(woord);
    }

    public void verwijderWoordOpIndex(int i) {
        verwijderWoordOpIndex(i, alfabetisch);
        verwijderWoordOpIndex(i, inleesvolgorde);
        verwijderWoordOpIndex(i, hashed);
    }

    // declareer en implementeer 'verwijderWoordOpIndex(... , ...)'
    public void verwijderWoordOpIndex(int i, Collection<String> col) {
        Iterator<String> it = col.iterator();
        if (i < col.size()) {
            for (int k = 0; k < i + 1; k++) {
                it.next();
            }
            it.remove();
        }
    }

    public void verwijderWoordenTussenIndices(int start, int stop) {
        verwijderWoordenTussenIndices(start, stop, alfabetisch);
        verwijderWoordenTussenIndices(start, stop, inleesvolgorde);
        verwijderWoordenTussenIndices(start, stop, hashed);
    }

    // declareer en implementeer 'verwijderWoordenTussenIndices(... , ... , ...)'

    public void verwijderWoordenTussenIndices(int start, int stop, Collection<String> col) {
        Iterator<String> it = col.iterator();
        if(start < col.size()){
            for(int i = 0; i < start+1 ; i++){
                it.next();
            }
            it.remove();
            for(int i = start + 1; i < Math.min(stop, col.size());i++){
                it.next();
                it.remove();
            }
        }
    }

    @Override
    public String toString() {
        return "alfabetisch:    " + alfabetisch + "\ninleesvolgorde: " + inleesvolgorde + "\nhashed:         " + hashed;

    }

}
