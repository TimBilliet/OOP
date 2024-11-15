package personen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author ...
 */
public class Personenlijst {

    // hier werd niet voor een set gekozen, omdat de reeds bestaande persoon
    // makkelijk opgevraagd moet kunnen worden (dat kan met een iterator voor een set - komt later aan bod)
    private List<Persoon> personen;

    public Personenlijst(String bestandsnaam) throws FileNotFoundException {
        personen = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(bestandsnaam))) {
            while (sc.hasNext()) {
                String lijn = sc.nextLine();
                Scanner scLijn = new Scanner(lijn);
                scLijn.useDelimiter("/");
                String soort = scLijn.next();  // hebben we niet nodig op dit moment
                //Persoon persoon = new Persoon(scLijn.next(), scLijn.next());
                Persoon persoon = null;

                try {
                    persoon = (Persoon) Class.forName("personen." + soort).getConstructor(String.class, String.class).newInstance(scLijn.next(), scLijn.next());
                    if (personen.contains(persoon)) {
                        Persoon teBewerkenPersoon = personen.get(personen.indexOf(persoon));
                        while (scLijn.hasNext()) {
                            teBewerkenPersoon.voegInformatieToe(scLijn.next());
                        }
                    } else {
                        while (scLijn.hasNext()) {
                            persoon.voegInformatieToe(scLijn.next());
                        }
                        personen.add(persoon);
                    }

                } catch (Exception ex) {
                    System.out.println("Maken van object gefaald: " + ex);
                }

                scLijn.close();
            }
        }
    }

    public List<Persoon> getPersonen() {
        return personen;
    }

    public Persoon nietStudentMetNaam(String naam, String voornaam) {
        Persoon teZoekenPersoon = new Persoon(naam, voornaam);
        if (personen.contains(teZoekenPersoon)) {
            return personen.get(personen.indexOf(teZoekenPersoon));
        } else {
            return null;
        }
    }

    public Student studentMetNaam(String naam, String voornaam) {
        Persoon teZoekenPersoon = new Student(naam, voornaam);
        if (personen.contains(teZoekenPersoon)) {
            return (Student) personen.get(personen.indexOf(teZoekenPersoon));
        } else {
            return null;
        }
    }

    public Set<Persoon> personenVanKlasseMetHaarkleur(String klassenaam, String kleur) {
        Set<Persoon> personenMetHaarKleur = new HashSet<>();
        for (Persoon persoon : personen) {
            if (persoon.getClass().getSimpleName().equals(klassenaam) && persoon.getHaarkleur().equals(kleur)) {
                personenMetHaarKleur.add(persoon);
            }
        }
        return personenMetHaarKleur;
    }

    public Set<Student> studentenMetStudie(String studie) {
        Set<Student> studenten = new HashSet<>();
        for (Persoon persoon : personen) {
            if (persoon instanceof Student student && student.getStudie().equals(studie)) {//cleaner dan persoon instanceof Student && ((Student)persoon).getStudie().equals(studie)
                studenten.add(student);
            }
        }
        return studenten;
    }

    public Persoon persoonMetMeesteHobbys() {
        Persoon persoonMetMeesteHobbys = null;
        for (Persoon persoon : personen) {
            if (persoonMetMeesteHobbys == null || persoon.getHobbys().size() > persoonMetMeesteHobbys.getHobbys().size()) {
                persoonMetMeesteHobbys = persoon;
            }
        }
        return persoonMetMeesteHobbys;

    }

    public Student studentMetMeesteDiplomas() {
        Student studentMetMeesteDiplomas = null;
        for (Persoon persoon : personen) {
            if (persoon instanceof Student student && (studentMetMeesteDiplomas == null || student.getDiplomas().size() > studentMetMeesteDiplomas.getDiplomas().size())) {
                studentMetMeesteDiplomas = student;
            }
        }
        return studentMetMeesteDiplomas;
    }
}
