package groepsindeling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Groepsindeling {
    private Map<Integer, Set<Persoon>> personenPerErvaring = new TreeMap<>();

    public Groepsindeling(String bestandsnaam) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(bestandsnaam));
        Map<Integer, List<Persoon>> tempMap = new TreeMap<>();
        while (sc.hasNext()) {
            String[] lijn = sc.next().split(";");
            int ervaring = Integer.parseInt(lijn[1]);
            String naam = lijn[0];
            Persoon toeTeVoegenPersoon = new Persoon(naam, ervaring);
            if (personenPerErvaring.containsKey(ervaring)) {
                personenPerErvaring.get(ervaring).add(toeTeVoegenPersoon);
            } else {
                personenPerErvaring.put(ervaring, new HashSet<>() {{
                    add(toeTeVoegenPersoon);
                }});
            }
        }
    }

    public Map<Integer, Set<Persoon>> groepenMetGelijkeErvaring(int aantalLeden) {
        Map<Integer, Set<Persoon>> groepen = new TreeMap<>();
        List<Persoon> samengevoegdeLijst = new ArrayList<>();

        for (Map.Entry<Integer, Set<Persoon>> entry : personenPerErvaring.entrySet()) {
            List<Persoon> shuffledLijst = new ArrayList<>(entry.getValue());
            Collections.shuffle(shuffledLijst);
            samengevoegdeLijst.addAll(shuffledLijst);
        }
        int aantalgroepen = samengevoegdeLijst.size() / aantalLeden;
        int aantalGroteGroepen = samengevoegdeLijst.size() % aantalLeden;
        int groteGroepenCounter = 0;

        for(int i = 0; i < aantalgroepen; i++) {
            if(i >= aantalgroepen - aantalGroteGroepen) {
                groteGroepenCounter++;
                if(groteGroepenCounter > 1) {
                    groepen.put(i + 1, new HashSet<>(samengevoegdeLijst.subList((i * aantalLeden) + 1, ((i + 1) * aantalLeden) + 2 )));
                } else {
                    groepen.put(i + 1, new HashSet<>(samengevoegdeLijst.subList(i * (aantalLeden), ((i + 1) * aantalLeden) + 1 )));
                }
            } else {
                groepen.put(i + 1, new HashSet<>(samengevoegdeLijst.subList(i * aantalLeden, (i + 1) * aantalLeden)));
            }
        }
        return groepen;
    }

    public Map<Integer, Set<Persoon>> groepenMetGespreideErvaring(int aantalLeden) {
        return null;
    }


}
