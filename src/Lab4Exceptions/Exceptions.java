package Lab4Exceptions;

import java.util.Scanner;

public class Exceptions {
    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        int y = 0;
        try {
            y = 285 / scanner.nextInt();
            System.out.println(y);
        } catch (ArithmeticException e) {
            System.out.println("деление на 0");
        }
        scanner.nextLine();
    }
    public static void enterArray(char[] mass) {
        Scanner scanner = new Scanner(System.in);

    }

}
