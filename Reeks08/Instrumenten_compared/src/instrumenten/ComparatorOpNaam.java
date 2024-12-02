package instrumenten;

import java.util.Comparator;

public class ComparatorOpNaam implements Comparator<Instrument> {


    @Override
    public int compare(Instrument instr1, Instrument instr2) {
        if(instr1.getNaam().compareTo(instr2.getNaam())!= 0)
            return instr1.getNaam().compareToIgnoreCase(instr2.getNaam());
        else
            return instr1.compareTo(instr2);
    }
}
