package adressen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AdressenDAO {
    private Adres[] adressen;


    public AdressenDAO(String bestandsnaam) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(bestandsnaam));
        adressen = new Adres[5000];
        int index = 0;
        while (sc.hasNext()) {

            String line = sc.nextLine();
            Scanner stukSc = new Scanner(line).useDelimiter(";");
            Adres adres = new Adres(stukSc.nextInt(), stukSc.next(), stukSc.next(), stukSc.nextInt());
            adressen[index] = adres;

            index++;
            //while(stukSc.hasNext()){
             //   System.out.println(stukSc.next());

           // }
        }
        adressen = Arrays.copyOf(adressen, index);
    }

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
}
