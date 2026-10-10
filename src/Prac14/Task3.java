package Prac14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {

        String text =
                "25.98 USD, 44 ERR, 10.50 RUB, 7.25 EU, 0.004 EU";

        String regex = "\\d+\\.\\d{2}\\s(USD|RUB|EU)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
