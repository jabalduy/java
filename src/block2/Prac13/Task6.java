package block2.Prac13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task6 {

    public static String getLine(String[] words) {
        boolean[] used = new boolean[words.length];
        StringBuilder result = new StringBuilder();

        if (buildLine(words, used, result, 0)) {
            return result.toString();
        }

        return "No solution";
    }

    private static boolean buildLine(
            String[] words,
            boolean[] used,
            StringBuilder result,
            int count
    ) {
        if (count == words.length) {
            return true;
        }

        for (int i = 0; i < words.length; i++) {

            if (used[i]) {
                continue;
            }

            if (result.length() == 0 ||
                    Character.toLowerCase(
                            result.charAt(result.length() - 1)
                    )
                            ==
                            Character.toLowerCase(
                                    words[i].charAt(0)
                            )) {

                int oldLength = result.length();

                if (result.length() > 0) {
                    result.append(" ");
                }

                result.append(words[i]);
                used[i] = true;

                if (buildLine(words, used, result, count + 1)) {
                    return true;
                }

                used[i] = false;
                result.setLength(oldLength);
            }
        }

        return false;
    }

    public static void main(String[] args)
            throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();

        Scanner fileScanner = new Scanner(new File(fileName));

        StringBuilder text = new StringBuilder();

        while (fileScanner.hasNext()) {
            text.append(fileScanner.next()).append(" ");
        }

        fileScanner.close();

        String[] words = text.toString().trim().split("\\s+");

        System.out.println(getLine(words));
    }
}
