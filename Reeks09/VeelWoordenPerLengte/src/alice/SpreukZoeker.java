package alice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author tiwi
 */
public class SpreukZoeker {

    private int[] lengtes;
    
    // map van vorige oefening (project "WoordenPerLengte") was:
    // private Map<Integer, Set<String>> mapMetSet;
    
    // voor deze oefening bewaar je geen gewone strings in de sets, maar objecten van type 'Woord'
    private Map<Integer, Set<Woord>> mapMetSet; 

   
    
    // oplossing van vorige oefening (project "WoordenPerLengte"); aan te passen!
    public SpreukZoeker(String bestandsnaam, int[] lengtes) throws FileNotFoundException {
        this.lengtes = lengtes;
        mapMetSet = new HashMap<>();
        for (int i : lengtes) {
            mapMetSet.put(i, new TreeSet<>());
        }
        Scanner sc = new Scanner(new File(bestandsnaam));
        while (sc.hasNext()) {
            String woord = sc.next();
            int waarde = sc.nextInt();
            int lengte = woord.length();
            if (mapMetSet.containsKey(lengte)) {
                mapMetSet.get(lengte).add(new Woord(woord, waarde));
            }
        }
        sc.close();
    }
    
    // oplossing van vorige oefening (project "WoordenPerLengte"); aan te passen!
    public String geefZin(){        
        StringBuilder zin = new StringBuilder();

        Map<Integer, Iterator<Woord>> iteratorenMap= new HashMap<>();

        for(Map.Entry<Integer, Set<Woord>> entry : mapMetSet.entrySet()){
            iteratorenMap.put(entry.getKey(), entry.getValue().iterator());
        }
        for (int lengte : lengtes) {
            zin.append(iteratorenMap.get(lengte).next().getTekst()).append(" ");
        }

        return zin.toString();
    }

}
