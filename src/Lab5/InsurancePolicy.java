package Lab5;

import java.time.LocalDate;
import java.util.Random;

public class InsurancePolicy {
    String policyHolder;
    int policyNumber;
    LocalDate startDate = LocalDate.of(2024, 10, 24);
    LocalDate endDate;
    String status = "неактивен";


    public void activatePolicy() {
        status = "активен";
    }

    public void deActivatePolicy() {
        status = "неактивен";
    }

    public void prolongPolicyOnYears(int years) {
        endDate = endDate.plusYears(years);
    }

    public static InsurancePolicy generateInsurancePolicy(String holderName) {
        Random random = new Random();
        InsurancePolicy policy = new InsurancePolicy();

        policy.policyHolder = holderName;

        policy.endDate = policy.startDate.plusYears(1);

        policy.policyNumber = random.nextInt(100000, 999999);

        return policy;
    }

    @Override
    public String toString() {
        return "Владелец полиса: " + policyHolder + "\nНомер полиса: " + policyNumber + "\nДата начала действия полиса: " +
                startDate + " Дата окончание действия полиса: " + endDate + "\nСтатус полиса: " + status + "\n";

    }
}
