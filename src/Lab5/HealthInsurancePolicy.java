package Lab5;

import java.util.Random;

public class HealthInsurancePolicy extends InsurancePolicy {
    static String policyType = "Полис страхования здоровья";
    int personAge;
    int insuranceAmount;
    static int defaultInsuranceAmount = 100000;

    public static int getDefaultInsuranceAmount() {
        return defaultInsuranceAmount;
    }

    public void upsizeAmount(int upsizeOfAmount) {
        insuranceAmount += upsizeOfAmount;
    }

    public static HealthInsurancePolicy generateHealthInsurancePolicy(String holderName) {
        Random random = new Random();
        HealthInsurancePolicy policy = new HealthInsurancePolicy();

        policy.policyHolder = holderName;

        policy.endDate = policy.startDate.plusYears(1);

        policy.policyNumber = random.nextInt(100000, 999999);

        policy.personAge = random.nextInt(18, 60);

        if (policy.personAge < 35) {
            policy.insuranceAmount = defaultInsuranceAmount;
        } else policy.insuranceAmount = 50000;

        return policy;
    }

    @Override
    public String toString() {
        return "Тип полиса: " + policyType + "\nВладелец полиса: " + policyHolder + "\nВозраст владельца полиса: " + personAge +
                "\nНомер полиса: " + policyNumber + "\nДата начала действия полиса: " +
                startDate + " Дата окончание действия полиса: " + endDate +
                "\nСтатус полиса: " + status + "\nПоложеная страховая выплата: " + insuranceAmount + "\n";
    }
}
