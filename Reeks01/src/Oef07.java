public class Oef07 {
    public static void main(String[] args) {
        int grens1 = gooiDobbelsteen();
        int grens2 = gooiDobbelsteen();
        int worp = gooiDobbelsteen();
        int pogingen = 1;
        System.out.println("Grens 1 = " + grens1 + ", grens 2 = " + grens2+ ", worp = " + worp);
        while(!(worp >= grens1 && worp <= grens2 || worp <= grens1 && worp >= grens2)) {
            worp = gooiDobbelsteen();
            System.out.println("Nieuwe worp: " + worp);
            pogingen++;
        }
        System.out.println("Aantal pogingen = " + pogingen);

    }

    private static int gooiDobbelsteen() {
        return 1 + (int)( (6 - 1 + 1)* Math.random());

    }
}
