package groepsindeling;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author tiwi
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Groepsindeling groepsindeling = new Groepsindeling("personen.csv");
        
        Map<Integer,Set<Persoon>> groepenGelijk = groepsindeling.groepenMetGelijkeErvaring(4);
        Map<Integer,Set<Persoon>> groepenGespreid = groepsindeling.groepenMetGespreideErvaring(4);
        
        System.out.println(groepenGelijk.toString());
        System.out.println(groepenGespreid.toString());                
    }
    
}
