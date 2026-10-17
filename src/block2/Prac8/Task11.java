package block2.Prac8;

import java.util.Scanner;

public class Task11 {

    static Scanner scanner = new Scanner(System.in);

    public static int countOnes() {

        int n = scanner.nextInt();

        if (n == 0) {
            int next = scanner.nextInt();

            if (next == 0) {
                return 0;
            }

            if (next == 1) {
                return 1 + countOnes();
            }

            return countOnes();
        }

        if (n == 1) {
            return 1 + countOnes();
        }

        return countOnes();
    }

    public static void main(String[] args) {
        System.out.println(countOnes());
    }
}