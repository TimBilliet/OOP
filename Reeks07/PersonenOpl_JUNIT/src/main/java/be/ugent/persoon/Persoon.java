package be.ugent.persoon;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author tiwi
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

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + voornaam + " " + naam + ", haar=" + haarkleur + ", hobbys=" + hobbys;
    }

    public void voegInformatieToe(String informatie) {
        String[] info = informatie.split(":");
        if (info[0].equals("hobby")) {
            voegHobbyToe(info[1]);
        } else if (info[0].equals("haarkleur")) {
            setHaarkleur(info[1]);
        }
    }

    @Override
    public int hashCode() {        
        return (naam+" "+voornaam).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Persoon other = (Persoon) obj;
        if (! this.naam.equals(other.naam)) {
            return false;
        }
        if (! this.voornaam.equals(other.voornaam)) {
            return false;
        }
        return true;
    }

    public String getNaam(){
        return naam;        
    }
    
    public String getVoornaam(){
        return voornaam;
    }
    
}
