import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bewerking bewerking = new Bewerking("12+34");
        Scanner scanner = new Scanner(System.in);
        System.out.println(bewerking);
        boolean juist = false;
        while (!juist && scanner.hasNext()) {
            String input = scanner.nextLine().trim();
            if(Integer.parseInt(input)== bewerking.oplossing()) {
                System.out.println("Correct");
                juist = true;
            } else {
                System.out.println("Fout");
            }
        }

    }
}
