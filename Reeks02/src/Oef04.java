public class Oef04 {
    public static void main(String[] args) {
        String[] w = {"Da", "t h", "eb j", "e", " g", "oe", "d g", "ed", "aan."};
        String[] v = {"llard)", "auri", "a L", "liz", "Dr. E", "aan.(", " te sl", "ren mee", "nde",
                "t om a", ", nie", "en", "n", "eu", "p te st", "m o", "tok o", "s een s", "of i", "elo", "t g", "He"};
        StringBuilder deelEen = new StringBuilder();
        StringBuilder deelTwee = new StringBuilder();
        for (int i = 0; i < w.length; i++) {
            deelEen.append(w[i]);
        }
        for (int i = 0; i < v.length; i++) {
            deelTwee.append(v[v.length - 1 - i]);
        }
        System.out.println(deelEen);
        System.out.println(deelTwee);

    }
}
