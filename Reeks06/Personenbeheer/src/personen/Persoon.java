package personen;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author ...
 */
public class Persoon {


    private String naam;
    private String voornaam;
    private String haarkleur;
    private Set<String> hobbys;

    public Persoon(String naam, String voornaam) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.hobbys = new TreeSet<>();
    }

    public String getHaarkleur() {
        return haarkleur;
    }

    public void setHaarkleur(String haarkleur) {
        this.haarkleur = haarkleur;
    }

    public Set<String> getHobbys() {
        return hobbys;
    }

    public void voegHobbyToe(String hobby) {
        this.hobbys.add(hobby);
    }

    public void voegInformatieToe(String soort) {
        String delen[] = soort.split(":");
        if(delen[0].equals("hobby")) {
            voegHobbyToe(delen[1]);
        } else if(delen[0].equals("haarkleur")) {
            setHaarkleur(delen[1]);
        }
    //soortInfo:inhoudInfo
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persoon persoon = (Persoon) o;
        return Objects.equals(naam, persoon.naam) && Objects.equals(voornaam, persoon.voornaam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, voornaam);
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Persoon)) return false;
//        Persoon persoon = (Persoon) o;
//        return Objects.equals(naam, persoon.naam) && Objects.equals(voornaam, persoon.voornaam);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(naam, voornaam);
//    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + voornaam + " " + naam + ", haar=" + haarkleur + ", hobbys=" + hobbys;
    }


    
}
