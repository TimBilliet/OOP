package iteratoren;

import java.io.FileNotFoundException;

/**
 *
 * @author tiwi
 */
public class Iteratoren {
    
    public static void main(String[] args) {
        testA();
        testB();
    }

    public static void testA() {
        
        System.out.println("\nTEST A\n");
        try {
            Woordenboek boek = new Woordenboek("woordenBIS.txt");
            System.out.println(boek);
            
            System.out.println("\nna verwijderen van '9'");
            boek.verwijderWoord("9");
            controleer("alfabetisch:    [0, 1, 2, 3, 4, 5, 6, 7, 8]\ninleesvolgorde: [0, 1, 2, 3, 4, 5, 6, 7, 8]\nhashed:         [0, 1, 2, 3, 4, 5, 6, 7, 8]",boek.toString());            
            
            System.out.println("\nna verwijderen van woord op index 7");
            boek.verwijderWoordOpIndex(7);
            controleer("alfabetisch:    [0, 1, 2, 3, 4, 5, 6, 8]\ninleesvolgorde: [0, 1, 2, 3, 4, 5, 6, 8]\nhashed:         [0, 1, 2, 3, 4, 5, 6, 8]",boek.toString());            
            
            
            System.out.println("\nna verwijderen van woorden tussen indices 2 en 4");
            boek.verwijderWoordenTussenIndices(2,4);
            controleer("alfabetisch:    [0, 1, 4, 5, 6, 8]\ninleesvolgorde: [0, 1, 4, 5, 6, 8]\nhashed:         [0, 1, 4, 5, 6, 8]",boek.toString());            
            
            
            System.out.println("\nna verwijderen van woorden tussen indices 5 en 15");
            boek.verwijderWoordenTussenIndices(5,15);
            controleer("alfabetisch:    [0, 1, 4, 5, 6]\ninleesvolgorde: [0, 1, 4, 5, 6]\nhashed:         [0, 1, 4, 5, 6]",boek.toString());            
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("bestand niet gevonden");
        }
    }
    
    
    // De testen bevatten duplicated code;
    // hier had een overkoepelende methode kunnen komen.
    // Voor de leesbaarheid (en omdat dit geen cruciaal te hergebruiken stuk code is) 
    // staat hier toch nog een kopie van testA().
    public static void testB() {
        
        System.out.println("\nTEST B\n");
        try {
            Woordenboek boek = new Woordenboek("woorden.txt");
            System.out.println(boek);
            
            System.out.println("\nna verwijderen van 'aap'");
            boek.verwijderWoord("aap");
            controleer("alfabetisch:    [mies, noot, schapen, teun, toon, vuur, weide, zus]\ninleesvolgorde: [noot, mies, vuur, toon, zus, schapen, weide, vuur, teun]\nhashed:         [weide, schapen, noot, mies, zus, vuur, toon, teun]",boek.toString());
            
            System.out.println("\nna verwijderen van woord op index 2");
            boek.verwijderWoordOpIndex(2);
            controleer("alfabetisch:    [mies, noot, teun, toon, vuur, weide, zus]\ninleesvolgorde: [noot, mies, toon, zus, schapen, weide, vuur, teun]\nhashed:         [weide, schapen, mies, zus, vuur, toon, teun]",boek.toString());                        
            
            System.out.println("\nna verwijderen van woorden tussen indices 3 en 5");
            boek.verwijderWoordenTussenIndices(3,5);
            controleer("alfabetisch:    [mies, noot, teun, weide, zus]\ninleesvolgorde: [noot, mies, toon, weide, vuur, teun]\nhashed:         [weide, schapen, mies, toon, teun]",boek.toString());            
                        
            System.out.println("\nna verwijderen van woorden tussen indices 5 en 15");
            boek.verwijderWoordenTussenIndices(5,15);
            controleer("alfabetisch:    [mies, noot, teun, weide, zus]\ninleesvolgorde: [noot, mies, toon, weide, vuur]\nhashed:         [weide, schapen, mies, toon, teun]",boek.toString());            
            
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("bestand niet gevonden");
        }
    }
    
    public static void controleer(String verwacht, String berekend){
        if(verwacht.equals(berekend)){
            System.out.println(":-)  test passed");
        }
        else{
            System.out.println(":-/  TEST FAILED\nverwacht:\n"+verwacht+"\nberekend:\n"+berekend);
        }
    }
    
}
