package Lab3FileManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    File totalDirectory = new File("D:/intellij idea/JavaLabsBonch", "dir");

    public boolean isDirectoryEmpty() {
        File[] files = totalDirectory.listFiles();
        if (files.length == 0) {
            return true;
        } else {
            return false;
        }

    }


    public void changeTotalDirectory(String input) {
        boolean fileFound = false;
        File[] files = totalDirectory.listFiles();
        for (File file : files) {
            if (file.getName().equals(input)) {
                totalDirectory = new File(totalDirectory, input);
                fileFound = true;
                break;
            }
        }
        if (fileFound == false) {
            System.out.println("Файл не найден");
        }
    }

    public void changeTotalDirectoryParent () {
        totalDirectory = new File(totalDirectory.getParent());
    }

    public void getFileStats(String input) {
        boolean fileFound = false;
        File[] files = totalDirectory.listFiles();
        for (File file : files) {
            if (file.getName().equals(input)) {
                System.out.println("Имя: " + file.getName() + "\t||\tРазмер: " + file.length() + " байт "
                        + (file.canRead ( ) ? "\t||\tдоступен для чтения " : "\t||\tне доступен для чтения ")
                        + ( file.canWrite ( ) ? "\t||\tдоступен для записи\n" : "\t||\tне доступен для записи\n")
                        + ( file.isDirectory ( ) ? "является каталогом" : "не является каталогом")
                        + ( file . isFile ( ) ? "\t||\tявляется обычным файлом " : "\t||\tможет быть именованным каналом" )
                        + (file.isAbsolute () ? "\t||\tявляется абсолютным" : "\t||\tне является абсолютным" )
                        + ( "\t||\tПоследнее изменение в файле : " + file.lastModified ( ) ) );

                fileFound = true;
                break;
            }
        }
        if (fileFound == false) {
            System.out.println("Файл не найден!");
        }
    }
    public void deleteFile(String input) {
        boolean fileFound = false;
        File[] files = totalDirectory.listFiles();

        for (File file : files) {
            if (file.getName().equals(input)) {
                fileFound = true;
                if (file.isDirectory()) {
                    File[] directoryFiles = file.listFiles();
                    if (directoryFiles.length == 0) {
                        file.delete();
                    } else {System.out.println("Директория не пуста!");}
                }
                } else {
                if (!file.delete()) {
                    System.out.println("Ошибка, файл не удален");
                }
            }
        }
        if (fileFound == false) {
            System.out.println("Файл не найден");
        }
    }

    public void renameFile(String currentName, String newName) {
        File[] files = totalDirectory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(currentName)) {
                    File newFile = new File(totalDirectory, newName);  // Создаем новый файл с новым именем

                    // Переименовываем
                    if (file.renameTo(newFile)) {
                        System.out.println("Переименовано в: " + newFile.getAbsolutePath());
                    } else {
                        System.out.println("Ошибка при переименовании файла или директории.");
                    }
                    return;
                }
            }
            // Если не нашли файл с текущим именем
            System.out.println("Файл или директория с именем '" + currentName + "' не найдены.");
        } else {
            System.out.println("Директория не может быть прочитана или переименована.");
        }
    }

    public void createFile (String fileName, String content) {
        File file = new File(totalDirectory, fileName);
        if (file.exists()) {
            System.out.println("Файл с именем " + fileName + " уже существует");
            return;
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
            System.out.println("Файл создан и записан " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public void openFile(String fileName) {
        File file = new File(totalDirectory, fileName);

        if (!file.exists()) {
            System.out.println("Файл с таким именем не найден");
            return;
        }
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("Notepad.exe", file.getAbsolutePath());
            processBuilder.start();
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public void createNewDirectory(String directoryName) {
        File file = new File(totalDirectory, directoryName);

        if (file.exists()) {
            System.out.println("Такая директория уже существует");
            return;
        }

        if (file.mkdir()) {
            System.out.println("Директория успешно создана");
        } else {
            System.out.println("Ошибка при создании директории");
        }
    }
    public void printMenu() {
        System.out.println("Текущая директория: " + totalDirectory.getAbsolutePath());
        if (totalDirectory.isDirectory()) {
            if (!isDirectoryEmpty()) {
                for (File file : totalDirectory.listFiles()) {
                    if(file.isDirectory()) {
                        System.out.println("[DIR] " + file.getName());
                    } else {
                        System.out.println("[FILE] " + file.getName());
                    }
                }
            } else {
                System.out.println("Директория пуста\n");
            }
        }
        System.out.println("Введите число от 1 до 8");
        System.out.println("1 - Переместиться в родительскую директорию");
        System.out.println("2 - Переместиться в директорию по названию");
        System.out.println("3 - Вывести свойства файла");
        System.out.println("4 - Удалить файл (каталог с файлами внутри удалить нельзя)");
        System.out.println("5 - Прочитать TXT файл");
        System.out.println("6 - Создать текстовый файл");
        System.out.println("7 - Создать директорию");
        System.out.println("8 - Переименовать файл");
    }
}
