package Lab7;

import java.lang.invoke.CallSite;
import java.util.*;

public class Main {
    // Массив фамилий в женском роде
    static String[] surnamesFemale = {"Иванова", "Петрова", "Сидорова", "Кузнецова", "Смирнова", "Попова", "Васильева", "Фёдорова", "Михайлова", "Новикова", "Козлова", "Морозова", "Волкова", "Соловьёва", "Лебедева", "Егорова", "Павлова", "Семенова", "Григорьева", "Андреева", "Степанова", "Николаева", "Орлова", "Тарасова", "Зайцева", "Борисова", "Яковлева", "Гаврилова", "Александрова", "Голубева"};

    // Массив имён в женском роде
    static String[] namesFemale = {"Александра", "Дарья", "Мария", "Светлана", "Анна", "Екатерина", "Ирина", "Татьяна", "Ольга", "Виктория", "Елена", "Юлия", "Наталья", "Полина", "Ксения", "Вероника", "Лариса", "Валентина", "Алёна", "Анастасия", "Надежда", "Любовь", "Маргарита", "Евгения", "Олеся", "Лилия", "Яна", "Тамара", "Варвара", "Агния"};

    // Массив отчеств в женском роде
    static String[] patronymicsFemale = {"Александровна", "Дмитриевна", "Михайловна", "Сергеевна", "Андреевна", "Ивановна", "Владимировна", "Юрьевна", "Алексеевна", "Павловна", "Евгеньевна", "Николаевна", "Викторовна", "Романовна", "Валентиновна", "Максимовна", "Олеговна", "Артёмовна", "Григорьевна", "Игоревна", "Константиновна", "Вадимовна", "Борисовна", "Антоновна", "Леонидовна", "Аркадьевна", "Тимофеевна", "Глебовна", "Степановна", "Ярославовна"};

    static String[] surnamesMale = {"Иванов", "Петров", "Сидоров", "Кузнецов", "Смирнов", "Попов", "Васильев", "Фёдоров", "Михайлов", "Новиков", "Козлов", "Морозов", "Волков", "Соловьёв", "Лебедев", "Егоров", "Павлов", "Семенов", "Григорьев", "Андреев", "Степанов", "Николаев", "Орлов", "Тарасов", "Зайцев", "Борисов", "Яковлев", "Гаврилов", "Александров", "Головин"};

    // Массив имён
    static String[] namesMale = {"Александр", "Дмитрий", "Михаил", "Сергей", "Андрей", "Иван", "Владимир", "Юрий", "Алексей", "Павел", "Евгений", "Николай", "Виктор", "Роман", "Валентин", "Максим", "Олег", "Артём", "Григорий", "Игорь", "Константин", "Вадим", "Борис", "Антон", "Леонид", "Аркадий", "Тимофей", "Глеб", "Степан", "Ярослав"};

    // Массив отчеств
    static String[] patronymicsMale = {"Александрович", "Дмитриевич", "Михайлович", "Сергеевич", "Андреевич", "Иванович", "Владимирович", "Юрьевич", "Алексеевич", "Павлович", "Евгеньевич", "Николаевич", "Викторович", "Романович", "Валентинович", "Максимович", "Олегович", "Артёмович", "Григорьевич", "Игоревич", "Константинович", "Вадимович", "Борисович", "Антонович", "Леонидович", "Аркадьевич", "Тимофеевич", "Глебович", "Степанович", "Ярославович"};

    // Методы генерирующие по 1 полису
    public static HomeInsurancePolicy generateHomeInsurancePolicy() {
        HomeInsurancePolicy policy = new HomeInsurancePolicy();
        Random rn = new Random();
        if (rn.nextInt(0, 2) == 1) {
            policy.name = namesMale[rn.nextInt(0, 30)];
            policy.surname = surnamesMale[rn.nextInt(0, 30)];
            policy.patronymic = patronymicsMale[rn.nextInt(0, 30)];
            policy.gender = "Мужской";
        } else {
            policy.name = namesFemale[rn.nextInt(0, 30)];
            policy.surname = surnamesFemale[rn.nextInt(0, 30)];
            policy.patronymic = patronymicsFemale[rn.nextInt(0, 30)];
            policy.gender = "Женский";
        }
        policy.status = rn.nextInt(0, 2) == 1 ? "активен" : "неактивен";
        return policy;
    }

    public static HealthInsurancePolicy generateHealthInsurancePolicy() {
        HealthInsurancePolicy policy = new HealthInsurancePolicy();
        Random rn = new Random();
        if (rn.nextInt(0, 2) == 1) {
            policy.name = namesMale[rn.nextInt(0, 30)];
            policy.surname = surnamesMale[rn.nextInt(0, 30)];
            policy.patronymic = patronymicsMale[rn.nextInt(0, 30)];
            policy.gender = "Мужской";
        } else {
            policy.name = namesFemale[rn.nextInt(0, 30)];
            policy.surname = surnamesFemale[rn.nextInt(0, 30)];
            policy.patronymic = patronymicsFemale[rn.nextInt(0, 30)];
            policy.gender = "Женский";
        }
        policy.status = rn.nextInt(0, 2) == 1 ? "активен" : "неактивен";
        return policy;
    }

    public static ArrayList<InsurancePolicy> generateArrayList() {
        Random rn = new Random();
        ArrayList<InsurancePolicy> polices = new ArrayList<InsurancePolicy>();
        for (int i = 0; i < 1_000_000; i++) {
            if (rn.nextInt(0, 2) == 1) {
                polices.add(generateHomeInsurancePolicy());
                polices.get(i).id = i + 1;
            } else {
                polices.add(generateHealthInsurancePolicy());
                polices.get(i).id = i + 1;
            }
        }
        return polices;
    }

