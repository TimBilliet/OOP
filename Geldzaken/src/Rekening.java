public class Rekening {

    private double saldo;

    public Rekening(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void stort(double bedrag) {
        saldo += bedrag;
    }

    public void haalAf(double bedrag) {
        saldo -= bedrag;
    }

    public void schrijfOverNaar(Rekening andereRekening, double bedrag) {
        haalAf(bedrag);
        andereRekening.stort(bedrag);
        //andereRekening.saldo += bedrag;
    }

    @Override
    public String toString() {
        return "€" + saldo;
    }
}