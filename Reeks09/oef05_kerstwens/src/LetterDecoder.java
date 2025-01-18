import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LetterDecoder {
    Map<Integer, Character> dict;

    public LetterDecoder(String bestandsnaam) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(bestandsnaam))) {
            dict = new HashMap<>();
            while (sc.hasNext()) {
                int key = sc.nextInt();
                char value = sc.next().charAt(0);
                dict.put(key, value);
            }
        }
    }
    public String decode(String input) {
        StringBuilder ret = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            try {
                Character oud = input.charAt(i);
                int key = Integer.parseInt(String.valueOf(oud));
                Character nieuw = dict.get(key);
                ret = new StringBuilder(ret.toString().replace(oud, nieuw));
            } catch (NumberFormatException _) {
            }
        }
        return ret.toString();
    }
}
