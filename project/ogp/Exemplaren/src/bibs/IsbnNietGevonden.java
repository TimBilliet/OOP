package bibs;

public class IsbnNietGevonden extends RuntimeException{

public IsbnNietGevonden(String isbn) {
    super("isbn + " + isbn + " niet gevonden");
}
}
