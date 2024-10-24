package Lab5;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    //Страховой полис
    //Полис с максимальным сроком действия
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InsurancePolicy[] policies = new InsurancePolicy[10];

        policies[0] = CarInsurancePolicy.generateCarInsurancePolicy("John Lewis");
        policies[1] = HealthInsurancePolicy.generateHealthInsurancePolicy("Василия Пупкина");

        int policyCount = 2;

        int choise;
        do {
            System.out.println("Выберите действие:");
            System.out.println("1. Просмотреть все объекты");
            System.out.println("2. Изменить поля объектов");
            System.out.println("3. Вычислить максимальный срок действия полиса");
            System.out.println("4. Выход из программы");
            choise = scanner.nextInt();
            scanner.nextLine();
            switch (choise) {
                case 1:
                    System.out.println("Все полисы: ");
                    for (int i = 0; i < policyCount; i++) {
                        System.out.println(policies[i]);
                    }
                    break;
                case 2:
                    System.out.print("Введите номер полиса для изменения: ");
                    int policyNumber = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;
                    for (int i = 0; i < policyCount; i++) {
                        if (policies[i].policyNumber == policyNumber) {
                            found = true;
                            System.out.print("Введите новый статус (активен/неактивен): ");
                            String newStatus = scanner.nextLine();
                            if (newStatus.equals("активен")) {
                                policies[i].activatePolicy();
                            } else {
                                policies[i].deActivatePolicy();
                            }
                            System.out.print("Введите количество лет для продления полиса: ");
                            int years = scanner.nextInt();
                            policies[i].prolongPolicyOnYears(years);
                            System.out.println("Полис обновлён:");
                            System.out.println(policies[i]);
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Полис с таким номером не найден.");
                    }
                    break;
                case 3:
                    // Вычисление максимального срока действия полиса
                    LocalDate maxEndDate = LocalDate.MIN;
                    for (int i = 0; i < policyCount; i++) {
                        if (policies[i].endDate.isAfter(maxEndDate)) {
                            maxEndDate = policies[i].endDate;
                        }
                    }
                    System.out.println("Максимальный срок действия полиса: " + maxEndDate);
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                    break;
            }
        } while (choise!=4);

    }
}
