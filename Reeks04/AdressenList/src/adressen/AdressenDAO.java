package adressen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdressenDAO {
    private List<Adres> adressen ;


    public AdressenDAO(String bestandsnaam) throws FileNotFoundException {
        adressen = new ArrayList<>();
        Scanner sc = new Scanner(new File(bestandsnaam));
        while (sc.hasNext()) {

            String line = sc.nextLine();
            Scanner stukSc = new Scanner(line).useDelimiter(";");
            Adres adres = new Adres(stukSc.nextInt(), stukSc.next(), stukSc.next(), stukSc.nextInt());
            adressen.add(adres);
        }
    }
    public List<Adres> getAdressenMetStraat(String straat) {
        List<Adres> adressen2 = new ArrayList<>();
        for(Adres adres : adressen) {
            if(adres.getStraat().equals(straat)) {
                adressen2.add(adres);
            }
        }
        return adressen2;
    }
/*
    public Adres[] getAdressenMetStraat(String straat) {
        Adres[] adressen2 = new Adres[this.adressen.length];
        int index = 0;
        for(Adres adres : adressen) {
            if(adres.getStraat().equals(straat)) {
                adressen2[index] = adres;
                index++;

            }
        }
        adressen2 = Arrays.copyOf(adressen2, index);
        return adressen2;
    }

 */
}
