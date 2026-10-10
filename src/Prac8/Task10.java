package Prac8;

import java.util.Scanner;

public class Task10 {

    private static int reverse(int n, int result) {
        if (n==0) {
            return result;
        }

        return reverse(n/10, result * 10 + n % 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.println(reverse(n,0));
    }
}


