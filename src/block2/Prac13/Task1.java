package block2.Prac13;

public class Task1 {

    public static void processString(String str) {

        // 2. Последний символ строки
        System.out.println("Last character: " +
                str.charAt(str.length() - 1));

        // 3. Заканчивается ли строка на !!!
        System.out.println("Ends with !!!: " +
                str.endsWith("!!!"));

        // 4. Начинается ли строка с I like
        System.out.println("Starts with I like: " +
                str.startsWith("I like"));

        // 5. Содержит ли строка Java
        System.out.println("Contains Java: " +
                str.contains("Java"));

        // 6. Позиция подстроки Java
        System.out.println("Position of Java: " +
                str.indexOf("Java"));

        // 7. Замена символов a на o
        System.out.println("Replace a with o: " +
                str.replace('a', 'o'));

        // 8. Верхний регистр
        System.out.println("Upper case: " +
                str.toUpperCase());

        // 9. Нижний регистр
        System.out.println("Lower case: " +
                str.toLowerCase());

        // 10. Вырезаем Java
        int start = str.indexOf("Java");

        if (start != -1) {
            System.out.println("Substring Java: " +
                    str.substring(start, start + 4));
        }
    }

    public static void main(String[] args) {
        processString("I like Java!!!");
    }
}
