import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Decoder {


    Map<Character, Character> decodeMap;
    Map<Character, Character> reverseDecodeMap;

    public Decoder(String bestandsnaam) throws FileNotFoundException {
        decodeMap = new HashMap<>();
        reverseDecodeMap = new HashMap<>();
        Scanner scanner = new Scanner(new File(bestandsnaam));
        while (scanner.hasNext()) {
            //String lijn[] = scanner.nextLine().split(" ");
            String lijn = scanner.nextLine();
            char eerste = lijn.charAt(0);
            char tweede = lijn.charAt(2);
            decodeMap.put(eerste, tweede);
        }
    }

    public String decodeer(String teDecoderenString) {
        StringBuilder gedecodeerdeString = new StringBuilder();
        for (int i = 0; i < teDecoderenString.length(); i++) {
            char teVervangenChar = teDecoderenString.charAt(i);
            char nieuweChar = decodeMap.get(teVervangenChar);
            gedecodeerdeString.append(nieuweChar);
        }
        return gedecodeerdeString.toString();
    }
    public String codeer(String teCoderenString) {
        StringBuilder geencodeerdeString = new StringBuilder();

        return geencodeerdeString.toString();
    }
}
