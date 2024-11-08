package personen;

import java.util.Set;

public class Student extends Persoon{
    private String studie;
    private Set<String> diplomas;
    public Student(String naam, String voornaam) {
        super(naam, voornaam);
    }

    public void voegInformatieToe(String soort) {

    }
    @Override
    public String toString() {
        return super.toString();
    }
}
