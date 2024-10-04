public class Oef05 {
    public static void main(String[] args) {
        String a = "Dirckx";
        String b = "daems";
        String c = "Vandenbulcke";
        String d = "Van De Velde";


        if(a.compareToIgnoreCase(b) < 0) {
            System.out.println("Vergelijken op de oorspronkelijke schrijfwijze: Dirckx komt alfabetisch voor daems");
        } else {
            System.out.println("Vergelijken op de oorspronkelijke schrijfwijze: daems komt alfabetisch voor Dirckx");
        }
        System.out.println(c.compareToIgnoreCase(d.replaceAll(" ", "")));
        if(c.compareToIgnoreCase(d.replaceAll(" ", "")) < 0) {
            System.out.println("Vergelijken op de oorspronkelijke schrijfwijze: Vandenbulcke komt alfabetisch voor Van De Velde");
        } else {
            System.out.println("Vergelijken op de oorspronkelijke schrijfwijze: Van De Velde komt alfabetisch voor Vandenbulcke");
        }

    }
}
