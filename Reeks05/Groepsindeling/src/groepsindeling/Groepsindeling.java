package groepsindeling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author tiwi
 */
public class Groepsindeling {
    private Map<Integer, Set<Persoon>> personenPerErvaring = new HashMap<>();
    public Groepsindeling(String bestandsnaam) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(bestandsnaam));
        while(sc.hasNext()) {
            String[] lijn = sc.next().split(";");
            int ervaring = Integer.parseInt(lijn[1]);
            String naam = lijn[0];
            Persoon toeTeVoegenPersoon = new Persoon(naam, ervaring);
            if(personenPerErvaring.containsKey(ervaring)) {
                personenPerErvaring.get(ervaring).add(toeTeVoegenPersoon);
            } else {
                personenPerErvaring.put(ervaring, new HashSet<>(){{add(toeTeVoegenPersoon);}});
            }
        }
    }

    public Map<Integer, Set<Persoon>> groepenMetGelijkeErvaring(int aantalLeden) {
    return null;
    }

    public Map<Integer, Set<Persoon>> groepenMetGespreideErvaring(int aantalLeden) {
return null;
    }
    
    
    
}
