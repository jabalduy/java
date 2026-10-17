package block3.Prac17.Task1;

import java.util.Scanner;

public class Student {

    private String name;
    private int age;

    Student next;

    public void read(Scanner scanner) {
        System.out.print("Введите имя: ");
        name = scanner.nextLine();

        System.out.print("Введите возраст: ");
        age = Integer.parseInt(scanner.nextLine());
    }

    public void print() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
    }

    public String getName() {
        return name;
    }
}