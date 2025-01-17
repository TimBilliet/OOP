package personen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TestVoorPersonenlijst {
    private Personenlijst lijstPersonen;
    private Personenlijst lijstNietStudenten;
    private Personenlijst lijstStudenten;

    @BeforeEach
    void setUp() {
        try {
            lijstPersonen = new Personenlijst("personen.csv");
            lijstNietStudenten = new Personenlijst("nietStudenten.csv");
            lijstStudenten = new Personenlijst("studenten.csv");
        } catch (Exception e) {
            System.out.println("***************");
            e.printStackTrace();
        }
    }


    @Test
    public void deel1() {
        Set<String> hobbysStudenten = lijstStudenten.alleMogelijkeHobbys();
        Set<String> hobbysNietStudenten = lijstNietStudenten.alleMogelijkeHobbys();
        assertEquals(22, hobbysStudenten.size(), "verschillende hobbys van studenten geteld");
        assertEquals(24, hobbysNietStudenten.size(), "verschillende hobbys van niet-studenten geteld");
    }

    @Test
    public void deel2() {
        Set<String> haarkleurenStudenten = lijstStudenten.alleMogelijkeHaarkleuren();
        Set<String> haarkleurenNietStudenten = lijstNietStudenten.alleMogelijkeHaarkleuren();
        assertEquals(15, haarkleurenStudenten.size(), "verschillende haarkleuren van studenten geteld");
        assertEquals(16, haarkleurenNietStudenten.size(), "verschillende haarkleuren van niet-studenten geteld");
        assertTrue(haarkleurenNietStudenten.contains("spierwit"), "haarkleur spierwit niet aanwezig bij studenten");
        assertTrue(!haarkleurenStudenten.contains("spierwit"), "haarkleur spierwit wel aanwezig bij niet-studenten");
    }

    @Test
    public void deel3() {
        Set<String> studiesStudenten = lijstStudenten.alleMogelijkeStudies();
        Set<String> studiesNietStudenten = lijstNietStudenten.alleMogelijkeStudies();
        assertEquals(18, studiesStudenten.size(), "verschillende studies van studenten geteld");
        assertEquals(0, studiesNietStudenten.size(), "verschillende studies van niet-studenten geteld");
        assertTrue(studiesStudenten.contains("biomedische"), "studies 'biomedische' aanwezig bij studenten");
    }

    @Test
    public void deel4() {
        Set<String> diplomasStudenten = lijstStudenten.alleMogelijkeDiplomas();
        Set<String> diplomasNietStudenten = lijstNietStudenten.alleMogelijkeDiplomas();
        assertEquals(11, diplomasStudenten.size(), "verschillende diploma's van studenten geteld");
        assertEquals(0, diplomasNietStudenten.size(), "verschillende diploma's van niet-studenten geteld");
        assertTrue(diplomasStudenten.contains("taal- en letterkunde"), "diploma 'taal- en letterkunde' aanwezig bij studenten");
    }

    @Test
    public void deel5() {
        Set<Persoon> studentenMetSpierwitHaar = lijstStudenten.personenMetHaarkleur("spierwit");
        Set<Persoon> nietStudentenMetSpierwitHaar = lijstNietStudenten.personenMetHaarkleur("spierwit");
        assertEquals(0, studentenMetSpierwitHaar.size(), "er zijn geen studenten met spierwit haar");
        assertEquals(1, nietStudentenMetSpierwitHaar.size(), "er is 1 niet-student met spierwit haar");
        Persoon p = new Persoon("Ickx", "Benjamin");
        assertTrue(nietStudentenMetSpierwitHaar.contains(p), "(enige) niet-student met spierwit haar is Benjamin Ickx");
    }

    @Test
    public void deel6() {
        Set<Persoon> studentenMetBruinHaar = lijstStudenten.personenMetOngeveerHaarkleur("bruin");
        Set<Persoon> nietStudentenMetBruinHaar = lijstNietStudenten.personenMetOngeveerHaarkleur("bruin");
        assertEquals(51, studentenMetBruinHaar.size(), "aantal studenten met bruin haar");
        assertEquals(58, nietStudentenMetBruinHaar.size(), "aantal niet-studenten met bruin haar");
        Persoon p = new Persoon("Antson", "Lennard");
        assertTrue(nietStudentenMetBruinHaar.contains(p), "niet-student Lennard Antson heeft bruin haar");
        Persoon s = new Student("Debaere", "Ahmad");
        assertTrue(studentenMetBruinHaar.contains(s), "student Ahmad Debaere heeft bruin haar");
    }

    @Test
    public void deel7() {
        Set<Student> studentenIndustrieel = lijstStudenten.studentenMetStudie("industrieel ingenieur");
        Set<Student> nietStudentenIndustrieel = lijstNietStudenten.studentenMetStudie("industrieel ingenieur");
        assertEquals(16, studentenIndustrieel.size(), "aantal studenten met studie 'industrieel ingenieur'");
        assertEquals(0, nietStudentenIndustrieel.size(), "aantal niet-studenten met studie 'industrieel ingenieur'");
        Student s = new Student("Hakizimali", "Iris");
        assertTrue(studentenIndustrieel.contains(s), "Iris Hakizimali studeert 'industrieel ingenieur'");
    }

    @Test
    public void deel8() {
        String voornamenActieveStudenten = lijstStudenten.voornamenVanPersonenMetMeerDanXHobbys(7);
        String voornamenActieveNietStudenten = lijstNietStudenten.voornamenVanPersonenMetMeerDanXHobbys(6);
        assertTrue(voornamenActieveStudenten.contains("Seppe"), "namen van actieve studenten");
        assertTrue(voornamenActieveStudenten.contains("Arthur"), "namen van actieve studenten");
        assertTrue(voornamenActieveStudenten.contains("Nils"), "namen van actieve studenten");
        assertEquals(17, voornamenActieveStudenten.trim().length(), "er zijn drie actieve studenten ( > 7 hobbys) [Seppe Arthur Nils]");
        assertTrue(voornamenActieveNietStudenten.contains("Seppe"), "namen van actieve studenten");
        assertTrue(voornamenActieveNietStudenten.contains("Hamlet"), "namen van actieve studenten");
        assertTrue(voornamenActieveNietStudenten.contains("Klara"), "namen van actieve studenten");
        assertEquals(29, voornamenActieveNietStudenten.trim().length(), "er zijn vijf actieve niet-studenten ( > 6 hobbys) [Klara Remi Klara Seppe Hamlet]");
    }


    @Test
    public void deel9() {
        try {
            for (Persoon p : lijstPersonen) {
            }
            for (Persoon p : lijstStudenten) {
            }
        } catch (Exception ex) {
            assertTrue(false, "Een object van de klasse Personenlijst zou overlopen moeten kunnen worden...");
        }
    }


    @Test
    public void deel10() {

        Personenlijst deepCopyLijstPersonen = null;
        try {
            deepCopyLijstPersonen = new Personenlijst("personen.csv");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        Personenlijst deepCopyLijstNietStudenten = new Personenlijst(lijstPersonen, false);
        Personenlijst deepCopyLijstStudenten = new Personenlijst(lijstPersonen, true);

        assertEquals(798, deepCopyLijstPersonen.getAantalPersonen(), "totaal aantal lijstPersonen");
        assertEquals(398, deepCopyLijstNietStudenten.getAantalPersonen(), "alle niet-lijstStudenten gefilterd");
        assertEquals(400, deepCopyLijstStudenten.getAantalPersonen(), "alle lijstStudenten gefilterd");

        Persoon persoonA = deepCopyLijstPersonen.getPersoonNr(0);
        Persoon persoonB = deepCopyLijstNietStudenten.getPersoonNr(0); // uit bestand: eerste regel bevat een niet-student
        assertTrue(persoonA.equals(persoonB), "1e object uit lijstPersonen stelt zelfde persoon voor als 1e object uit lijstNietStudenten"); // beide lijstPersonen worden (adhv 'equals') als gelijk beschouwd
        assertTrue(persoonA != persoonB, "1e object uit lijstPersonen moet ander object zijn dan 1e object uit lijstNietStudenten");      // het moet echter om verschillende objecten gaan!
        assertTrue(persoonA.getHobbys() != persoonB.getHobbys(), "hobby's van beide personen zijn onafhankelijk van elkaar (zie opgave)");

        Student studentA = (Student) deepCopyLijstPersonen.getPersoonNr(3);
        Student studentB = (Student) deepCopyLijstStudenten.getPersoonNr(0);// uit bestand: vierde regel bevat de eerste student
        assertTrue(studentA.equals(studentB), "4e object uit lijstPersonen stelt zelfde student voor als 1e object uit lijstStudenten");
        assertTrue(studentA != studentB, "4e object uit lijstPersonen moet ander object zijn dan 1e object uit lijstStudenten");
        assertTrue(studentA.getDiplomas() != studentB.getDiplomas(), "diploma's van beide studenten zijn onafhankelijk van elkaar (zie opgave)");
    }

}
