package instrumenten;

import java.util.Comparator;

public class ComparatorOpSoort implements Comparator<Instrument> {
    @Override
    public int compare(Instrument instr1, Instrument instr2) {
       int classComp = instr1.getClass().getSimpleName().compareTo(instr2.getClass().getSimpleName());
       return classComp == 0 ? instr1.compareTo(instr2) : classComp;
    }
}
