package Prac11;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Task3 {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2005, Calendar.MARCH, 15);

        Date birthDate = calendar.getTime();

        Student student =
                new Student("Ivan", "Ivanov", birthDate);

        System.out.println(
                student.getBirthDate(DateFormat.SHORT)
        );

        System.out.println(
                student.getBirthDate(DateFormat.MEDIUM)
        );

        System.out.println(
                student.getBirthDate(DateFormat.LONG)
        );

        System.out.println(student);
    }
}
