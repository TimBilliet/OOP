package be.ugent.memory.model;

import java.io.File;

public class DummyMemoryGame implements IMemoryGame {

    private boolean metSmileys = false;

    public DummyMemoryGame(File bestand) {
        metSmileys = false;
    }

    public DummyMemoryGame(int row, int col){
        metSmileys = true;
    }

    @Override
    public int getRowCount() {
        return 3;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getCardValue(int row, int col) {
        return metSmileys?"\uD83D\uDE06":"A";
    }

    @Override
    public boolean isCardFlipped(int row, int col) {
        return false;
    }

    @Override
    public void selectCard(int row, int col) {
        // does nothing yet
    }

    @Override
    public boolean isGameOver() {
        return true;
    }

    @Override
    public int getMoveCount() {
        return 0;
    }


}
