package Lab4Exceptions;

import java.io.*;
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

    public static void enterArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = scanner.nextInt();
        scanner.nextLine();
        char[] charArray = new char[size];

        System.out.println("Введите строку");
        String inputString = scanner.nextLine();
        for (int i = 0; i < inputString.length(); i++) {
            charArray[i] = inputString.charAt(i);
        }
        System.out.println(charArray);
    }

    public static void task3() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Введите заглавную букву:");
            char upperLetter = (char) reader.read();
            reader.readLine();

            System.out.println("Введите строчную букву:");
            char lowerLetter = (char) reader.read();
            reader.readLine();

            int codeUpperLetter = (upperLetter >> 2);
            int codeLowerLetter = (lowerLetter << 1);

            System.out.println(codeUpperLetter + " " + codeLowerLetter);

            System.out.println("Полученная заглавная буква (сдвинутый код): " + (char) codeUpperLetter);
            System.out.println("Полученная строчная буква (сдвинутый код): " + (char) codeLowerLetter);

            if ((codeLowerLetter < 32 || codeLowerLetter > 175) && (codeUpperLetter < 32 || codeUpperLetter > 175)) {
                throw new NumberIsOutOfRange("Обе буквы вне диапозона");
            } else if (codeLowerLetter < 32 || codeLowerLetter > 175) {
                throw new NumberIsOutOfRange("Строчная буква вне диапозона");
            } else if (codeUpperLetter < 32 || codeUpperLetter > 175) {
                throw new NumberIsOutOfRange("Заглавная буква вне диапозона");
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberIsOutOfRange e) {
            System.out.println(e);
        }

    }
}

class NumberIsOutOfRange extends Exception {
    private String messageAboutException;

    public NumberIsOutOfRange(String message) {
        messageAboutException = message;
    }

    public String toString() {
        return "Exception NumberIsOutOfRange with message: [" + messageAboutException + "]";
    }
}
