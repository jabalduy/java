package block2.Prac14;

public class Task2 {
    public static void main(String[] args) {

        String regex = "^abcdefghijklmnopqrstuv18340$";

        String str1 = "abcdefghijklmnopqrstuv18340";
        String str2 = "abcdefghijklmnoasdfasdpqrstuv18340";

        System.out.println(str1.matches(regex));
        System.out.println(str2.matches(regex));
    }
}