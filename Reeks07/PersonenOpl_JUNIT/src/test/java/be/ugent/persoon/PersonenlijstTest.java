package be.ugent.persoon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class PersonenlijstTest {

    private Personenlijst personenlijst;

    @BeforeEach
    public void setup() {
        try {
            personenlijst = new Personenlijst("personen.csv");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void constructorTest() {
        assertEquals(798, personenlijst.getPersonen().size());
    }

    @Test
    public void zoekOpNamenTest() {
        String[] voornamen = {"Serdar", "Benjamin", "Martha"};
        String[] namen = {"Mortier", "Hakizimali", "Debyser"};

        // er IS geen persoon Serdar Mortier, alleen een student -> dus null verwacht
        Persoon[] verwachtNietStudent = {null, new Persoon("Hakizimali", "Benjamin"), new Persoon("Debyser", "Martha")};
        for (int i = 0; i < namen.length; i++) {
            assertEquals(verwachtNietStudent[i], personenlijst.nietStudentMetNaam(namen[i], voornamen[i]));
        }

        // er IS geen student Benjamin Hakizimali, alleen een niet-student (persoon) -> dus null verwacht
        Student[] verwachtStudent = {new Student("Mortier", "Serdar"), null, new Student("Debyser", "Martha")};
        for (int i = 0; i < namen.length; i++) {
            assertEquals(verwachtStudent[i], personenlijst.studentMetNaam(namen[i], voornamen[i]));
        }
    }

    @Test
    public void zoekenOpHaarkleurTest() {
        String[] haarkleuren = {"peper en zout", "vuurtorenros", "pimpelpaars", "ravenzwart"};
        int[] verwachtNietStudent = {12,13,0,13};
        int[] verwachtStudent = {9,10,0,9};
        for (int i = 0; i < haarkleuren.length; i++) {
            assertEquals(verwachtNietStudent[i], personenlijst.personenVanKlasseMetHaarkleur("Persoon", haarkleuren[i]).size());
            assertEquals(verwachtStudent[i], personenlijst.personenVanKlasseMetHaarkleur("Student", haarkleuren[i]).size());
        }
    }

    @Test
    public void zoekenOpStudiesTest() {
        String[] studies = {"industrieel ingenieur", "bio-ingenieur", "geneeskunde", "rechten"};
        int[] verwacht = {16,16,21,18};
        for (int i = 0; i < studies.length; i++) {
            assertEquals(verwacht[i],personenlijst.studentenMetStudie(studies[i]).size());
        }
    }

    @Test
    public void zoekenOpHobbys() {
        assertEquals(9,personenlijst.persoonMetMeesteHobbys().getHobbys().size());
    }
    @Test
    public void zoekenOpDiplomas(){
        assertEquals(3,personenlijst.studentMetMeesteDiplomas().getDiplomas().size());
    }
}
