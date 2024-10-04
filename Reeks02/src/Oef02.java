public class Oef02 {
    public static void main(String[] args) {
        for (int i = 0; i < 128; i++) {

            StringBuilder charType = new StringBuilder();
            if (Character.isDigit((char)i)) {
                charType.append("cijfer");
            } else if (Character.isLetter((char)i) && Character.isUpperCase((char)i)) {
                charType.append("hoofdletter");
            } else if (Character.isLetter((char)i) && Character.isLowerCase((char)i)) {
                charType.append("kleine letter");
            } else if (Character.isWhitespace((char)i)) {
                charType.append("blanco teken");
            }
            System.out.println(i + "..." + (char) i + "***" + "\t" + charType);

        }
    }
}
