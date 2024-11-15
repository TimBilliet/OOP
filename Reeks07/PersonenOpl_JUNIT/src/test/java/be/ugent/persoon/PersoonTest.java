package be.ugent.persoon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersoonTest {
    private Persoon persoon;

    @BeforeEach
    public void setup() {
        persoon = new Persoon("Brouns", "Leen");
    }

    @Test
    public void constructorTest() {
        assertEquals(persoon.getVoornaam(), "Leen");
        assertEquals(persoon.getNaam(), "Brouns");
    }

    @Test
    public void testVoegHobbyToe() {
        persoon.voegHobbyToe("fietsen");
        persoon.voegHobbyToe("winkelen");
        assertTrue(persoon.getHobbys().contains("fietsen"));
        assertTrue(persoon.getHobbys().contains("winkelen"));
        assertFalse(persoon.getHobbys().contains("koken"));
    }

    @Test
    public void testVoegInformatieToe() {
        persoon.voegInformatieToe("haarkleur:bruin");
        persoon.voegInformatieToe("hobby:wandelen");
        assertEquals("bruin", persoon.getHaarkleur());
        assertTrue(persoon.getHobbys().contains("wandelen"));
    }

    @Test
    public void testTestEquals() {
        Persoon persoonCopy = new Persoon("Brouns", "Leen");
        Persoon anderePersoon = new Persoon("Verkerken", "Miel");
        assertEquals(persoon, persoonCopy);
        assertNotEquals(persoon, anderePersoon);
    }
}