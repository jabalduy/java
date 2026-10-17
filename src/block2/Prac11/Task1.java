package block2.Prac11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Task1 {
    public static void main(String[] args) {

        String surname = "Trifonov";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2026, Calendar.OCTOBER, 10, 14, 30, 0);

        Date receivedDate = calendar.getTime();
        Date completedDate = new Date();

        SimpleDateFormat format =
                new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        System.out.println("Developer: " + surname);
        System.out.println("Received: " + format.format(receivedDate));
        System.out.println("Submitted: " + format.format(completedDate));
    }
}
