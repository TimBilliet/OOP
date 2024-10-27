package totems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author ...
 */
public class TotemKiezer {

    private List<String> totems;
    private List<String> voortotems;

    private Random random = new Random();

    public TotemKiezer(String bestandTotems, String bestandVoortotems) throws FileNotFoundException {
        Scanner scannerTotems = new Scanner(new File(bestandTotems));
        Scanner scannerVoorTotems = new Scanner(new File(bestandVoortotems));
        totems = new ArrayList<>();
        voortotems = new ArrayList<>();
        while (scannerTotems.hasNext()) {
            totems.add(scannerTotems.next());
        }
        while (scannerVoorTotems.hasNext()) {
            voortotems.add(scannerVoorTotems.next());
        }
        System.out.println(voortotems);
    }

    public List<String> geefVerschillendeNamen(int aantal, boolean totem) {
        List<String> verschillendeNamen = new ArrayList<>();
        Set<String> totemsTemp = new HashSet<>();

        if (!totem) {
            while (totemsTemp.size() < aantal) {
                totemsTemp.add(voortotems.get(random.nextInt(totems.size())));
            }
        } else {
            while (totemsTemp.size() < aantal) {
                totemsTemp.add(totems.get(random.nextInt(totems.size())));
            }
        }
        verschillendeNamen.addAll(totemsTemp);
        return verschillendeNamen;
    }

}
