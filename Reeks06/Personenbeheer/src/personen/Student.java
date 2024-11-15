package personen;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student extends Persoon{
    private String studie = "";
    private Set<String> diplomas;

    public Student(String naam, String voornaam) {
        super(naam, voornaam);
        diplomas = new HashSet<>();
    }

    public void voegInformatieToe(String soort) {

        String delen[] = soort.split(":");
        if(delen[0].equals("studie")) {
            studie = delen[1];
        } else if(delen[0].equals("diploma")) {
            diplomas.add(delen[1]);
        } else {
            super.voegInformatieToe(soort);
        }
    }

    public Set<String> getDiplomas() {
        return diplomas;
    }

    public String getStudie() {
        return studie;
    }

    @Override
    public String toString() {
        return super.toString() + ", stud=" + studie + ", dipl=" + diplomas;
    }
}
