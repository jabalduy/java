package block2.Prac8;

import java.util.Scanner;

public class Task12 {

    static Scanner scanner = new Scanner(System.in);

    public static void printOdd() {
        int n = scanner.nextInt();

        if (n == 0) {
            return;
        }

        if (n % 2 != 0) {
            System.out.println(n);
        }

        printOdd();
    }

    public static void main(String[] args) {
        printOdd();
    }
}
