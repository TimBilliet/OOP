package personen;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author tiwi
 */
public class Personenlijst {

    // hier werd niet voor een set gekozen, omdat de reeds bestaande persoon
    // makkelijk opgevraagd moet kunnen worden (dat kan met een iterator voor een set - komt later aan bod)
    private List<Persoon> personen;
    private String foutmelding;
    // Merk op: 
    // deze methode vangt veel fouten op, maar een onbestaand bestand leidt toch
    // nog tot het doorgooien van een fout.
    // Dit vermijdt dat er een object wordt aangemaakt terwijl het eigenlijk niet
    // netjes kon ingevuld worden.
    public Personenlijst(String bestandsnaam) throws FileNotFoundException {
        personen = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int regelnr = 0;
        try (Scanner sc = new Scanner(new File(bestandsnaam))) {
            while (sc.hasNext()) {
                String lijn = sc.nextLine();
                Scanner scLijn = new Scanner(lijn);
                scLijn.useDelimiter("/");
                String soort = scLijn.next();
                regelnr++;
                try {
                    Persoon persoon = (Persoon) Class.forName("personen."
                            + soort).getConstructor(String.class, String.class).newInstance(scLijn.next(), scLijn.next());
                    if (personen.contains(persoon)) {
                        int locatie = personen.indexOf(persoon);
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
                } catch (ClassNotFoundException ex) {    // hoort bij .forName("personen." + soort)
                    builder.append("\nRegel ").append(regelnr).append(" werd niet opgenomen in het verslag: ").append(soort);
                }

                // Merk op:
                // NetBeans helpt je bij het opvangen van alle mogelijke fouten.
                // Hieronder staan ze allemaal opgesomd (zoals door NetBeans gegenereerd),
                // met een vermelding van de methode die deze fout opwerpt.
                // Wil je dit zelf opzoeken, dan raadpleeg je de klasse 'Class' in de online API van Java.
                // Zoek de methodes forName(...), getConstructor(...) en newInstance(...),
                // en klik door tot je de volledige uitleg vindt. Daar staat meer informatie
                // over de gegooide excepties.
            /* catch (NoSuchMethodException ex) {     // hoort bij .getConstructor(String.class, String.class)
                Logger.getLogger(Personenlijst.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {         // hoort bij .getConstructor(String.class, String.class)
                Logger.getLogger(Personenlijst.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {    // hoort bij .newInstance(scLijn.next(), scLijn.next())
                Logger.getLogger(Personenlijst.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {    // hoort bij .newInstance(scLijn.next(), scLijn.next())
                Logger.getLogger(Personenlijst.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {  // hoort bij .newInstance(scLijn.next(), scLijn.next())
                Logger.getLogger(Personenlijst.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) { // hoort bij .newInstance(scLijn.next(), scLijn.next())
                Logger.getLogger(Personenlijst.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
                // Op een test aan computer mag je bovenstaande laten staan.
                // Op een schriftelijk examen mag je alle excepties waar je geen speciale actie voor onderneemt
                // samenbundelen in één catch-clause:
                catch (Exception ex) {  }

									  
														 
            }
            foutmelding = builder.toString();
        }
				   
    }

    public String getFoutmelding(){
        return foutmelding;
    }

    public Persoon persoonMetVolgnummer(int volgnr) {
        for(Persoon persoon: personen) {
            if(persoon.getVolgnummer() == volgnr) {
                return persoon;
            }
        }
        return null;
    }
    public List<Persoon> getPersonen() {
        return personen;
    }

    public Persoon persoonMetNaam(String naam, String voornaam) {
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
        Set<Student> set = new HashSet<>();
        for (Persoon p : personen) {
            if (p instanceof Student) {
                Student s = (Student) p; // hier wel casten
                if (studie.equals(s.getStudies())) {
                    set.add(s);
                }
            }
        }
        return set;
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
