package block4.Prac18.Task3;

import java.util.Scanner;

public class Exception3 {

    public void exceptionDemo() {

        Scanner myScanner = new Scanner(System.in);

        try {
            System.out.print("Enter an integer ");

            String intString = myScanner.next();

            int i = Integer.parseInt(intString);

            System.out.println(2 / i);

        } catch (NumberFormatException e) {

            System.out.println("Введено некорректное целое число.");

        } catch (ArithmeticException e) {

            System.out.println("Деление на ноль невозможно.");

        } catch (Exception e) {

            System.out.println("Произошла другая ошибка.");
        }
    }
}
