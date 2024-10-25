package totems;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiwi
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        List<Integer> list = new ArrayList<>();
        int[] getallen = {5, 1, 1, 1, 1, 1, 1};

        for (int i = 0; i < getallen.length; i++) {
            int x = getallen[i];
            if (x < list.size()) {
                //list.add(x, 1);
            }
            //list.add(x,list.get(x) + 1);
        }

        System.out.println(list.toString());
        
        oefeningTotems("totemsKort.txt", "voortotemsKort.txt", 6);  // 6 is echt wel het maximum;
        // het programma loopt vast als je voor 7 gaat! 
        oefeningTotems("totems.txt", "voortotems.txt", 12);

    }

    public static void oefeningTotems(String bestandTotems, String bestandVoortotems, int aantal) throws FileNotFoundException {
        TotemKiezer totemKiezer = new TotemKiezer(bestandTotems, bestandVoortotems);
        List<String> totems = totemKiezer.geefVerschillendeNamen(aantal, true);
        List<String> voortotems = totemKiezer.geefVerschillendeNamen(aantal, false);
        for (int i = 0; i < totems.size(); i++) {
            System.out.println(voortotems.get(i) + " " + totems.get(i));
        }
        System.out.println("\n\n");
    }

}
