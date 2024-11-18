package bibs;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Catalogus {
    private Map<String, BoekInfo> map;

    public Catalogus(String bestandsnaam) {
        try (Scanner sc = new Scanner(new File(bestandsnaam))) {
            map = new HashMap<>();
            while (sc.hasNext()) {
                String lijn = sc.nextLine();
                String woorden[] = lijn.split(";");
                String rest = lijn.substring(lijn.indexOf(";") + 1);
                try {
                    System.out.println(woorden[0]);
                    System.out.println(rest);
                    BoekInfo boekinfo = (BoekInfo) Class.forName(getClass().getPackageName()+ "." + woorden[0]).getConstructor(String.class).newInstance(rest);
                    map.put(boekinfo.getIsbn(), boekinfo);
                } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                         IllegalAccessException | InvocationTargetException ex ) {
                    System.out.println("Object aanmaken gefaald");
                }
                System.out.println(map);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Bestand niet gevonden");
        }
    }
    public BoekInfo getBoekInfo(String isbn) throws IsbnNietGevonden {
        BoekInfo info = map.get(isbn);
        if(info != null) {
            return info;
        } else {
            throw new IsbnNietGevonden(isbn);
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        if(map != null) {
            for(Map.Entry<String, BoekInfo> catalogusEntry : map.entrySet()) {
                output.append(catalogusEntry.getKey()).append(" ").append(catalogusEntry.getValue().getAuteur()).append("\n");
            }
        }
        return output.toString();
    }

    public List<BoekInfo> zoekOpAuteur(String auteur) {
        List<BoekInfo> boekenLijst = new ArrayList<>();
        for(BoekInfo boekInfo : map.values()) {
            if(boekInfo.getAuteur().toLowerCase().contains(auteur.toLowerCase())) {
                boekenLijst.add(boekInfo);
            }
        }
        return boekenLijst;
    }


    public PrentenboekInfo[] drieVanIllustrator(String illustrator) {
        PrentenboekInfo lijst[] = new PrentenboekInfo[3];
        int counter = 0;
        for(BoekInfo boekInfo : map.values()) {
            if(boekInfo instanceof PrentenboekInfo prentenboekInfo && prentenboekInfo.getIllustrator().equals(illustrator)) {
                if(counter < 3) {
                    lijst[counter] = prentenboekInfo;
                }
                counter++;
            }
        }
        return lijst;
    }
}