public class Oef02 {
    //Hello world, ik tel af vanaf 10:
    //10 9 8 7 6 5 4 3 2 1 START
    public static void main(String[] args) {
        int startWaarde1 = 10;
        int startWaarde2 = 37;
        System.out.println("Hello world, ik tel af vanaf " + startWaarde1 + ": ");
        for(int i = startWaarde1; i > 0; i--) {
            System.out.print(i + " ");
        }
        System.out.println("START");
        //Hello world, ik tel af vanaf 37
        System.out.println("Hello world, ik tel af vanaf " + startWaarde2 + ": ");

        for(int i = startWaarde2; i > 0; i--) {
            System.out.print(i + " ");
        }
        System.out.println("START");
    }
}
