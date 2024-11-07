package be.ugent.memory.model;

import be.ugent.memory.MemoryView;

import java.io.File;

public class MemoryGame implements IMemoryGame {

    private int rijen;
    private int kolommen;
    private Kaart[][] bord;
    private Kaart previousCard;
    private int moves;
    private int flippedCount;

    public MemoryGame(File bestand) {
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
        if (moves != 0 && bord[row][col].getValue().equals(previousCard.getValue())) {
            previousCard.setFlipped(true);
            bord[row][col].setFlipped(true);
            flippedCount++;
        }
        previousCard = bord[row][col];
        moves++;
    }

    @Override
    public boolean isGameOver() {
        return flippedCount == rijen * kolommen / 2;
    }

    @Override
    public int getMoveCount() {
        return moves;
    }
}
