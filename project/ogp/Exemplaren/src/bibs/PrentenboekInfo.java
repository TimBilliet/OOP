package bibs;

public class PrentenboekInfo extends BoekInfo {
    private String illustrator;

    public PrentenboekInfo(String info) {
        String woorden[] = info.split(";");
        super(woorden[0] + ";" + woorden[1] + ";" + woorden[2] + ";" + woorden[3]);
        illustrator = woorden[4];
    }

    public String getIllustrator() {
        return illustrator;
    }
    @Override
    public String toString() {
        return super.toString() + " --- getekend door " + illustrator;
    }
}
