package personen;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tiwi
 */
public class Personenlijst implements Iterable<Persoon> {

    private List<Persoon> personen;

    public Personenlijst(String bestandsnaam) throws FileNotFoundException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        personen = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(bestandsnaam))) {
            while (sc.hasNext()) {
                String lijn = sc.nextLine();
                Scanner scLijn = new Scanner(lijn);
                scLijn.useDelimiter("/");
                String soort = scLijn.next();
                Persoon persoon = (Persoon) Class.forName("personen." + soort).getConstructor(String.class, String.class).newInstance(scLijn.next(), scLijn.next());
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
        }
    }
    public Personenlijst(Personenlijst lijst, boolean enkelStudenten) {
        personen = new ArrayList<>();
        for(Persoon persoon : lijst){
            if(enkelStudenten == persoon instanceof Student) {
                personen.add(persoon.clone());
            }
        }
    }

    public int getAantalPersonen() {
        return personen.size();
    }

    public Persoon getPersoonNr(int i) {
        return personen.get(i);
    }


    // deel 1
    public Set<String> alleMogelijkeHobbys() {
        Set<String> ret = new TreeSet<>();
        personen.forEach(x -> ret.addAll(x.getHobbys()));
        return ret;
    }

    // deel 2
    public Set<String> alleMogelijkeHaarkleuren() {
        Set<String> ret = new TreeSet<>();
        personen.forEach(x -> {
            if (x.getHaarkleur() != null) {
                ret.add(x.getHaarkleur());
            }
        });
        return ret;
    }

    // deel 3
    public Set<String> alleMogelijkeStudies() {
        Set<String> ret = new HashSet<>();

        personen.forEach(x -> {
            if (x instanceof Student student && student.getStudie() != null) {
                ret.add(student.getStudie());
            }
        });
        return ret;
    }

    // deel 4
    public Set<String> alleMogelijkeDiplomas() {
        Set<String> ret = new HashSet<>();
        personen.forEach(x -> {
            if (x instanceof Student student) {
                ret.addAll(student.getDiplomas());
            }
        });
        return ret;
    }

    // deel 5
    public Set<Persoon> personenMetHaarkleur(String haarkleur) {
        return personen.stream().filter(x -> x.getHaarkleur() != null && x.getHaarkleur().equals(haarkleur)).collect(Collectors.toSet());
    }

    // deel 6
    public Set<Persoon> personenMetOngeveerHaarkleur(String haarkleur) {
        return personen.stream().filter(x -> x.getHaarkleur() != null && x.getHaarkleur().contains(haarkleur)).collect(Collectors.toSet());
    }

    // deel 7
    public Set<Student> studentenMetStudie(String studie) {
        Set<Student> ret = new HashSet<>();
        personen.forEach(x-> {
            if(x instanceof Student student && student.getStudie() != null && student.getStudie().equals(studie)) {
                ret.add(student);
            }
        });
        return ret;
    }

    // deel 8
    public String voornamenVanPersonenMetMeerDanXHobbys(int aantalX) {
        StringBuilder ret = new StringBuilder();
        personen.forEach(x-> {
            if(x.getHobbys().size() > aantalX) {
                ret.append(x.getVoornaam()).append(" ");
            }
        });
        return ret.toString();
    }

    @Override
    public Iterator<Persoon> iterator() {
        return personen.iterator();
    }
}
