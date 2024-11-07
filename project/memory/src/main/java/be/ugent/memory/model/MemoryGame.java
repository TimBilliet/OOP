package be.ugent.memory.model;

import be.ugent.memory.MemoryView;

import java.io.File;

public class MemoryGame implements IMemoryGame{

    private int rijen;
    private int kolommen;
    File bestand;

    public MemoryGame(File bestand) {
        this.bestand = bestand;
    }

    public MemoryGame(int aantalRijen, int aantalKolommen) {
        rijen = aantalRijen;
        kolommen = aantalKolommen;
    }


    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public String getCardValue(int row, int col) {
        return "";
    }

    @Override
    public boolean isCardFlipped(int row, int col) {
        return false;
    }

    @Override
    public void selectCard(int row, int col) {

    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public int getMoveCount() {
        return 0;
    }
}
