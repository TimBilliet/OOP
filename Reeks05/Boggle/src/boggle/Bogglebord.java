package boggle;

/**
 *
 * @author ...
 */
public class Bogglebord {

    public static final int DIM = 4;
    
    private Dobbelsteen[][] bord;

    public Bogglebord () {
        String[] letters = {"NTOKEZ", "CDEPAM", "LUNPET", "MOARSI", "DONSTE", "HIEFES", "RESHCA", "BQMJOD",
                "TIALNB", "GYNJEU", "ZAEDNV", "AOIEAW", "HSIREN", "GENVIT", "WEGLUR", "RIAFXK"};
        bord = new Dobbelsteen[DIM][DIM];
        for(int i = 0; i < DIM; i++) {
            for(int j = 0; j < DIM; j++) {
                bord[i][j] = new Dobbelsteen(letters[i*DIM+j]);
            }
        }
    }
    public void dobbel() {
        for(int i = 0; i < DIM; i++) {
            for(int j = 0; j < DIM; j++) {
                bord[i][j].dobbel();
            }
        }
    }

    public String toString() {
        String result = "";
        for(int i = 0; i < DIM; i++) {
            for(int j = 0; j < DIM; j++) {
                System.out.print(bord[i][j].getWaarde() + " ");
            }
            System.out.println();
        }
        return result;
    }
}
