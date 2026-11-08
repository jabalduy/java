package block4.Prac17.Task3;

import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentList list = new StudentList();

        int choice;

        do {
            System.out.println("\n=== КОЛЬЦЕВАЯ КАРТОТЕКА ===");
            System.out.println("1. Добавить студента");
            System.out.println("2. Удалить студента");
            System.out.println("3. Вывести список");
            System.out.println("4. Очистить список");
            System.out.println("5. Проверить, пуст ли список");
            System.out.println("0. Выход");

            System.out.print("Выберите действие: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    Student student = new Student();
                    student.read(scanner);
                    list.add(student);

                    System.out.println("Студент добавлен.");
                    break;

                case 2:
                    System.out.print("Введите имя студента: ");
                    String name = scanner.nextLine();

                    list.remove(name);
                    break;

                case 3:
                    if (list.isEmpty()) {
                        System.out.println("Список пуст.");
                    } else {
                        list.printAll();
                    }
                    break;

                case 4:
                    list.clear();
                    System.out.println("Список очищен.");
                    break;

                case 5:
                    if (list.isEmpty()) {
                        System.out.println("Список пуст.");
                    } else {
                        System.out.println("В списке есть студенты.");
                    }
                    break;

                case 0:
                    System.out.println("Программа завершена.");
                    break;

                default:
                    System.out.println("Неизвестная команда.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
