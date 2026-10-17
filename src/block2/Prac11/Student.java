package block2.Prac11;

import java.text.DateFormat;
import java.util.Date;

public class Student {

    private String name;
    private String surname;
    private Date birthDate;

    public Student(String name, String surname, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public String getBirthDate(int format) {
        DateFormat dateFormat = DateFormat.getDateInstance(format);
        return dateFormat.format(birthDate);
    }

    public String toString() {
        return name + " " + surname +
                ", дата рождения: " + getBirthDate(DateFormat.MEDIUM);
    }
}
