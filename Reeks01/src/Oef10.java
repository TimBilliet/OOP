public class Oef10 {
    public static void main(String[] args) {
        int aantal = (int) ((10 + 1) * Math.random());
        boolean hoofdletter = true;
        int charCounter1 = 0;
        int charCounter2 = 0;
        char letterDriehoek2 = 'a';
        System.out.println("aantal is " + aantal);

        for (int i = 0; i < aantal; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j <= charCounter1; j++) {
                    System.out.print("*");
                }
            } else {
                for (int j = 0; j <= charCounter1; j++) {
                    if (hoofdletter) {
                        System.out.print("A");
                    } else {
                        System.out.print("a");
                    }
                }
            }
            System.out.println();
            charCounter1++;
        }
        charCounter1 = 0;
        System.out.println();
        for (int i = 0; i < aantal; i++) {
            if (i == 0) {
                System.out.println("*");
            } else {
                for (int j = 0; j <= charCounter1; j++) {
                    if (i == aantal - 1) {
                        System.out.print("!");
                    } else {
                        if (hoofdletter) {
                            System.out.print((char) ((int) letterDriehoek2 - ((int) 'a' - (int) 'A')));
                        } else {
                            System.out.print(letterDriehoek2);
                        }
                    }
                }
                letterDriehoek2 = (char) ((int) letterDriehoek2 + 1);
                System.out.println();
            }
            charCounter1++;
        }

    }
}
