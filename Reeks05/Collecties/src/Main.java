import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Generator generator = new Generator(10,30);

        Set<Integer> getallen = generator.geefVerschillendeGetallen(10);
        //Schrijf deze getallen uit ter controle
        System.out.println("verschillende getallen:");
        for(int getal : getallen) {
            System.out.println("getal: " + getal);
        }

        Set<Integer> getallenInvolgorde = generator.geefVerschillendeGetallenInVolgorde(10);
        //Schrijf deze getallen uit ter controle
        System.out.println("verschillende getallen in volgorde:");

        for(int getal : getallenInvolgorde) {
            System.out.println("getal: " + getal);
        }
    }
}