package Prac13;

public class Task3 {

    public static void main(String[] args) {

        String address1 =
                "Russia, Moscow Region, Moscow, Tverskaya, 10, 2, 15";

        String address2 =
                "Russia; Leningrad Region; Saint Petersburg; Nevsky; 25; 1; 8";

        String address3 =
                "Germany. Bavaria. Munich. Main Street. 7. 3. 21";

        String address4 =
                "France, Ile-de-France; Paris. Rivoli, 12; 4. 30";

        Address a1 = new Address();
        a1.parseWithSplit(address1);
        a1.printAddress();

        Address a2 = new Address();
        a2.parseWithTokenizer(address2);
        a2.printAddress();

        Address a3 = new Address();
        a3.parseWithTokenizer(address3);
        a3.printAddress();

        Address a4 = new Address();
        a4.parseWithTokenizer(address4);
        a4.printAddress();
    }
}
