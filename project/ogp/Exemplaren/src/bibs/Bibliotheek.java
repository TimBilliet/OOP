package bibs;

import java.util.*;

public class Bibliotheek {

    // verander niets aan de instantievariabelen
    private Catalogus catalogus;
    private Set<Exemplaar> boeken;
    private Map<String,List<Exemplaar>> exemplarenVanIsbn;

    public Bibliotheek(String bestandsnaamCatalogus, String bestandsnaamExemplaren){
        // vul aan



        // op het einde van de constructor laat je dit staan:
        vulExemplarenVanIsbn();
    }

    private void vulExemplarenVanIsbn(){
        // vul aan
    }
    public int aantalBoeken(){
        return boeken.size();
    }

    public void vraagBoekAan(){
        // vul aan
    }

}
