package alice;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ...
 */
public class Main {

    public static void main(String[] args) {
        
        try {
            
//             int[] lengtes = {4,4,5,4,3,5};  // voor het bestand "zoekHetGedichtKORT.txt"
            
            int[] lengtes = {2,2,4,2,2,5,4,2,7,3,4,4,3,6,6,2,2,3,8,3,6,4,5,4,3,4,8,2,2,4,4,3,4,9,4,7,2,3,
                5,5,2,2,3,10,7,3,8,3,6,5,2,4,3,2,3,4,5,8,3,2,3,9,7,3,2,4,5,3,9,6,3,6,3,7,7,3,4,3,2,4,5,8,
                3,8,4,3,13,2,2,4,2,2,5,4,2,7,2,2,3,4,3,2,6,1,5,6,9,10,10};
            
            SpreukZoeker zoeker = new SpreukZoeker("zoekHetGedicht.txt",lengtes);
            System.out.println(zoeker.geefZin());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
