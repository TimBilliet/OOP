package boggle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ...
 */
public class Bogglebord {

    public static final int DIM = 4;

    private Dobbelsteen[][] bord;
    private String[] letters = {"AAAAAA", "BBBBBB", "CCCCCC", "DDDDDD", "EEEEEE", "FFFFFF", "GGGGGG", "HHHHHH",
            "IIIIII", "JJJJJJ", "KKKKKK", "LLLLLL", "MMMMMM", "NNNNNN", "OOOOOO", "PPPPPP"};

    public Bogglebord() {
        //String[] letters = {"NTOKEZ", "CDEPAM", "LUNPET", "MOARSI", "DONSTE", "HIEFES", "RESHCA", "BQMJOD", "TIALNB", "GYNJEU", "ZAEDNV", "AOIEAW", "HSIREN", "GENVIT", "WEGLUR", "RIAFXK"};
        bord = new Dobbelsteen[DIM][DIM];
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                bord[i][j] = new Dobbelsteen(letters[i * DIM + j]);
            }
        }
    }

    public void dobbel() {
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                bord[i][j].dobbel();
            }
        }
    }

    public void schud() {
        Integer[] temparray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        List<Integer> lijstvanarray = Arrays.asList(temparray);
        Collections.shuffle(lijstvanarray);
        String[] newStringArray  = new String[16];
        for(int i = 0; i < newStringArray.length; i++){
            newStringArray[i] = letters[temparray[i]];
        }
        letters = newStringArray;
        dobbel();
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                System.out.print(bord[i][j].getWaarde() + " ");
            }
            System.out.println();
        }
        return result;
    }
}
