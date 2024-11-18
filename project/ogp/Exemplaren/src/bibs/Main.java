package bibs;

import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IsbnNietGevonden {
        System.out.println("Haal oproep en implementatie van de 3 testmethodes in bibs.Main gaandeweg uit commentaar.");
//        testKlassenBoekEnPrentenboek();
        testKlasseCatalogus();
        //testKlasseBibliotheek();
    }

    public static void testKlassenBoekEnPrentenboek() {
        System.out.println("\nTEST VAN KLASSEN BOEKINFO EN PRENTENBOEKENINFO\n");
        BoekInfo boek = new BoekInfo("doeternietoe;123456;Over het kanaal;Annelies Beck");
        PrentenboekInfo prentenboek = new PrentenboekInfo("doeterniet;456789;Toen de zee stil was;Annelies Beck;Karolien Raeymaekers");
        assertEquals_("BoekInfo 123456 Over het kanaal door Annelies Beck", boek.toString(), "constructor Boek of toString()-methode niet ok");
        assertEquals_("PrentenboekInfo 456789 Toen de zee stil was door Annelies Beck --- getekend door Karolien Raeymaekers", prentenboek.toString(), "constructor Prentenboek of toString()-methode niet ok");
    }


    public static void testKlasseCatalogus() throws IsbnNietGevonden {
        System.out.println("\nTEST VAN KLASSE CATALOGUS\n");
//        Catalogus legeCatalogus = new Catalogus("niet_te_vinden.txt");
//        assertTrue_(legeCatalogus.toString().trim().equals(""), "onbestaand bestand -> lege catalogus?");

        Catalogus catalogus = new Catalogus("cat.csv");
        assertTrue_(("" + catalogus).trim().startsWith("535758773 Linda van Rijn\n878590631 Suzanne Vermeer"), "Catalogus leesbaar uitgeschreven volgens specificaties uit opgave?");

        assertEquals_("BoekInfo 228671283 De reuzenperzik door Roald Dahl", catalogus.getBoekInfo("228671283").toString(), "Constructor of getBoekInfo niet ok");
        assertEquals_("PrentenboekInfo 954134057 Kleine Koen in de tuin door Elsa Beskow --- getekend door Elsa Beskow", catalogus.getBoekInfo("954134057").toString(), "Constructor of getBoekInfo niet ok");
        assertEquals_("7", "" + catalogus.zoekOpAuteur("ANNE").size(), "zoekOpAuteur geeft niet 't juiste aantal boeken terug");
        assertEquals_("Suzanne Vermeer", catalogus.zoekOpAuteur("ANNE").get(0).getAuteur(), "auteur van eerstgevonden boek is niet juist");

        PrentenboekInfo[] drieVanBeskow = catalogus.drieVanIllustrator("Elsa Beskow");
        assertTrue_(drieVanBeskow[0] != null, "er zouden drie boeken getekend door Elsa Beskow moeten zijn");
        Set<String> isbns = new HashSet<>();
        isbns.add(drieVanBeskow[0].getIsbn());
        isbns.add(drieVanBeskow[1].getIsbn());
        isbns.add(drieVanBeskow[2].getIsbn());
        assertTrue_(isbns.contains("954134057"), "'Kleine Koen in de tuin' van Elsa Beskow niet gevonden");
        assertTrue_(isbns.contains("999888777"), "'Okke, Nootje en Doppejan' van Elsa Beskow niet gevonden");
        assertTrue_(isbns.contains("777888999"), "'Het huis van meneer Peter' van Elsa Beskow niet gevonden");
    }

    /*
    public static void testKlasseBibliotheek() {
        System.out.println("\nTEST VAN KLASSE BIBLIOTHEEK\n");
        Bibliotheek bib = new Bibliotheek("cat.csv", "bib.txt");
        assertEquals_("102", "" + bib.aantalBoeken(), "Aantal boeken klopt niet (dubbels moesten genegeerd worden)");

        bib.vraagBoekAan();
        bib.vraagBoekAan();
    }
    */

    public static void assertEquals_(String verwacht, String gekregen, String boodschap) {
        if (verwacht.equals(gekregen)) {
            System.out.println("TEST GESLAAGD");
        } else {
            System.out.println("TEST NIET GESLAAGD\n\tboodschap\n\tverwacht:\n\t" + verwacht + "\n\tgekregen:\n\t" + gekregen);
        }
    }

    public static void assertTrue_(boolean uitspraak, String boodschap) {
        if (uitspraak) {
            System.out.println("TEST GESLAAGD");
        } else {
            System.out.println("TEST NIET GESLAAGD\n\t" + boodschap);
        }
    }
}