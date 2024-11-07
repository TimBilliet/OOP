package be.ugent.memory.model;

public interface IMemoryGame {

    /**
     * Returns the number of rows in the game board.
     */
    int getRowCount();

    /**
     * Returns the number of columns in the game board.
     */
    int getColumnCount();

    /**
     * Returns the value of the card at the specified position.
     */
    String getCardValue(int row, int col);

    /**
     * Checks if the card at the specified position is currently flipped.
     */
    boolean isCardFlipped(int row, int col);

    /**
     * Handles the logic when a card is selected by the player.
     */
    void selectCard(int row, int col);

    /**
     * Checks if the game is over.
     */
    boolean isGameOver();

    /**
     * Returns the number of moves made by the player.
     */
    int getMoveCount();
}

