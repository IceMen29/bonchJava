package Lab7;

public class HealthInsurancePolicy extends InsurancePolicy {
    static String policyType = "Полис обязательного медицинского страхования";

    @Override
    public String toString() {
        return "HealthInsurancePolicy{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", gender='" + gender + '\'' +
                ", policyType='" + policyType + '\'' +
                '}';
    }
}
