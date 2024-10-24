package lab2;


import java.util.Scanner;

public class Solution {
    public static final String ALPHABET_FOR_CAESAR = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    //public static final String ALPHABET = " АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    public static String caesarEncrypt(String text, int step) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            char textChar = text.charAt(i);
            int textIndex = ALPHABET_FOR_CAESAR.indexOf(textChar);
            if (textIndex == -1) {  //если indexOf вернул -1 значит не нашел вхождения символа в строку, значит это символ не из алфавита
                encryptedText.append(textChar);  //значит его не шифруем а просто возвращаем изначальный символ
                continue;
            }
            int encryptedIndex = (textIndex + step) % ALPHABET_FOR_CAESAR.length();


            encryptedText.append(ALPHABET_FOR_CAESAR.charAt(encryptedIndex));
        }
        return encryptedText.toString();
    }



    /*public static String xorEncrypt(String text, String key) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char textChar = text.charAt(i); //записываем символ в переменную для каждой итерации
            char keyChar = key.charAt(i % key.length());

            int textIndex = ALPHABET.indexOf(textChar); //ищем индекс символа в алфавите
            int keyIndex = ALPHABET.indexOf(keyChar);

            if (textIndex == -1) {
                encryptedText.append(textChar);
                continue;
            }

            int encryptedIndex = (textIndex ^ keyIndex); //находим индекс зашифрованного символа операцией XOR

            encryptedText.append(ALPHABET.charAt(encryptedIndex % ALPHABET.length())); //добавляем символ в конечный зашифрованный текст

            System.out.println(textIndex + " ^ " + keyIndex + " = " + encryptedIndex);

            System.out.println(encryptedText);
        }
        return encryptedText.toString();
    }*/

    //Реализовать шифрование как в методичке не получилось, из-за того что при шифровке некоторых символов
    //результат сложения по модулю 2 их двоичных представлений получался больше размера алфавита,
    //в таком случае приходилось брать остаток от деления на размер алфавита
    //но тогда при расшифровке результата получалось абсолютно другое число

    public static String xorEncrypt(String text, String key) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char textChar = text.charAt(i);
            char keyChar = key.charAt(i % key.length());

            // Применяем XOR к символам как к числам (кодам символов)
            char encryptedChar = (char) (textChar ^ keyChar);

            encryptedText.append(encryptedChar); // Добавляем зашифрованный символ
        }
        return encryptedText.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите:");
            System.out.println("1. Шифр цезаря");
            System.out.println("2. Шифр XOR");
            System.out.println("3. Выход");
            if (scanner.hasNextInt()){
                int choise = scanner.nextInt();
                scanner.nextLine();
                switch (choise) {
                    case 1:
                        System.out.println("Введите текст для шифрования:");
                        String textFromEncrypt = scanner.nextLine();
                        System.out.println("Введите шаг:");
                        int stepFromEncrypt = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Вы ввели: " + textFromEncrypt);
                        System.out.println("Зашифрованный текст: " + Solution.caesarEncrypt(textFromEncrypt, stepFromEncrypt));
                        break;
                    case 2:
                        System.out.println("Введите текст для шифрования");
                        String textFromEncryptXOR = scanner.nextLine();
                        System.out.println("Исходный текст: " + textFromEncryptXOR);
                        System.out.println("Зашифрованный текст: " + Solution.xorEncrypt(textFromEncryptXOR, "СЕКРЕТ"));
                        System.out.println("Расшифрованный текст: " +
                                Solution.xorEncrypt(Solution.xorEncrypt(textFromEncryptXOR, "СЕКРЕТ"), "СЕКРЕТ"));
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Неверный выбор");
                }
            } else {
                System.out.println("Неверный ввод");
                scanner.nextLine();
            }
        }
    }
}
