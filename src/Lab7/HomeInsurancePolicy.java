package Lab7;
public class HomeInsurancePolicy extends InsurancePolicy {
    static String policyType = "Полис страхования жилища";

    @Override
    public String toString() {
        return "HomeInsurancePolicy{" +
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
