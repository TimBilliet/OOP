package be.ugent.memory.model;

import be.ugent.memory.MemoryView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MemoryGame implements IMemoryGame {

    private int rijen;
    private int kolommen;
    private Kaart[][] bord;
    private Kaart previousCard;
    private int aantalZetten;
    private int aantalGevondenDuos;

    public MemoryGame(File bestand) {
        try(Scanner sc = new Scanner(bestand)) {
            rijen = sc.nextInt();
            kolommen  = sc.nextInt();
        } catch (FileNotFoundException ex) {
            System.out.println("Bestand niet gevonden");
        }
    }

    public MemoryGame(int aantalRijen, int aantalKolommen) {
        rijen = aantalRijen;
        kolommen = aantalKolommen;
        bord = new Kaart[aantalRijen][aantalKolommen];
        char val = 'A';
        int volgnr = 0;
        for (int i = 0; i < aantalRijen; i++) {
            for (int j = 0; j < aantalKolommen; j++) {
                volgnr++;
                bord[i][j] = new Kaart(i, j, String.valueOf(val));
                if (volgnr % 2 == 0) {
                    val++;
                }
            }
        }
    }


    @Override
    public int getRowCount() {
        return rijen;
    }

    @Override
    public int getColumnCount() {
        return kolommen;
    }

    @Override
    public String getCardValue(int row, int col) {
        return bord[row][col].getValue();
    }

    @Override
    public boolean isCardFlipped(int row, int col) {
        return bord[row][col].isFlipped();
    }

    @Override
    public void selectCard(int row, int col) {
        if(!bord[row][col].isFlipped()) { // draait de kaart alleen om als die nog niet omgedraaid is
            bord[row][col].setFlipped(true);
            aantalZetten++;
            //volgorde van de if else belangrijk

            if(previousCard != null && bord[row][col].getValue().equals(previousCard.getValue())) { // als de waarde van de geselecteerde kaart gelijk is met de vorige kaart is er een duo gevonden
                aantalGevondenDuos ++;
            } else if(aantalZetten % 2 == 0 && aantalZetten > 1){ // als de 2de kaart van een poging wordt gedraait en deze niet gelijk waren(in de if ervoor gecheckt), draai beide kaarten weer om
                bord[row][col].setFlipped(false);
                previousCard.setFlipped(false);
                previousCard = null;
                return;
            }
            previousCard = bord[row][col]; // maak de vorige kaart de kaart die net geselecteerd werd
        }
    }

    @Override
    public boolean isGameOver() {
        return aantalGevondenDuos == rijen * kolommen / 2;
    }

    @Override
    public int getMoveCount() {
        return aantalZetten;
    }
}
