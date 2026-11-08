package block4.Prac19.Task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ФИО: ");
        String fullName = scanner.nextLine();

        System.out.print("Введите ИНН: ");
        String inn = scanner.nextLine();

        Customer customer = new Customer(fullName, inn);

        try {
            customer.validateInn();

            System.out.println("ИНН действителен.");
            System.out.println("Заказ успешно оформлен.");

        } catch (InvalidInnException e) {

            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }
}
