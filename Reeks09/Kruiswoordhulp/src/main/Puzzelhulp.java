package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Puzzelhulp {

    private final List<String> woorden;

    public Puzzelhulp(String bestandsnaamWoordenlijst) throws FileNotFoundException {

        try (Scanner sc = new Scanner(new File(bestandsnaamWoordenlijst))) {
            woorden = new ArrayList<>();
            while (sc.hasNext()) {
                woorden.add(sc.next());
            }
        }
    }

    public int aantalWoordenMetLengte(int lengte) {
        return (int) woorden.stream().filter(x -> x.length() == lengte).distinct().count();
    }

    public List<String> woordenMetLengte(int lengte) {
        return woorden.stream().filter(x -> x.length() == lengte).distinct().toList();
    }

    public List<String> woordenMetMeerKlinkersDanMedeklinkers() {
        String test = "Tes";
        return woorden.stream().filter(x -> {
            int medeklinkers = 0;
            int klinkers = 0;
            for (int i = 0; i < x.length(); i++) {
                if (String.valueOf(x.charAt(i)).matches("[aeiouAEIOU]")) {
                    klinkers++;
                } else if (String.valueOf(x.charAt(i)).matches("[a-zA-Z&&[^aeiouAEIOU]]")) {
                    medeklinkers++;
                }
            }
            return klinkers > medeklinkers;
        }).distinct().sorted(String::compareTo).toList();
    }


    public void schrijfWoordenMetLetters(char... letters) {
        woorden.stream().map(String::toLowerCase).distinct().sorted(String::compareTo).forEach(x -> {
            int aantalMatched = 0;
            for (Character letter : letters) {
                if (x.indexOf(letter) >= 0) {
                    aantalMatched++;
                }
            }
            if(letters.length == aantalMatched) {
                System.out.print(x + " - ");
            }
        });
    }

    public String alfabetischEerste(int lengte) {

        return woorden.stream().filter(x -> x.length() == lengte).min(String::compareTo).orElse("-");
    }

    public String alfabetischLaatste(int lengte) {
        return woorden.stream().filter(x -> x.length() == lengte).max(String::compareTo).orElse("-");

    }


}

