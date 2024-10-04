public class Oef08 {
    public static void main(String[] args) {

        char letter = 'a';         // vul hier de letter a in
        // ... hier mogen eventueel berekeningen komen
        System.out.println("De ASCII-code van de letter " + letter + " is " + (int) letter);
        char hoofdletter = 'A';    // vul hier de letter A in
        // ... hier mogen eventueel berekeningen komen
        System.out.println("De ASCII-code van de hoofdletter " + hoofdletter + " is " + (int) hoofdletter);
        // ... hier mogen eventueel berekeningen komen
        System.out.println("Het verschil tussen de ASCII-codes is " + ((int) letter - (int) hoofdletter));

        char letter2 = 'c';        // vul hier de letter c in
        // ... hier mogen eventueel berekeningen komen
        System.out.println("De ASCII-code van de letter " + letter2 + " is " + (int) letter2);
        // ... hier mogen eventueel berekeningen komen

        System.out.println("De positie van de letter " + letter2 + " in het alfabet is " + ((int) letter2 - (int) letter + 1));
        char cijfer = '1';         // vul hier het cijfer 1 in
        // ... hier mogen eventueel berekeningen komen
        System.out.println("De ASCII-code van het cijfer " + cijfer + " is " + (int)cijfer);

        System.out.println("Alle ASCII-tekens :");
        for (int i = 0; i < 128; i++) {
            System.out.println(i + "..." + (char) i + "***");

        }

    }
}
