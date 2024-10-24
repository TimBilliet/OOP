public class Test_1_BewerkingConstructor3Parameters {

    public static void main(String[] args) {

        Bewerking bewerking = new Bewerking("12", "+", "34");
        controleerEquals("constructor met parameters \"12\", \"+\", \"34\"","12 + 34 = ", bewerking.toString());
        controleerEquals("constructor met parameters \"12\", \"+\", \"34\"","12 + 34 = 46", bewerking.toStringMetOplossing());

        bewerking = new Bewerking(" 56 ", " + ", "  78 ");
        controleerEquals("constructor met parameters \" 56 \", \" + \", \"  78 \"","56 + 78 = ", bewerking.toString());
        controleerEquals("constructor met parameters \" 56 \", \" + \", \"  78 \"","56 + 78 = 134", bewerking.toStringMetOplossing());

        bewerking = new Bewerking("-12", "*", "-3");
        controleerEquals("constructor met parameters \"-12\", \"*\", \"-3\"","-12 * -3 = ", bewerking.toString());
        controleerEquals("constructor met parameters \"-12\", \"*\", \"-3\"","-12 * -3 = 36", bewerking.toStringMetOplossing());
    }

    public static void controleerEquals(String boodschap, String verwacht, String berekend){
        if(verwacht.equals(berekend)){
            System.out.println("test passed ");
        }
        else{
            System.out.println("TEST FAILED "+boodschap);
        }
    }
}
