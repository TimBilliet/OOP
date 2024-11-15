package personen;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tiwi
 */
public class Student extends Persoon {
    private String studies;
    private Set<String> diplomas;

    public Student(String naam, String voornaam) {
        super(naam, voornaam);
        diplomas = new HashSet<>();
    }

    public String getStudies() {
        return studies;
    }

    public void setStudie(String studies) {
        this.studies = studies;
    }

    public Set<String> getDiplomas() {
        return diplomas;
    }

    public void voegDiplomaToe(String diploma) {
        this.diplomas.add(diploma);
    }

    @Override
    public String toString() {
        return super.toString() + ", stud=" + studies + ", dipl=" + diplomas;
    }


    public void voegInformatieToe(String informatie) {
        super.voegInformatieToe(informatie);
        String[] info = informatie.split(":");
        if (info[0].equals("diploma")) {
            voegDiplomaToe(info[1]);
        } else if (info[0].equals("studie")) {
            setStudie(info[1]);
        }
    }
}
