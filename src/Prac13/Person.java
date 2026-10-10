package Prac13;

public class Person {

    private String surname;
    private String name;
    private String otchestvo;

    public Person(String surname, String name, String otchestvo) {
        this.surname = surname;
        this.name = name;
        this.otchestvo = otchestvo;
    }

    public String getShortName() {
        StringBuilder result = new StringBuilder();

        if (surname != null && !surname.isEmpty()) {
            result.append(surname);
        }

        if (name != null && !name.isEmpty()) {
            result.append(" ")
                    .append(name.charAt(0))
                    .append(".");
        }

        if (otchestvo != null && !otchestvo.isEmpty()) {
            result.append(otchestvo.charAt(0))
                    .append(".");
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Person person1 =
                new Person("Иванов", "Иван", "Олегович");

        Person person2 =
                new Person("Петров", "Петр", null);

        Person person3 =
                new Person("Сидоров", null, null);

        System.out.println(person1.getShortName());
        System.out.println(person2.getShortName());
        System.out.println(person3.getShortName());
    }
}
