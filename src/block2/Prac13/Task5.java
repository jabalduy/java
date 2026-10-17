package block2.Prac13;

public class Task5 {

    public static void main(String[] args) {

        PhoneNumber number1 =
                new PhoneNumber("+79175655655");

        PhoneNumber number2 =
                new PhoneNumber("+104289652211");

        PhoneNumber number3 =
                new PhoneNumber("89175655655");

        System.out.println(number1.format());
        System.out.println(number2.format());
        System.out.println(number3.format());
    }
}
