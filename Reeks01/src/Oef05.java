public class Oef05 {
    public static void main(String[] args) {

        double resultaat = 1;
        double grondtal = 0.5;
        int maxLoop = 20;
        int index = 0;
        while (resultaat < 10000 && index < maxLoop) {
            System.out.println("De " + index + " macht van " + grondtal + " is " + resultaat);
            resultaat *= grondtal;
            index++;
        }
    }
}
