package be.ugent.memory.model;

public class Kaart {
    private int rij;
    private int kolom;
    private boolean flipped = false;
    private String value;

    public Kaart(int rij, int kolom, String value) {
        this.kolom = kolom;
        this.rij = rij;
        this.value = value;
    }

    public boolean isFlipped() {
        return flipped;
    }
    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
    }
    public String getValue() {
        return value;
    }
}
