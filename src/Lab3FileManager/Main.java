package Lab3FileManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FileManager fileManager = new FileManager();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            fileManager.printMenu();


            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка введено не число");
                scanner.nextLine();
                continue;
            }

            int choise = scanner.nextInt();
            scanner.nextLine();

            switch (choise) {
                case 1:
                    fileManager.changeTotalDirectoryParent();
                    break;
                case 2:
                    System.out.println("Введите название директории для перехода: ");
                    String dirName = scanner.nextLine();
                    fileManager.changeTotalDirectory(dirName);
                    break;
                case 3:
                    System.out.println("Введите название файла: ");
                    String fileName = scanner.nextLine();
                    fileManager.getFileStats(fileName);
                    break;
                case 4:
                    System.out.println("Введите название файла: ");
                    String deleteFileName = scanner.nextLine();
                    fileManager.deleteFile(deleteFileName);
                    break;
                case 5:
                    System.out.println("Введите название файла: ");
                    String openFileName = scanner.nextLine();
                    fileManager.openFile(openFileName);
                    break;
                case 6:
                    System.out.println("Введите название файла: ");
                    String newFileName = scanner.nextLine();
                    System.out.println("Введите содержимое файла: ");
                    String content = scanner.nextLine();
                    fileManager.createFile(newFileName, content);
                    break;
                case 7:
                    System.out.println("Введите название директории: ");
                    String newDirectoryName = scanner.nextLine();
                    fileManager.createNewDirectory(newDirectoryName);
                    break;
                case 8:
                    System.out.println("Введите название файла");
                    String renameFileName = scanner.nextLine();
                    System.out.println("Введите новое название файла");
                    String newRenameFileName = scanner.nextLine();
                    fileManager.renameFile(renameFileName, newRenameFileName);
                    break;
                default:
                    System.out.println("неверный выбор попробуйте снова");
                    break;
            }
        }
    }
}
