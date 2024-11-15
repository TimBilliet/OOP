package be.ugent.persoon;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 *
 * @author tiwi
 */
public class Personenlijst {

    // hier werd niet voor een set gekozen, omdat de reeds bestaande persoon
    // makkelijk opgevraagd moet kunnen worden (dat kan met een iterator voor een set - komt later aan bod)
    private List<Persoon> personen;

    public Personenlijst(String bestandsnaam) throws FileNotFoundException{
        personen = new ArrayList<>();
        File file = new File(bestandsnaam);
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String lijn = sc.nextLine();
            Scanner scLijn = new Scanner(lijn);
            scLijn.useDelimiter("/");
            String soort = scLijn.next();

            Persoon persoon = null;
            try {
                persoon = (Persoon) Class.forName(this.getClass().getPackageName() +"."+ soort).getConstructor(String.class, String.class).newInstance(scLijn.next(), scLijn.next());
            } catch (Exception e) {
                System.out.println("**" + e.getClass()+ " "+e.getMessage());
            }
            int locatie = personen.indexOf(persoon);
            if (locatie != -1) {
                Persoon reedsBestaand = personen.get(locatie);
                persoon = personen.get(locatie);
            } else {
                personen.add(persoon);
            }
            // nu heb je de reeds bestaande persoon opgevraagd, ipv de nieuwe (als dat nodig was)
            // als dat niet nodig was, heb je de nieuwe persoon toegevoegd 

            while (scLijn.hasNext()) {
                persoon.voegInformatieToe(scLijn.next());
            }
            scLijn.close();
        }
        sc.close();
    }

    public List<Persoon> getPersonen() {
        return personen;
    }

    public Persoon nietStudentMetNaam(String naam, String voornaam) {
        Persoon pers = new Persoon(naam, voornaam);
        int locatie = personen.indexOf(pers);
        if (locatie != -1) {
            return personen.get(locatie);
        } else {
            return null;
        }
    }

    public Student studentMetNaam(String naam, String voornaam) {
        Student stud = new Student(naam, voornaam);
        int locatie = personen.indexOf(stud);
        if (locatie != -1) {
            return (Student) personen.get(locatie);
        } else {
            return null;
        }
    }

    public Set<Persoon> personenVanKlasseMetHaarkleur(String klassenaam, String haarkleur) {
        Set<Persoon> set = new HashSet<>();
        for (Persoon p : personen) {
            if (p.getClass().getSimpleName().equals(klassenaam)) {
                if (p.getHaarkleur() != null && p.getHaarkleur().equals(haarkleur)) {
                    set.add(p);
                }
            }
        }
        return set;
    }

    public Set<Student> studentenMetStudie(String studie) {
        Set<Student> verz = new HashSet<>();
        for (Persoon p : personen) {
            if (p instanceof Student) {
                Student s = (Student) p; // hier wel casten
                if (studie.equals(s.getStudie())) {
                    verz.add(s);
                }
            }
        }
        return verz;
    }

    // één persoon is genoeg
    public Persoon persoonMetMeesteHobbys() {
        if (personen.size() == 0) {
            return null;
        }
        Persoon actiefste = personen.get(0);
        for (Persoon p : personen) {
            if (actiefste.getHobbys().size() <= p.getHobbys().size()) {
                actiefste = p;
            }
        }
        return actiefste;
    }

    // één student is genoeg
    public Student studentMetMeesteDiplomas() {
        if (personen.size() == 0) {
            return null;
        }
        Student actiefste = null;  // de eerste in de lijst is niet per se een student!
        for (Persoon p : personen) {
            if (p instanceof Student) {
                Student s = (Student) p;
                if (actiefste == null) {
                    actiefste = s;
                } else {
                    if (actiefste.getDiplomas().size() <= s.getDiplomas().size()) {
                        actiefste = s;
                    }
                }
            }
        }
        return actiefste;
    }

}
