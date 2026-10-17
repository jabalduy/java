package block2.Prac11;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Год: ");
        int year = scanner.nextInt();

        System.out.print("Месяц: ");
        int month = scanner.nextInt();

        System.out.print("День: ");
        int day = scanner.nextInt();

        System.out.print("Часы: ");
        int hours = scanner.nextInt();

        System.out.print("Минуты: ");
        int minutes = scanner.nextInt();

        Calendar calendar = Calendar.getInstance();

        calendar.set(year, month - 1, day, hours, minutes, 0);

        Date date = calendar.getTime();

        System.out.println("Дата: " + date);
    }
}