    public static LinkedList<InsurancePolicy> generateLinkedList() {
        Random rn = new Random();
        LinkedList<InsurancePolicy> polices = new LinkedList<InsurancePolicy>();
        for (int i = 0; i < 1_000_000; i++) {
            if (rn.nextInt(0, 2) == 1) {
                polices.add(generateHomeInsurancePolicy());
                polices.get(i).id = i + 1;
            } else {
                polices.add(generateHealthInsurancePolicy());
                polices.get(i).id = i + 1;
            }
        }
        return polices;
    }

    public static InsurancePolicy findById(ArrayList<InsurancePolicy> list, int id) {
        for (InsurancePolicy policy : list) {
            if (policy.id == id) {
                return policy; // Возвращаем объект, если нашли
            }
        }
        return null; // Если не нашли
    }

    public static InsurancePolicy findById(LinkedList<InsurancePolicy> list, int id) {
        for (InsurancePolicy policy : list) {
            if (policy.id == id) {
                return policy; // Возвращаем объект, если нашли
            }
        }
        return null; // Если не нашли
    }

    public static boolean removeById(ArrayList<InsurancePolicy> list, int id) {
        for (InsurancePolicy policy : list) {
            if (policy.id == id) {
                list.remove(policy); // Возвращаем объект, если нашли
            }
            return true;
        }
        return false;
    }

    public static boolean removeById(LinkedList<InsurancePolicy> list, int id) {
        for (InsurancePolicy policy : list) {
            if (policy.id == id) {
                list.remove(policy); // Возвращаем объект, если нашли
            }
            return true;
        }
        return false;
    }

    public static int findPolicesBySurname(LinkedList<InsurancePolicy> list, String surname) {
        int counter = 0;
        for (InsurancePolicy policy : list) {
            if (policy.surname.toLowerCase().equals(surname.toLowerCase())) counter++;
        }
        return counter;
    }

    public static int findPolicesBySurname(ArrayList<InsurancePolicy> list, String surname) {
        int counter = 0;
        for (InsurancePolicy policy : list) {
            if (policy.surname.toLowerCase().equals(surname.toLowerCase())) counter++;
        }
        return counter;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long startTime;
        long endTime;
        int choise;
        while (true) {
            System.out.println("1.ArrayList\n2.LinkedList");
            if (scanner.hasNextInt()) {
                choise = scanner.nextInt();
                if (choise == 1 || choise == 2) {
                    break;
                } else {
                    System.out.println("Ошибка! Пожалуйста, введите 1 или 2.");
                }
            } else {
                System.out.println("Вы ввели не число");
            }

        }

        startTime = System.currentTimeMillis();
        ArrayList<InsurancePolicy> arrayList = generateArrayList();
        endTime = System.currentTimeMillis();
        long arrayListCrating = endTime - startTime;
        startTime = System.currentTimeMillis();
        LinkedList<InsurancePolicy> linkedList = generateLinkedList();
        endTime = System.currentTimeMillis();
        long linkedListCrating = endTime - startTime;

        if (choise == 1) {
            System.out.println("Создание заняло " + arrayListCrating + "ms");
        } else {
            System.out.println("Создание заняло " + linkedListCrating + "ms");
        }


        boolean isWorking = true;
        while (isWorking) {
            System.out.println("Выберите:\n1.Поиск элемента по значению параметра\n" + "2.Удаление обьекта из списка с заданным параметром\n" + "3.Расчет вычисляемого показателя\n" + "4.Выход");
            if (scanner.hasNextInt()) {
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("Введите id элемента");
                        int id = scanner.nextInt();
                        startTime = System.currentTimeMillis();
                        if (choise == 1)
                            System.out.println(findById(arrayList, id));
                        else
                            System.out.println(findById(linkedList, id));
                        endTime = System.currentTimeMillis();
                        System.out.println("Поиск занял " + (endTime - startTime) + "ms");
                        break;
                    case 2:
                        System.out.println("Введите id элемента");
                        int id2 = scanner.nextInt();
                        startTime = System.currentTimeMillis();
                        if (choise == 1)
                            removeById(arrayList, id2);
                        else
                            removeById(linkedList, id2);
                        endTime = System.currentTimeMillis();
                        System.out.println("Удаление заняло " + (endTime - startTime) + "ms");
                        break;
                    case 3:
                        System.out.println("Введите фамилию");
                        scanner.nextLine();
                        String surname = scanner.nextLine();
                        startTime = System.currentTimeMillis();
                        if (choise == 1)
                            System.out.println("Обьектов с такой фамилией " + findPolicesBySurname(arrayList, surname));
                        else
                            System.out.println("Обьектов с такой фамилией " + findPolicesBySurname(linkedList, surname));
                        endTime = System.currentTimeMillis();
                        System.out.println("Расчет вычисляемого показателя занял " + (endTime - startTime) + "ms");
                        break;
                    case 4:
                        isWorking = false;
                        break;
                    default:
                        System.out.println("Вы ввели не то число");
                        break;
                }
            } else {
                System.out.println("Вы ввели не число");
            }

        }


//        int choise = scanner.nextInt();
//
//        ArrayList<InsurancePolicy> array1 = generateArrayList();
//
//        switch (choise) {
//            case 1:
//                array1 = generateArrayList();
//                for (InsurancePolicy policy : array1) {
//                    System.out.println(policy);
//                }
//                break;
//            case 2:
//                System.out.println("Поиск по значению в списке, введите значение параметра id");
//                int choiseId = scanner.nextInt();
//                startTime = System.currentTimeMillis();
//                System.out.println(findById(array1, choiseId));
//                endTime = System.currentTimeMillis();
//                System.out.println(endTime-startTime);
//        }
    }
}
