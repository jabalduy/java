package block2.Prac11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat format =
                new SimpleDateFormat("dd.MM.yyyy");

        System.out.print("Введите дату (dd.MM.yyyy): ");
        String input = scanner.nextLine();

        Date userDate = format.parse(input);
        Date currentDate = new Date();

        if (userDate.before(currentDate)) {
            System.out.println("Введенная дата раньше настоящей");
        } else if (userDate.after(currentDate)) {
            System.out.println("Введенная дата позже настоящей");
        } else {
            System.out.println("Введенная дата равна настоящей");
        }

        System.out.println("Настоящая дата: " + format.format(currentDate));
        System.out.println("Введенная дата: " + format.format(userDate));
    }
}
