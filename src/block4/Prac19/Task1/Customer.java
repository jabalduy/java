package block4.Prac19.Task1;

public class Customer {

    private String fullName;
    private String inn;

    public Customer(String fullName, String inn) {
        this.fullName = fullName;
        this.inn = inn;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInn() {
        return inn;
    }

    public void validateInn() throws InvalidInnException {

        if (inn == null || !inn.matches("\\d{12}")) {
            throw new InvalidInnException(
                    "Недействительный ИНН для клиента " + fullName
            );
        }
    }
}
