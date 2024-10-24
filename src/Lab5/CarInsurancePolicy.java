package Lab5;

import java.util.Random;

public class CarInsurancePolicy extends InsurancePolicy {
    static String policyType = "Полис страхования автомобиля";
    String carModel;
    int insuranceAmount;
    int driverAge;
    static int defaultInsuranceAmount = 20000;

    public static int getDefaultInsuranceAmount() {
        return defaultInsuranceAmount;
    }

    public void upsizeAmount(int upsizeOfAmount) {
        insuranceAmount += upsizeOfAmount;
    }

    public static CarInsurancePolicy generateCarInsurancePolicy(String holderName) {
        Random random = new Random();

        final String[] massCarModel = {"Toyota", "BMW","Mercedes-Benz","Audi","Honda","Tesla","Volkswagen","Hyundai","Nissan"};

        CarInsurancePolicy policy = new CarInsurancePolicy();

        policy.policyHolder = holderName;

        policy.endDate = policy.startDate.plusYears(1);

        policy.policyNumber = random.nextInt(100000, 999999);

        policy.carModel = massCarModel[random.nextInt(0,8)];

        policy.driverAge = random.nextInt(18, 90);

        policy.insuranceAmount = defaultInsuranceAmount;

        return policy;
    }

    @Override
    public String toString() {
        return "Тип полиса: " + policyType + "\nВладелец полиса: " + policyHolder + "\nВозраст владельца полиса: " + driverAge +
                "\nНомер полиса: " + policyNumber +"\nТип автомобиля: "+ carModel + "\nДата начала действия полиса: " +
                startDate + " Дата окончание действия полиса: " + endDate +
                "\nСтатус полиса: " + status + "\nПоложеная страховая выплата: " + insuranceAmount + "\n";
    }
}
