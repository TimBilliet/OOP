package boggle;

import java.io.FileNotFoundException;

/**
 *
 * @author tiwi
 */
public class Test_Woordenboek extends Testklasse{

    public static void main(String[] args) throws FileNotFoundException {
        
        Woordenboek woordenboek = new Woordenboek("woordenlijst.txt");
        
        String[] woorden = {"a","in","aap","noot","appel","huizen","omringd","goesting","appelmoes","didgeridoo","everzwijnen","qdfqdf"};
        int[] punten={0,0,1,1,2,3,5,11,11,11,11,0};
        
        for(int i=0; i<woorden.length; i++){
            controleerEquals(woorden[i],punten[i],woordenboek.puntVanWoord(woorden[i]));
        }        
    }
}
