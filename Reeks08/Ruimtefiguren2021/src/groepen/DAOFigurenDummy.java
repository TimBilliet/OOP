package groepen;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author tiwi
 */
public class DAOFigurenDummy {

    private final Ruimtefiguur[] keuzelijst;

    private final List<Ruimtefiguur> figuren;
    private final SortedSet<Balk> balken;
    private final Set<Cilinder> cilinders;

    public DAOFigurenDummy() {
        keuzelijst = new Ruimtefiguur[17];
        keuzelijst[0] = new Balk(2, 3, 4,"rood");
        keuzelijst[1] = new Balk(2, 3, 4,"geel");
        keuzelijst[2] = new Cilinder(3, 4,"rood");
        keuzelijst[3] = new Cilinder(30, 4,"blauw");
        keuzelijst[4] = new Balk(20, 30, 4,"blauw");
        keuzelijst[5] = new Cilinder(10, 8,"geel");
        keuzelijst[6] = new Balk(20, 3, 4,"rood");
        keuzelijst[7] = new Balk(20, 3, 4,"geel");
        keuzelijst[8] = new Cilinder(30, 5,"rood");
        keuzelijst[9] = new Cilinder(3, 5,"blauw");
        keuzelijst[10] = new Balk(20, 30, 40,"blauw");
        keuzelijst[11] = new Cilinder(8, 8,"geel");
        keuzelijst[12] = new Balk(20, 30, 40,"blauw"); // dubbel exemplaar!
        keuzelijst[13] = new Cilinder(8, 8,"geel"); // dubbel exemplaar!
        keuzelijst[14] = new Balk(20, 3, 400,"blauw"); // gelijke kleur als [10], maar toch verschillend!
        keuzelijst[15] = new Balk(20, 300, 4,"blauw"); 
        keuzelijst[16] = new Balk(200, 30, 4,"blauw"); 
        keuzelijst[16] = new Balk(4, 30, 200,"blauw"); // gelijk aan de vorige
        
        

        figuren = Arrays.asList(keuzelijst);

        balken = new TreeSet<>();
        for(Ruimtefiguur f : keuzelijst){
            if(f instanceof Balk){
                balken.add((Balk)f);
            }
        }

        cilinders = new HashSet<>();        
        for(Ruimtefiguur f : keuzelijst){
            if(f instanceof Cilinder){
                cilinders.add((Cilinder)f);
            }
        }
    }    

    public List<Ruimtefiguur> getFiguren() {
        return figuren;
    }

    public SortedSet<Balk> getBalken() {
        return balken;
    }

    public Set<Cilinder> getCilinders() {
        return new HashSet<>(cilinders);
    }

}
