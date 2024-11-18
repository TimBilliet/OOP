package bibs;

public class BoekInfo {

    private String isbn;
    private String titel;
    private String auteur;

    public BoekInfo(String info) {

        String woorden[] = info.split(";");
        isbn = woorden[1];
        titel = woorden[2];
        auteur = woorden[3];
    }


    public String getIsbn() {
        return isbn;
    }

    public String getAuteur() {
        return auteur;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + isbn + " " + titel + " door " + auteur;
    }
}
