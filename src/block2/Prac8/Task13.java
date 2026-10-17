package block2.Prac8;

import java.util.Scanner;

public class Task13 {

    static Scanner scanner = new Scanner(System.in);

    public static void printOddPositions() {
        int n = scanner.nextInt();

        if (n == 0) {
            return;
        }

        System.out.println(n);

        n = scanner.nextInt();

        if (n == 0) {
            return;
        }

        printOddPositions();
    }

    public static void main(String[] args) {
        printOddPositions();
    }
}
