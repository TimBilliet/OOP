package be.ugent.persoon;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author tiwi
 */
public class Student extends Persoon{
    private String studie;    
    private Set<String> diplomas;
    
    public Student(String naam, String voornaam){
        super(naam,voornaam);
        diplomas = new HashSet<>();
    }
    
    public String getStudie() {
        return studie;
    }

    public void setStudie(String studies) {
        this.studie = studies;
    }
    
    public Set<String> getDiplomas() {
        return diplomas;
    }

    public void voegDiplomaToe(String diploma) {
        this.diplomas.add(diploma);
    }

    @Override
    public String toString() {
        return super.toString() + ", stud=" + studie + ", dipl=" + diplomas;
    }
    
    
    public void voegInformatieToe(String informatie){
        String[] info = informatie.split(":");
        if(info[0].equals("diploma")){
            voegDiplomaToe(info[1]);
        }
        else if(info[0].equals("studie")){
            setStudie(info[1]);
        }
        else{ // dan betreft het informatie die de bovenklasse kan verwerken
            super.voegInformatieToe(informatie);
        }
    }

    
    
}
