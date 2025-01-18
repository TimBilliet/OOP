import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Kerstwensdecode implements Iterable<String>{

    private Map<String, String> woordvolgordeMap;
    public Kerstwensdecode(String inputbestand, String decodebestand) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(inputbestand))) {
            woordvolgordeMap = new TreeMap<>();
            LetterDecoder decoder = new LetterDecoder(decodebestand);
            while (sc.hasNext()) {
                String[] lijn = sc.nextLine().split(";");
                if(lijn.length != 2){
                    throw new IllegalArgumentException("Ongeldig inputbestand");
                }
                woordvolgordeMap.put(lijn[0], decoder.decode(lijn[1]).replace("@", "\n"));
            }
        }
    }
    @Override
    public Iterator<String> iterator() {
        return woordvolgordeMap.values().iterator();
    }
}